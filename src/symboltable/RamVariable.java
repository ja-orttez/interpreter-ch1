/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package symboltable;

import syntaxtree.Type;

/**
 *
 * @author estudiante
 */
public class RamVariable {
    private String id;
    private Type type;
    
//RamVariable(String, Type) : constructor
    public RamVariable(String id, Type type){
        this.id = id;
        this.type = type;
    }
    
//String getId()
    public String getId(){
        return id;
    }
    
//Type type()
    public Type type(){
        return type;
    }
    
//String toString()
    public String toString(){
        return id;
    }
}