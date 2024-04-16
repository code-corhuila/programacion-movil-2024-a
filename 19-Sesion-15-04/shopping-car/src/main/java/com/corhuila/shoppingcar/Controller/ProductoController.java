package com.corhuila.shoppingcar.Controller;

import com.corhuila.shoppingcar.Entity.Producto;
import com.corhuila.shoppingcar.IService.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/producto")
public class ProductoController {
    //Inyectar el servicio
    @Autowired
    private IProductoService service;

    @GetMapping()
    public List<Producto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Producto> findById(@RequestParam Long id) {
        return service.findById(id);
    }

    @PostMapping()
    public Producto save(@RequestParam Producto producto) {
        return service.save(producto);
    }


    @PutMapping("/{id}")
    public void update(@RequestBody Producto producto, @RequestParam Long id) {
        service.update(producto, id);
    }
    @DeleteMapping("/{id}")

    public void delete(@RequestParam Long id) {
        service.delete(id);
    }
}
