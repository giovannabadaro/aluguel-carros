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

/**
 *
 * @author geova
 */
public class PessoaFisicaDAO {
    Connection con;
    public PessoaFisicaDAO(){
        con = ConnectionFactory.getConnection();
            }
    public void Create (PessoaFisica pf){
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement("INSERT INTO PessoaFisica (CPF, sexo, DataNascimento, Cliente_idCliente) VALUES (?,?,?,?)");
            stmt.setString(1, pf.getCPF());
            stmt.setString(2,pf.getSexo());
            stmt.setString(3, pf.getDataNascimento());
            stmt.setString(4, pf.getCliente_idCliente());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    public List<PessoaFisica> pesquisa()
    {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<PessoaFisica> fisica = new ArrayList<>();
        try{
            stmt = con.prepareStatement("SELECT * FROM PessoaFisica");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                PessoaFisica Pfisica = new PessoaFisica();
                
                Pfisica.setCPF(rs.getString("CPF"));
                Pfisica.setSexo(rs.getString("sexo"));
                Pfisica.setDataNascimento(rs.getString("DataNascimento"));
                Pfisica.setId_Cliente(rs.getString("Cliente_idCliente"));
                fisica.add(Pfisica);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return fisica;
        
    }
    public void Atualizar (PessoaFisica pf){
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement("UPDATE PessoaFisica SET CPF = ? sexo = ? DataNascimento = ? Cliente_idCliente = ? ");
           stmt.setString(1, pf.getCPF());
            stmt.setString(2,pf.getSexo());
            stmt.setString(3, pf.getDataNascimento());
            stmt.setString(4, pf.getId_Cliente());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public void deletar (PessoaFisica pf){
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement("DELETE FROM PessoaFisica WHERE CPF = ?");
            stmt.setString(1, pf.getCPF()); 
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
}