package br.com.hdi.corretorativo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CorretorAtivoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorretorAtivoApplication.class, args);
	}

}
