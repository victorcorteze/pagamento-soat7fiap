package br.com.fiap.soat7.pagamento.config;

import br.com.fiap.soat7.pagamento.application.gateway.PagamentoGateway;
import br.com.fiap.soat7.pagamento.application.usecases.Pagamento;
import br.com.fiap.soat7.pagamento.infrastructure.gateway.PagamentoRepositoryGateway;
import br.com.fiap.soat7.pagamento.infrastructure.persistence.ISolicitacaoPagamentoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PagamentoConfig {

    @Bean
    Pagamento pagamento(PagamentoGateway pagamentoGateway){
        return new Pagamento(pagamentoGateway);
    }

    @Bean
    PagamentoGateway gateway(ISolicitacaoPagamentoRepository repository){
        return new PagamentoRepositoryGateway(repository);
    }
}
