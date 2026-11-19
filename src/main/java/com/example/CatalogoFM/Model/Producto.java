package com.example.CatalogoFM.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idproducto;
    private String codigo;
    private String nombreproducto;
    private String descripcion;
    private double precio;
    private double preciooferta;
    private int stock;
    private int stockCritico;
    private String imagenUrl;
    private Boolean disponible;
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria miCategoria;

    public Producto() {
    }

    public Producto(Long idproducto, String codigo, String nombreproducto, String descripcion, double precio, double preciooferta, int stock, int stockCritico, Boolean disponible, String imagenUrl, Categoria miCategoria) {
        this.idproducto = idproducto;
        this.codigo = codigo;
        this.nombreproducto = nombreproducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.preciooferta = preciooferta;
        this.stock = stock;
        this.stockCritico = stockCritico;
        this.disponible = disponible;
        this.imagenUrl = imagenUrl;
        this.miCategoria = miCategoria;
    }

    public Long getIdproducto() {return idproducto;}

    public void setIdproducto(Long idproducto) {this.idproducto = idproducto;}

    public String getCodigo() {return codigo;}

    public void setCodigo(String codigo) {this.codigo = codigo;}

    public String getNombreproducto() {return nombreproducto;}

    public void setNombreproducto(String nombreproducto) {this.nombreproducto = nombreproducto;}

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public double getPrecio() {return precio;}

    public void setPrecio(double precio) {this.precio = precio;}

    public double getPreciooferta() {return preciooferta;}

    public void setPreciooferta(double preciooferta) {this.preciooferta = preciooferta;}

    public int getStock() {return stock;}

    public void setStock(int stock) {this.stock = stock;}

    public int getStockCritico() {return stockCritico;}

    public void setStockCritico(int stockCritico) {this.stockCritico = stockCritico;}

    public String getImagenUrl() {return imagenUrl;}

    public void setImagenUrl(String imagenUrl) {this.imagenUrl = imagenUrl;}

    public Categoria getMiCategoria() {return miCategoria;}

    public void setMiCategoria(Categoria miCategoria) {this.miCategoria = miCategoria;}

    public Boolean getDisponible() {return disponible;}

    public void setDisponible(Boolean disponible) {this.disponible = disponible;}
}
