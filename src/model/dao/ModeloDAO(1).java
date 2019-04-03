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
/**
 *
 * @author Cida
 */
public class ModeloDAO {

    Connection con;
    
    public ModeloDAO() {
        con = ConnectionFactory.getConnection();
    }    
    public void Create(Modelo m){
     PreparedStatement stmt = null;

          try {
            stmt = con.prepareStatement("INSERT INTO Modelo (Codigo, Categoria,Câmbio,Direção,nPassageiros)VALUES(?,?,?,?)");
            stmt.setString(1, m.getCodigo());
            stmt.setString(2, m.getCategoria());
            stmt.setString(3, m.getCambio());
            stmt.setString(4, m.getDirecao());
            stmt.setString(5, m.getnPassageiros());
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }    
        public List<Modelo> pesquisa() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Modelo> mods = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Modelo");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Modelo modelo = new Modelo();
               
                modelo.setCodigo(rs.getString("Código"));
                modelo.setCategoria(rs.getString("Categoria"));
                modelo.setCambio(rs.getString("Câmbio"));
                modelo.setDirecao(rs.getString("Direção"));
                modelo.setnPassageiros(rs.getString("nPassageiros"));
                
                mods.add(modelo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return mods;
    }
       /* public List<Modelo> PesquisaPorDesc(String desc) {  

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Modelo> mods = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Modelo WHERE  LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                 Modelo modelo = new Modelo();

                modelo.setCategoria(rs.getString("Categoria"));
                modelo.setCambio(rs.getString("Câmbio"));
                modelo.setDirecao(rs.getString("Direção"));
                modelo.setnPassageiros(rs.getString("nPassageiros"));
                
                mods.add(modelo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return mods;
    }*/
        
        public void Atualizar(Modelo m) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Modelo SET Categoria = ? Câmbio = ? Direção = ? nPassageiros = ? WHERE Código = ?");
            stmt.setString(1, m.getCategoria());
            stmt.setString(2, m.getCambio());
            stmt.setString(3, m.getDirecao());
            stmt.setString(4, m.getnPassageiros());
            stmt.setString(5, m.getCodigo());
        

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
         public void deletar (String codigo) {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM Modelo WHERE Código = ?");
            stmt.setString(1, codigo);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    








}