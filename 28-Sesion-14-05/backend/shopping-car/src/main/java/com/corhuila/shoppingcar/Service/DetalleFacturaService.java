package com.corhuila.shoppingcar.Service;

import com.corhuila.shoppingcar.Document.DetalleFactura;
import com.corhuila.shoppingcar.IRepository.IDetalleFacturaRepository;
import com.corhuila.shoppingcar.IService.IDetalleFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleFacturaService implements IDetalleFacturaService {

    //Conectar con los datos - IRepository
    // Inyección de dependencia
    @Autowired
    private IDetalleFacturaRepository repository;


    @Override
    public List<DetalleFactura> findAll() {
       return repository.findAll();
    }

    @Override
    public Optional<DetalleFactura> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public DetalleFactura save(DetalleFactura detalleFactura) {
        return repository.save(detalleFactura);
    }

    @Override
    public void update(DetalleFactura detalleFactura, String id) {
        //Obtener el objeto detalleFactura y el id
        //Verificar con el id, si exiten los datos
        Optional<DetalleFactura> ps = repository.findById(id);

        //Cargar nuevo objeto
        if (!ps.isEmpty()){
            DetalleFactura detalleFacturaUpdate = ps.get();
            detalleFacturaUpdate.setCantidad(detalleFactura.getCantidad());
            detalleFacturaUpdate.setValorUnitario(detalleFactura.getValorUnitario());
            detalleFacturaUpdate.setTotalBruto(detalleFactura.getTotalBruto());
            detalleFacturaUpdate.setTotalNeto(detalleFactura.getTotalNeto());
            detalleFacturaUpdate.setPorcentajeDescuento(detalleFactura.getPorcentajeDescuento());
            detalleFacturaUpdate.setPorcentajeIva(detalleFactura.getPorcentajeIva());
            detalleFacturaUpdate.setProductoId(detalleFactura.getProductoId());
            detalleFacturaUpdate.setFacturaId(detalleFactura.getFacturaId());
            //Actualizar el objeto detalleFactura
            repository.save(detalleFacturaUpdate);
        }else{
            System.out.println("No existe el detalleFactura");
        }
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
