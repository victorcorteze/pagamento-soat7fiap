package br.com.fiap.soat7.pagamento.infrastructure.controller;

import br.com.fiap.soat7.pagamento.application.usecases.Pagamento;
import br.com.fiap.soat7.pagamento.infrastructure.controller.request.Pedido;
import br.com.fiap.soat7.pagamento.infrastructure.persistence.entity.SolicitacaoPagamentoEntity;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/v1/pagamento")
public class PagamentoController {

    private final Pagamento pagamento;

    public PagamentoController(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    @PostMapping()
    public ResponseEntity<Pedido> solicitarPagamento(@RequestBody Pedido pedido) {
        val registrar = pagamento.registrar(pedido);
        return ResponseEntity.ok(registrar);
    }

}
