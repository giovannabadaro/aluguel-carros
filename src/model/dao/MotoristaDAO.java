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
import model.bean.Motorista;

/**
 *
 * @author geova
 */
public class MotoristaDAO {

    Connection con;

    public MotoristaDAO() {
        con = ConnectionFactory.getConnection();

    }

    public void Create(Motorista m) {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO (numeroHabilitacao, RG, Nome, Vencimento, Cliente_idCliente)VALUES (?,?,?,?,?)");
            stmt.setString(1, m.getNumeroHabilitacao());
            stmt.setString(2, m.getRG());
            stmt.setString(3, m.getNome());
            stmt.setString(4, m.getVencimento());
            stmt.setString(5, m.getCliente_idCliente());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Motorista> pesquisa() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Motorista> motorista = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM Motorista");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Motorista moto = new Motorista();

                moto.setNumeroHabilitacao(rs.getString("numeroHabilitacao"));
                moto.setRG(rs.getString("RG"));
                moto.setNome(rs.getString("Nome"));
                moto.setVencimento(rs.getString("Vencimento"));
                moto.setCliente_idCliente(rs.getString("Cliente_idCliente"));
                motorista.add(moto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return motorista;
    }

    public void Atualizar(Motorista m) {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE Motorista SET numeroHabilitacao = ? RG = ? Nome = ? Vencimento = ? Cliente_idCliente = ? ");
            stmt.setString(1, m.getNumeroHabilitacao());
            stmt.setString(2, m.getRG());
            stmt.setString(3, m.getNome());
            stmt.setString(4, m.getVencimento());
            stmt.setString(5, m.getCliente_idCliente());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void deletar(String numeroH) {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM Motorista WHERE numeroHabilitacao = ?");
            stmt.setString(1, numeroH);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
}
