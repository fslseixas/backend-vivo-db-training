package br.com.vivo.testes.steps.pagamento;


import br.com.vivo.testes.actions.pagamento.PagamentoAction; // Importando do novo local de teste
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PagamentoSteps {

    // A instância correta da sua Action
    private PagamentoAction pagamentoAction = new PagamentoAction();

    @Given("que existe um cliente {string} com fatura de {double}")
    public void que_existe_um_cliente_com_fatura_de(String nome, Double valor) {
        // Deixe a Action fazer o trabalho!
        pagamentoAction.criarClienteParaTeste(nome, valor);
    }

    @When("ele realiza o pagamento de {double}")
    public void ele_realiza_o_pagamento_de(Double valorPago) {
        pagamentoAction.processarPagamentoFatura(valorPago);
    }

    @Then("a fatura deve ser marcada como paga")
    public void a_fatura_deve_ser_marcada_como_paga() {
        pagamentoAction.validarStatusFinal();
    }

    @Then("a fatura não deve ser marcada como paga")
    public void a_fatura_nao_deve_ser_marcada_como_paga() {
        pagamentoAction.validarBloqueioPagamento();
    }
}