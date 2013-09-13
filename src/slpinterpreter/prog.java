//*************************************************************************************//
//  NAME: Javier Ortiz Cortez                                                          //
//  CLASS: CSC416                                                                      //
//  ASSIGNMENT: Assignment 1                                                           //
//  FILENAME: Exp                                                                      //
//  DATE: September 17, 2013                                                           //
//  DESCRIOTION: This program creates Stm objects as well as other corresponding       //
//      objects for the single line language to be interpreted in the main method      //
//*************************************************************************************//
package slpinterpreter;

/**
 *
 * @author Javier
 */
public class prog 
{
    // a:=5+3;b:=(print(a,a-1), 10*a);print(b)
    static Stm prog =
            new CompoundStm(new AssignStm("a",
            new OpExp(new NumExp(5),OpExp.Plus,
            new NumExp(3))),
            new CompoundStm(new AssignStm("b",
            new EseqExp(new PrintStm(new PairExpList(new IdExp("a"),
            new LastExpList(new OpExp(new IdExp("a"),OpExp.Minus,
            new NumExp(1))))),
            
            new OpExp(new NumExp(10), OpExp.Time, new IdExp("a")))),
            new PrintStm(new LastExpList(new IdExp("b")))));
    
    // a:=18
    static Stm progA =
            new AssignStm("a", new NumExp(18));
    
    // print(28)
    static Stm progB =
            new PrintStm(new LastExpList(new NumExp(28)));
    
    // a := 7 + 2; print(a)
    static Stm progC =
            new CompoundStm(new AssignStm("a",
            new OpExp(new NumExp(7), OpExp.Plus, new NumExp(2))),
            new PrintStm(new LastExpList(new IdExp("a"))));
    
    // b:=(print(10,9,8,c:=(print(11,10,9,8,7),6),5),3)
    static Stm progD =
            new AssignStm("b", new EseqExp(
            new PrintStm(new PairExpList(new NumExp(10),
            new PairExpList(new NumExp(9),
            new PairExpList(new NumExp(8),
            new LastExpList(new EseqExp(
            new AssignStm("c", new EseqExp(new PrintStm(
            new PairExpList(new NumExp(11),
            new PairExpList(new NumExp(10),
            new PairExpList(new NumExp(9),
            new PairExpList(new NumExp(8),
            new LastExpList(new NumExp(7))))))),
            new NumExp(6))),new NumExp(5))))))),
            new NumExp(3)));
}
