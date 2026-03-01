package br.com.vivo;// 1. IMPORTAÇÕES: Ferramentas necessárias para o Java conversar com o banco.
import java.sql.Connection;   // Gerencia a "estrada" (conexão) até o arquivo.
import java.sql.DriverManager; // O "motorista" que conhece o caminho.
import java.sql.ResultSet;    // A "pasta" que recebe os dados que o banco devolve.
import java.sql.Statement;    // O "mensageiro" que leva sua pergunta SQL.

public class TesteConexao {
    public static void main(String[] args) {

        // 2. ENDEREÇO DO BANCO: O caminho exato que deu "Succeeded" no seu print.
        // O prefixo 'jdbc:sqlite:' avisa ao Java qual motor usar.
        String url = "jdbc:sqlite:C:/Users/HOME/Documents/VivoBackendAutomation/vivo_vendas.db";

        // 3. CARREGAMENTO MANUAL (Dica de Ouro): Forçamos o Java a carregar o motorista (driver).
        // Isso resolve o erro de "No suitable driver found" que apareceu no seu console.
        try {
            Class.forName("org.sqlite.JDBC");

            // 4. CONEXÃO: Tentamos abrir a porta do banco.
            // O try-with-resources (parênteses) fecha o banco sozinho no final.
            try (Connection conexao = DriverManager.getConnection(url)) {

                System.out.println("✅ Sucesso! O Java conectou ao banco da Vivo.");

                // 5. PREPARANDO A PERGUNTA: Criamos o objeto para enviar o SQL.
                Statement mensageiro = conexao.createStatement();

                // 6. BUSCANDO OS DADOS: Rodamos o SELECT que você criou no DBeaver.
                ResultSet resultado = mensageiro.executeQuery("SELECT nome_vendedor FROM tb_vendedor");

                // 7. LENDO A TABELA: O while percorre cada linha que o banco retornou.
                System.out.println("--- Lista de Vendedores ---");
                while (resultado.next()) {
                    // Pegamos o texto da coluna 'nome_vendedor'
                    System.out.println("Vendedor: " + resultado.getString("nome_vendedor"));
                }

            }
        } catch (Exception e) {
            // 8. TRATAMENTO DE ERROS: Se algo falhar, o Java cai aqui e explica o porquê.
            System.out.println("❌ Ops! Erro no código:");
            e.printStackTrace(); // Mostra o erro detalhado para podermos consertar.
        }
    }
}