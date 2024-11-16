package br.com.anderson.portifolio.service;

import br.com.anderson.portifolio.exception.BusinessException;
import br.com.anderson.portifolio.model.Projeto;
import br.com.anderson.portifolio.model.Status;
import br.com.anderson.portifolio.repository.ProjetoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> listarTodos() {
        return projetoRepository.findAll();
    }

    public Projeto buscarPorId(Long id) {
        return projetoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Projeto não encontrado"));
    }

    public Projeto salvar(Projeto projeto) {
        if (Status.INICIADO.equals(projeto.getStatus()) ||
                Status.EM_ANDAMENTO.equals(projeto.getStatus()) ||
                Status.ENCERRADO.equals(projeto.getStatus())) {
            throw new BusinessException("Não é possível excluir projeto com status iniciado, em andamento ou encerrado.");
        }
        return projetoRepository.save(projeto);
    }

    public void excluir(Long id) {
        Projeto projeto = projetoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Projeto não encontrado"));
        if (Status.INICIADO.equals(projeto.getStatus()) ||
                Status.EM_ANDAMENTO.equals(projeto.getStatus()) ||
                Status.ENCERRADO.equals(projeto.getStatus())) {
            throw new BusinessException("Não é possível excluir projeto com status iniciado, em andamento ou encerrado.");
        }
        projetoRepository.delete(projeto);
    }
}