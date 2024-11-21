package br.com.meteora.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.meteora.api.model.produto.DadosAtualizarProduto;
import br.com.meteora.api.model.produto.DadosCadastroProduto;
import br.com.meteora.api.model.produto.ProdutoModel;
import br.com.meteora.api.model.produto.ProdutoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    
  @Autowired
  private ProdutoRepository repository;

  @PostMapping("/cadastrar")
  @Transactional
  public void cadastrar(@RequestBody @Valid DadosCadastroProduto dados) {
    repository.save(new ProdutoModel(dados));
  }
 @GetMapping("/listar")
public List<ProdutoModel> listar() {
    return repository.findAll();
}

@PutMapping
@Transactional
public void atualizar(@RequestBody DadosAtualizarProduto dados) {
 ProdutoModel produto = repository.getReferenceById(dados.id()) ;
 produto.atualizarInformacoes(dados);
}
@DeleteMapping("/{id}")
@Transactional
public void excluir(@PathVariable Long id ) {
  repository.deleteById(id);
}


}
