//*************************************************************************************//
//  NAME: Javier Ortiz Cortez                                                          //
//  CLASS: CSC416                                                                      //
//  ASSIGNMENT: Assignment 1                                                           //
//  FILENAME: PairExpList                                                              //
//  DATE: September 17, 2013                                                           //
//  DESCRIOTION: This class defines a PairExpList object                               //
//*************************************************************************************//
package slpinterpreter;

/**
 *
 * @author Javier
 */
public class PairExpList extends ExpList 
{
    public Exp head;
    public ExpList tail;
    public PairExpList(Exp h, ExpList t)
    {
        head = h;
        tail = t;
    }
}
