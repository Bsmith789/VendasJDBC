package com.qintess.curso;

import com.qintess.curso.domain.entity.Cliente;
import com.qintess.curso.domain.repositorio.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClienteRepo clienteRepo){
        return args -> {
            clienteRepo.salvar(new Cliente("Gabriel"));
            clienteRepo.salvar(new Cliente("Mônica"));

            List<Cliente> todosClientes = clienteRepo.obterTodos();
            todosClientes.forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class,args);
    }
}
