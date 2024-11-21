package br.com.meteora.api.model.produto;

import jakarta.persistence.*;
import lombok.*;

@Table (name = "produtos")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private  String tamanho;

    private String modelo;

    private  String descricao;

    private double preco;

    private String cor;

    @Enumerated(EnumType.STRING)
    private Fabricante fabricante;

    public void atualizarInformacoes(DadosAtualizarProduto dados) {

        if (dados.nome() != null) {
            this.nome = dados.nome();
           }
           if (dados.tamanho() != null) {
            this.tamanho = dados.tamanho();
           }
           if (dados.modelo() != null) {
            this.modelo = dados.modelo();
           }
           if (dados.cor() != null) {
            this.cor = dados.cor();
           }

    }

    public ProdutoModel(DadosCadastroProduto dados) {
    this.nome = dados.nome();
    this.tamanho = dados.tamanho();
    this.modelo = dados.modelo();
    this.descricao = dados.descricao();
    this.preco = dados.preco();
    this.cor = dados.cor();
    this.fabricante = dados.fabricante();

    }

}

