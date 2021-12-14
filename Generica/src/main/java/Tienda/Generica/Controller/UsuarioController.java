package Tienda.Generica.Controller;

import Tienda.Generica.Entity.Usuario;
import Tienda.Generica.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @GetMapping("/usuarios")
    public String usuarios(Model model){
        var personas = usuarioService.lista();
        model.addAttribute("personas", personas);
        return "usuarios";
    }
    
    @GetMapping("/registro")
    public String registro(Usuario usuario,Model model){
        model.addAttribute("usuario", usuario);
        return "registro";
    }
    
    @PostMapping("/agregar")
    public String agregar(Usuario usuario, Model model){
        if(usuarioService.existsByCedula(usuario.getCedula())){
            model.addAttribute("error", "La cedula ya se encuentra registrada");
            return "registro";
        }
        if(usuarioService.existsByCorreo(usuario.getCorreo())){
            model.addAttribute("error", "El correo ya se encuentra registrado");
            return "registro";
        }
        if(usuarioService.existsByNombreusuario(usuario.getNombreUsuario())){
            model.addAttribute("error", "El usuario ya se encuentra registrado");
            return "registro";
        }
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioService.save(usuario);
        return "redirect:/usuarios";
    }
    
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id")int id,Model model){
        var persona = usuarioService.getById(id).get();
        model.addAttribute("usuario", persona);
        return "editar";
        
    }
    
    @PostMapping("/actualizar")
    public String actualizar(Usuario usuario,Model model){
        
        if(usuarioService.existsByCedula(usuario.getCedula()) && usuarioService.getByCedula(usuario.getCedula()).get().getId() != usuario.getId()){
            model.addAttribute("error", "La cedula ya esta registrada");
            return "editar";
        }
        if(usuarioService.existsByCorreo(usuario.getCorreo()) && usuarioService.getByCorreo(usuario.getCorreo()).get().getId() != usuario.getId()){
            model.addAttribute("error", "El correo ya esta registrado");
            return "editar";
        }
        if(usuarioService.existsByNombreusuario(usuario.getNombreUsuario()) && usuarioService.getByNombreUsuario(usuario.getNombreUsuario()).get().getId() != usuario.getId()){
            model.addAttribute("error", "El usuario ya esta registrado");
            return "editar";
        }
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioService.save(usuario);
        return "redirect:/usuarios";
    }
    
    @GetMapping("/borrar/{id}")
    public String delete(@PathVariable("id")int id){
        usuarioService.delete(id);
        return "redirect:/usuarios";
    }
    
    @GetMapping("/buscar")
    public String buscar(@RequestParam String bcedula,Model model){
        if (usuarioService.existsByCedula(bcedula)) {
            Usuario bpersona = usuarioService.getByCedula(bcedula).get();
            model.addAttribute("bpersona", bpersona);
            return "busqueda";
        }else{
            var bpersona = usuarioService.lista();
            model.addAttribute("personas", bpersona);
            model.addAttribute("error", "La cedula no esta registrada");
            return "usuarios";
        }
    }
}
