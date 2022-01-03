package com.example.demo.Controller;

import com.example.demo.Domain.Cliente;
import com.example.demo.Repository.ClienteRepositiry;
import com.example.demo.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = { "*"})
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

//---------------------------------------------------------------------------------------------------------------------
    @GetMapping
    public ResponseEntity<List<Cliente>> list(){
        return new ResponseEntity<List<Cliente>>(clienteService.getList(), HttpStatus.OK);
    }
//---------------------------------------------------------------------------------------------------------------------

    @GetMapping("/{id}")
    public ResponseEntity<?> listId (@PathVariable(value = "id") Long clienteId){
        Optional<Cliente> cliente = clienteService.getById(clienteId);

        if (!cliente.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }
//---------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------
    @PostMapping("/login")
    private Cliente login(@RequestBody Cliente cliente){
        Cliente _cliente = clienteService.findByNombreAndTelefono(cliente.getNombre(), cliente.getTelefono());
        return _cliente;
    }


//---------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------
 //---------------------------------------------------------------------------------------------------------------------

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.post(cliente));
    }

 //---------------------------------------------------------------------------------------------------------------------

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Cliente clienteMod, @PathVariable(value = "id") Long clienteId){
        Optional<Cliente> cliente = clienteService.getById(clienteId);
        if(!cliente.isPresent()){
            return ResponseEntity.notFound().build();
        }
        cliente.get().setNombre(clienteMod.getNombre());
        cliente.get().setApellido(clienteMod.getApellido());
        cliente.get().setTelefono(clienteMod.getTelefono());
        cliente.get().setDireccion(clienteMod.getDireccion());
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.post(cliente.get()));
    }

//---------------------------------------------------------------------------------------------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long clienteId){
        Optional<Cliente> cliente = clienteService.getById(clienteId);
        if (!cliente.isPresent()){
            return ResponseEntity.notFound().build();
        }
        clienteService.delete(clienteId);
        return ResponseEntity.ok().build();
    }




}
