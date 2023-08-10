package br.com.api.rh.controller;

import br.com.api.rh.model.Funcionario;
import br.com.api.rh.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public List<Funcionario> getAll() {
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public Funcionario getById(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Funcionario getById(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        return service.atualizar(funcionario, id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario create(@RequestBody Funcionario funcionario) {
        return service.cadastrar(funcionario);
    }
}
