package br.com.meteora.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.meteora.api.model.usuario.*;
import br.com.meteora.api.model.usuario.UsuarioModel;
import br.com.meteora.api.model.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

@Autowired
private UsuarioRepository repository;

@PostMapping("/cadastrar")
@Transactional
public void cadastrar(@RequestBody @Valid DadosCadastroUsuario dados) {
 repository.save(new UsuarioModel(dados));
}
@GetMapping("/listar")
public List<UsuarioModel> listar() {
    return repository.findAll();
}

@PutMapping
@Transactional
public void atualizar(@RequestBody DadosAtualizarUsuario dados) {
     UsuarioModel usuario = repository.getReferenceById(dados.id()) ;
     usuario.atualizarInformacoes(dados);
}
 @DeleteMapping("/{id}") 
 @Transactional
 public void excluir(@PathVariable Long id ) {
     repository.deleteById(id);
 }



}
