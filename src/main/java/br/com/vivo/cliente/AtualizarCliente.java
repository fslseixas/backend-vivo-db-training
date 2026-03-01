package br.com.vivo.cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AtualizarCliente {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:C:/Users/HOME/Documents/VivoBackendAutomation/vivo_vendas.db";
        // O WHERE usa o CPF, que é o identificador único dele aqui [cite: 2026-02-27]
        String sql = "UPDATE tb_cliente SET telefone = ? WHERE cpf = ?";

        try (Connection conexao = DriverManager.getConnection(url)) {
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, "(11) 91111-2222"); // Novo telefone
            comando.setString(2, "123.456.789-00"); // CPF do Claudio

            int linhas = comando.executeUpdate();
            if (linhas > 0) {
                System.out.println("🆙 Sucesso! Telefone do cliente atualizado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}