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
import model.bean.PessoaJuridica;

/**
 *
 * @author geova
 */
public class PessoaJuridicaDAO {

    Connection con;

    public PessoaJuridicaDAO() {
        con = ConnectionFactory.getConnection();
    }

    public void Create(PessoaJuridica pj) {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO PessoaJuridica (CNPJ, Nome, Cliente_idCliente)VALUES (?,?,?");
            stmt.setString(1, pj.getCNPJ());
            stmt.setString(2, pj.getNome());
            stmt.setString(3, pj.getCliente_idCliente());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<PessoaJuridica> pesquisa() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<PessoaJuridica> juridica = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM PessoaJuridica");
            rs = stmt.executeQuery();
            while (rs.next()) {

                PessoaJuridica Pjuridica = new PessoaJuridica();

                Pjuridica.setCNPJ(rs.getString("CNPJ"));
                Pjuridica.setNome(rs.getString("Nome"));
                Pjuridica.setCliente_idCliente(rs.getString("Cliente_idCliente"));
                juridica.add(Pjuridica);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return juridica;

    }

    public void Atualizar(PessoaJuridica pj) {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE PessoaJuridica SET CNPJ = ? Nome = ? Cliente_idCliente = ?");
            stmt.setString(1, pj.getCNPJ());
            stmt.setString(2, pj.getNome());
            stmt.setString(3, pj.getCliente_idCliente());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void deletar(PessoaJuridica pj) {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM PessoaJuridica WHERE CNPJ = ?");
            stmt.setString(1, pj.getCNPJ());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
