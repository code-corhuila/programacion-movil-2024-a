package com.corhuila.shoppingcar.IService;

import com.corhuila.shoppingcar.Document.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    List<Cliente> findAll(); // Devuelve una lista de clientes
    Optional<Cliente> findById(String id); // Devuelve un cliente por su id
    Cliente save(Cliente cliente); // Guarda un cliente
    void update(Cliente cliente, String id); // Actualiza un cliente
    void deleteLogical(Cliente cliente, String id); // Eliminado lógico
    void delete(String id); // Elimina un cliente
}
