package com.inicio.CRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// Força o Spring a escanear tudo, inclusive bibliotecas externas como o SpringDoc
@ComponentScan(basePackages = {"com.inicio.CRUD", "org.springdoc"})
public class CrudApplication {
	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}
}