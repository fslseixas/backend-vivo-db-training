package br.com.vivo.vendedor; // IMPORTANTE: Identifica que a classe está no pacote correto

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CadastroVendedor {
    public static void main(String[] args) {

        // Endereço do seu banco que confirmamos nos testes anteriores
        String url = "jdbc:sqlite:C:/Users/HOME/Documents/VivoBackendAutomation/vivo_vendas.db";

        // SQL de inserção (o comando que envia dados para as gavetas do banco)
        String sql = "INSERT INTO tb_vendedor (nome_vendedor, matricula, email, setor) VALUES (?, ?, ?, ?)";

        try {
            // Força o carregamento do motor do SQLite
            Class.forName("org.sqlite.JDBC");

            try (Connection conexao = DriverManager.getConnection(url)) {

                // Prepara o mensageiro seguro
                PreparedStatement comando = conexao.prepareStatement(sql);

                // Preenche os dados da nova vendedora da Vivo
                comando.setString(1, "Juliana Costa");
                comando.setString(2, "VIV004");
                comando.setString(3, "juliana.costa@vivo.com");
                comando.setString(4, "Loja Shopping");

                // Executa a gravação
                int linhas = comando.executeUpdate();

                if (linhas > 0) {
                    System.out.println("✅ Sucesso! Juliana cadastrada via Java no pacote br.com.vivo!");
                }
            }
        } catch (Exception e) {
            System.out.println("❌ Erro no cadastro: " + e.getMessage());
        }
    }
}