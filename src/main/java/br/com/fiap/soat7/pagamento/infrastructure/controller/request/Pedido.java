package br.com.fiap.soat7.pagamento.infrastructure.controller.request;

import br.com.fiap.soat7.pagamento.domain.entity.Produto;
import br.com.fiap.soat7.pagamento.domain.types.StatusPagamento;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Pedido {

    private Long id;
    private String cpf;
    @Schema(type = "string", pattern = "dd/MM/yyyy HH:mm:ss")
    private Date dataCadastro;
    private StatusPagamento statusPagamento;
    private String observacao;
    private List<Produto> produtoList;
}
