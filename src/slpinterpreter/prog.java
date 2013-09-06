/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slpinterpreter;

/**
 *
 * @author estudiante
 */
public class prog 
{
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
}
