package com.yo1000.saleslog.presentation;

import com.yo1000.saleslog.domain.Customer;
import com.yo1000.saleslog.domain.PointHolder;
import com.yo1000.saleslog.domain.PointHolderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

class MonitorRestControllerTests {
    @Test
    void returnsPointHolderOfSpecifiedCustomer() throws Exception {
        // Given
        PointHolderRepository repository = Mockito.mock(PointHolderRepository.class);
        Mockito.when(repository.findByCustomerId(264589))
                .thenReturn(new PointHolder(new Customer(264589), 1375));
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new MonitorRestController(repository)).build();

        // When
        MvcResult result = mockMvc.perform(get("/monitor").param("customer", "264589")).andReturn();

        // Then
        assertThat(result.getResponse().getStatus()).isEqualTo(200);
        assertThat(result.getResponse().getContentAsString())
                .isEqualTo("[{\"customer\":{\"id\":264589},\"point\":1375}]");
        Mockito.verify(repository, Mockito.never()).findAll();
    }

    @Test
    void returnsEmptyArrayWhenCustomerHasNotPurchased() throws Exception {
        // Given
        PointHolderRepository repository = Mockito.mock(PointHolderRepository.class);
        Mockito.when(repository.findByCustomerId(1)).thenReturn(null);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new MonitorRestController(repository)).build();

        // When
        MvcResult result = mockMvc.perform(get("/monitor").param("customer", "1")).andReturn();

        // Then
        assertThat(result.getResponse().getStatus()).isEqualTo(200);
        assertThat(result.getResponse().getContentAsString()).isEqualTo("[]");
    }

    @Test
    void returnsAllPointHoldersWithoutCustomerParameter() throws Exception {
        // Given
        PointHolderRepository repository = Mockito.mock(PointHolderRepository.class);
        Mockito.when(repository.findAll()).thenReturn(List.of(
                new PointHolder(new Customer(1), 10),
                new PointHolder(new Customer(2), 20)));
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new MonitorRestController(repository)).build();

        // When
        MvcResult result = mockMvc.perform(get("/monitor")).andReturn();

        // Then
        assertThat(result.getResponse().getStatus()).isEqualTo(200);
        assertThat(result.getResponse().getContentAsString())
                .isEqualTo("[{\"customer\":{\"id\":1},\"point\":10},{\"customer\":{\"id\":2},\"point\":20}]");
    }

    @Test
    void rejectsNonNumericCustomer() throws Exception {
        // Given
        PointHolderRepository repository = Mockito.mock(PointHolderRepository.class);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new MonitorRestController(repository)).build();

        // When
        MvcResult result = mockMvc.perform(get("/monitor").param("customer", "abc")).andReturn();

        // Then
        assertThat(result.getResponse().getStatus()).isEqualTo(400);
    }
}
