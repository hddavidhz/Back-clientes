package com.example.demo.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "prestamo")
public class Prestamo implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prestamo;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "interes")
    private float interes;

    @Column(name = "n_cuotas")
    private  Integer n_cuotas;

    @Column(name = "fecha_inicio")
    private Date fecha_inicio;

//    @ManyToOne
//    @JoinColumn(name = "id_cliente")
//    private Cliente cliente;

//---------------------------------------------------------------------------
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente",referencedColumnName = "id_cliente")
    @JsonIgnore
    private Cliente cliente;

}
