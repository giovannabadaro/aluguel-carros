/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.PessoaFisica;
import model.bean.PessoaJuridica;
import model.bean.Cliente;
/**
 *
 * @author Cida
 */
public class ClienteDAO {

    Connection con;
    
    public ClienteDAO() {
        con = ConnectionFactory.getConnection();
    }
    //--------------------------------------INSERE PESSOA FISICA ------------------------------------------------------------------
    public void CreatePessoaFisica (PessoaFisica pf){
     PreparedStatement stmt = null;

          try {
            stmt = con.prepareStatement("INSERT INTO Cliente (Endereço,Nome)VALUES(?,?)");
            stmt.setString(1, pf.getEndereco());
            stmt.setString(2, pf.getNome());        

            stmt.executeUpdate();
            //-------------------------------------------NAO MEXER EM NADA--------------------------------------------------------------------------
            //Consulta o ID gerado pelo sgbd na insercao de Cliente
        stmt = con.prepareStatement("select idCliente from Cliente where Endereço = " + "'" + pf.getEndereco() + "'" + " and Nome = " + "'" + pf.getNome()+ "'");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            pf.setId_Cliente(rs.getString("Id_cliente"));
        }
           //-----------------------------------------------------------------------------------------------------------------------

           //AGORA INSERE COM PESSOA FISICA NO MESMO CREATE DO CLIENTE
            stmt = con.prepareStatement("INSERT INTO PessoaFísica (CPF, DataNascimento, Sexo, Cliente_idCliente) VALUES (?,?,?,?) ");
            stmt.setString(1, pf.getCPF());
            stmt.setString(2, pf.getDataNascimento());
            stmt.setString(3, pf.getSexo());
            stmt.setString(4, pf.getId_Cliente());
            stmt.executeUpdate();
            
           
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }//----------------------------------------------------INSERE PESSOA JURIDICA-------------------------------------------------------------------------------
    
    public void CreatePessoaJuridica (PessoaJuridica pj){
     PreparedStatement stmt = null;

          try {
            stmt = con.prepareStatement("INSERT INTO Cliente (Endereço,Nome)VALUES(?,?)");
            stmt.setString(1, pj.getEndereco());
            stmt.setString(2, pj.getNome());        

            stmt.executeUpdate();
            //-------------------------------------------NAO MEXER EM NADA--------------------------------------------------------------------------
            //Consulta o ID gerado pelo sgbd na insercao de Cliente
        stmt = con.prepareStatement("select idCliente from Cliente where Endereço = " + "'" + pj.getEndereco() + "'" + " and Nome = " + "'" + pj.getNome()+ "'");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            pj.setId_Cliente(rs.getString("Id_cliente"));
        }
           //-----------------------------------------------------------------------------------------------------------------------

           //AGORA INSERE COM PESSOA FISICA NO MESMO CREATE DO CLIENTE
            stmt = con.prepareStatement("INSERT INTO PessoaFísica (CNPJ, Cliente_idCliente) VALUES (?,?,?,?) ");
            stmt.setString(1, pj.getCNPJ());
             stmt.setString(2, pj.getId_Cliente());
            
            stmt.executeUpdate();
            
           
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    //-----------------------------PESQUISA PESSOA FISICA--------------------------------------------------------------      
    
    
    
        public List<PessoaFisica> pesquisaPessoaFisica() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<PessoaFisica> PessoaFisica = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM PessoaFísica, Cliente WHERE idCliente = Cliente_idCliente");
            rs = stmt.executeQuery();

            while (rs.next()) {

                PessoaFisica pessoafisica = new PessoaFisica();
                pessoafisica.setCliente_idCliente("Cliente_idCliente");
                pessoafisica.setCPF("CPF");
                pessoafisica.setNome(rs.getString("Nome"));
                pessoafisica.setEndereco(rs.getString("Endereço"));
                pessoafisica.setSexo("Sexo");
                pessoafisica.setDataNascimento("DataNascimento");
                
                PessoaFisica.add(pessoafisica);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return PessoaFisica;
        
        //--------------------------------------------------------------------------------------------------------------------------
    }
        /*public List<Cliente> PesquisaPorDesc(String desc) { // USAR APENAS SE FOR PESQUISAR POR CAMPO, POR ENQUANTO N USAREMOS

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cliente> cliente = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Cliente WHERE descricao LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente cli = new Cliente();

               cli.setNome(rs.getString("Nome"));
                cli.setEndereco(rs.getString("Endereco"));
                cliente.add(cli);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return cliente;

    }*/
        
        public List<PessoaJuridica> pesquisaPessoaJuridica() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<PessoaJuridica> PessoaJuridica = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM PessoaJurídica, Cliente WHERE idCliente = Cliente_idCliente");
            rs = stmt.executeQuery();

            while (rs.next()) {

                PessoaJuridica pessoajuridica = new PessoaJuridica();
                pessoajuridica.setCliente_idCliente("Cliente_idCliente");
                pessoajuridica.setNome(rs.getString("Nome"));                
                pessoajuridica.setEndereco(rs.getString("Endereço"));
                pessoajuridica.setCNPJ("CNPJ");
                
               PessoaJuridica.add(pessoajuridica);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return PessoaJuridica;}
     //------------------------------------------ATUALIZAR APENAS CLIENTE DE PESSOA FISICA--------------------------------------------------------------   
        public void Atualizar(PessoaFisica pf) { //vai ser atualizado apenas a classe cliente, pois ninguem altera cpf e sexo nem data de nascimento

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Cliente SET Nome = ? , Endereço = ? WHERE idCliente = ?");
            stmt.setString(1,pf.getNome());
            stmt.setString(2, pf.getEndereco());
            stmt.setString(3, pf.getId_Cliente());
        

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        //----------------------------------------------------------------------------------------------------------

    }
         public void deletar (String Id_Cliente) { //passar so id como parametro na tela para n precisar digitar tudo

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM Cliente WHERE idCliente = ?"); //apenas o cliente, pois se deletar o cliente, como ele esta CASCADE, deleta a pessoa fisica ou juridica
            
            stmt.setString(1,Id_Cliente);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    








}