package br.com.fiap.soat7.pagamento.application.usecases;

import br.com.fiap.soat7.pagamento.application.gateway.PagamentoGateway;
import br.com.fiap.soat7.pagamento.domain.entity.Produto;
import br.com.fiap.soat7.pagamento.domain.types.StatusPagamento;
import br.com.fiap.soat7.pagamento.infrastructure.controller.request.Pedido;
import br.com.fiap.soat7.pagamento.infrastructure.persistence.entity.SolicitacaoPagamentoEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PagamentoTest {

    @Mock
    PagamentoGateway pagamentoGateway;

    @InjectMocks
    Pagamento pagamento;


    @Test
    void registrarPedidoComSucesso(){

        //
        Produto produto = new Produto();
        produto.setNome("banana");
        produto.setPreco(BigDecimal.valueOf(3.0));

        Pedido pedido = new Pedido();
        pedido.setId(1L);
        pedido.setStatusPagamento(StatusPagamento.AGUARDANDO_PAGAMENTO);
        pedido.setCpf("111.111.111-01");
        pedido.setObservacao("teset");
        pedido.setProdutoList(List.of(produto));

        SolicitacaoPagamentoEntity solicitacaoPagamentoEntity = new SolicitacaoPagamentoEntity();

        when(pagamentoGateway.registrar(Mockito.any())).thenReturn(solicitacaoPagamentoEntity);

        //
        Pedido registrar = pagamento.registrar(pedido);

        //
        assertNotNull(registrar);


    }

}
