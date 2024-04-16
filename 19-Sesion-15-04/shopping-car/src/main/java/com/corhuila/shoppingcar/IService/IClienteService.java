package com.corhuila.shoppingcar.IService;

import com.corhuila.shoppingcar.Entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    List<Cliente> findAll(); // Devuelve una lista de clientes
    Optional<Cliente> findById(Long id); // Devuelve un cliente por su id
    Cliente save(Cliente cliente); // Guarda un cliente
    void update(Cliente cliente, Long id); // Actualiza un cliente
    void delete(Long id); // Elimina un cliente
}
