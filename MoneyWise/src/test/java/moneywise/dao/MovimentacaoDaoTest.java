package moneywise.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import moneywise.modelo.Movimentacao;
import moneywise.modelo.Usuario;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MovimentacaoDaoTest {
    
    MovimentacaoDao dao;
    
    @Before
    public void setUpBefore(){
        try {
            dao = new MovimentacaoDao();
            UsuarioDao uDao = new UsuarioDao();
            Usuario user = new Usuario("test@mov.com", "senha", "nome", "m", Date.valueOf("1999-01-01"));
            uDao.salvar(user);
        } catch (Exception ex) {
            Logger.getLogger(MovimentacaoDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testGetLastID_CT01() {
        System.out.println("getLastID() - CT01");
        Movimentacao mov = new Movimentacao(-1, "test@mov.com", "descricao...", 250.75f, Date.valueOf("1990-02-01"), "Tipo1", "Categoria1");
        int result = dao.getLastID();
        dao.salvar(mov);
        assertEquals(mov.getCod(), result);
    }
    
    @Test
    public void testSalvar_CT01() {
        System.out.println("salvar - CT01");
        Movimentacao mov = new Movimentacao(-1, "test@mov.com", "descricao...", 250.75f, Date.valueOf("1990-02-01"), "Tipo1", "Categoria1");
        boolean result = dao.salvar(mov);
        assertTrue(result);
    }
    
    @Test
    public void testSalvar_CT02() {
        System.out.println("salvar - CT02");
        Movimentacao mov = new Movimentacao(-1, null, "descricao...", 250.75f, Date.valueOf("1990-02-01"), "Tipo1", "Categoria1");
        boolean result = dao.salvar(mov);
        assertFalse(result);
    }

    @Test
    public void testBuscar_CT01() {
        System.out.println("buscar - CT01");
        int cod = dao.getLastID();
        Movimentacao mov = new Movimentacao(cod, "test@mov.com", "descricao...", 250.75f, Date.valueOf("1990-02-01"), "Tipo1", "Categoria1");
        dao.salvar(mov);
        Movimentacao result = dao.buscar(cod);
        assertEquals(mov, result);
    }
    
    @Test
    public void testBuscar_CT02() {
        System.out.println("buscar - CT02");
       
        Movimentacao result = dao.buscar(-1);
        assertNull(result);
    }
    
    @Test
    public void testAtualizar_CT01() {
        System.out.println("atualizar - CT01");
        int cod = dao.getLastID();
        Movimentacao mov = new Movimentacao(cod, "test@mov.com", "descricao...", 250.75f, Date.valueOf("1990-02-01"), "Tipo1", "Categoria1");
        dao.salvar(mov);
        
        Movimentacao novaMov = new Movimentacao(cod, "test@mov.com", "Nova movimentacao...", 250.75f, Date.valueOf("1990-02-01"), "Tipo1", "Categoria1");
        boolean result = dao.atualizar(cod, novaMov);
        assertTrue(result);
    }
    
    @Test
    public void testAtualizar_CT02() {
        System.out.println("atualizar - CT02");
        
        int cod = dao.getLastID();
        Movimentacao mov = new Movimentacao(cod, "test@mov.com", "descricao...", 250.75f, Date.valueOf("1990-02-01"), "Tipo1", "Categoria1");
        dao.salvar(mov);
        
        Movimentacao novaMov = new Movimentacao(cod, "test@mov.com", "Nova movimentacao...", 250.75f, Date.valueOf("1990-02-01"), "Tipo1", "Categoria1");
        dao.atualizar(cod, novaMov);
        Movimentacao result = dao.buscar(cod);
        assertEquals(novaMov, result);
    }
    
    @Test
    public void testRemover_CT01() {
        System.out.println("remover - CT01");
        
        int cod = dao.getLastID();
        Movimentacao mov = new Movimentacao(cod, "test@mov.com", "descricao...", 250.75f, Date.valueOf("1990-02-01"), "Tipo1", "Categoria1");
        dao.salvar(mov);
        
        boolean resultA = dao.remover(cod);
        boolean resultB = (dao.buscar(cod) == null);
        assertTrue(resultA && resultB);
    }
    
    @Test
    public void testRemover_CT02() {
        System.out.println("remover - CT02");
        
        int cod = dao.getLastID();        
        boolean result = dao.remover(cod+1);
        assertFalse(result);
    }
    
}
