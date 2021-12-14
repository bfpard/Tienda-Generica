package Tienda.Generica.Repository;

import Tienda.Generica.Entity.Producto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    
    Optional<Producto> findByNit(String nit);
    boolean existsByNit(String nit);
    
    
}
