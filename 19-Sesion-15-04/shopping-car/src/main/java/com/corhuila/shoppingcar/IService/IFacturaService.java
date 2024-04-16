package com.corhuila.shoppingcar.IService;

import com.corhuila.shoppingcar.Dto.IFacturaDto;
import com.corhuila.shoppingcar.Entity.Factura;

import java.util.List;
import java.util.Optional;

public interface IFacturaService {
    List<Factura> findAll(); // Devuelve una lista de facturas
    Optional<Factura> findById(Long id); // Devuelve un factura por su id
    Factura save(Factura factura); // Guarda un factura
    void update(Factura factura, Long id); // Actualiza un factura
    void delete(Long id); // Elimina un factura

    List<IFacturaDto> getList();
}
