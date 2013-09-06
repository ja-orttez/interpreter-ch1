/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slpinterpreter;

/**
 *
 * @author estudiante
 */
public class OpExp extends Exp 
{
    public Exp left, right;
    public int oper;
    final public static int Plus=1, Minus = 2, Time = 3, Div = 4;
    public OpExp(Exp l, int o, Exp r)
    {
        left = l;
        oper = o;
        right = r;
    }
}
