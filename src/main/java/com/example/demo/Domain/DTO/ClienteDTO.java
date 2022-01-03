package com.example.demo.Domain.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class ClienteDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id_cliente;

    private String nombre;

    private String apellido;

    private String telefono;

    private String direccion;

    private List<PrestamoDTO> prestamos;

}
