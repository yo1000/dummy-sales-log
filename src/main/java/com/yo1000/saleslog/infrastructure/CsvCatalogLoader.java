package com.yo1000.saleslog.infrastructure;

import com.yo1000.saleslog.domain.Brand;
import com.yo1000.saleslog.domain.Catalog;
import com.yo1000.saleslog.domain.Genre;
import com.yo1000.saleslog.domain.Product;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * brands.csv / genres.csv / products.csv からカタログを読み込む。
 * <ul>
 *     <li>brands.csv: id, name, coefficient</li>
 *     <li>genres.csv: id, name</li>
 *     <li>products.csv: id, brand_id, genre_id, name, color, price</li>
 * </ul>
 * いずれも UTF-8（BOM 可）、1行目はヘッダ、値にカンマ・引用符を含まない前提。
 */
public class CsvCatalogLoader {
    private static final char BOM = '﻿';

    public Catalog load(Resource brands, Resource genres, Resource products) {
        return new Catalog(
                read(brands, f -> new Brand(
                        Integer.parseInt(f[0]),
                        f[1],
                        Integer.parseInt(f[2]))),
                read(genres, f -> new Genre(
                        Integer.parseInt(f[0]),
                        f[1])),
                read(products, f -> new Product(
                        Integer.parseInt(f[0]),
                        Integer.parseInt(f[1]),
                        Integer.parseInt(f[2]),
                        f[3],
                        f[4],
                        Integer.parseInt(f[5]))));
    }

    private <T> List<T> read(Resource resource, Function<String[], T> mapper) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            List<T> rows = new ArrayList<>();
            String header = reader.readLine();
            if (header == null) {
                return rows;
            }
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.isBlank()) {
                    continue;
                }
                if (!line.isEmpty() && line.charAt(0) == BOM) {
                    line = line.substring(1);
                }
                try {
                    rows.add(mapper.apply(line.split(",", -1)));
                } catch (RuntimeException e) {
                    throw new IllegalStateException(
                            "Invalid row at " + resource.getDescription() + ":" + lineNumber, e);
                }
            }
            return rows;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
