package br.com.cesurgmarau.bancos; // <--- AQUI ESTÁ O SEGREDO: tem que ter o .bancos

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// Como seus controllers também estão dentro de 'bancos', isso deve bastar.
public class BancosApplication {

    public static void main(String[] args) {
        SpringApplication.run(BancosApplication.class, args);
    }

}