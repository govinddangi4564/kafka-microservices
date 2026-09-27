package com.example.notification_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

}


/*
 *              cd C:\kafka_2.12-3.9.0
                bin\windows\zookeeper-server-start.bat config\zookeeper.properties 
                
                cd C:\kafka_2.12-3.9.0
                bin\windows\kafka-server-start.bat config\server.properties
 * 
 * */
 