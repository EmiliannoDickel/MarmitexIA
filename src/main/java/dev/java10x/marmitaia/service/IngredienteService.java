package dev.java10x.marmitaia.service;

import dev.java10x.marmitaia.entity.Ingredientes;
import dev.java10x.marmitaia.repository.IngredienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredienteService {


    private final IngredienteRepository ingredienteRepository;

    public IngredienteService(IngredienteRepository ingredientesRepository) {
        this.ingredienteRepository = ingredientesRepository;
    }

    //criar
    public Ingredientes salvarIngredientes(Ingredientes ingredientes){
        return ingredienteRepository.save(ingredientes);
    }

    //buscar pelo Id
    public Optional<Ingredientes> buscarIngredientePeloId(Long id) {
        return ingredienteRepository.findById(id);
    }

    //listar tudo
    public List<Ingredientes> listarIngrendientes () {
        return ingredienteRepository.findAll();
    }

    //deletar
    public Void deletarIngredientePeloId(Long id) {
        ingredienteRepository.deleteById(id);
        return null;
    }

    //alterar
    public Ingredientes alterarIngrediente(Ingredientes ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }



}

