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
import model.bean.Modelo;
import model.bean.Veiculo;

/**
 *
 * @author geova
 */
public class VeiculoDAO {
    Modelo modelo;

    Connection con;

    public VeiculoDAO() {
        con = ConnectionFactory.getConnection();

    }

    public void Create(Veiculo v) {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO modelo (Placa, Chassi, Cor,Km, DatamedidaKm, UltimaRevisão, Filial_idFilial, Modelo_codigo)VALUES(?,?,?,?,?,?,?,?)");
            stmt.setString(1, v.getPlaca());
            stmt.setString(2, v.getChassi());
            stmt.setString(3, v.getCor());
            stmt.setString(4, v.getKm());
            stmt.setString(5, v.getDatamedidaKm());
            stmt.setString(6, v.getUltimaRevisao());
            stmt.setString(7, v.getFilial_idFilial());
            stmt.setString(8, v.getModelo_codigo());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Veiculo> pesquisa() {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Veiculo> veiculos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Veiculo");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Veiculo veiculo = new Veiculo();
                veiculo.setPlaca(rs.getString("Placa"));
                veiculo.setChassi(rs.getString("Chassi"));
                veiculo.setCor(rs.getString("Cor"));
                veiculo.setKm(rs.getString("Km"));
                veiculo.setDatamedidaKm(rs.getString("DatamedidaKm"));
                veiculo.setUltimaRevisao(rs.getString("UltimaRevisao"));
                veiculo.setFilial_idFilial(rs.getString("Filial_idFilial"));
                veiculo.setModelo_codigo(rs.getString("Modelo_codigo"));

                veiculos.add(veiculo);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return veiculos;

    }
    
   public void Atualizar (Veiculo v)
   {
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("UPDATE modelo SET Placa = ? Chassi = ? Cor = ? Km = ? DatamedidaKm = ?  UltimaRevisão = ? Filial_idFilial = ? Modelo_codigo = ? WHERE Placa = ?");
            stmt.setString(1, v.getPlaca());
            stmt.setString(2, v.getChassi());
            stmt.setString(3, v.getCor());
            stmt.setString(4, v.getKm());
            stmt.setString(5, v.getDatamedidaKm());
            stmt.setString(6, v.getUltimaRevisao());
            stmt.setString(7, v.getFilial_idFilial());
            stmt.setString(8, v.getModelo_codigo());
            
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
       
   }
   
   public void deletar (String v)
   {
        PreparedStatement stmt = null;
        
        try{
           stmt = con.prepareStatement("DELETE FROM Veiculo WHERE Placa = ?");
           stmt.setString(1,v);
           
           stmt.executeUpdate();
           
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
   }

}
