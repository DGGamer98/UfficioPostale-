/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import it.tutor.up.ErrorType;
import it.tutor.up.Person;
import it.tutor.up.PostalOffice;
import it.tutor.up.ServiziType;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author loren
 */
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class UfficioPostaleTest {

    private String message;
    boolean ok = false;

    public static final String INVALID = "INVALID";

    public UfficioPostaleTest() {
    }
    
    
    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
        System.out.println(message + (ok ? " SUCCESS" : " FAILED"));
    }

    @Test
    public void test38() {
        Person p1 = new Person(null, null, "39 123942983", "P1-1");
        String name1 = p1.getName();
        String surname1 = p1.getSurname();
        assertEquals(INVALID, name1, "Ho messo il nome nullo e mi aspettavo invalido");
        assertEquals(INVALID, surname1, "Ho messo il cognome nullo e mi aspettavo invalido");

        Person p2 = new Person("", "", "39 123942983", "P1-1");
        String name2 = p2.getName();
        String surname2 = p2.getSurname();
        assertEquals(INVALID, name2, "Ho messo il nome vuoto e mi aspettavo invalido");
        assertEquals(INVALID, surname2, "Ho messo il cognome vuoto e mi aspettavo invalido");

        Person p3 = new Person("luca", "rossi", "39 123942983", "P1-1");
        String name3 = p3.getName();
        String surname3 = p3.getSurname();
        assertEquals(INVALID, name3, "Ho messo il nome con la minuscola  e mi aspettavo invalido");
        assertEquals(INVALID, surname3, "Ho messo il cognome con la minuscola e mi aspettavo invalido");

        Person p4 = new Person("Luca", "Rossi", "39 123942983", "P1-1");
        String name4 = p4.getName();
        String surname4 = p4.getSurname();
        assertEquals("Luca", name4, "Ho messo il nome corretto  e non mi aspettavo invalido");
        assertEquals("Rossi", surname4, "Ho messo il cognome corretto  e non mi aspettavo invalido");
        
        Person p5 = new Person("luca5", "rossi5", "39 123942983", "P1-1");
        String name5 = p5.getName();
        String surname5 = p5.getSurname();
        assertEquals("Luca5", name5);
        assertEquals("rossi5",surname5);
        
         Person p6 = new Person("luca6", "rossi6", "39 123942983", "P1-1");
        String name6 = p6.getName();
        String surname6 = p6.getSurname();
        assertEquals("Luca6", name6);
        assertEquals("rossi6",surname6);
        
        
        

    }
    @Test 
    @DisplayName("Test numeri di telefono")
    public void test39(TestInfo info) {
       message = info.getDisplayName();
       Person n1 = PostalOffice.getInstance().createPerson("Gianni","Giannini","3441879885", ServiziType.PAGAMENTI);
       Person n2 = PostalOffice.getInstance().createPerson("Paolo","Paoletti","3441879456", ServiziType.PAGAMENTI);
       Person n3 = PostalOffice.getInstance().createPerson("Gianni","Giannini","3441879392093584", ServiziType.PAGAMENTI);
       assertEquals(ErrorType.NO_ERROR, PostalOffice.getInstance().validateFields(n1.getName(),n1.getSurname(),n1.getPhonenumber()),"Mi aspettavo un numero di telefono corretto 3441879885");
       assertEquals(ErrorType.TELEPHONE_INVALID, PostalOffice.getInstance().validateFields(n3.getName(),n3.getSurname(),n3.getPhonenumber()),"Mi aspettavo un numero di telefono corretto 3441879885");


    }

    @Test
    public void test40a() {
       
       String code = PostalOffice.getInstance().generateCode(ServiziType.PAGAMENTI);
       assertEquals(true,PostalOffice.getInstance().validateCode(code),"Ho passato un codice e mi aspettavo true");
    }
    
    @Test
    public void test40b() {
       
       String code = PostalOffice.getInstance().generateCode(ServiziType.SPEDIZIONI);
       assertEquals(true,PostalOffice.getInstance().validateCode(code),"Ho passato un codice e mi aspettavo true");
    }
    
    @Test
    public void test40c() {
       
       String code = PostalOffice.getInstance().generateCode(ServiziType.FINANZIARI);
       assertEquals(true,PostalOffice.getInstance().validateCode(code),"Ho passato un codice e mi aspettavo true");
    }

    @Test
    public void test41() {
        PostalOffice.getInstance().reset();
        assertEquals(0,PostalOffice.getInstance().getSportello1().size(),"Ho resettato e mi aspettavo 0");
        assertEquals(0,PostalOffice.getInstance().getSportello2().size(),"Ho resettato e mi aspettavo 0");
        assertEquals(0,PostalOffice.getInstance().getSportello3().size(),"Ho resettato e mi aspettavo 0");
        assertEquals(0,PostalOffice.getInstance().getSportello4().size(),"Ho resettato e mi aspettavo 0");
        assertEquals(0,PostalOffice.getInstance().giveId(),"Ho resettato e mi aspettavo 0");
    }

    @Test
    public void test42() {

        Float result1 = PostalOffice.getInstance().getWaitingTime(null);
        assertNull(result1, "Ho passato argomento null e mi dovrebbe ritonare null");

        Float result2 = PostalOffice.getInstance().getWaitingTime(new LinkedList<>());
        assertEquals(0f, result2, "Ho passato una lista vuota e mi dovrebbe ritornare 0");
        
        Person f1 = new Person("Mario", "Marini", "39 123647983", "F1-4");
        Person f2 = new Person("Luca", "Luchini", "39 123942983", "F4-7");
        Person f3 = new Person("Sofia", "Sofini", "39 102647983", "F2-1");
        
        List<Person> listaF = new LinkedList<Person>();
        listaF.add(f1);
        listaF.add(f2);
        listaF.add(f3);
        
        Float result3 = PostalOffice.getInstance().getWaitingTime(listaF);
        assertEquals(90.0f, result3, "Ho passato tre prenotazioni valide di tipo F e mi aspttavo 90.0");
        
        Person p1 = new Person("Mario", "Marini", "39 123647983", "P1-4");
        Person p2 = new Person("Luca", "Luchini", "39 123942983", "P4-7");
        Person p3 = new Person("Sofia", "Sofini", "39 102647983", "P2-1");
        
        List<Person> listaP = new LinkedList<Person>();
        listaP.add(p1);
        listaP.add(p2);
        listaP.add(p3);
        
        Float result4 = PostalOffice.getInstance().getWaitingTime(listaP);
        assertEquals(30.0f, result4, "Ho passato tre prenotazioni valide di tipo P e mi aspttavo 30.0");
        
        Person s1 = new Person("Mario", "Marini", "39 123647983", "S1-4");
        Person s2 = new Person("Luca", "Luchini", "39 123942983", "S4-7");
        Person s3 = new Person("Sofia", "Sofini", "39 102647983", "S2-1");
        
        List<Person> listaS = new LinkedList<Person>();
        listaS.add(s1);
        listaS.add(s2);
        listaS.add(s3);
        
         Float result5 = PostalOffice.getInstance().getWaitingTime(listaS);
        assertEquals(22.5f, result5, "Ho passato tre prenotazioni valide di tipo S e mi aspttavo 22.5");
        
        
    }

    @Test
    @DisplayName("[isNumberExisting] Create person x3")
    public void test43(TestInfo info) {
        message = info.getDisplayName();
        Person p1 = PostalOffice.getInstance().createPerson("Mario", "Rossi", "3334444333", ServiziType.PAGAMENTI);
        Person p2 = PostalOffice.getInstance().createPerson("Chiara", "Marchetti", "2223333444", ServiziType.PAGAMENTI);
        Person p3 = PostalOffice.getInstance().createPerson("Marco", "Chiaretti", "3334444555", ServiziType.PAGAMENTI);
        PostalOffice.getInstance().getSportello1().add(p1);
        PostalOffice.getInstance().getSportello2().add(p2);
        PostalOffice.getInstance().getSportello3().add(p3);
        assertTrue(PostalOffice.getInstance().isNumberExisting("3334444333"), "Ho inserito un numero già esistente e non è stato rilevato l'errore");
        assertTrue(PostalOffice.getInstance().isNumberExisting("3334444555"), "Ho inserito un numero già esistente e non è stato rilevato l'errore");
        assertFalse(PostalOffice.getInstance().isNumberExisting("2226666333"), "Ho inserito un numero non inserito e ha rilevato errore");
        ok = true;
        //Assumptions.assumeT
    }

    @Test
    public void test44() {

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
