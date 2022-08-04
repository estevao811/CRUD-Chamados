package controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;


public class DAOsql {

	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public java.sql.Connection conectaBD() throws SQLException, ClassNotFoundException, IOException {
		String url = "jdbc:mysql://localhost:3306/dbsocorrodesk";
		String user = "root";
		String passwd = "12345";
		Connection con = DriverManager.getConnection(url, user, passwd);   
        return con ;
    }
	
	
	public Usuario realizarLoginDAO(Usuario usuario) throws Exception, SQLException, IOException {	
		String query = "SELECT * FROM usuario "
				+ "WHERE login = '" + usuario.getLogin() + "' "
				+ "AND senha = '" + usuario.getSenha() + "' " 
				;
		Connection c = this.conectaBD();
        PreparedStatement ps = c.prepareStatement(query);
		ResultSet resultado = null;		
		try {
			resultado = ps.executeQuery(query);
			if(resultado.next()) {
				usuario.setIdUsuario(Integer.parseInt(resultado.getString(1)));
				usuario.setNome(resultado.getString(2));
				usuario.setEmail(resultado.getString(3));			
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que realiza o login.");
			System.out.println("Erro: " + e.getMessage());
		}		
		return usuario;
	}
	
	
	public Object[][] buscarChamadosAbertos() {
		try {
            String sql ="SELECT * FROM CHAMADOS WHERE DATAFECHAMENTO IS NULL ORDER BY DATAABERTURA";
            Connection c = this.conectaBD();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<String[]> list = new ArrayList<String[]>();
            while (rs.next()) {
            	 String[] linha = {rs.getString(4), LocalDate.parse(rs.getString(6)).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), rs.getString(1)};
                list.add(linha);
            }
            Object [][] array = new Object[list.size()][3];
            int i = 0;
            for(String[] tupla: list) {
                array[i] = list.get(i) ;
                i++;
            }
            return  array ;
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	
	public Object[][] buscarTodosChamados() {
		try {
            String sql ="SELECT * FROM CHAMADOS ORDER BY DATAABERTURA";
            Connection c = this.conectaBD();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<String[]> list = new ArrayList<String[]>();
            while (rs.next()) {
            	String[] linha = {rs.getString(4), LocalDate.parse(rs.getString(6)).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), rs.getString(1)};
                list.add(linha);
            }
            Object [][] array = new Object[list.size()][3];
            int i = 0;
            for(String[] tupla: list) {
                array[i] = list.get(i) ;
                i++;
            }
            return  array ;
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	
	public Object[][] buscarChamadosAbertosIDusuario(int idUsuario){
		try {
            String sql ="SELECT * FROM CHAMADOS WHERE DATAFECHAMENTO IS NULL "
            		+ "AND IDUSUARIO = " +idUsuario+ " "
            		+ "ORDER BY DATAABERTURA";
            Connection c = this.conectaBD();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<String[]> list = new ArrayList<String[]>();
            while (rs.next()) {            
            	String[] linha = {rs.getString(4), LocalDate.parse(rs.getString(6)).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), rs.getString(1)};
                list.add(linha);
            }
            Object [][] array = new Object[list.size()][3];
            int i = 0;
            for(String[] tupla: list) {
                array[i] = list.get(i) ;
                i++;
            }
            return  array ;
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	
	public Object[][] buscarChamadosAtendimentoIDusuario(int idUsuario){

		try {
            String sql ="SELECT * FROM CHAMADOS WHERE DATAFECHAMENTO IS NULL "
            		+ "AND IDTECNICO = " +idUsuario+ " "
            		+ "ORDER BY DATAABERTURA";
            Connection c = this.conectaBD();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<String[]> list = new ArrayList<String[]>();
            while (rs.next()) {            
            	String[] linha = {rs.getString(4), LocalDate.parse(rs.getString(6)).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), rs.getString(1)};
                list.add(linha);
            }
            Object [][] array = new Object[list.size()][3];
            int i = 0;
            for(String[] tupla: list) {
                array[i] = list.get(i) ;
                i++;
            }
            return  array ;
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	public int inserirChamado(String IDUSUARIO, String IDTECNICO, String TITULO, 
			String DESCRICAO, String DATAABERTURA, 
			String SOLUCAO, String DATAFECHAMENTO){
		try {
            String sql ="INSERT INTO CHAMADOS (IDUSUARIO, IDTECNICO, TITULO, DESCRICAO, DATAABERTURA, SOLUCAO, DATAFECHAMENTO) VALUES (?,?,?,?,?,?,?)";
            Connection c = this.conectaBD();
            
            PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, IDUSUARIO);
            ps.setString(2, IDTECNICO);
            ps.setString(3, TITULO);
            ps.setString(4, DESCRICAO);
            ps.setString(5, DATAABERTURA);
            ps.setString(6, SOLUCAO);
            ps.setString(7, DATAFECHAMENTO);
            int atualizacao=ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            return id;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return -1;
    }

	public boolean editarChamado(int IDUSUARIO, int IDTECNICO, 
			String TITULO, String DESCRICAO, String DATAABERTURA, 
			String SOLUCAO ,String DATAFECHAMENTO, int IDCHAMADO) {
		try {
            String sql ="UPDATE CHAMADOS SET IDUSUARIO = ?, IDTECNICO = ?, "
            		+ "TITULO = ?,DESCRICAO = ?, DATAABERTURA = ?, SOLUCAO = ?,  DATAFECHAMENTO = ? "
            		+ "WHERE IDCHAMADO = " +IDCHAMADO;
            Connection c = this.conectaBD();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, IDUSUARIO);
            ps.setInt(2, IDTECNICO);
            ps.setString(3, TITULO);
            ps.setString(4, DESCRICAO);
            ps.setString(5, DATAABERTURA);
            ps.setString(6, SOLUCAO);
            ps.setString(7, DATAFECHAMENTO);
            int linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas > 0 ? true : false;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

	
	
	public boolean excluirChamadoPorId(String idChamado) {
		try {
            String sql ="DELETE FROM CHAMADOS WHERE IDCHAMADO = ?";
            Connection c = this.conectaBD();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, idChamado);
            int resultado = ps.executeUpdate();
            return resultado >0 ? true : false;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
	}
	
	
}
