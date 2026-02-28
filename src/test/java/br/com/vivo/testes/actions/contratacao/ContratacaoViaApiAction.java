package br.com.vivo.testes.actions.contratacao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import java.util.Map;
import static io.restassured.RestAssured.*;

public class ContratacaoViaApiAction {
    private io.restassured.response.Response response; // Guarda o que o servidor responde
    private int statusCode; // Guarda o número do status (ex: 201)
    private Map<String, String> dadosContratacao;

    // Recebe o Map diretamente do Step
    public void prepararDados(Map<String, String> dados) {
        this.dadosContratacao = dados;
        System.out.println("LOG [INFO]: Dados carregados via Map: " + dados.toString());
    }

   /* public void simularEnvioApi() {
        // No Backend, verificaríamos se o CPF existe no Map antes de enviar
        if (dadosContratacao.containsKey("cpf")) {
            this.statusCode = 201; // Simula sucesso na criação do contrato
            System.out.println("LOG [INFO]: 🚀 JSON enviado para API Vivo com sucesso.");
        }
    }*/

    public void simularEnvioApi() {
        try {
            // Objeto responsável por converter Objetos Java em JSON (e vice-versa)
            ObjectMapper mapper = new ObjectMapper();

            // Serialização: Transforma o Map 'dadosContratacao' em uma String no formato JSON
            String jsonFinal = mapper.writeValueAsString(dadosContratacao);

            // Início da DSL (Domain Specific Language) do RestAssured
            this.response = given()
                    // Define o cabeçalho (Header): Avisa ao servidor que estamos enviando um JSON
                    .header("Content-Type", "application/json")
                    // User-Agent: Identificação do cliente. Usamos o do Postman para evitar bloqueios de segurança
                    .header("User-Agent", "PostmanRuntime/7.32.2")
                    // Define o corpo (Payload) da requisição com o JSON que geramos acima
                    .body(jsonFinal)
                    .when()
                    // Verbo HTTP POST: Usado para CRIAR recursos (como uma nova contratação)
                    .post("https://jsonplaceholder.typicode.com/posts")
                    .then()
                    // Extrai o objeto de resposta completo para que possamos validar depois
                    .extract().response();

            // Extrai apenas o número do Status (201, 403, 500, etc.) da resposta
            this.statusCode = response.getStatusCode();

            // --- SEÇÃO DE LOGS NO CONSOLE ---
            System.out.println("--------------------------------------------------");
            System.out.println("🚀 [INFO]: Enviando dados para o Backend da Vivo...");
            System.out.println("📥 [INFO]: Resposta recebida. Status: " + this.statusCode);

            // Lógica de Depuração: Só detalhamos a resposta se houver algo diferente de SUCESSO (201)
            // Se o status for DIFERENTE de 201 (Sucesso) E DIFERENTE de 400 (Erro que estamos testando)
            if (this.statusCode != 201 && this.statusCode != 400) {
                System.err.println("❌ [ALERTA]: Ocorreu um erro inesperado (fora do fluxo planejado)!");
                System.err.println("Status recebido: " + this.statusCode);
                System.err.println("Detalhes: " + response.asPrettyString());
            } else {
                // Se caiu aqui, é porque recebemos ou 201 ou 400, que são os nossos fluxos mapeados
                System.out.println("📥 [INFO]: Resposta dentro do esperado para o cenário atual.");
            }
            System.out.println("--------------------------------------------------");

        } catch (Exception e) {
            // Bloco de segurança: Captura falhas de rede, URLs mal digitadas ou erros de serialização
            System.err.println("🚨 [ERRO CRÍTICO]: Falha interna no código: " + e.getMessage());
        }
    }

    public void validarStatusCode(int esperado) {
        // Validação técnica de Backend
        Assert.assertEquals("Erro: Status da API inesperado!", esperado, this.statusCode);
        System.out.println("LOG [INFO]: ✅ Status Code validado: " + this.statusCode);
    }

    public void validarDadosResposta(String campo, String valorEsperado) {
        // 1. O JsonPath "escaneia" a resposta que guardamos na variável 'response'
        // 2. Ele busca a chave (ex: "nome") e transforma o valor em String
        String valorReal = response.jsonPath().getString(campo);

        // 3. O JUnit compara: O que eu esperava (Fabio) é igual ao que a API mandou?
        Assert.assertEquals("Erro: O valor do campo " + campo + " não corresponde!", valorEsperado, valorReal);

        System.out.println("LOG [INFO]: ✅ Validação de conteúdo: " + campo + " = " + valorReal);
    }
}

