package com.csi;

import com.csi.model.User;
import com.csi.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class JwtcoreexApplication {

	@Autowired
	UserServiceImpl userServiceImpl;


	public static void main(String[] args) {
		SpringApplication.run(JwtcoreexApplication.class, args);
	}

	@PostConstruct
	public void saveData(){
		userServiceImpl.saveData(new User(121, "Swara", "Swara@csi.com", "Swara@2023"));
	}
}
