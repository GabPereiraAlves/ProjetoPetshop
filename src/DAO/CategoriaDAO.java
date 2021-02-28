
package DAO;

import DTO.CategoriaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class CategoriaDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<CategoriaDTO> lista = new ArrayList<>();
    
    public void cadastrarRaca(CategoriaDTO objcategoriadto){
        String sql = "INSERT INTO categoriapet (raca) VALUES (?)";
        
        conn = new ConectaDB().conectaDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objcategoriadto.getRaca());
            
            pstm.execute();
            pstm.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "CadastrarRaca" + erro);
        }
    }
    
    public void cadastrarServico(CategoriaDTO objcategoriadto){
        String sql = "INSERT INTO servicos (servico, lixo) VALUES (?,?)";
        
        conn = new ConectaDB().conectaDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objcategoriadto.getServico());
            pstm.setString(2, "N");
            
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "CadastrarServico" + erro);
        }
    }
    
    public ArrayList<CategoriaDTO> listarRaca(){
        String sql = "SELECT id_categoriapet, raca FROM categoriapet";
        conn = new ConectaDB().conectaDB();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            lista.clear();
            
            while(rs.next()){
                CategoriaDTO objcategoriadto = new CategoriaDTO();
                objcategoriadto.setId_raca(rs.getInt("id_categoriapet"));
                objcategoriadto.setRaca(rs.getString("raca"));
                
                lista.add(objcategoriadto);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Listar Raça: " + erro);
        }
        return lista;
    }
    
    public ArrayList<CategoriaDTO> listarServico(){
        String sql = "SELECT id_servicos, servico FROM servicos";
        conn = new ConectaDB().conectaDB();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            lista.clear();
            
            while(rs.next()){
                CategoriaDTO objcategoriadto = new CategoriaDTO();
                objcategoriadto.setId_servico(rs.getInt("id_servicos"));
                objcategoriadto.setServico(rs.getString("servico"));
                
                lista.add(objcategoriadto);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Listar Serviços: " + erro);
        }
        return lista;
    }
    
    public void alterarRaca(CategoriaDTO objcategoriadto){
        String sql = "UPDATE categoriapet SET raca = ? WHERE id_categoriapet = ?";
        
        conn = new ConectaDB().conectaDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objcategoriadto.getRaca());
            pstm.setInt(2, objcategoriadto.getId_raca());
            
            pstm.execute();
            pstm.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "AlterarRaca: " + erro);
        }
    }
    
    public void alterarServico(CategoriaDTO objcategoriadto){
        String sql = "UPDATE servicos SET servico = ? WHERE id_servicos = ?";
        
        conn = new ConectaDB().conectaDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objcategoriadto.getServico());
            pstm.setInt(2, objcategoriadto.getId_servico());
            
            pstm.execute();
            pstm.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "AlterarServico: " + erro);
        }
    }
    
    public void deletaRaca(CategoriaDTO objcategoriadto){
        String sql = "DELETE FROM categoriapet WHERE id_categoriapet = ?";
        
        conn = new ConectaDB().conectaDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objcategoriadto.getId_raca());
            
            pstm.execute();
            pstm.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Deletar Raça: " + erro);
        }
    }
    
    public void deletaServico(CategoriaDTO objcategoriadto){
        String sql = "DELETE FROM servicos WHERE id_servicos = ?";
        
        conn = new ConectaDB().conectaDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objcategoriadto.getId_servico());
            
            pstm.execute();
            pstm.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Deletar Serviço: " + erro);
        }
    }
}
