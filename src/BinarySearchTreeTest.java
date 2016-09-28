/*
Algoritmos y Estructuras de Datos
Hoja de trabajo 7

Integrantes:
Alejandro Chaclan 15018
Jose Javier Jo 14343

Esta clase realiza las pruebas JUnit de los metodos de agregar y buscar en el arbol binario.
*/

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DiccionarioAssociationTreeTest {

    public DiccionarioAssociationTreeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /*
    Se prueba una entrada que este y otra que no este.
    */

    @Test
    public void testSearchInOrder() {
        System.out.println("SerchInOder");
        Diccionario instance = new DiccionarioAssociationTree();
        //Se agrega una entrada y se busca para comprobar
        Association<String, String> data1 = new Association ("yes", "si");
        instance.add(instance, data1);
        boolean expResult1 = "si";
        boolean result1 = instance.searchInOrder("yes");
        //Se busca una entrada que no existe en el arbol
        Association<String, String> data2 = new Association("no","no");
        boolean expResult2 = "";
        boolean result2 = instance.searchInOrder("no");
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
    }



    /**
    Se agrega una entrada y se busca para comprobar que si se añadio
    */
    @Test
    public void testAdd() {
        System.out.println("Add");
        Diccionario instance = new DiccionarioAssociationTree();
        Association<String, String> data1 = new Association ("yes", "si");
        instance.add(instance, data1);
        boolean expResult1 = "si";
        boolean result1 = instance.searchInOrder("yes");
        assertEquals(expResult, result);
    }

}
