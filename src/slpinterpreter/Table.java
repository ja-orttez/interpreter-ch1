/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slpinterpreter;

/**
 *
 * @author estudiante
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