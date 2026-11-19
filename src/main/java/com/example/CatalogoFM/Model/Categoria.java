package com.example.CatalogoFM.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcategoria;

    private String nombrecategoria;

    public Categoria() {
    }

    public Categoria(Long idcategoria, String nombrecategoria) {
        this.idcategoria = idcategoria;
        this.nombrecategoria = nombrecategoria;
    }

    public Long getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Long idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNombrecategoria() {
        return nombrecategoria;
    }

    public void setNombrecategoria(String nombrecategoria) {
        this.nombrecategoria = nombrecategoria;
    }
}