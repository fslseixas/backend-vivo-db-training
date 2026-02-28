package br.com.vivo.testes.steps.contratacao;

import br.com.vivo.testes.actions.contratacao.ContratacaoAction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContratacaoSteps {

    // 1. INSTÂNCIA (O objeto que mantém o estado do teste)
    private ContratacaoAction contratacaoAction = new ContratacaoAction();

    // 2. O DADO (Given)
    @Given("que o cliente seleciona o plano {string}")
    public void que_o_cliente_seleciona_o_plano(String Plano) {
        // Repassamos o nome do plano para a Action guardar
        contratacaoAction.selecionarPlano(Plano);

    }
    @When("ele confirma a contratação")
    public void ele_confirma_a_contratação() {
        // Pedimos para a Action realizar a lógica de contratação
        contratacaoAction.confirmarContratacao();

    }
    @Then("o plano deve estar ativo no perfil do cliente")
    public void o_plano_deve_estar_ativo_no_perfil_do_cliente() {
        // Pedimos para a Action fazer o Assert final
        contratacaoAction.validarPlanoAtivo();

    }
}
