package moneywise.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import moneywise.modelo.Movimentacao;
import moneywise.modelo.Usuario;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoDaoTest {

    MovimentacaoDao dao;

    @BeforeClass
    public static void addUserTest() {
        UsuarioDao uDao;
        try {
            uDao = new UsuarioDao();
            Usuario user = new Usuario("test@mov.com", "senha", "nome", "m", Date.valueOf("1999-01-01"));
            uDao.salvar(user);
        } catch (Exception ex) {
            Logger.getLogger(MovimentacaoDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Before
    public void setUpBefore() {
        try {
            dao = new MovimentacaoDao();
        } catch (Exception ex) {
            Logger.getLogger(MovimentacaoDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void test01GetLastID_CT01() {
        System.out.println("getLastID() - CT01");
        Movimentacao mov = new Movimentacao(1, "test@mov.com", "descricao...", 250.75f, Date.valueOf("1990-02-01"), "Tipo1", "Categoria1");
        int result = dao.getLastID();
        dao.salvar(mov);
        assertEquals(mov.getCod(), result);
    }

    @Test
    public void test02Salvar_CT01() {
        System.out.println("salvar - CT01");
        Movimentacao mov = new Movimentacao(-1, "test@mov.com", "descricao...", 250.75f, Date.valueOf("1990-02-01"), "Tipo1", "Categoria1");
        boolean result = dao.salvar(mov);
        assertTrue(result);
    }

    @Test
    public void test03Salvar_CT02() {
        System.out.println("salvar - CT02");
        Movimentacao mov = new Movimentacao(-1, null, "descricao...", 250.75f, Date.valueOf("1990-02-01"), "Tipo1", "Categoria1");
        boolean result = dao.salvar(mov);
        assertFalse(result);
    }

    @Test
    public void test04Buscar_CT01() {
        System.out.println("buscar - CT01");
        int cod = dao.getLastID();
        Movimentacao mov = new Movimentacao(cod, "test@mov.com", "descricao...", 250.75f, Date.valueOf("1990-02-01"), "Tipo1", "Categoria1");
        dao.salvar(mov);
        Movimentacao result = dao.buscar(cod);
        assertEquals(mov, result);
    }

    @Test
    public void test05Buscar_CT02() {
        System.out.println("buscar - CT02");

        Movimentacao result = dao.buscar(-1);
        assertNull(result);
    }

    @Test
    public void test06Atualizar_CT01() {
        System.out.println("atualizar - CT01");
        int cod = dao.getLastID();
        Movimentacao mov = new Movimentacao(cod, "test@mov.com", "descricao...", 250.75f, Date.valueOf("1990-02-01"), "Tipo1", "Categoria1");
        dao.salvar(mov);

        Movimentacao novaMov = new Movimentacao(cod, "test@mov.com", "Nova movimentacao...", 250.75f, Date.valueOf("1990-02-01"), "Tipo1", "Categoria1");
        boolean result = dao.atualizar(cod, novaMov);
        assertTrue(result);
    }

    @Test
    public void test07Atualizar_CT02() {
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
    public void test08Remover_CT01() {
        System.out.println("remover - CT01");

        int cod = dao.getLastID();
        Movimentacao mov = new Movimentacao(cod, "test@mov.com", "descricao...", 250.75f, Date.valueOf("1990-02-01"), "Tipo1", "Categoria1");
        dao.salvar(mov);

        boolean resultA = dao.remover(cod);
        boolean resultB = (dao.buscar(cod) == null);
        assertTrue(resultA && resultB);
    }

    @AfterClass
    public static void fecharConexao(){
        UsuarioDao uDao;
        try {
            uDao = new UsuarioDao();
            if(uDao.buscar("test@mov.com")!=null){
                uDao.remover("test@mov.com");
            }
        } catch (Exception ex) {
            Logger.getLogger(MovimentacaoDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
