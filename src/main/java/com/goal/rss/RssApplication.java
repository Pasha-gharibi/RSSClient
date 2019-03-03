package com.goal.rss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


/*
* Automatically @ComponentScan will raise with @SpringBootApplication and scans the default path in which this project is :com.goal.rss.*
* */
@SpringBootApplication
@EnableScheduling
public class RssApplication {

	public static void main(String[] args) {
		SpringApplication.run(RssApplication.class, args);
	}

}
