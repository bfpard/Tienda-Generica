package Tienda.Generica.Controller;

import Tienda.Generica.Entity.Proveedor;
import Tienda.Generica.Services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProveedorController {
    
    @Autowired
    ProveedorService proveedorService;
    
    @GetMapping("/proveedores")
    public String proveedores(Model model){
        var proveedor = proveedorService.lista();
        model.addAttribute("personas", proveedor);
        return "proveedores/proveedores";
    }
    
    @GetMapping("/registro_proveedor")
    public String registroProveedor(Proveedor proveedor, Model model){
        model.addAttribute("proveedor", proveedor);
        return "proveedores/registroproveedor";
    }
    
    @PostMapping("/agregar_proveedor")
    public String agregarProveedor(Proveedor proveedor, Model model){
        if(proveedorService.existsByNit(proveedor.getNit())){
            model.addAttribute("error", "El NIT ya se encuentra registrado");
            return "proveedores/registroproveedor";
        }
        proveedorService.save(proveedor);
        return "redirect:/proveedores";
    }
    
    @GetMapping("/editar_proveedor/{id}")
    public String editarProveedor(@PathVariable("id")int id,Model model){
        var provee = proveedorService.getById(id).get();
        model.addAttribute("proveedor", provee);
        return "proveedores/editarproveedor";
    }
    
    @PostMapping("actualizar_proveedor")
    public String actualizarProveedor(Proveedor proveedor,Model model){
        if(proveedorService.existsByNit(proveedor.getNit()) && proveedorService.getByNit(proveedor.getNit()).get().getId() != proveedor.getId()){
            model.addAttribute("error", "El NIT ya esta registrado");
            return "proveedores/editarproveedor";
        }
        
        proveedorService.save(proveedor);
        return "redirect:/proveedores";
    }
    
    @GetMapping("/borrar_proveedor/{id}")
    public String deleteProveedor(@PathVariable("id")int id){
        proveedorService.delete(id);
        return "redirect:/proveedores";
    }
    
    @GetMapping("buscar_proveedor")
    public String buscarProveedor(@RequestParam String bccedula,Model model){
        System.out.println(bccedula);
        if (proveedorService.existsByNit(bccedula)) {
            Proveedor bproveedor = proveedorService.getByNit(bccedula).get();
            model.addAttribute("personas", bproveedor);
            return "proveedores/busquedaproveedor";
        }else{
            var bpersona = proveedorService.lista();
            model.addAttribute("personas", bpersona);
            model.addAttribute("error", "El NIT no esta registrado");
            return "proveedores/proveedores";
        }
    }
    
}
