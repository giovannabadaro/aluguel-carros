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
import model.bean.Reserva;

/**
 *
 * @author geova
 */
public class ReservaDAO {

    Connection con;

    public ReservaDAO() {
        con = ConnectionFactory.getConnection();
    }

    public void Create(Reserva r) {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO Reserva (idReserva, dataRetirada, dataDevolução, Filial_idFiliall, Filial_idFilial, Cliente_idCliente, ModeloCodigo, Custo)VALUES(?,?,?,?,?,?,? )");
            stmt.setString(1, r.getIdReserva());
            stmt.setString(2, r.getDataRetirada());
            stmt.setString(3, r.getDataDevolucao());
            stmt.setString(4, r.getFilial_idFilial1());
            stmt.setString(5, r.getFilial_idFilial());
            stmt.setString(6, r.getCliente_idCliente());
            stmt.setString(7, r.getModeloCodigo());
            stmt.setString(8, r.getCusto());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Reserva> pesquisa() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Reserva> reservas = new ArrayList();
        try {
            stmt = con.prepareStatement("SELECT * FROM Reserva");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setIdReserva(rs.getString("idReserva"));
                reserva.setDataRetirada(rs.getString("DataRetirada"));
                reserva.setDataDevolucao(rs.getString("DataDevolução"));
                reserva.setFilial_idFilial1(rs.getString("Filial_idFiliall"));
                reserva.setFilial_idFilial(rs.getString("Filial_idFilial"));
                reserva.setCliente_idCliente(rs.getString("Cliente_idCliente"));
                reserva.setModeloCodigo(rs.getString("ModeloCodigo"));
                reserva.setCusto(rs.getString("Custo"));

                reservas.add(reserva);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return reservas;
    }

    public void Atualizar(Reserva r) {
        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement("UPDATE Reserva SET DataRetirada = ? DataDevolução = ? Filial_idFiliall = ? Filial_idFilial = ? Cliente_idCliente = ? ModeloCodigo = ? Custo = ? WHERE idReserva = ? ");

            stmt.setString(1, r.getIdReserva());
            stmt.setString(2, r.getDataRetirada());
            stmt.setString(3, r.getDataDevolucao());
            stmt.setString(4, r.getFilial_idFilial1());
            stmt.setString(5, r.getFilial_idFilial());
            stmt.setString(6, r.getCliente_idCliente());
            stmt.setString(7, r.getModeloCodigo());
            stmt.setString(8, r.getCusto());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void Deletar(String r) {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM Reserva WHERE idReserva = ?");
            stmt.setString(1, r);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
