package com.curso.java.udemy.Curso.java.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursoJavaSpringBootApplication implements CommandLineRunner {
	
	private static final Logger LOG = LoggerFactory.getLogger(CursoJavaSpringBootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CursoJavaSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Iniciando o run");

		Curso curso = new Curso();
		String tst =  curso.mostraDados();
		
		LOG.info("Finalizando o run");
		LOG.warn("Alerta no código");
		LOG.error("Erro no código");
		
		LOG.debug("Debugando o código");
		
	}

}
