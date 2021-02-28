
package DAO;

import DTO.AgendamentoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class AgendamentoDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<AgendamentoDTO> lista = new ArrayList<>();
    
    public ResultSet listarProfissional(){
        conn = new ConectaDB().conectaDB();
        String sql = "SELECT nome FROM funcionario ORDER BY nome asc;";
        
        try {
            
            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();
            
        } catch (Exception erro) {
            
            JOptionPane.showMessageDialog(null, "listarProfissional: " + erro);
            return null;
        }
    }
    
    public ResultSet listarServico(){
        conn = new ConectaDB().conectaDB();
        String sql = "SELECT servico FROM servicos ORDER BY servico asc;";
        
        try {
            
            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();
            
        } catch (Exception erro) {
            
            JOptionPane.showMessageDialog(null, "listarServico: " + erro);
            return null;
        }
    }
    
    public void cadastrarAgendamento(AgendamentoDTO objagendamentodto){
        
        conn = new ConectaDB().conectaDB();
        String sql = "INSERT INTO agendamento (nomepet, especie, porte, peso, datas,"
                + "horario, valorservico, nomeprofissional, procedimento, realizado)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?);";
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objagendamentodto.getNomePet());
            pstm.setString(2, objagendamentodto.getEspecie());
            pstm.setString(3, objagendamentodto.getPorte());
            pstm.setString(4, objagendamentodto.getPeso());
            pstm.setString(5, objagendamentodto.getData());
            pstm.setString(6, objagendamentodto.getHorario());
            pstm.setString(7, objagendamentodto.getValorServico());
            pstm.setString(8, objagendamentodto.getNomeProfissional());
            pstm.setString(9, objagendamentodto.getProcediemnto());
            pstm.setString(10, objagendamentodto.getRealizado());
            
            pstm.execute();
            pstm.close();
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "cadastrarAgendamento: " + erro);
        }
    }
    
    public ArrayList<AgendamentoDTO> listarAgendamentos(){
        
        String sql = "SELECT * FROM agendamento;";
        conn = new ConectaDB().conectaDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                AgendamentoDTO objagendamentodto = new AgendamentoDTO();
                
                objagendamentodto.setId_agendamento(rs.getInt("id_agendamento"));
                objagendamentodto.setNomePet(rs.getString("nomepet"));
                objagendamentodto.setEspecie(rs.getString("especie"));
                objagendamentodto.setPorte(rs.getString("porte"));
                objagendamentodto.setPeso(rs.getString("peso"));
                objagendamentodto.setData(rs.getString("datas"));
                objagendamentodto.setHorario(rs.getString("horario"));
                objagendamentodto.setValorServico(rs.getString("valorservico"));
                objagendamentodto.setNomeProfissional(rs.getString("nomeprofissional"));
                objagendamentodto.setProcediemnto(rs.getString("procedimento"));
                objagendamentodto.setRealizado(rs.getString("realizado"));
                
                lista.add(objagendamentodto);
            }
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "listarAgendamentos: " + erro);
        }
        return lista;
    }
    
    public void alterarAgendamento(AgendamentoDTO objagendamentodto){
        String sql = "UPDATE agendamento "
                + "SET nomepet = ?, especie = ?, porte = ?, peso = ?, datas = ?,"
                + "horario = ?, valorservico = ?, nomeprofissional = ?,"
                + "procedimento = ?, realizado = ?"
                + "WHERE id_agendamento = ?;";
        
        conn = new ConectaDB().conectaDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objagendamentodto.getNomePet());
            pstm.setString(2, objagendamentodto.getEspecie());
            pstm.setString(3, objagendamentodto.getPorte());
            pstm.setString(4, objagendamentodto.getPeso());
            pstm.setString(5, objagendamentodto.getData());
            pstm.setString(6, objagendamentodto.getHorario());
            pstm.setString(7, objagendamentodto.getValorServico());
            pstm.setString(8, objagendamentodto.getNomeProfissional());
            pstm.setString(9, objagendamentodto.getProcediemnto());
            pstm.setString(10, objagendamentodto.getRealizado());
            pstm.setInt(11, objagendamentodto.getId_agendamento());
            
            pstm.execute();
            pstm.close();
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "alterarAgendamento: " + erro);
        }
    }
    
    public void deletaAgendamento(AgendamentoDTO objagendamentodto){
        String sql = "DELETE FROM agendamento WHERE id_agendamento = ?;";
        
        conn = new ConectaDB().conectaDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objagendamentodto.getId_agendamento());
            
            pstm.execute();
            pstm.close();
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "deletaAgendamento: " + erro);
        }
    }
}
