package com.corhuila.shoppingcar.Service;

import com.corhuila.shoppingcar.Document.Factura;
import com.corhuila.shoppingcar.IRepository.IFacturaRepository;
import com.corhuila.shoppingcar.IService.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaService implements IFacturaService {

    //Conectar con los datos - IRepository
    // Inyección de dependencia
    @Autowired
    private IFacturaRepository repository;


    @Override
    public List<Factura> findAll() {
       return repository.findAll();
    }

    @Override
    public Optional<Factura> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Factura save(Factura factura) {
        return repository.save(factura);
    }

    @Override
    public void update(Factura factura, String id) {
        //Obtener el objeto factura y el id
        //Verificar con el id, si exiten los datos
        Optional<Factura> ps = repository.findById(id);

        //Cargar nuevo objeto
        if (!ps.isEmpty()){
            Factura facturaUpdate = ps.get();
            facturaUpdate.setFecha(factura.getFecha());
            facturaUpdate.setTotalBruto(factura.getTotalBruto());
            facturaUpdate.setTotalNeto(factura.getTotalNeto());
            facturaUpdate.setTotalDescuento(factura.getTotalDescuento());
            facturaUpdate.setTotalIva(factura.getTotalIva());
            facturaUpdate.setCliente(factura.getCliente());
            //Actualizar el objeto factura
            repository.save(facturaUpdate);
        }else{
            System.out.println("No existe el factura");
        }
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
