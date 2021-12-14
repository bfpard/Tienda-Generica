package Tienda.Generica.Services;

import Tienda.Generica.Entity.Usuario;
import Tienda.Generica.Repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> lista(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getById(int id){
        return usuarioRepository.findById(id);
    }
    
    public Optional<Usuario> getByCedula(String cedula){
        return usuarioRepository.findByCedula(cedula);
    }
    
    public Optional<Usuario> getByCorreo(String correo){
        return usuarioRepository.findByCorreo(correo);
    }

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }
    
    public void delete(int id){
        usuarioRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return usuarioRepository.existsById(id);
    }

    public boolean existsByNombreusuario(String nombreUsuario){
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByCedula(String cedula){
        return usuarioRepository.existsByCedula(cedula);
    }
    
    public boolean existsByCorreo(String correo){
        return usuarioRepository.existsByCorreo(correo);
    }
}
