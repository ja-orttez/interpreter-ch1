//*************************************************************************************//
//  NAME: Javier Ortiz Cortez                                                          //
//  CLASS: CSC416                                                                      //
//  ASSIGNMENT: Assignment 1                                                           //
//  FILENAME: OpExp                                                                    //
//  DATE: September 17, 2013                                                           //
//  DESCRIOTION: This class defines an OpExp object                                    //
//*************************************************************************************//
package slpinterpreter;

/**
 *
 * @author Javier
 */
public class OpExp extends Exp 
{
    public Exp left, right;
    public int oper;
    final public static int Plus=1, Minus=2, Time=3, Div=4;
    public OpExp(Exp l, int o, Exp r)
    {
        left = l;
        oper = o;
        right = r;
    }
}
