/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package errors;

/**
 *
 * @author estudiante
 */
public class ErrorMsg{
        private boolean anyErrors;
        public ErrorMsg(){
            anyErrors = false;
        }
        public void complain(String msg){
            anyErrors = true;
            System.out.println(msg);
        }
        public boolean anyErrors(){
            return anyErrors;
        }
    }