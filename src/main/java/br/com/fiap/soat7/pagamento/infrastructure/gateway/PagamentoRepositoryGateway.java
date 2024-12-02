package br.com.fiap.soat7.pagamento.infrastructure.gateway;

import br.com.fiap.soat7.pagamento.application.gateway.PagamentoGateway;
import br.com.fiap.soat7.pagamento.infrastructure.persistence.ISolicitacaoPagamentoRepository;
import br.com.fiap.soat7.pagamento.infrastructure.persistence.entity.SolicitacaoPagamentoEntity;

public class PagamentoRepositoryGateway implements PagamentoGateway {

    private final ISolicitacaoPagamentoRepository repository;

    public PagamentoRepositoryGateway(ISolicitacaoPagamentoRepository repository) {
        this.repository = repository;
    }

    @Override
    public SolicitacaoPagamentoEntity registrar(SolicitacaoPagamentoEntity pedido) {
        return repository.save(pedido);
    }
}
