package org.urjc.isi.travis;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class AppTest
{
   private List<String> list;   // Test fixture, o banco de pruebas

   @Before      // Set up - Called before every test method.
   public void setUp()
   {
      list = new ArrayList<String>(); //Se ejecuta antes del test
   }

   @After      // Tear down - Called after every test method.
   public void tearDown()
   {
      list = null;  // redundant in this example!, despues de cada test, se ejecuta este metodo,cosa que es redundante
      //ya que cada vez que se vaya a ejecturar un test, se ejecuta before que creara una nueva lista, que ya sera null
   }

   @Test
   public void testForNullList()
   //Aqui intentamos testar que se va a elevar una excepcion
   {
      list = null;
      try {
         App.min (list);
      } catch (NullPointerException e) {
         return;
      }
      fail ("NullPointerException expected");
   }

   @Test (expected = NullPointerException.class)
   public void testForNullElement()
   {
      list.add (null);
      list.add ("cat");
      App.min (list);
   }

   @Test (expected = NullPointerException.class)
   public void testForSoloNullElement()
   {
      list.add (null);
      App.min (list);
   }

   @Test (expected = ClassCastException.class)
   @SuppressWarnings ("unchecked")
   public void testMutuallyIncomparable()
   {
      List list = new ArrayList();
      list.add ("cat");
      list.add ("dog");
      list.add (1);
      App.min (list);
   }

   @Test (expected = IllegalArgumentException.class)
   public void testEmptyList()
   {
      App.min (list);
   }

   @Test
   public void testSingleElement()
   {
      list.add ("cat");
      Object obj = App.min (list);
      assertTrue ("Single Element List", obj.equals ("cat"));
   }

   @Test
   public void testDoubleElement()
   {
      list.add ("dog");
      list.add ("cat");
      Object obj = App.min (list);
      assertTrue ("Double Element List", obj.equals ("cat"));
   }
}