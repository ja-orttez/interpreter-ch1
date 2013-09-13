//*************************************************************************************//
//  NAME: Javier Ortiz Cortez                                                          //
//  CLASS: CSC416                                                                      //
//  ASSIGNMENT: Assignment 1                                                           //
//  FILENAME: Table                                                                    //
//  DATE: September 17, 2013                                                           //
//  DESCRIOTION: The following program defines a singly linked list containing a       //
//      String, an int, and an object like itself                                      //
//*************************************************************************************//
package slpinterpreter;

/**
 *
 * @author Javier
 */
public class Table {
    String id;
    int value;
    Table tail;
    
    Table(String i, int v, Table t)
    {
        id=i;
        value=v;
        tail=t;
    }
    int lookup(String key)
    {
        if(key.equals(id))
            return value;
        else
            return tail.lookup(key); //keep searching recursively
    }
}