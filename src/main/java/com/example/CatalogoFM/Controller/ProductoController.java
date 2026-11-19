package com.example.CatalogoFM.Controller;

import com.example.CatalogoFM.Model.Producto;
import com.example.CatalogoFM.Repository.ProductoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductoController {

    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productRepository) {
        this.productoRepository = productRepository;
    }

    // Endpoint PÚBLICO para consultar todos los productos
    @GetMapping
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    // Endpoint PÚBLICO para consultar un producto por ID
    @GetMapping("/productos/{idProducto}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long idproducto) {
        return productoRepository.findById(idproducto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint PROTEGIDO para crear un producto (requiere token JWT)
    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoRepository.save(producto);
        return ResponseEntity.ok(nuevoProducto);
    }

    @PutMapping("/actualizarproducto/{id}")
    public void actualizarProducto(@PathVariable Long idproducto, @RequestBody Producto producto) {
        productoRepository.deleteById(idproducto);
        productoRepository.save(producto);
    }

    @DeleteMapping("/productosEliminar/{id}")
    void deleteEmployee(@PathVariable Long idproducto) {

        productoRepository.deleteById(idproducto);
    }
}
