package Tienda.Generica.Repository;

import Tienda.Generica.Entity.Cliente;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
    Optional<Cliente> findByCedula(String cedula);
    boolean existsByCedula(String cedula);
    Optional<Cliente> findByCorreo(String correo);
    boolean existsByCorreo(String correo);
    
}
