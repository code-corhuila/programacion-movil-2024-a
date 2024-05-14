package com.corhuila.shoppingcar.Controller;

import com.corhuila.shoppingcar.Document.DetalleFactura;
import com.corhuila.shoppingcar.IService.IDetalleFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/detalleDetalleFactura")
public class DetalleFacturaController {
    //Inyectar el servicio
    @Autowired
    private IDetalleFacturaService service;

    @GetMapping()
    public List<DetalleFactura> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<DetalleFactura> findById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping()
    public DetalleFactura save(@RequestBody DetalleFactura detalleDetalleFactura) {
        return service.save(detalleDetalleFactura);
    }


    @PutMapping("/{id}")
    public void update(@RequestBody DetalleFactura detalleDetalleFactura, @PathVariable String id) {
        service.update(detalleDetalleFactura, id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
