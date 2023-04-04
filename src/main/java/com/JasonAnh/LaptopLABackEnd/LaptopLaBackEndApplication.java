package com.JasonAnh.LaptopLABackEnd;

import com.JasonAnh.LaptopLABackEnd.configuration.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@EnableScheduling
@EnableConfigurationProperties(FileStorageProperties.class)
@SpringBootApplication
@EntityScan(basePackageClasses = {LaptopLaBackEndApplication.class, Jsr310JpaConverters.class})
public class LaptopLaBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaptopLaBackEndApplication.class, args);
	}

}
