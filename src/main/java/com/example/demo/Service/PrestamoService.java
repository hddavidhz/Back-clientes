package com.example.demo.Service;
import com.example.demo.Domain.Cliente;
import com.example.demo.Domain.Prestamo;
import java.util.List;
import java.util.Optional;


public interface PrestamoService {

//    List<Prestamo> listar();
//
//    Prestamo registrar (Prestamo prestamo);
//
//    Prestamo actualizar (Prestamo prestamo);
//
//    void eliminar(Long id);
//
//    Prestamo ListarPorId(Long id);

    List<Prestamo> getList();

    Optional<Prestamo> getById(Long id);

    Prestamo post (Prestamo prestamo);

    void delete(Long id);

}
