package moneywise.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import moneywise.factory.Conexao;
import moneywise.modelo.Usuario;
import moneywise.resources.Encryption;

public class UsuarioDao {
    
    private Connection conn;

    public UsuarioDao() throws SQLException, ClassNotFoundException{
        conn = Conexao.getConnection();
    }
    
    public boolean salvar(Usuario usuario) {
        String sql = "INSERT INTO Usuario(email, senha, nome, sexo, nascimento)"
                   + "VALUES (?,?,?,?,?);";

        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, usuario.getEmail());
            //Encripta a senha antes de salvar
            stmt.setString(2, Encryption.encrypt(usuario.getSenha()));
            stmt.setString(3, usuario.getNome());
            stmt.setString(4, usuario.getSexo());
            stmt.setDate  (5, usuario.getNascimento());

            stmt.executeUpdate();

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public Usuario buscar(String email) {

        Usuario usuario = null;

        String sql = "SELECT * FROM Usuario WHERE Email ILIKE ?";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            while(rs.next())
                usuario = new Usuario(
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("nome"),
                        rs.getString("sexo"),
                        rs.getDate("nascimento")
                );

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        return usuario;
    }

    public boolean atualizar(Usuario usuario) {

        String sql = "UPDATE Usuario SET senha = ?, nome = ?, sexo = ?, nascimento = ?"
                   + "WHERE email = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            //Encripta a senha antes de salvar
            stmt.setString(1, Encryption.encrypt(usuario.getSenha()));
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getSexo());
            stmt.setDate  (4, usuario.getNascimento());            
            stmt.setString (5, usuario.getEmail());

            stmt.executeUpdate();

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean remover(String email) {

        String sql = "DELETE FROM Movimentacao WHERE Usuario ILIKE ?;"
                   + "DELETE FROM Usuario WHERE Email ILIKE ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, email);
            stmt.setString(2, email);

            stmt.executeUpdate();

            stmt.close();
            conn.close();
        } catch (SQLException ex) {

            ex.printStackTrace();
            return false;
        }

        return true;
    }

    public Usuario loginUsuario(String email, String senha) throws SQLException {

        Usuario usuario = null;

        String sql = "SELECT senha FROM Usuario WHERE email ILIKE ?";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, senha);

        ResultSet rs = stmt.executeQuery();

        if(Encryption.checkPassword(senha, rs.getString("Senha"))){
           usuario = buscar(email); 
        }

        rs.close();
        stmt.close();
        conn.close();

        return usuario;
    }
    
}
