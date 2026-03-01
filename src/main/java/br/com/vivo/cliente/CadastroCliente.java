package br.com.vivo.cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Classe responsável por realizar o cadastro de novos clientes no banco de dados.
 * Prática do Módulo 06 - Persistência de Dados.
 */
public class CadastroCliente {
    public static void main(String[] args) {

        // 1. ENDEREÇO DO BANCO: O caminho onde o arquivo .db está guardado no seu PC
        String url = "jdbc:sqlite:C:/Users/HOME/Documents/VivoBackendAutomation/vivo_vendas.db";

        // 2. COMANDO SQL: Usamos '?' (Placeholders) por segurança contra SQL Injection [cite: 2026-02-27]
        String sql = "INSERT INTO tb_cliente (nome_cliente, cpf, telefone, email_cliente) VALUES (?, ?, ?, ?)";

        // 3. TRY-WITH-RESOURCES: Abre a conexão e garante que ela será fechada automaticamente [cite: 2026-02-02]
        try (Connection conexao = DriverManager.getConnection(url)) {

            // 4. PREPARED STATEMENT: Prepara o comando antes de enviar para o banco [cite: 2026-02-02]
            PreparedStatement comando = conexao.prepareStatement(sql);

            // 5. MAPEAMENTO: Associamos cada '?' ao dado real do cliente da Vivo
            comando.setString(1, "Claudio Jose");           // Nome do Cliente
            comando.setString(2, "123.456.789-00");         // CPF (Deve ser único no banco)
            comando.setString(3, "(11) 99999-8888");        // Telefone de contato
            comando.setString(4, "claudio.jose@email.com"); // E-mail institucional

            // 6. EXECUÇÃO: O método executeUpdate é usado para comandos que alteram o banco (Insert/Update/Delete)
            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("✅ Sucesso! Cliente Claudio cadastrado no banco da Vivo.");
            }

        } catch (Exception e) {
            // 7. TRATAMENTO DE ERRO: Captura falhas como CPF duplicado (Unique Constraint)
            System.out.println("❌ Erro ao cadastrar cliente: " + e.getMessage());
        }
    }
}