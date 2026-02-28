package br.com.vivo.testes.steps.contratacao;

import br.com.vivo.testes.actions.contratacao.ContratacaoAction;
import br.com.vivo.testes.actions.contratacao.ContratacaoViaApiAction;
import io.cucumber.java.en.*;
import java.util.Map;

public class ContratacaoViaApiSteps {

    private ContratacaoViaApiAction action = new ContratacaoViaApiAction();

    @Given("que eu preparo os dados da contratação:")
    public void que_eu_preparo_os_dados_da_contratacao(Map<String, String> dados) {
        // O Cucumber mapeia a tabela para este Map 'dados'
        action.prepararDados(dados);
    }

    @When("eu envio a requisição para o endpoint de vendas")
    public void eu_envio_a_requisicao_para_o_endpoint_de_vendas() {
        action.simularEnvioApi();
    }

    @Then("o status da resposta deve ser {int}")
    public void o_status_da_resposta_deve_ser(int status) {
        action.validarStatusCode(status);
    }

    @Then("o campo {string} na resposta deve ser {string}")
    public void o_campo_na_resposta_deve_ser(String campo, String valorEsperado) {
        action.validarDadosResposta(campo, valorEsperado);
    }


}

