package com.example.demo.Domain.DTO;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Data
public class PrestamoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id_prestamo;

    private Integer cantidad;

    private float interes;

    private  Integer n_cuotas;

    private Date fecha_inicio;

    private Long id_cliente;
}
