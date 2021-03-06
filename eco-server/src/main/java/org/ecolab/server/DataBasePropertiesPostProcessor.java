package org.ecolab.server;

import java.util.Map;
import java.util.stream.Collectors;
import org.ecolab.server.db.h2.public_.tables.records.CommonSettingsRecord;
import org.jooq.impl.DSL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;


import static org.ecolab.server.db.h2.public_.Tables.COMMON_SETTINGS;

public class DataBasePropertiesPostProcessor implements EnvironmentPostProcessor {

    private static final String PROPERTY_SOURCE_NAME = "ecolab.";

    /**
     * Adds Spring Environment custom logic. This custom logic fetch properties from database and setting highest precedence
     */
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        if (environment.containsProperty("spring.datasource.url")) {
            var dataSourceUrl = environment.getProperty("spring.datasource.url");
            var username = environment.getProperty("spring.datasource.username");
            var password = environment.getProperty("spring.datasource.password");

            Map<String, Object> propertySource =
                    DSL.using(dataSourceUrl, username, password).selectFrom(COMMON_SETTINGS).fetch().stream().collect
                            (Collectors.toMap(CommonSettingsRecord::getName, CommonSettingsRecord::getValue, (a, b) -> b));
            // Create a custom property source with the highest precedence and add it to Spring Environment
            environment.getPropertySources().addFirst(new MapPropertySource(PROPERTY_SOURCE_NAME, propertySource));
        }
    }
}