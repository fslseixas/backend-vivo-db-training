Feature: Contratação de Planos  # <--- ADICIONE ESTA LINHA NO TOPO
  Como um cliente da Vivo       # <--- (Opcional) Descrição do que estamos testando

  @contratacao_massa
  Scenario Outline: Contratar plano de Fibra com sucesso
    Given que o cliente seleciona o plano "<nome_plano>"
    When ele confirma a contratação
    Then o plano deve estar ativo no perfil do cliente

  Examples:
  | nome_plano           |
  | Vivo Fibra 500 Mega  |
  | Vivo Fibra 700 Mega  |
  | Vivo Fibra 1 Giga    |