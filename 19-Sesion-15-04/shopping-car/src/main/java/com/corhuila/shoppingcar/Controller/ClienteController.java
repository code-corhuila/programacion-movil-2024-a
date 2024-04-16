package com.corhuila.shoppingcar.Controller;

import com.corhuila.shoppingcar.Dto.IFacturaDto;
import com.corhuila.shoppingcar.Entity.Cliente;
import com.corhuila.shoppingcar.IService.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/cliente")
public class ClienteController {
    //Inyectar el servicio
    @Autowired
    private IClienteService service;

    @GetMapping()
    public List<Cliente> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> findById(@RequestParam Long id) {
        return service.findById(id);
    }

    @PostMapping()
    public Cliente save(@RequestBody Cliente cliente) {
        return service.save(cliente);
    }


    @PutMapping("/{id}")
    public void update(@RequestBody Cliente cliente, @RequestParam Long id) {
        service.update(cliente, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }
}
