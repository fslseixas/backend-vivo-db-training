package br.com.vivo.vendedor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ExcluirVendedor {
    public static void main(String[] args) {
        // O caminho do teu banco que já validámos
        String url = "jdbc:sqlite:C:/Users/HOME/Documents/VivoBackendAutomation/vivo_vendas.db";
        String sql = "DELETE FROM tb_vendedor WHERE matricula = ?";

        try (Connection conexao = DriverManager.getConnection(url)) {
            PreparedStatement comando = conexao.prepareStatement(sql);

            // Passamos a matrícula da Juliana para o '?'
            comando.setString(1, "VIV004");

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("🗑️ Sucesso! Juliana (VIV004) foi removida do banco da Vivo.");
            } else {
                System.out.println("⚠️ Atenção: Nenhum vendedor encontrado com essa matrícula.");
            }
        } catch (Exception e) {
            System.err.println("❌ Erro ao excluir: " + e.getMessage());
        }
    }
}