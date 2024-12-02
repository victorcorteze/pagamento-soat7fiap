package br.com.fiap.soat7.pagamento.application.gateway;

import br.com.fiap.soat7.pagamento.infrastructure.controller.request.Pedido;
import br.com.fiap.soat7.pagamento.infrastructure.persistence.entity.SolicitacaoPagamentoEntity;

public interface PagamentoGateway {

    SolicitacaoPagamentoEntity registrar (SolicitacaoPagamentoEntity pedido);

}
