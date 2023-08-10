package br.com.api.rh.service;

import br.com.api.rh.model.Funcionario;
import br.com.api.rh.repository.FuncionarioRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionario> buscarTodos() {
        return repository.findAll();
    }

    public Funcionario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado!"));
    }

    public Funcionario atualizar(Funcionario funcionario, Long id) {
        if(!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionario não encontrado!");
        }

        funcionario.setId(id);
        return repository.save(funcionario);
    }

    public Funcionario cadastrar(Funcionario funcionario) {
        return repository.save(funcionario);
    }
}
