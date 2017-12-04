package org.urjc.isi.travis;

//Introduction to Software Testing
//Authors: Paul Ammann & Jeff Offutt
//Chapter 3; page ??
//See MinTest.java for JUnit tests.
//See DataDrivenMinTest.java for JUnit tests. (Instructor only)

import java.util.*;

public class App
{
/**
 * Returns the mininum element in a list
 * @param list Comparable list of elements to search
 * @return the minimum element in the list
 * @throws NullPointerException if list is null or
 *         if any list elements are null
 * @throws ClassCastException if list elements are not mutually comparable
 * @throws IllegalArgumentException if list is empty
 */
 public static <T extends Comparable<? super T>> T min (List<? extends T> list)
 //@param Lista de T, que puede ser T o cualquier cosa que hereda de T
 {
    if (list.size() == 0)
    {
       throw new IllegalArgumentException ("Min.min");
    }else if(list.size() == 1){
      Iterator<? extends T> itr = list.iterator();
      T result = itr.next();
      if( result == null){
        throw new NullPointerException("Min.min");
      }else{
        return result;
      }
    }

    Iterator<? extends T> itr = list.iterator();
    T result = itr.next();


    while (itr.hasNext())
    {   // throws NPE, CCE as needed
        T comp = itr.next();
        if (comp.compareTo (result) < 0)
        {
            result = comp;
        }
    }
    return result;
 }
}