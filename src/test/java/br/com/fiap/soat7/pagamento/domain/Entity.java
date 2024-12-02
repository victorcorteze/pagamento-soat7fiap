package br.com.fiap.soat7.pagamento.domain;

import br.com.fiap.soat7.pagamento.domain.entity.Produto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNull;


@ExtendWith(MockitoExtension.class)
public class Entity {

    @Test
    void criarProdutoNull(){

        Produto produto = new Produto();
        assertNull(produto.getPreco());
        assertNull(produto.getNome());
        assertNull(produto.getDescricao());

    }

}
