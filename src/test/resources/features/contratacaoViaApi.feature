@contratacao_map
Feature: Contratação de Planos Backend
  Como um sistema de vendas da Vivo
  Eu quero processar requisições de contratação via API
  Para ativar serviços de Fibra para os clientes

  Scenario: Validar contratação via API com múltiplos campos
    Given que eu preparo os dados da contratação:
      | nome   | Fabio               |
      | cpf    | 12345678901         |
      | plano  | Vivo Fibra 500 Mega |
      | email  | fabio@vivo.com.br   |
      | telefone | 11988887777 |
    When eu envio a requisição para o endpoint de vendas
    Then o status da resposta deve ser 201

@validacao_conteudo
  Scenario: Validar contratação via API com múltiplos campos
    Given que eu preparo os dados da contratação:
      | nome   |               |
      | cpf    | 12345678901         |
      | plano  | Vivo Fibra 500 Mega |
      #| email  | fabio@vivo.com.br   |
      #| telefone | 11988887777 |
    When eu envio a requisição para o endpoint de vendas
    Then o status da resposta deve ser 201
    And o campo "nome" na resposta deve ser "Fabio"
    And o campo "plano" na resposta deve ser "Vivo Fibra 500 Mega"

  @validacao_erro
  Scenario: Validar erro ao enviar contratação sem nome
    Given que eu preparo os dados da contratação:
      | nome     |                     |
      | cpf      | 12345678901         |
      | plano    | Vivo Fibra 500 Mega |
    When eu envio a requisição para o endpoint de vendas
    Then o status da resposta deve ser 400