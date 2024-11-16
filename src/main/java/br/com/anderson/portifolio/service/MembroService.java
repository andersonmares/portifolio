package br.com.anderson.portifolio.service;

import br.com.anderson.portifolio.model.Membro;
import br.com.anderson.portifolio.repository.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembroService {

    @Autowired
    private MembroRepository membroRepository;

    public Membro adicionar(Membro membro) {
        return membroRepository.save(membro);
    }
}
