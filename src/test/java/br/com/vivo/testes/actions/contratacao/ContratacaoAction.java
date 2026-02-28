package br.com.vivo.testes.actions.contratacao;

import org.junit.Assert; // Import necessário para as validações

public class ContratacaoAction {

    // 1. ATRIBUTOS (Estado do teste)
    private String planoSelecionado; // Guarda o nome do plano que o cliente escolheu
    private boolean contratoAtivo = false; // Começa como falso (não contratado)

    // 2. MÉTODO DE SELEÇÃO (Corresponde ao Given)
    public void selecionarPlano(String nomePlano) {
        this.planoSelecionado = nomePlano; // Salva o nome vindo da Feature
        System.out.println("LOG [INFO]: Cliente selecionou o plano: " + nomePlano);
    }

    // 3. MÉTODO DE EXECUÇÃO (Corresponde ao When)
    public void confirmarContratacao() {
        // Simulamos a ativação: se tem um plano, ativamos o contrato
        if (this.planoSelecionado != null) {
            this.contratoAtivo = true; // Muda o estado para verdadeiro
            System.out.println("LOG [INFO]: ✅ Processando contratação do plano " + this.planoSelecionado);
        }
    }

    // 4. MÉTODO DE VALIDAÇÃO (Corresponde ao Then)
    public void validarPlanoAtivo() {
        // O Assert verifica se 'contratoAtivo' é TRUE.
        // Se for, barra verde! Se for FALSE, exibe a mensagem de erro.
        Assert.assertTrue("Erro: A contratação não foi concluída com sucesso!", contratoAtivo);

        System.out.println("LOG [INFO]: ⭐ Validação concluída: Plano " + planoSelecionado + " está ATIVO.");
    }
}