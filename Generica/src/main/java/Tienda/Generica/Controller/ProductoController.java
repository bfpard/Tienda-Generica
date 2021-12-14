package Tienda.Generica.Controller;

import Tienda.Generica.Config.CSVHelper;
import Tienda.Generica.Entity.Producto;
import Tienda.Generica.Services.ProductoService;
import Tienda.Generica.Services.ProveedorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductoController {
    
    @Autowired
    ProductoService productoService;
    
    @Autowired
    ProveedorService proveedorService;
    
    @GetMapping("/productos")
    public String productos(Model model){
        var producto = productoService.lista();
        model.addAttribute("personas", producto);
        return "productos/productos";
    }

    @PostMapping("/cargar")
    public String uploadFile(@RequestParam("file") MultipartFile file,Model model) {
        if (CSVHelper.hasCSVFormat(file)) {
            try {
                List<Producto> producto = CSVHelper.csvToTutorials(file.getInputStream());
                System.out.println("DATOSSSSS LEIDOSS CORRECTAMNTE");
                for(int i=0;i < producto.size();i++){
                    var nitevalue = producto.get(i).getNit();
                    if(proveedorService.existsByNit(nitevalue)){
                        System.out.println("SI EXISTE NIT DEL PROVEEDORRRRRRRRR");
                        Producto nproduct = new Producto();
                        nproduct.setNombre(producto.get(i).getNombre());
                        nproduct.setNit(producto.get(i).getNit());
                        nproduct.setPrecioCompra(producto.get(i).getPrecioCompra());
                        nproduct.setIva(producto.get(i).getIva());
                        nproduct.setPrecioVenta(producto.get(i).getPrecioVenta());
                        productoService.save(nproduct);
                        return "redirect:/productos";
                    }else{
                        System.out.println("llegue al elseeeeeeeeeee");
                        int idemas = i+1;
                        var product = productoService.lista();
                        model.addAttribute("personas", product);
                        model.addAttribute("error","El NIT "+producto.get(i).getNit()+" del producto con el codigo: "+idemas+", no esta registrado en los proveedores");
                        return "productos/productos";
                    }
                }
                
                return "home";
            } catch (Exception e) {
                model.addAttribute("error","No se puedo cargar el archivo intente nuevamente");
                return "usuarios";
            }
        }
        model.addAttribute("error","Este no es un archivo csv");
        return "productos/productos";
    }
    
    @GetMapping("/registro_producto")
    public String registroProducto(Producto producto, Model model){
        model.addAttribute("producto", producto);
        return "productos/registroproductos";
    }
    
    @PostMapping("/agregar_producto")
    public String agregarProducto(Producto producto, Model model){
        if(proveedorService.existsByNit(producto.getNit())){
            productoService.save(producto);
            return "redirect:/productos";
        }else{
            var product = productoService.lista();
            model.addAttribute("personas", product);
            model.addAttribute("error","El NIT del producto no esta asociado a ningun proveedor");
            return "productos/productos";
        }
    }
    
    @GetMapping("/editar_producto/{id}")
    public String editarCProducto(@PathVariable("id")int id,Model model){
        var producto = productoService.getById(id).get();
        model.addAttribute("producto", producto);
        return "productos/editarproductos";
    }
    
    @PostMapping("actualizar_producto")
    public String actualizarProducto(Producto producto,Model model){
        
        if(proveedorService.existsByNit(producto.getNit())){
            productoService.save(producto);
            return "redirect:/productos";
        }else{
            var product = productoService.lista();
            model.addAttribute("personas", product);
            model.addAttribute("error","El NIT del producto no esta asociado a ningun proveedor");
            return "productos/productos";
        }
    }
    
    @GetMapping("/borrar_producto/{id}")
    public String deleteProducto(@PathVariable("id")int id){
        productoService.delete(id);
        return "redirect:/productos";
    }

}
