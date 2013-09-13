//*************************************************************************************//
//  NAME: Javier Ortiz Cortez                                                          //
//  CLASS: CSC416                                                                      //
//  ASSIGNMENT: Assignment 1                                                           //
//  FILENAME: CompoundStm                                                              //
//  DATE: September 17, 2013                                                           //
//  DESCRIOTION: This class defines a CompoundStm object                               //
//*************************************************************************************//
package slpinterpreter;

/**
 *
 * @author Javier
 */
class CompoundStm extends Stm {
    public Stm stm1, stm2;
    public CompoundStm(Stm s1, Stm s2)
    {
        stm1 = s1;
        stm2 = s2;
    }
}
