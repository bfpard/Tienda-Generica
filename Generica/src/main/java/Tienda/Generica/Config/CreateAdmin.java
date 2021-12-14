package Tienda.Generica.Config;

import Tienda.Generica.Entity.Rol;
import Tienda.Generica.Entity.Usuario;
import Tienda.Generica.Enums.RolNombre;
import Tienda.Generica.Services.RolService;
import Tienda.Generica.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CreateAdmin implements CommandLineRunner {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
        /*Usuario usuario = new Usuario();
        String passwordEncoded = passwordEncoder.encode("admin123456");
        usuario.setNombre("Brayan Felipe Pardo Cortes");
        usuario.setCedula("1069756892");
        usuario.setCorreo("felcor1996@outlook.com");
        usuario.setNombreUsuario("admininicial");
        usuario.setPassword(passwordEncoded);
        Rol rolAdmin = rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get();
        Rol rolUser = rolService.getByRolNombre(RolNombre.ROLE_USER).get();
        Set<Rol> roles = new HashSet<>();
        roles.add(rolAdmin);
        roles.add(rolUser);
        usuario.setRoles(roles);
        usuarioService.save(usuario);*/
    }
}
