package moneywise.dao;

import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import moneywise.modelo.Usuario;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UsuarioDaoTest {
    
    UsuarioDao dao;
    
    @Before
    public void setUpClass() {
        try {
            dao = new UsuarioDao();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testSalvar_CT01() {
        System.out.println("salvar - CT01");
        Usuario usuario = new Usuario("joao@email.com", "senha123", "Joao", "m", Date.valueOf("1990-02-01"));
        boolean result = dao.salvar(usuario);
        assertTrue(result);
    }
    
    @Test
    public void testSalvar_CT02() {
        System.out.println("salvar - CT02");
        Usuario usuario = new Usuario(null, "senha123", "Joao", "m", Date.valueOf("1990-02-01"));
        boolean result = dao.salvar(usuario);
        assertFalse(result);
    }

    @Test
    public void testBuscar_CT01() {
        System.out.println("buscar - CT01");
        
        String email = "joao@email.com";
        Usuario expResult = new Usuario("joao@email.com", "senha123", "Joao", "m", Date.valueOf("1990-02-01"));
        Usuario result = dao.buscar(email);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testBuscar_CT02() {
        System.out.println("buscar - CT02");
        
        String email = "fake@email.com";
        Usuario result = dao.buscar(email);
        assertNull(result);
    }
    
    @Test
    public void testAtualizar_CT01() {
        System.out.println("atualizar - CT01");
        
        Usuario usuario = new Usuario("joao@email.com", "senha123", "Joao Alves", "m", Date.valueOf("2000-10-01"));
        boolean result = dao.atualizar(usuario);
        assertTrue(result);
    }
    
    @Test
    public void testAtualizar_CT02() {
        System.out.println("atualizar - CT02");
        
        Usuario usuario = new Usuario("joao@email.com", "abcdefghij", "Joao Almeida", "m", Date.valueOf("1980-02-01"));
        dao.atualizar(usuario);
        Usuario result = dao.buscar(usuario.getEmail());
        assertEquals(usuario, result);
    }
    
    @Test
    public void testRemover_CT01() {
        System.out.println("remover - CT01");
        String email = "joao@email.com";
        boolean resultA = dao.remover(email);
        boolean resultB = (dao.buscar(email) == null);
        assertTrue(resultA && resultB);
    }
    
    @Test
    public void testRemover_CT02() {
        System.out.println("remover - CT02");
        String email = "fake@email.com";
        boolean result = dao.remover(email);
        assertFalse(result);
    }
    
    @Test
    public void testLoginUsuario_CT01() throws Exception {
        System.out.println("loginUsuario - CT01");
        Usuario usuario = new Usuario("maria@email.com", "qwerty", "Maria", "f", Date.valueOf("1995-12-01"));
        dao.salvar(usuario);
        Usuario result = dao.loginUsuario(usuario.getEmail(), usuario.getSenha());
        assertEquals(usuario, result);
    }
    
}
