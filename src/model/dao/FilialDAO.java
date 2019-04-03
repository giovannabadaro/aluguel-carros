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
import model.bean.Filial;
/**
 *
 * @author Cida
 */
public class FilialDAO {

    Connection con;
    
    public FilialDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public void Create(Filial f){
     PreparedStatement stmt = null;

          try {
            stmt = con.prepareStatement("INSERT INTO Filial (Endereço)VALUES(?)");
            stmt.setString(1, f.getEndereco());          
            stmt.executeUpdate();
            
             //-------------------------------------------NAO MEXER EM NADA--------------------------------------------------------------------------
            //Consulta o ID gerado pelo sgbd na insercao de Cliente
        stmt = con.prepareStatement("select idFilial from Filial where Endereço = " + "'" + f.getEndereco() + "'");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            f.setIdFilial(rs.getString("idFilial"));
        }
           //-----------------------------------------------------------------------------------------------------------------------


            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
        public List<Filial> pesquisa() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Filial> filiais = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Filial");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Filial filial = new Filial();

                filial.setIdFilial(rs.getString("idFilial"));
                filial.setEndereco(rs.getString("Endereço"));
                filiais.add(filial);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return filiais;

    }
        /*public List<Filial> PesquisaPorDesc(String desc) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Filial> filiais = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto WHERE descricao LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Filial filial = new Filial();

               
                filial.setEndereco(rs.getString("Endereço"));
                filiais.add(filial);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return filiais;

    }*/
        
        public void Atualizar(Filial f) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE produto SET Endereço = ? WHERE idFilial = ?");
          
            stmt.setString(1, f.getEndereco());
           
        

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
         public void deletar (String IdFilial) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM Filial WHERE idFilial = ?");
            stmt.setString(1, IdFilial);
           
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    








}