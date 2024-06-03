package com.yo1000.saleslog.infrastructure;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yo1000.saleslog.config.DataConfigurationProperties;
import com.yo1000.saleslog.domain.Customers;
import com.yo1000.saleslog.domain.PointHolder;
import com.yo1000.saleslog.domain.PointHolderRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ConditionalOnProperty(prefix = "app.data.file", name = "enabled", havingValue = "true", matchIfMissing = false)
@Repository
public class FilePointHolderRepository implements PointHolderRepository {
    private final ObjectMapper objectMapper;
    private final File file;

    public FilePointHolderRepository(
            ObjectMapper objectMapper,
            DataConfigurationProperties dataProperties
    ) {
        this.objectMapper = objectMapper;
        this.file = dataProperties.getFile().getPath().toFile();
        File dir = file.getParentFile();

        synchronized (file) {
            try {
                if (!dir.exists() && !dir.mkdirs()) {
                    throw new RuntimeException("Directory creation error");
                }
                if (!file.exists() && !file.createNewFile()) {
                    throw new RuntimeException("File creation error");
                }

                if (findAll().isEmpty()) {
                    save(new PointHolder(Customers.SQUALL.data(), 0));
                    save(new PointHolder(Customers.ZELL.data(), 0));
                    save(new PointHolder(Customers.IRVINE.data(), 0));
                    save(new PointHolder(Customers.QUISTIS.data(), 0));
                    save(new PointHolder(Customers.RINOA.data(), 0));
                    save(new PointHolder(Customers.SELPHIE.data(), 0));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Collection<PointHolder> findAll() {
        synchronized (file) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
                String json = reader.lines().collect(Collectors.joining());
                if (json.trim().isEmpty()) {
                    return Collections.emptyList();
                }
                return objectMapper.readValue(json, new TypeReference<List<PointHolder>>() {});
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public PointHolder findByCustomerId(int customerId) {
        synchronized (file) {
            return findAll().stream()
                    .filter(pointHolder -> pointHolder.getCustomer().id() == customerId)
                    .findFirst()
                    .orElse(null);
        }
    }

    @Override
    public synchronized PointHolder save(PointHolder pointHolder) {
        synchronized (file) {
            List<PointHolder> pointHolders = Stream
                    .concat(
                            findAll().stream().filter(exists -> exists.getCustomer().id() != pointHolder.getCustomer().id()),
                            Stream.of(pointHolder))
                    .toList();

            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)))) {
                writer.write(objectMapper.writeValueAsString(pointHolders));
                writer.flush();
                return pointHolder;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
