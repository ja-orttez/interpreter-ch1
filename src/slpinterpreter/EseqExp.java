//*************************************************************************************//
//  NAME: Javier Ortiz Cortez                                                          //
//  CLASS: CSC416                                                                      //
//  ASSIGNMENT: Assignment 1                                                           //
//  FILENAME: PairExpList                                                              //
//  DATE: September 17, 2013                                                           //
//  DESCRIOTION: This class defines an EseqExp object                                  //
//*************************************************************************************//
package slpinterpreter;

/**
 *
 * @author Javier
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
