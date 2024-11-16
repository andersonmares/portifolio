package br.com.anderson.portifolio.controller;

import br.com.anderson.portifolio.model.Membro;
import br.com.anderson.portifolio.service.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/membros")
public class MembroControllerImpl{

    @Autowired
    private MembroService membroService;

    @PostMapping
    public Membro adicionar(@RequestBody Membro membro) {
        return membroService.adicionar(membro);
    }
}
