package com.example.demo.Service;

import com.example.demo.Domain.Cliente;
import com.example.demo.Repository.ClienteRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    public ClienteRepositiry clienteRepositiry;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getList() {
        return clienteRepositiry.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cliente> getById(Long id) {
        return clienteRepositiry.findById(id);
    }

    @Override
    public Cliente findByNombreAndTelefono(String nombre, String telefono) {
        return clienteRepositiry.findByNombreAndTelefono(nombre, telefono);
    }

    @Override
    @Transactional
    public Cliente post(Cliente cliente) {
        return clienteRepositiry.save(cliente);
    }

    @Override
    public void delete(Long id) {
        clienteRepositiry.deleteById(id);
    }
}
