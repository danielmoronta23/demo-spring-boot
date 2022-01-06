package com.example.demo;

import com.example.demo.api.RestApi;
import com.example.demo.model.entities.Autor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("HOLA MUNDO");
      //  RestApi restApi = new RestApi();
        //restApi.agregar(new Autor("Daniel moronta"));
    }

}
