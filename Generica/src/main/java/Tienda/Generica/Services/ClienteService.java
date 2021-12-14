package Tienda.Generica.Services;

import Tienda.Generica.Entity.Cliente;
import Tienda.Generica.Repository.ClienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;
    
    public List<Cliente> lista(){
        return clienteRepository.findAll();
    }
    
    public void save(Cliente cliente){
        clienteRepository.save(cliente);
    }
    
    public void delete(int id){
        clienteRepository.deleteById(id);
    }
    
    public Optional<Cliente> getByCedula(String cedula){
        return clienteRepository.findByCedula(cedula);
    }
    
    public Optional<Cliente> getByCorreo(String correo){
        return clienteRepository.findByCorreo(correo);
    }
    
    public boolean existsByCedula(String cedula){
        return clienteRepository.existsByCedula(cedula);
    }
    
    public boolean existsByCorreo(String correo){
        return clienteRepository.existsByCorreo(correo);
    }
    
    public Optional<Cliente> getById(int id){
        return clienteRepository.findById(id);
    }
}
