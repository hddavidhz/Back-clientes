package com.example.demo.Service;

import com.example.demo.Domain.Prestamo;
import com.example.demo.Repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoServiceImpl implements PrestamoService{

    @Autowired
    PrestamoRepository prestamoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Prestamo> getList() {
        return prestamoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Prestamo> getById(Long id) {
        return prestamoRepository.findById(id);
    }

    @Override
    @Transactional
    public Prestamo post(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @Override
    public void delete(Long id) {
        prestamoRepository.deleteById(id);
    }


//    @Override
//    public List<Prestamo> listar() {
//        return prestamoRepository.findAll();
//    }
//
//    @Override
//    public Prestamo registrar(Prestamo prestamo) {
//        return prestamoRepository.save(prestamo);
//    }
//
//    @Override
//    public Prestamo actualizar(Prestamo prestamo) {
//        return prestamoRepository.save(prestamo);
//    }
//
//    @Override
//    public void eliminar(Long id) {
//        prestamoRepository.deleteById(id);
//    }
//
//    @Override
//    public Prestamo ListarPorId(Long id) {
//        return prestamoRepository.findById(id).orElse(null);
//    }
}
