package br.com.vivo.cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ExcluirCliente {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:C:/Users/HOME/Documents/VivoBackendAutomation/vivo_vendas.db";
        String sql = "DELETE FROM tb_cliente WHERE cpf = ?";

        try (Connection conexao = DriverManager.getConnection(url)) {
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, "123.456.789-00");

            int linhas = comando.executeUpdate();
            if (linhas > 0) {
                System.out.println("🗑️ Sucesso! Cliente removido do sistema.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}