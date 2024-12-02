package br.com.fiap.soat7.pagamento.application.usecases;

import br.com.fiap.soat7.pagamento.application.gateway.PagamentoGateway;
import br.com.fiap.soat7.pagamento.domain.types.StatusPagamento;
import br.com.fiap.soat7.pagamento.infrastructure.controller.request.Pedido;
import br.com.fiap.soat7.pagamento.infrastructure.persistence.entity.SolicitacaoPagamentoEntity;
import lombok.val;

public class Pagamento {

    private final PagamentoGateway gateway;

    public Pagamento(PagamentoGateway gateway) {
        this.gateway = gateway;
    }


    public Pedido registrar(Pedido pedidoRequest) {
        pedidoRequest.setStatusPagamento(StatusPagamento.APROVADO);
        val solicitacaoPagamento = new SolicitacaoPagamentoEntity(pedidoRequest);
        this.gateway.registrar(solicitacaoPagamento);
        return pedidoRequest;
    }
}
