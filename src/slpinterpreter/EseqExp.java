/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slpinterpreter;

/**
 *
 * @author estudiante
 */
public class EseqExp extends Exp 
{
    public Stm stm;
    public Exp exp;
    public EseqExp(Stm s, Exp e)
    {
        stm = s;
        exp = e;
    }
}
