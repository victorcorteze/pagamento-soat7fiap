package br.com.fiap.soat7.pagamento.infrastructure.controller;

import br.com.fiap.soat7.pagamento.application.usecases.Pagamento;
import br.com.fiap.soat7.pagamento.domain.entity.Produto;
import br.com.fiap.soat7.pagamento.domain.types.StatusPagamento;
import br.com.fiap.soat7.pagamento.infrastructure.controller.request.Pedido;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PagamentoControllerTest {


    @InjectMocks
    private PagamentoController pagamentoController;
    @Mock
    private Pagamento pagamento;

    @Test
    void solicitarPagamentoComSucesso(){

        Produto produto = new Produto();
        produto.setNome("banana");
        produto.setPreco(BigDecimal.valueOf(3.0));

        Pedido pedido = new Pedido();
        pedido.setId(1L);
        pedido.setStatusPagamento(StatusPagamento.APROVADO);
        pedido.setCpf("111.111.111-01");
        pedido.setObservacao("teset");
        pedido.setProdutoList(List.of(produto));

        when(pagamento.registrar(Mockito.any())).thenReturn(pedido);

        ResponseEntity<Pedido> pedidoResponseEntity = pagamentoController.solicitarPagamento(pedido);

        assertNotNull(pedidoResponseEntity.getBody());
        assertEquals(pedidoResponseEntity.getBody().getStatusPagamento(), StatusPagamento.APROVADO);
        assertEquals(pedidoResponseEntity.getStatusCode(), HttpStatusCode.valueOf(200));

    }

}
