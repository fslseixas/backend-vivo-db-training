package br.com.vivo.pagamento.model;

public class Cliente {
        // 1. Atributos (Dados que um cliente Vivo tem)
        private String nome;
        private String plano;
        private double valorFatura;

        // --- AGORA USE OS ATALHOS ABAIXO ---

        // 2. Aperte Alt + Insert -> Escolha "Constructor" -> Selecione todos os campos e dê OK.
        // 3. Aperte Alt + Insert -> Escolha "Getter and Setter" -> Selecione todos e dê OK.


        public Cliente(String plano, double valorFatura, String nome) {
            this.plano = plano;
            this.valorFatura = valorFatura;
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getPlano() {
            return plano;
        }

        public void setPlano(String plano) {
            this.plano = plano;
        }

        public double getValorFatura() {
            return valorFatura;
        }

        public void setValorFatura(double valorFatura) {
            this.valorFatura = valorFatura;
        }
    }

