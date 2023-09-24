/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import java.sql.Connection ;
import java.sql.PreparedStatement ;
import beans.Produtos;
import beans.Conexao;

    public class ProdutosDAO {

        private Conexao conexao;
        private Connection conn;

        public ProdutosDAO() {
            this.conexao = new Conexao();
            this.conn = this.conexao.getConexao();
        }

        public void inserir(Produtos produtos) {
            String sql = "INSERT INTO produtos(nome, valor, status) VALUES "
                    + "(?, ?, ?)";
            try {
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setString(1, produtos.getNome());
                stmt.setInt(2, produtos.getValor());
                stmt.setString(3, produtos.getStatus());
           
                
                stmt.execute();

            } catch (Exception e) {
                System.out.println("Erro ao inserir cliente: " + e.getMessage());
            }
        }

    }

    

