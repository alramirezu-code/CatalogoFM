package com.example.CatalogoFM.Repository;

import com.example.CatalogoFM.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
