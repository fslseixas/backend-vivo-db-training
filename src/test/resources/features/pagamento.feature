@teste_fabio
Feature: Pagamento de Fatura Vivo

  Scenario: Validar pagamento com valor exato
    Given que existe um cliente "Fabio" com fatura de 450.0
    When ele realiza o pagamento de 450.0
    Then a fatura deve ser marcada como paga

@teste_falha
  Scenario: Validar bloqueio de pagamento insuficiente
    Given que existe um cliente "Fabio" com fatura de 450.0
    When ele realiza o pagamento de 10.0
    Then a fatura não deve ser marcada como paga