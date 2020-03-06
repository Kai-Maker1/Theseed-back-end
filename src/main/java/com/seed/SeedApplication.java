package com.seed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableCaching
public class SeedApplication {
    private static Logger logger = LoggerFactory.getLogger(SeedApplication.class);
    public static void main(String[] args) {
        logger.info("后台启动成功！");
        SpringApplication.run(SeedApplication.class, args);

    }

}

