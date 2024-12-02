package br.com.fiap.soat7.pagamento.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class Produto {

    private String nome;
    private BigDecimal preco;
    private String descricao;
}
