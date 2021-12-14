package Tienda.Generica.Repository;

import Tienda.Generica.Entity.Proveedor;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer>{
    
    Optional<Proveedor> findByNit(String nit);
    boolean existsByNit(String nit);
    
    
}
