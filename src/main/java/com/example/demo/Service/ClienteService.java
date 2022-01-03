package com.example.demo.Service;

import com.example.demo.Domain.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Cliente> getList();

    Optional<Cliente> getById(Long id);

    Cliente findByNombreAndTelefono(String nombre, String telefono);

    Cliente post (Cliente cliente);

    void delete(Long id);

}
