//*************************************************************************************//
//  NAME: Javier Ortiz Cortez                                                          //
//  CLASS: CSC416                                                                      //
//  ASSIGNMENT: Assignment 1                                                           //
//  FILENAME: PrintStm                                                                 //
//  DATE: September 17, 2013                                                           //
//  DESCRIOTION: This class defines a PrintStm object                                  //
//*************************************************************************************//
package slpinterpreter;

/**
 *
 * @author estudiante
 */
public class PrintStm extends Stm 
{
    public ExpList exps;
    public PrintStm(ExpList e)
    {
        exps = e;
    }
}
