package moneywise.dao;

import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import moneywise.modelo.Usuario;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioDaoTest {
    
    UsuarioDao dao;
    
    @Before
    public void setUp() {
        try {
            dao = new UsuarioDao();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void test01Salvar_CT01() {
        System.out.println("salvar - CT01");
        Usuario usuario = new Usuario("joao@email.com", "senha123", "Joao", "m", Date.valueOf("1990-02-01"));
        boolean result = dao.salvar(usuario);
        assertTrue(result);
    }
        
    @Test
    public void test02Salvar_CT02() {
        System.out.println("salvar - CT02");
        Usuario usuario = new Usuario(null, "senha123", "Joao", "m", Date.valueOf("1990-02-01"));
        boolean result = dao.salvar(usuario);
        assertFalse(result);
    }

    @Test
    public void test03Buscar_CT01() {
        System.out.println("buscar - CT01");
        
        String email = "joao@email.com";
        Usuario expResult = new Usuario("joao@email.com", "senha123", "Joao", "m", Date.valueOf("1990-02-01"));
        Usuario result = dao.buscar(email);
        assertEquals(expResult, result);
    }
    
    @Test
    public void test04Buscar_CT02() {
        System.out.println("buscar - CT02");
        
        String email = "fake@email.com";
        Usuario result = dao.buscar(email);
        assertNull(result);
    }
    
    @Test
    public void test05Atualizar_CT01() {
        System.out.println("atualizar - CT01");
        
        Usuario usuario = new Usuario("joao@email.com", "senha123", "Joao Alves", "m", Date.valueOf("2000-10-01"));
        boolean result = dao.atualizar(usuario);
        assertTrue(result);
    }
    
    @Test
    public void test06Atualizar_CT02() {
        System.out.println("atualizar - CT02");
        
        Usuario usuario = new Usuario("joao@email.com", "abcdefghij", "Joao Almeida", "m", Date.valueOf("1980-02-01"));
        dao.atualizar(usuario);
        Usuario result = dao.buscar(usuario.getEmail());
        assertEquals(usuario, result);
    }
    
    @Test
    public void test07Remover_CT01() {
        System.out.println("remover - CT01");
        String email = "joao@email.com";
        boolean resultA = dao.remover(email);
        boolean resultB = (dao.buscar(email) == null);
        assertTrue(resultA && resultB);
    }
        
    @Test
    public void test08LoginUsuario_CT01() throws Exception {
        System.out.println("loginUsuario - CT01");
        Usuario usuario = new Usuario("maria@email.com", "qwerty", "Maria", "f", Date.valueOf("1995-12-01"));
        dao.salvar(usuario);
        Usuario result = dao.loginUsuario(usuario.getEmail(), usuario.getSenha());
        assertEquals(usuario, result);
    }
   
}
