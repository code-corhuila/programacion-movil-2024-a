package com.corhuila.shoppingcar.IService;

import com.corhuila.shoppingcar.Entity.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    List<Producto> findAll(); // Devuelve una lista de productos
    Optional<Producto> findById(Long id); // Devuelve un producto por su id
    Producto save(Producto producto); // Guarda un producto
    void update(Producto producto, Long id); // Actualiza un producto
    void delete(Long id); // Elimina un producto
}
