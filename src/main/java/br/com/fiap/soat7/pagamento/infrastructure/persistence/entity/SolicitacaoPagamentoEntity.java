package br.com.fiap.soat7.pagamento.infrastructure.persistence.entity;

import br.com.fiap.soat7.pagamento.domain.entity.Produto;
import br.com.fiap.soat7.pagamento.domain.types.StatusPagamento;
import br.com.fiap.soat7.pagamento.infrastructure.controller.request.Pedido;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

import static br.com.fiap.soat7.pagamento.domain.types.StatusPagamento.AGUARDANDO_PAGAMENTO;

@Entity
@Table(name = "solicitacao_pagamento")
@Getter
@Setter
@NoArgsConstructor
public class SolicitacaoPagamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long pedidoId;
    private String cpf;
    private Date dataSolicitacao;
    @Enumerated(EnumType.STRING)
    private StatusPagamento statusPagamento;
    private BigDecimal valorPedido;

    public SolicitacaoPagamentoEntity(Pedido pedido){
        this.pedidoId = pedido.getId();
        this.cpf = pedido.getCpf();
        this.dataSolicitacao = new Date();
        this.statusPagamento = AGUARDANDO_PAGAMENTO;
        this.valorPedido = pedido.getProdutoList().stream().map(Produto::getPreco).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
