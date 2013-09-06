/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slpinterpreter;

/**
 *
 * @author estudiante
 */
public class PrintStm extends Stm 
{
    public ExpList exps;
    public PrintStm(ExpList e)
    {
        exps = e;
    }
}
