package br.com.meteora.api.model.usuario;

import br.com.meteora.api.model.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarUsuario(
   @NotNull Long id,
    String nome,
    String dataDeNascimento,
    DadosEndereco endereco
    
) {
    
}
