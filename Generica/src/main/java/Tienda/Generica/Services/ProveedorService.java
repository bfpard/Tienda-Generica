package Tienda.Generica.Services;

import Tienda.Generica.Entity.Proveedor;
import Tienda.Generica.Repository.ProveedorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorService {
    
    @Autowired
    ProveedorRepository proveedorRepository;
    
    public List<Proveedor> lista(){
        return proveedorRepository.findAll();
    }
    
    public void save(Proveedor proveedor){
        proveedorRepository.save(proveedor);
    }
    
    public void delete(int id){
        proveedorRepository.deleteById(id);
    }
    
    public Optional<Proveedor> getById(int id){
        return proveedorRepository.findById(id);
    }
    
    public Optional<Proveedor> getByNit(String nit){
        return proveedorRepository.findByNit(nit);
    }
    
    public boolean existsByNit(String nit){
        return proveedorRepository.existsByNit(nit);
    }
    
}
