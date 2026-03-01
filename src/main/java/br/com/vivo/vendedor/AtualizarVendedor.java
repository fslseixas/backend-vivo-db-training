package br.com.vivo.vendedor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AtualizarVendedor {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:C:/Users/HOME/Documents/VivoBackendAutomation/vivo_vendas.db";

        // SQL para mudar o SETOR de um vendedor específico
        String sql = "UPDATE tb_vendedor SET setor = ? WHERE matricula = ?";

        try (Connection conexao = DriverManager.getConnection(url)) {
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, "Vendas Corporativas"); // Novo Setor
            comando.setString(2, "VIV004");              // Matrícula da Juliana

            int linhas = comando.executeUpdate();
            if (linhas > 0) {
                System.out.println("🆙 Sucesso! Dados da Juliana atualizados.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}