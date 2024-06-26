package com.corhuila.shoppingcar.Controller;

import com.corhuila.shoppingcar.Dto.IFacturaDto;
import com.corhuila.shoppingcar.Entity.Factura;
import com.corhuila.shoppingcar.IService.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/factura")
public class FacturaController {
    //Inyectar el servicio
    @Autowired
    private IFacturaService service;

    @GetMapping()
    public List<Factura> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Factura> findById(@RequestParam Long id) {
        return service.findById(id);
    }

    @PostMapping()
    public Factura save(@RequestBody Factura factura) {
        return service.save(factura);
    }


    @PutMapping("/{id}")
    public void update(@RequestBody Factura factura, @RequestParam Long id) {
        service.update(factura, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }

    @GetMapping("/getList")
    public List<IFacturaDto> getList(){
        return service.getList();
    }
}
