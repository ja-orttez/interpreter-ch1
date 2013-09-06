/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slpinterpreter;

/**
 *
 * @author estudiante
 */
public class AssignStm extends Stm
{
    public String id;
    public Exp exp;
    public AssignStm(String i, Exp e)
    {
        id = i;
        exp = e;
    }
}
