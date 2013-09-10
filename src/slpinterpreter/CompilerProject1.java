/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slpinterpreter;

import java.lang.Math;
/**
 *
 * @author Javier
 */
public class CompilerProject1 {

    /* interp() */
    public static void interp(Stm s)
    {
        //interpretation
    }
    
        
    Table interpStm(Stm s, Table t){
        if(s instanceof CompoundStm)
            return interpStm(((CompoundStm)s).stm1,interpStm(((CompoundStm)s).stm2,t));
        else if(s instanceof AssignStm)
        {
            IntAndTable it = new interExp(((AssignStm)s).exp,t);
            return new Table(((AssignStm)s).id,it.i,it.t);
        }
        else if(s instanceof PrintStm)
            return interpStm(((PrintStm)s).exps);
        return 0;
    }
    
    
    IntAndTable interExp(Exp e, Table t)
    {
        if(e instanceof IdExp)
            return new IntAndTable(t.lookup(((IdExp)e).id),t); //
        else if(e instanceof NumExp)
            return new IntAndTable(((NumExp)e).num,t);
        else if(e instanceof OpExp)
            return interExp(maxargs(((OpExp)e).left), interExp(((OpExp)e).right));
        else if(e instanceof EseqExp)
            return interExp((((EseqExp)e).stm),interExp(((EseqExp)e).exp));
        else
            return 0;
    }
    
    static int maxargs(Stm s)
    {
        if(s instanceof CompoundStm)
            return Math.max(maxargs(((CompoundStm)s).stm1),maxargs(((CompoundStm)s).stm2));
        else if(s instanceof AssignStm)
            return maxargs(((AssignStm)s).exp);
        else if(s instanceof PrintStm)//stm vs exp
            return Math.max(count(((PrintStm)s).exps),maxargs(((PrintStm)s).exps));
        else
            return 0;
    }
    
    static int maxargs(Exp e)
    {
        if(e instanceof IdExp)
            return 0;
        else if(e instanceof NumExp)
            return 0;
        else if(e instanceof OpExp)
            return Math.max(maxargs(((OpExp)e).left), maxargs(((OpExp)e).right));
        else if(e instanceof EseqExp)
            return Math.max(maxargs(((EseqExp)e).stm),maxargs(((EseqExp)e).exp));
        else
            return 0;
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
        System.out.println(maxargs(prog.progA));
        System.out.println(maxargs(prog.progB));
        System.out.println(maxargs(prog.progC));
        System.out.println(maxargs(prog.progD)); //Not working right
    }
}
