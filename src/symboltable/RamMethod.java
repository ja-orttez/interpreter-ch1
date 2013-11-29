package symboltable;

import syntaxtree.IdentifierType;
import syntaxtree.Type;
import java.util.Hashtable;
import java.util.Enumeration;
//import java.util.LinkedHashMap;

public class RamMethod {
    private String id;
    private Hashtable<String, RamVariable> params;
    private Hashtable<String, RamVariable> locals;
    private Type type;
//RamMethod(String, Type) : constructor
    public RamMethod(String id, Type type){//need work
        this.id = id;
        this.type = new IdentifierType(id);
        params = new Hashtable<String, RamVariable>();
        locals = new Hashtable<String, RamVariable>();
    }
    
    public RamMethod() { }
    
//boolean addParam(String, Type)
    public boolean addParam(String id,Type type){
        if (containsParam(id)) {
            return false;
        } else {
            params.put(id, new RamVariable(id, type));
            return true;
        }
    }
    
//boolean addVar(String, Type)
    public boolean addVar(String id, Type type){
        if (containsVar(id)) {
            return false;
        } else {
            locals.put(id, new RamVariable(id, type));
            return true;
        }
    }
    
//boolean containsParam(String)
    public boolean containsParam(String id){
        return params.containsKey(id);
    }
    
 //boolean containsVar(String)
    public boolean containsVar(String id){
        return locals.containsKey(id);
    }
    
 //boolean getId()
    public String getId(){
        return id;//methods.contains(new IdentifierType(id));//maybe
    }
    
 //RamVariable getParam(String)
    public RamVariable getParam(String id){
        if (containsParam(id)) {
            return params.get(id);
        } else {
            return null;
        }
    }
    
//RamVariable getParamAt(int)
    public RamVariable getParamAt(int i){
        if(i > params.size()-1)
            return null;
        RamVariable para = null;
        int j = 0;
        while(j <= i){
            para = locals.elements().nextElement();
            j++;
        }
        return para;
    }
    
//Enumeration getParams()
    public Enumeration getParams(){
        Enumeration<RamVariable> en = params.elements();
        return en;
    }
    
//RamVariable getVar(String)
    public RamVariable getVar(String id){
        if (containsVar(id)) {
            return locals.get(id);
        } else {
            return null;
        }
    }
    
//String toString()
    public String toString(){
        String str = "\n";
        Enumeration<RamVariable> en = getParams();
        Enumeration<RamVariable> en2 = locals.elements();
        RamVariable rammy;
        Object[] meth = params.entrySet().toArray();
        Object[] glob = locals.entrySet().toArray();
        //int i = 0;
        str += "\t\t\t\tParams:\n";
        while(en.hasMoreElements()){
            rammy = (RamVariable)en.nextElement();
            str +=  "\t\t\t\t\t"+rammy.type().getClass().toString() +" " +rammy+"\n";
            //i++;
        }
        //i = 0;
        str += "\t\t\t\tLocals:\n";
        rammy = null;
        while(en2.hasMoreElements()){
            rammy =(RamVariable)en2.nextElement();
            str +=  "\t\t\t\t\t"+rammy.type().getClass().toString() +" " +rammy+"\n";
            //i++;
        }
        return str;
    }
    
//Type type() 
    public Type type(){
        return type;
    }
}

