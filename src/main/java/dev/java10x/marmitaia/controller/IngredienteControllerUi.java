package dev.java10x.marmitaia.controller;


import dev.java10x.marmitaia.entity.Ingredientes;
import dev.java10x.marmitaia.service.IngredienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/ingrediente/ui")
public class IngredienteControllerUi {

    private IngredienteService ingredienteService;

    public IngredienteControllerUi(IngredienteService ingredientesService) {
        this.ingredienteService = ingredientesService;
    }

    @GetMapping ("/lista")
    public String pegarIngredientes (Model model) {
        List<Ingredientes> ingrendientes = ingredienteService.listarIngrendientes();
        model.addAttribute("Ingredientes" , ingrendientes);
        return "ingredienteLista"; //pagina html
    }


    @GetMapping("/{id}")
    public String excluirIngrediente (@PathVariable Long id) {
        ingredienteService.deletarIngredientePeloId(id);
        return "redirect:/api/ingrediente/ui/lista";
    }

    @GetMapping("/adicionar")
    public String mostarFormularioAdicionarIngrediente (Model model) {
        model.addAttribute("ingrediente", new Ingredientes());
        return "FormularioAdicionarIngrediente";
    }

    @PostMapping ("/salvar")
    public String salvarIngrediente (@ModelAttribute Ingredientes ingrediente, RedirectAttributes attributes) {
        ingredienteService.salvarIngredientes(ingrediente);
        attributes.addFlashAttribute("mensagem", "Ingrediente Cadastrado com sucesso!");
        return "redirect:/api/ingrediente/lista";
    }

    @PutMapping ("/alterar/{id}")
    public String alterarUsuario (@PathVariable Long id, Model model) {
        Optional<Ingredientes> ingrediente = ingredienteService.buscarIngredientePeloId(id);
        if (ingrediente.isPresent()) {
            model.addAttribute("ingrediente", ingrediente);
            return "alterarIngrediente";
        } else {
            model.addAttribute("mensagem", "Ingrediente não encontrado!");
            return "ingredienteLista";
        }
    }
}
