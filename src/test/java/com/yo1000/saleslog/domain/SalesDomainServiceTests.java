package com.yo1000.saleslog.domain;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.yo1000.saleslog.infrastructure.CsvCatalogLoader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.SplittableRandom;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class SalesDomainServiceTests {
    private static Catalog catalog;
    private static SalesDomainService service;

    @BeforeAll
    static void setUp() {
        catalog = new CsvCatalogLoader().load(
                new ClassPathResource("data/brands.csv"),
                new ClassPathResource("data/genres.csv"),
                new ClassPathResource("data/products.csv"));
        service = new SalesDomainService(catalog);
    }

    @Test
    void catalogIsLoaded() {
        assertThat(catalog.brands()).hasSize(200);
        assertThat(catalog.productCount()).isGreaterThan(80_000);
        assertThat(catalog.genre(1).name()).isEqualTo("トップス");
        assertThat(catalog.brands()).allMatch(brand -> brand.coefficient() > 0);
    }

    @Test
    void salesJsonExpandsEverythingExceptCustomerId() throws Exception {
        Sales sales = service.sell(new Customer(7), BuyingPattern.forCustomer(7), LocalDateTime.of(1999, 2, 11, 10, 0));
        JsonNode json = new ObjectMapper().registerModule(new JavaTimeModule()).valueToTree(sales);

        assertThat(json.get("customer").properties()).hasSize(1);
        assertThat(json.get("customer").get("id").asInt()).isEqualTo(7);
        JsonNode item = json.get("items").get(0);
        assertThat(item.get("brand").get("name").asText()).isNotBlank();
        assertThat(item.get("brand").has("coefficient")).isFalse();
        assertThat(item.get("genre").get("name").asText()).isNotBlank();
        assertThat(item.has("brandId")).isFalse();
    }

    @Test
    void singleBrandPatternBuysOnlyFromMainBrand() {
        SplittableRandom random = new SplittableRandom(1);
        for (int id = 1; id <= 2_000; id++) {
            BuyingPattern pattern = BuyingPattern.forCustomer(id);
            if (pattern.brandCombination() != BuyingPattern.BrandCombination.SINGLE_BRAND) {
                continue;
            }
            int mainBrandId = pattern.mainBrand(catalog).id();
            List<SalesItem> items = service.pick(pattern, random);
            assertThat(items).isNotEmpty();
            assertThat(items).allMatch(item -> item.brand().id() == mainBrandId);
        }
    }

    @Test
    void variousBrandsPatternBuysFromMultipleBrands() {
        SplittableRandom random = new SplittableRandom(2);
        BuyingPattern pattern = new BuyingPattern(
                BuyingPattern.BrandCombination.VARIOUS_BRANDS, BuyingPattern.Budget.HIGH, 42L);
        Set<Integer> brandIds = Set.of();
        for (int i = 0; i < 20 && brandIds.size() < 2; i++) {
            brandIds = service.pick(pattern, random).stream()
                    .map(item -> item.brand().id()).collect(Collectors.toSet());
        }
        assertThat(brandIds).hasSizeGreaterThan(1);
    }

    @Test
    void salesTotalsAreConsistentAndMostlyWithinBudget() {
        SplittableRandom random = new SplittableRandom(3);
        int withinBudget = 0;
        int trials = 0;
        for (int id = 1; id <= 5_000; id++) {
            BuyingPattern pattern = BuyingPattern.forCustomer(id);
            List<SalesItem> items = service.pick(pattern, random);
            int total = items.stream().mapToInt(SalesItem::subtotal).sum();

            assertThat(items).isNotEmpty();
            assertThat(total).isPositive();
            trials++;
            if (total <= pattern.budget().max()) {
                withinBudget++;
            }
        }
        // 1点も買えない場合のみ予算超過を許容しているため、大半は予算内に収まる
        assertThat((double) withinBudget / trials).isGreaterThan(0.95);
    }

    @Test
    void sellCreatesSalesForMemberAndNonMember() {
        Sales member = service.sell(new Customer(123), BuyingPattern.forCustomer(123), LocalDateTime.now());
        assertThat(member.customer().getId()).isEqualTo(123);
        assertThat(member.paidCash()).isEqualTo(member.total());

        Sales nonMember = service.sell(null, BuyingPattern.random(new SplittableRandom(4)), LocalDateTime.now());
        assertThat(nonMember.customer()).isNull();
        assertThat(nonMember.items()).isNotEmpty();
        assertThat(nonMember.items()).allSatisfy(item -> {
            assertThat(item.brand().name()).isNotBlank();
            assertThat(item.genre().name()).isNotBlank();
        });
    }
}
