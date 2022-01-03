package com.example.demo.Controller;

import com.example.demo.Domain.DTO.PrestamoDTO;
import com.example.demo.Domain.Prestamo;
import com.example.demo.Service.ClienteService;
import com.example.demo.Service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/prestamos")
public class PrestamoController {
    private Prestamo prestamo;

    private PrestamoDTO prestamoDTO;
    @Autowired
    private PrestamoService prestamoService;

    @Autowired
    private ClienteService clienteService;
//---------------------------------------------------------------------------------------------------------------------

//---------------------------------------------------------------------------------------------------------------------
    @GetMapping
    public List<PrestamoDTO> list(){

        List<Prestamo> prestamos = StreamSupport
                .stream(prestamoService.getList().spliterator(),false)
                .collect(Collectors.toList());

        List<PrestamoDTO> presDTO = prestamos.stream()
                .map(entity -> this.entityDTO(entity))
                .collect(Collectors.toList());
        return presDTO;
    }
//---------------------------------------------------------------------------------------------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<?> listId(@PathVariable(value = "id") Long prestamoId){
        Optional<Prestamo> prestamo = prestamoService.getById(prestamoId);
        if (!prestamo.isPresent()){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(prestamo);
    }
//---------------------------------------------------------------------------------------------------------------------
    @PostMapping("/{clienteId}")
    public Prestamo create (@PathVariable(value = "clienteId") Long clienteId, @RequestBody Prestamo prestamo){
        this.prestamo = prestamo;
        clienteService.getById(clienteId).map( cliente -> {
            this.prestamo.setCliente(cliente);
            return this.prestamo;
        });
        return prestamoService.post(prestamo);
//        Prestamo prestamos = prestamoService.post(prestamo);
//        return new ResponseEntity<Prestamo>(prestamos, HttpStatus.CREATED);
    }
//---------------------------------------------------------------------------------------------------------------------
    @PutMapping("/{id}")
    public ResponseEntity<?> update (@RequestBody Prestamo prestamoMod, @PathVariable(value = "id") Long prestamoId){
        Optional<Prestamo> prestamo = prestamoService.getById(prestamoId);
        if (!prestamo.isPresent()){
            ResponseEntity.notFound().build();
        }
        prestamo.get().setCantidad(prestamoMod.getCantidad());
        prestamo.get().setInteres(prestamoMod.getInteres());
        prestamo.get().setN_cuotas(prestamoMod.getN_cuotas());
        prestamo.get().setFecha_inicio(prestamoMod.getFecha_inicio());
        //prestamoDTO.setId_cliente(prestamoDTO.getId_cliente());
        //prestamo.get().setCliente(prestamoMod.getCliente());
        return ResponseEntity.status(HttpStatus.CREATED).body(prestamoService.post(prestamo.get()));
    }

//---------------------------------------------------------------------------------------------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long prestamoId){
        Optional<Prestamo> prestamo = prestamoService.getById(prestamoId);
        if (!prestamo.isPresent()){
            return  ResponseEntity.notFound().build();
        }
        prestamoService.delete(prestamoId);
        return ResponseEntity.ok().build();
    }
//---------------------------------------------------------------------------------------------------------------------

    public PrestamoDTO entityDTO( Prestamo prestamo){
        PrestamoDTO prestamoDTO = new PrestamoDTO();
        prestamoDTO.setId_prestamo(prestamo.getId_prestamo());
        prestamoDTO.setCantidad(prestamo.getCantidad());
        prestamoDTO.setInteres(prestamo.getInteres());
        prestamoDTO.setN_cuotas(prestamo.getN_cuotas());
        prestamoDTO.setFecha_inicio(prestamo.getFecha_inicio());
        prestamoDTO.setId_cliente(prestamo.getCliente().getId_cliente());
        return prestamoDTO;
    }

    public  Prestamo entity(){
        return null;
    }

}
