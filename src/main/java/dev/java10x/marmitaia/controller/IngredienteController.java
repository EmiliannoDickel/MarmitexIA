package dev.java10x.marmitaia.controller;

import dev.java10x.marmitaia.entity.Ingredientes;
import dev.java10x.marmitaia.service.IngredienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/api/ingrediente")
public class IngredienteController {
    private IngredienteService ingredienteService;

    public IngredienteController(IngredienteService ingredientesService) {
        this.ingredienteService = ingredientesService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Ingredientes>> listarIngredientes () {
        List<Ingredientes> lista = ingredienteService.listarIngrendientes();
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirIngrediente (@PathVariable Long id) {
        ingredienteService.deletarIngredientePeloId(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/criar")
    public ResponseEntity<Ingredientes> criarIngrediente(@RequestBody Ingredientes ingredientesDTO) {
        Ingredientes ingredienteSalvo = ingredienteService.salvarIngredientes(ingredientesDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ingredienteSalvo);
    }

//    @PostMapping("/criar")
//    public ResponseEntity<Ingredientes> criarIngrediente(@RequestBody Ingredientes ingrediente) {
//        if (ingrediente.getCalorias() == 0) {
//            ingrediente.setCalorias(consultarCaloriasOpenAI(ingrediente.getNome()));
//        }
//        ingredienteService.salvarIngredientes(ingrediente);
//        return ResponseEntity.ok(ingrediente);
//    }
//
//        private int consultarCaloriasOpenAI(Ingredientes ingrediente) {
//            String prompt = "Quantas calorias tem " + ingrediente.getQuantidade() + " de"  + ingrediente.getNome() + "? Apenas me dê o número.";
//            String resposta = chamarAPIChatGPT(prompt);
//            return Integer.parseInt(resposta.replaceAll("[^0-9]", ""));
//        }
//
//        private String chamarAPIChatGPT(String prompt) {
//            // Aqui você faria a requisição para a API da OpenAI e retornaria a resposta
//            return "50"; // Exemplo de resposta fixa (substituir pela real)
//        }












    @GetMapping("/{id}")
    public ResponseEntity<Ingredientes> buscarIngredientePeloId(@PathVariable Long id) {
        ingredienteService.buscarIngredientePeloId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarIngrediente (@RequestBody Ingredientes ingredientes, @PathVariable Long id ) {
        return ingredienteService.buscarIngredientePeloId(id).map(itemExistente -> {
            ingredientes.setId(itemExistente.getId());
            Ingredientes atualizado = ingredienteService.alterarIngrediente(ingredientes);
            return ResponseEntity.status(HttpStatus.OK).body(atualizado.toString());
        })
                .orElse(ResponseEntity.notFound().build());

    }


}
