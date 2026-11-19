package com.example.CatalogoFM.Controller;


import com.example.CatalogoFM.Model.Categoria;
import com.example.CatalogoFM.Repository.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "http://localhost:5173")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoryRepository) {

        this.categoriaRepository = categoryRepository;
    }

    // Endpoint PÚBLICO para consultar todos las categorias
    @GetMapping
    public List<Categoria> listarProductos() {

        return categoriaRepository.findAll();
    }

    // Endpoint PÚBLICO para consultar una categoria por ID
    @GetMapping("/categorias/{idcategoria}")
    public ResponseEntity<Categoria> obtenerProductoPorId(@PathVariable Long idcategoria) {
        return categoriaRepository.findById(idcategoria)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint PROTEGIDO para crear una categoria (requiere token JWT)
    @PostMapping
    public ResponseEntity<Categoria> crearProducto(@RequestBody Categoria categoria) {
        Categoria nuevaCategoria= categoriaRepository.save(categoria);
        return ResponseEntity.ok(nuevaCategoria);
    }

    @PutMapping("/actualizarCategoria/{idcategoria}")
    public void actualizarProducto(@PathVariable Long idcategoria, @RequestBody Categoria categoria) {
        categoriaRepository.deleteById(idcategoria);
        categoriaRepository.save(categoria);
    }

    @DeleteMapping("/categoriasEliminar/{idcategoria}")
    void deleteEmployee(@PathVariable Long idcategoria) {

        categoriaRepository.deleteById(idcategoria);
    }
}
