package com.advantest.logExecTime;

import com.advantest.logExecTime.services.Calculate;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class LogExecTimeApplication {

	@Autowired
	private Calculate calculate;

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(LogExecTimeApplication.class, args);
	}

	@PostConstruct
	public void initialize() throws InterruptedException {
		calculate.addTwoArrayList();
	}
}