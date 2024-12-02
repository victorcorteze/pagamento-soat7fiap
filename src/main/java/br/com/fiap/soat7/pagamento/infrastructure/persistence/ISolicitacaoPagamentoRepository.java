package br.com.fiap.soat7.pagamento.infrastructure.persistence;

import br.com.fiap.soat7.pagamento.infrastructure.persistence.entity.SolicitacaoPagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISolicitacaoPagamentoRepository extends JpaRepository<SolicitacaoPagamentoEntity, Long> {
}
