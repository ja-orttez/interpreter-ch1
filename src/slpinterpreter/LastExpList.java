//*************************************************************************************//
//  NAME: Javier Ortiz Cortez                                                          //
//  CLASS: CSC416                                                                      //
//  ASSIGNMENT: Assignment 1                                                           //
//  FILENAME: LastExpList                                                              //
//  DATE: September 17, 2013                                                           //
//  DESCRIOTION: This class defines a LastExpList object                               //
//*************************************************************************************//
package slpinterpreter;

/**
 *
 * @author Javier
 */
public class LastExpList extends ExpList
{
    public Exp head;
    public LastExpList(Exp h)
    {
        head = h;
    }
}
