//*************************************************************************************//
//  NAME: Javier Ortiz Cortez                                                          //
//  CLASS: CSC416                                                                      //
//  ASSIGNMENT: Assignment 1                                                           //
//  FILENAME: AssignStm                                                                //
//  DATE: September 17, 2013                                                           //
//  DESCRIOTION: This class defines an AssignStm object                                //
//*************************************************************************************//
package slpinterpreter;

/**
 *
 * @author Javier
 */
public class AssignStm extends Stm
{
    public String id;
    public Exp exp;
    public AssignStm(String i, Exp e)
    {
        id = i;
        exp = e;
    }
}
