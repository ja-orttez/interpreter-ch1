/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slpinterpreter;

/**
 *
 * @author estudiante
 */
public class PairExpList extends ExpList 
{
    public Exp head;
    public ExpList tail;
    public PairExpList(Exp h, ExpList t)
    {
        head = h;
        tail = t;
    }
}
