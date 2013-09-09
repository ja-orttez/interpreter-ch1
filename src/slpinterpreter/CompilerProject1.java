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
    
    class Table{
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
            return 0;
        }
    }
        
    Table interpStm(Stm s, Table t){
        if(s instanceof CompoundStm)
            return Math.max(maxargs(((CompoundStm)s).stm1),maxargs(((CompoundStm)s).stm2));
        else if(s instanceof AssignStm)
            return maxargs(((AssignStm)s).exp);
        else if(s instanceof PrintStm)
            return count(((PrintStm)s).exps);
        return 0;
    }
    
    class IntAndTable{int i; Table t;
        IntAndTable(int ii, Table tt) {i=ii; t=tt;}}
    
    IntAndTable interExp(Exp e, Table t)
    {
        return null;
    }
    
    static int maxargs(Stm s)
    {
        if(s instanceof CompoundStm)
            return Math.max(maxargs(((CompoundStm)s).stm1),maxargs(((CompoundStm)s).stm2));
        else if(s instanceof AssignStm)
            return maxargs(((AssignStm)s).exp);
        else if(s instanceof PrintStm)
            return count(((PrintStm)s).exps);
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
