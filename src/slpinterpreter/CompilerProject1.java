/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slpinterpreter;

import java.lang.Math;
/**
 *
 * @author estudiante
 */
public class CompilerProject1 {

    /* interp() */
    public static void interp(Stm s)
    {
        
    }
    
    static int maxargs(Stm s)
    {
        if(s instanceof CompoundStm)
            return Math.max(maxargs(((CompoundStm)s).stm1),maxargs(((CompoundStm)s).stm2));
        else if(s instanceof AssignStm)
            return maxargs(((AssignStm)s).exp);
        else
            return count(((PrintStm)s).exps);
    }
    
    static int maxargs(Exp e)
    {
        if(e instanceof IdExp)
            return 0;
        else if(e instanceof NumExp)
            return 0;
        else if(e instanceof OpExp)
            return Math.max(maxargs(((OpExp)e).left), maxargs(((OpExp)e).right));
        else// if(e instanceof EseqExp)
            return Math.max(maxargs(((EseqExp)e).stm),maxargs(((EseqExp)e).exp));
    }
    
    static int maxargs(ExpList el)
    {
        if(el instanceof PairExpList)
            return Math.max(maxargs(((PairExpList)el).head), maxargs(((PairExpList)el).tail));
        else// if(el instanceof LastExpList)
            return maxargs(((LastExpList)el).head);
    }
    
    //need to account for printStm inside
    static int count(ExpList el)
    {
        if(el instanceof PairExpList)
            return 1+count(((PairExpList)el).tail);
        else//if(el instanceof LastExpList)
            return 1;
    }
    //public static void CompilerProject1(Stm)
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(maxargs(prog.prog));
    }
}
