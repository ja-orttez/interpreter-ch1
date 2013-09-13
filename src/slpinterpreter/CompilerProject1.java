//*************************************************************************************//
//  NAME: Javier Ortiz Cortez                                                          //
//  CLASS: CSC416                                                                      //
//  ASSIGNMENT: Assignment 1                                                           //
//  FILENAME: CompilerProject1                                                         //
//  DATE: September 17, 2013                                                           //
//  DESCRIOTION: The following program utilizes several other classes for creating an  //
//      Interpreter of a simple language.                                              //
//*************************************************************************************//

package slpinterpreter;

import java.lang.Math;
/**
 *
 * @author Javier
 */
public class CompilerProject1 {

    /**
     * interp() method calls helper methods in order to interpret an Stm object
     * @param s The Stm object to be interpreted
     */
    public static void interp(Stm s)
    {
        interpStm(s,null);//interpretation
    }
    
    /**
     * interpStm() method is one of interp()'s helper methods which interprets Stm objects
     * @param s The object to be interpreted
     * @param t The Table object where elements will be stored for interpretation
     * @return A table containing the wanted string, int, and table object
     */
    private static Table interpStm(Stm s, Table t){
        if(s instanceof CompoundStm)
            return interpStm(((CompoundStm)s).stm2,interpStm(((CompoundStm)s).stm1,t));
        else if(s instanceof AssignStm)
        {
            IntAndTable it = interExp(((AssignStm)s).exp,t);
            return new Table(((AssignStm)s).id,it.i,it.t);
        }
        else// if(s instanceof PrintStm)
            return interPrint(((PrintStm)s).exps,t);
    }
    
    /**
     * interpExp() is one of interp()'s helper methods for interpreting Exp objects
     * @param e The Exp object to be identified
     * @param t The linked list to be updated
     * @return An object containing an int and a Table
     */
    private static IntAndTable interExp(Exp e, Table t)
    {
        if(e instanceof IdExp)
        {
            //System.out.println(t.lookup(((IdExp)e).id));
            return new IntAndTable(t.lookup(((IdExp)e).id),t); //
        }
        else if(e instanceof NumExp)
            return new IntAndTable(((NumExp)e).num,t);
        else if(e instanceof OpExp)
        {
            IntAndTable iat1 = interExp(((OpExp)e).left,t);
            IntAndTable iat2 = interExp(((OpExp)e).right,t);
            int total;
            if(((OpExp)e).oper == 1)
                total = iat1.i+iat2.i;
            else if(((OpExp)e).oper == 2)
                total = iat1.i-iat2.i;
            else if(((OpExp)e).oper == 3)
                total = iat1.i*iat2.i;
            else// if(((OpExp)e).oper == 4)
                total = iat1.i/iat2.i;
            return new IntAndTable(total,t);
        }
        else// if(e instanceof EseqExp)
            return interExp(((EseqExp)e).exp,interpStm(((EseqExp)e).stm,t));
    }
    
    /**
     * interpPrint() displays the values inside any PrintStm()
     * @param el The objects to be interpreted
     * @param t The linked list with the wanted elements
     * @return The table with the desired elements
     */
    private static Table interPrint(ExpList el, Table t)
    {
        if(el instanceof PairExpList)
        {
            IntAndTable iat = interExp(((PairExpList)el).head,t);
            System.out.print(iat.i + " ");
            return interPrint(((PairExpList)el).tail,t);
        }
        else//if(el instanceof LastExpList)
        {
            IntAndTable iat1 = interExp(((LastExpList)el).head,t);
            System.out.println(iat1.i + " ");
            return iat1.t;
        }
    }
    
    /**
     * maxargs() counts the maximum number of elements printed by a printStm()
     * @param s The Stm object that could possibly be the desired PrintStm
     * @return The maximum number elements within a PrintStm
     */
    static int maxargs(Stm s)
    {
        if(s instanceof CompoundStm)
            return Math.max(maxargs(((CompoundStm)s).stm1),maxargs(((CompoundStm)s).stm2));
        else if(s instanceof AssignStm)
            return maxargs(((AssignStm)s).exp);
        else// if(s instanceof PrintStm)//stm vs exp
            return Math.max(count(((PrintStm)s).exps),maxargs(((PrintStm)s).exps));
    }
    
    /**
     * maxargs() is a helper method that takes an Exp object for counting printed elements
     * @param e The Exp object to be analyzed
     * @return the number of elements that are printed
     */
    private static int maxargs(Exp e)
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
    
    /**
     * This maxargs() handles ExpList object in the counting of printed elements
     * @param el The ExpList object to be analyzed
     * @return The total number of elements printed
     */
    private static int maxargs(ExpList el)
    {
        if(el instanceof PairExpList)
            return Math.max(maxargs(((PairExpList)el).head), maxargs(((PairExpList)el).tail));
        else// if(el instanceof LastExpList)
            return maxargs(((LastExpList)el).head);
    }
    
    /**
     * count() returns the total number of elements printed
     * @param el The counted elements
     * @return The larger number of elements displayed by a PrintStm()
     */
    private static int count(ExpList el)
    {
        if(el instanceof PairExpList)
            return 1+count(((PairExpList)el).tail);
        else//if(el instanceof LastExpList)
            return 1;
    }

    /**main()
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // testing maxargs() and interp()
        dashline();
        System.out.println(maxargs(prog.prog));
        dashline();
        interp(prog.prog);
        dashline();
        System.out.println(maxargs(prog.progA));
        dashline();
        interp(prog.progA);
        dashline();
        System.out.println(maxargs(prog.progB));
        dashline();
        interp(prog.progB);
        dashline();
        System.out.println(maxargs(prog.progC));
        dashline();
        interp(prog.progC);
        dashline();
        System.out.println(maxargs(prog.progD));
        dashline();
        interp(prog.progD);
        dashline();
    }
    
    /**
     * dashline() simply displays a dotted line
     */
    public static void dashline()
    {
        System.out.println("---------------------");
    }
}
