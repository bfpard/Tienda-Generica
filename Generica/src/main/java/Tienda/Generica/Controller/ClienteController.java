package Tienda.Generica.Controller;

import Tienda.Generica.Entity.Cliente;
import Tienda.Generica.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;
    
    @GetMapping("/clientes")
    public String clientes(Model model){
        var cliente = clienteService.lista();
        model.addAttribute("personas", cliente);
        return "/clientes/clientes";
    }
    
    @GetMapping("/registro_cliente")
    public String registroCliente(Cliente cliente, Model model){
        model.addAttribute("cliente", cliente);
        return "clientes/registrocliente";
    }
    
    @PostMapping("/agregar_cliente")
    public String agregarCliente(Cliente cliente, Model model){
        if(clienteService.existsByCedula(cliente.getCedula())){
            model.addAttribute("error", "La cedula ya se encuentra registrada");
            return "clientes/registrocliente";
        }
        if(clienteService.existsByCorreo(cliente.getCorreo())){
            model.addAttribute("error", "El correo ya se encuentra registrado");
            return "clientes/registrocliente";
        }
        clienteService.save(cliente);
        return "redirect:/clientes";
    }
    
    @GetMapping("/editar_cliente/{id}")
    public String editarCliente(@PathVariable("id")int id,Model model){
        var client = clienteService.getById(id).get();
        model.addAttribute("cliente", client);
        return "clientes/editarcliente";
    }
    
    @PostMapping("actualizar_cliente")
    public String actualizarCliente(Cliente cliente,Model model){
        if(clienteService.existsByCedula(cliente.getCedula()) && clienteService.getByCedula(cliente.getCedula()).get().getId() != cliente.getId()){
            model.addAttribute("error", "La cedula ya esta registrada");
            return "clientes/editarcliente";
        }
        if(clienteService.existsByCorreo(cliente.getCorreo()) && clienteService.getByCorreo(cliente.getCorreo()).get().getId() != cliente.getId()){
            model.addAttribute("error", "El correo ya esta registrado");
            return "clientes/editarcliente";
        }
        
        clienteService.save(cliente);
        return "redirect:/clientes";
    }
    
    @GetMapping("/borrar_cliente/{id}")
    public String deleteCliente(@PathVariable("id")int id){
        clienteService.delete(id);
        return "redirect:/clientes";
    }
    
    @GetMapping("buscar_cliente")
    public String buscarCliente(@RequestParam String bccedula,Model model){
        if (clienteService.existsByCedula(bccedula)) {
            Cliente bpersona = clienteService.getByCedula(bccedula).get();
            model.addAttribute("personas", bpersona);
            return "clientes/busquedacliente";
        }else{
            var bpersona = clienteService.lista();
            model.addAttribute("personas", bpersona);
            model.addAttribute("error", "La cedula no esta registrada");
            return "clientes/clientes";
        }
    }
}
