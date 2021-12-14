package Tienda.Generica.Services;

import Tienda.Generica.Entity.Producto;
import Tienda.Generica.Repository.ProductoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    
    @Autowired
    ProductoRepository productoRepository;
    
    public void save(Producto producto){
        productoRepository.save(producto);
    }
    
    public void delete(int id){
        productoRepository.deleteById(id);
    }
    
    public List<Producto> lista(){
        return productoRepository.findAll();
    }
    
    public Optional<Producto> getByNit(String nit){
        return productoRepository.findByNit(nit);
    }
    
    public boolean existsByNit(String nit){
        return productoRepository.existsByNit(nit);
    }
    
    public Optional<Producto> getById(int id){
        return productoRepository.findById(id);
    }
    
}
