package Tienda.Generica.Entity;

import javax.persistence.*;

@Entity
public class Producto {
    
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int id;
    
    @Column(name = "fullname",nullable = true)
    private String nombre;
    
    @Column(name = "nit",nullable = true)
    private String nit;
    
    @Column(name = "precio_compra")
    private String precioCompra;
    
    @Column(name = "IVA")
    private String iva;
    
    @Column(name = "precio_venta",nullable = true)
    private String precioVenta;

    public Producto() {
    }

    public Producto(int id, String nombre, String nit, String precioCompra, String iva, String precioVenta) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
        this.precioCompra = precioCompra;
        this.iva = iva;
        this.precioVenta = precioVenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(String precioCompra) {
        this.precioCompra = precioCompra;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(String precioVenta) {
        this.precioVenta = precioVenta;
    }

    

    
    
    
}
