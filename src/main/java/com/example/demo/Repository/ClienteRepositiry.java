package com.example.demo.Repository;

import com.example.demo.Domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositiry extends JpaRepository<Cliente, Long> {
    Cliente findByNombreAndTelefono(String nombre, String telefono);
}
