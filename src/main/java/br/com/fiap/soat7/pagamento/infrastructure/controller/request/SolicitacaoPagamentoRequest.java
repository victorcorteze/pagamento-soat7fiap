package br.com.fiap.soat7.pagamento.infrastructure.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class SolicitacaoPagamentoRequest {

    private Long pedidoId;
    private String cpf;
    @Schema(type = "string", pattern = "dd/MM/yyyy HH:mm:ss")
    private Date dataSolicitacao;

}
