package br.com.vivo.contratacao.model;

public class TesteContratacao {

    public static void main(String[] args) {
        // Agora que estão no mesmo pacote, não precisa usar o nome completo br.com.vivo...
        Contratacao novaContratacao = new Contratacao(1L, "Fabio", "01234567891","Vivo Fibra 500 Mega");

        System.out.println("--------------------------------------------------");
        System.out.println("🚀 [BACKEND]: Objeto de Contratação criado com sucesso!");
        System.out.println("ID do Registro: " + novaContratacao.getId());
        System.out.println("Nome: " + novaContratacao.getNome());
        System.out.println("CPF: " + novaContratacao.getCpf());
        System.out.println("Plano: " + novaContratacao.getPlano());
        System.out.println("--------------------------------------------------");
    }
}