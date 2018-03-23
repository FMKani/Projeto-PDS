package moneywise.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import moneywise.factory.Conexao;
import moneywise.modelo.Movimentacao;
import moneywise.modelo.Usuario;

public class MovimentacaoDao {

    private Connection conn;

    public MovimentacaoDao() throws SQLException, ClassNotFoundException {
        conn = Conexao.getConnection();
    }

    public int getLastCod() throws SQLException{
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery("select MAX(cod) from Movimentacao");

        rs.next();
        int id = rs.getInt("MAX") + 1;

        stat.close();
        return id;
    }

    public boolean salvar(Movimentacao mov) {
        String sql = "INSERT INTO Movimentacao(cod, usuario, descricao, valor, data, tipo, categoria)"
                + "VALUES (?,?,?,?,?,?,?);";

        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);

            //Caso cod == -1, set cod com o ultimo cod disponivel
            if (mov.getCod() == -1) {
                mov.setCod(getLastCod());
            }

            stmt.setInt(1, mov.getCod());
            stmt.setString(2, mov.getEmailUsuario());
            stmt.setString(3, mov.getDescricao());
            stmt.setFloat(4, mov.getValor());
            stmt.setDate(5, mov.getData());
            stmt.setString(6, mov.getTipo());
            stmt.setString(7, mov.getCategoria());

            stmt.executeUpdate();

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Movimentacao buscar(int cod) {

        Movimentacao mov = null;

        String sql = "SELECT * FROM Movimentacao WHERE cod = ?";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cod);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                mov = new Movimentacao(
                        rs.getInt("cod"),
                        rs.getString("usuario"),
                        rs.getString("descricao"),
                        rs.getFloat("valor"),
                        rs.getDate("data"),
                        rs.getString("tipo"),
                        rs.getString("categoria")
                );
            }

            rs.close();
            stmt.close();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        return mov;
    }

    public List<Movimentacao> listarTudo(Usuario usuario) {

        List<Movimentacao> movs = new ArrayList<>();

        String sql = "SELECT * FROM Movimentacao WHERE usuario = ? ORDER BY data DESC";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getEmail());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Movimentacao mov = new Movimentacao(
                        rs.getInt("cod"),
                        rs.getString("usuario"),
                        rs.getString("descricao"),
                        rs.getFloat("valor"),
                        rs.getDate("data"),
                        rs.getString("tipo"),
                        rs.getString("categoria")
                );
                
                movs.add(mov);
            }

            rs.close();
            stmt.close();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        return movs;
    }
    
    public List<Movimentacao> listarDataInicio(Usuario usuario, Date inicio) {

        List<Movimentacao> movs = new ArrayList<>();

        String sql = "SELECT * FROM Movimentacao WHERE usuario = ? and data >= ? ORDER BY data DESC";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getEmail());
            stmt.setDate(2, inicio);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Movimentacao mov = new Movimentacao(
                        rs.getInt("cod"),
                        rs.getString("usuario"),
                        rs.getString("descricao"),
                        rs.getFloat("valor"),
                        rs.getDate("data"),
                        rs.getString("tipo"),
                        rs.getString("categoria")
                );
                
                movs.add(mov);
            }

            rs.close();
            stmt.close();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        return movs;
    }
    
    public List<Movimentacao> listarDataFim(Usuario usuario, Date fim) {

        List<Movimentacao> movs = new ArrayList<>();

        String sql = "SELECT * FROM Movimentacao WHERE usuario = ? and data <= ? ORDER BY data DESC";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getEmail());
            stmt.setDate(2, fim);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Movimentacao mov = new Movimentacao(
                        rs.getInt("cod"),
                        rs.getString("usuario"),
                        rs.getString("descricao"),
                        rs.getFloat("valor"),
                        rs.getDate("data"),
                        rs.getString("tipo"),
                        rs.getString("categoria")
                );
                
                movs.add(mov);
            }

            rs.close();
            stmt.close();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        return movs;
    }
    
    public List<Movimentacao> listarDataInicioFim(Usuario usuario, Date inicio, Date fim) {

        List<Movimentacao> movs = new ArrayList<>();

        String sql = "SELECT * FROM Movimentacao WHERE usuario = ? and data >= ? and data <= ? ORDER BY data DESC";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getEmail());
            stmt.setDate(2, inicio);
            stmt.setDate(3, fim);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Movimentacao mov = new Movimentacao(
                        rs.getInt("cod"),
                        rs.getString("usuario"),
                        rs.getString("descricao"),
                        rs.getFloat("valor"),
                        rs.getDate("data"),
                        rs.getString("tipo"),
                        rs.getString("categoria")
                );
                
                movs.add(mov);
            }

            rs.close();
            stmt.close();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        return movs;
    }
    
    public boolean atualizar(int cod, Movimentacao mov) {

        String sql = "UPDATE Movimentacao SET cod = ?, usuario = ?, descricao = ?, "
                + "valor = ?, data = ?, tipo = ?, categoria = ? WHERE cod = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            //Caso cod == -1, set cod com o ultimo cod disponivel
            if (mov.getCod() == -1) {
                mov.setCod(getLastCod());
            }

            stmt.setInt(1, mov.getCod());
            stmt.setString(2, mov.getEmailUsuario());
            stmt.setString(3, mov.getDescricao());
            stmt.setFloat(4, mov.getValor());
            stmt.setDate(5, mov.getData());
            stmt.setString(6, mov.getTipo());
            stmt.setString(7, mov.getCategoria());
            stmt.setInt(8, cod);

            stmt.executeUpdate();

            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean remover(int cod) {

        String sql = "DELETE FROM Movimentacao WHERE cod = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, cod);

            stmt.executeUpdate();

            stmt.close();
        } catch (SQLException ex) {

            ex.printStackTrace();
            return false;
        }

        return true;
    }

    public void close() throws SQLException {
        conn.close();
    }

}
