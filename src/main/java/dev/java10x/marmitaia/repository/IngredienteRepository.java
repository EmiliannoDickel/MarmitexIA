package dev.java10x.marmitaia.repository;

import dev.java10x.marmitaia.entity.Ingredientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingredientes, Long> {
}
