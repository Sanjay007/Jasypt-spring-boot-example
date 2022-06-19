package com.frugalis.jasypt;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JasyptSpringBootApplication {


    public static void main(String[] args) {
    //System.setProperty("jasypt.encryptor.password","mysecretpwd");
        SpringApplication.run(JasyptSpringBootApplication.class, args);
    }



}
