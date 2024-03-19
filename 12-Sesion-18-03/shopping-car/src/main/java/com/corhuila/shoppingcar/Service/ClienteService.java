package com.corhuila.shoppingcar.Service;

import com.corhuila.shoppingcar.Entity.Cliente;
import com.corhuila.shoppingcar.IRepository.IClienteRepository;
import com.corhuila.shoppingcar.IService.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {

    //Conectar con los datos - IRepository
    // Inyección de dependencia
    @Autowired
    private IClienteRepository repository;


    @Override
    public List<Cliente> findAll() {
       return repository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public void update(Cliente cliente, Long id) {
        //Obtener el objeto cliente y el id
        //Verificar con el id, si exiten los datos
        Optional<Cliente> ps = repository.findById(id);

        //Cargar nuevo objeto
        if (!ps.isEmpty()){
            Cliente clienteUpdate = ps.get();
            clienteUpdate.setNombre(cliente.getNombre());
            clienteUpdate.setDocumento(cliente.getDocumento());
            clienteUpdate.setMetodoPago(cliente.getMetodoPago());
            clienteUpdate.setDireccion(cliente.getDireccion());

            //Actualizar el objeto cliente
            repository.save(clienteUpdate);
        }else{
            System.out.println("No existe el cliente");
        }
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
