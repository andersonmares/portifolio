package br.com.anderson.portifolio.controller;

import br.com.anderson.portifolio.model.Pessoa;
import br.com.anderson.portifolio.model.Projeto;
import br.com.anderson.portifolio.service.PessoaService;
import br.com.anderson.portifolio.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/projetos")
public class ProjetoControllerImpl {

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    PessoaService pessoaService;

    @GetMapping("/lista")
    public String listar(Model model) {
        model.addAttribute("projetos", projetoService.listarTodos());
        return "lista"; // Localizado em /WEB-INF/jsp/lista.jsp
    }

//    @GetMapping("/lista")
//    public String listar(Model model) {
//        List<Projeto> projetos = Arrays.asList(
//                new Projeto("Projeto A", "Gerente 1", "Ativo"),
//                new Projeto("Projeto B", "Gerente 2", "Finalizado")
//        );
//        model.addAttribute("projetos", projetos);
//        return "lista"; // O Spring usará /WEB-INF/jsp/lista.jsp com a configuração correta do ViewResolver
//    }

//    @GetMapping("/novo")
//    public String novo(Model model) {
//        model.addAttribute("projeto", new Projeto());
//        model.addAttribute("gerenteList", pessoaService.listarTodos()); // Substitua pela lógica que retorna os gerentes.
//        model.addAttribute("statusList", Arrays.asList("Ativo", "Finalizado", "Pendente")); // Lista de status.
//        return "form";
//    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("projeto", new Projeto());
        return "form"; // Localizado em /WEB-INF/jsp/form.jsp
    }

    @PostMapping
    public String salvar(@Valid @ModelAttribute Projeto projeto, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "form"; // Localizado em /WEB-INF/jsp/form.jsp
        }
        projetoService.salvar(projeto);
        attributes.addFlashAttribute("mensagem", "Projeto salvo com sucesso!");
        return "redirect:/projetos/lista";
    }

    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id, RedirectAttributes attributes) {
        projetoService.excluir(id);
        attributes.addFlashAttribute("mensagem", "Projeto excluído com sucesso!");
        return "redirect:/projetos/lista";
    }
}