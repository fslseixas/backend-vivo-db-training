package br.com.vivo.testes.actions.pagamento;

import br.com.vivo.pagamento.model.Cliente;
import org.junit.Assert; // IMPORTANTE: Isso resolve o erro vermelho

public class PagamentoAction {

    private Cliente cliente; // Guarda o cliente do teste atual
    private boolean resultadoPagamento; // Guarda se o pagamento deu certo ou não

    // 1. Prepara o cenário (Dado)
    public void criarClienteParaTeste(String nome, Double valor) {
        this.cliente = new Cliente("Fibra", valor, nome);
    }

    // 2. Executa a ação (Quando)
    public void processarPagamentoFatura(Double valorPago) {
        System.out.println("LOG [INFO]: Validando pagamento para " + cliente.getNome());

        if (valorPago >= cliente.getValorFatura()) {
            this.resultadoPagamento = true;
            cliente.setValorFatura(0.0);
        } else {
            this.resultadoPagamento = false;
        }
    }

    // 3. Valida o sucesso (Então - Sucesso)
    public void validarStatusFinal() {
        // Usa o Assert para dar o "Check" verde no Cucumber
        Assert.assertTrue("Erro: O pagamento deveria ter sido aceito!", resultadoPagamento);
    }

    // 4. Valida a falha (Então - Falha)
    public void validarBloqueioPagamento() {
        Assert.assertFalse("Erro: O sistema aceitou pagamento insuficiente!", resultadoPagamento);
    }
}