package com.example.CatalogoFM.Repository;

import com.example.CatalogoFM.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
