package visitor;

import syntaxtree.*;

public class PrettyPrintPython implements Visitor {
String space = "";
String myProgram;
  // MainClass m;
  // ClassDeclList cl;
  public void visit(Program n) {
    for ( int i = 0; i < n.cl.size(); i++ ) {
        System.out.println();
        n.cl.elementAt(i).accept(this);
    }
    space = "";
    System.out.println();
    System.out.println();
    n.m.accept(this);
    n.fileName = myProgram;
  }
  
  // Identifier i1,i2;
  // Statement s;
  public void visit(MainClass n) {
    System.out.println(space+"import sys");
    System.out.print(space+"if __name__ == '__main__':\n");
    //System.out.print(space+"class ");
    
    //space += "\t";
    //System.out.print(space+"if __name__ == '__main__': \n");
    //n.i2.accept(this);
    //System.out.println(": ");
    space += "\t";
    System.out.print(space);
    //n.i1.accept(this);
    //System.out.print("().");
    n.s.accept(this);
    space = "\t";
    System.out.print("\n"+space);
    //System.out.println();//"}");
    myProgram = n.i1.toString();
  }

  // Identifier i;
  // VarDeclList vl;
  // MethodDeclList ml;
  public void visit(ClassDeclSimple n) {
    System.out.print(space+"class ");
    n.i.accept(this);
    System.out.print("(): ");
    space = "\t";
    for ( int i = 0; i < n.vl.size(); i++ ) {
        System.out.print(space);
        n.vl.elementAt(i).accept(this);
        //if ( i+1 < n.vl.size() ) { System.out.println(space); }
    }
    for ( int i = 0; i < n.ml.size(); i++ ) {
        System.out.println();
        n.ml.elementAt(i).accept(this);
    }
    //System.out.println();
    //System.out.println("");
  }
 
  // Identifier i;
  // Identifier j;
  // VarDeclList vl;
  // MethodDeclList ml;
  public void visit(ClassDeclExtends n) {
    System.out.print(space+"class ");
    n.i.accept(this);
    System.out.print(" extends ");
    n.j.accept(this);
    System.out.println(" { ");
    space += "\t";
    for ( int i = 0; i < n.vl.size(); i++ ) {
        System.out.print(space);
        n.vl.elementAt(i).accept(this);
        if ( i+1 < n.vl.size() ) { System.out.println(); }
    }
    for ( int i = 0; i < n.ml.size(); i++ ) {
        System.out.println();
        n.ml.elementAt(i).accept(this);
    }
    System.out.println();
    space = space.substring(0,space.length()-1);
    System.out.println(space+"}");
  }

  // Type t;
  // Identifier i;
  public void visit(VarDecl n) {
    //n.t.accept(this);
    //System.out.print(" ");
    //n.i.accept(this);
    //System.out.print(" = None");
  }

  // Type t;
  // Identifier i;
  // FormalList fl;
  // VarDeclList vl;
  // StatementList sl;
  // Exp e;
  public void visit(MethodDecl n) {
    System.out.print(space+"def ");
    //n.t.accept(this);
    //System.out.print(" ");
    n.i.accept(this);
    System.out.print("(");
    System.out.print("self");
    for ( int i = 0; i < n.fl.size(); i++ ) {
        if (i < n.fl.size()) { 
            System.out.print(", ");
            n.fl.elementAt(i).accept(this);
        }
    }
    System.out.println("): "); //{ ");
    space += "\t";
    //for ( int i = 0; i < n.vl.size(); i++ ) {
      //  if (i < n.vl.size()){
        //    System.out.print(space);
          //  n.vl.elementAt(i).accept(this);
        //System.out.println();
        //}
    //}
    //space = space.substring(0,space.length()-1);
    for ( int i = 0; i < n.sl.size(); i++ ) {
        System.out.print(space);
        n.sl.elementAt(i).accept(this);
        if ( i < n.sl.size() ) { System.out.println(); }
    }
    System.out.print(space+"return ");
    n.e.accept(this);
    //System.out.println();//"!");
    space = space.substring(0,space.length()-1);
    //System.out.print(space+"}");
  }

  // Type t;
  // Identifier i;
  public void visit(Formal n) {
    //n.t.accept(this);
    //System.out.print(" ");
    n.i.accept(this);
  }

  public void visit(IntArrayType n) {
    System.out.print("int []");
  }

  public void visit(BooleanType n) {
    System.out.print("bool");
  }

  public void visit(IntegerType n) {
    System.out.print("int");
  }

  // String s;
  public void visit(IdentifierType n) {
    System.out.print(n.s);
  }

  // StatementList sl;
  public void visit(Block n) {
    //System.out.println();//"{ ");
    //space += "\t";
    for ( int i = 0; i < n.sl.size(); i++ ) {
        n.sl.elementAt(i).accept(this);
        if(i != n.sl.size()-1)
            System.out.println();
            System.out.print(space);
    }
    //space = space.substring(0,space.length()-1);
    //System.out.print(space+"} ");
  }

  // Exp e;
  // Statement s1,s2;
  public void visit(If n) {
    System.out.print("if ");
    n.e.accept(this);
    System.out.println(": ");
    space += "\t";
    System.out.print(space);
    n.s1.accept(this);
    System.out.println();
    space = space.substring(0,space.length()-1);
    System.out.println(space+"else: ");
    space += "\t";
    System.out.print(space);
    n.s2.accept(this);
    space = space.substring(0,space.length()-1);
  }

  // Exp e;
  // Statement s;  	while ( Exp ) Statement
  public void visit(While n) {
    System.out.print("while ");
    n.e.accept(this);
    System.out.println(": ");
    space +="\t";
    System.out.print(space);
    n.s.accept(this);
    space = space.substring(0,space.length()-1);
  }

  // foreach ( Type id : id ) Statement
  //for item in iterable_collection:
  public void visit(Foreach n) {
    System.out.print("for ");
    //n.t.accept(this);
    //System.out.print(" ");
    n.id1.accept(this);
    System.out.print(" in ");
    n.id2.accept(this);
    System.out.print(") ");
    n.s.accept(this);
  }
  
  // Exp e;
  public void visit(Print n) {
    System.out.print("print ");
    n.e.accept(this);
    System.out.print(" ,");
  }
  
  // Exp e;
  public void visit(Println n) {
    System.out.print("print ");
    n.e.accept(this);
    //System.out.print("");
  }
  
  // Identifier i;
  // Exp e;
  public void visit(Assign n) {
    n.i.accept(this);
    System.out.print(" = ");
    n.e.accept(this);
    //System.out.print("!");
  }

  // Identifier i;
  // Exp e1,e2;
  public void visit(ArrayAssign n) {
    n.i.accept(this);
    System.out.print("[");
    n.e1.accept(this);
    System.out.print("] = ");
    n.e2.accept(this);
    //System.out.print("!");
  }

  // Exp e1,e2;
  public void visit(And n) {
    System.out.print("(");
    n.e1.accept(this);
    System.out.print(" and ");
    n.e2.accept(this);
    System.out.print(")");
  }

    // Exp e1,e2;
  public void visit(Or n) {
    System.out.print("(");
    n.e1.accept(this);
    System.out.print(" or ");
    n.e2.accept(this);
    System.out.print(")");
  }
  
  // Exp e1,e2;
  public void visit(LessThan n) {
    System.out.print("(");
    n.e1.accept(this);
    System.out.print(" < ");
    n.e2.accept(this);
    System.out.print(")");
  }
  
  // Exp e1,e2;
  public void visit(LessThanEq n) {
    System.out.print("(");
    n.e1.accept(this);
    System.out.print(" <= ");
    n.e2.accept(this);
    System.out.print(")");
  }

  // Exp e1,e2;
  public void visit(Plus n) {
    System.out.print("(");
    n.e1.accept(this);
    System.out.print(" + ");
    n.e2.accept(this);
    System.out.print(")");
  }
  
  // Exp e1,e2;
  // Identifier i;
  // Exp e;
  public void visit(PlusEq n) {
    n.i.accept(this);
    System.out.print(" += ");
    n.e.accept(this);
    //System.out.print("!");
  }

  // Exp e1,e2;
  public void visit(Minus n) {
    System.out.print("(");
    n.e1.accept(this);
    System.out.print(" - ");
    n.e2.accept(this);
    System.out.print(")");
  }

  // Exp e1,e2;
  public void visit(Times n) {
    System.out.print("(");
    n.e1.accept(this);
    System.out.print(" * ");
    n.e2.accept(this);
    System.out.print(")");
  }

  // Exp e1,e2;
  public void visit(ArrayLookup n) {
    n.e1.accept(this);
    System.out.print("[");
    n.e2.accept(this);
    System.out.print("]");
  }

  // Exp e;
  public void visit(ArrayLength n) {
    n.e.accept(this);
    System.out.print(".length");
  }

  // Exp e;
  // Identifier i;
  // ExpList el;
  public void visit(Call n) {
    n.e.accept(this);
    System.out.print(".");
    n.i.accept(this);
    System.out.print("(");
    for ( int i = 0; i < n.el.size(); i++ ) {
        n.el.elementAt(i).accept(this);
        if ( i+1 < n.el.size() ) { System.out.print(", "); }
    }
    System.out.print(")");
  }

  // int i;
  public void visit(IntegerLiteral n) {
    System.out.print(n.i);
  }

  public void visit(True n) {
    System.out.print("True");
  }

  public void visit(False n) {
    System.out.print("False");
  }

  // String s;
  public void visit(IdentifierExp n) {
    System.out.print(n.s);
  }

  public void visit(This n) {
    System.out.print("self");
  }

  // Exp e;
  public void visit(NewArray n) {
    System.out.print("[");
    n.e.accept(this);
    System.out.print("]");
  }

  // Identifier i;
  public void visit(NewObject n) {
    //System.out.print("new ");
    System.out.print(n.i.s);
    System.out.print("()");
  }

  // Exp e;
  public void visit(Not n) {
    System.out.print("not ");
    n.e.accept(this);
  }

  // String s;
  public void visit(Identifier n) {
    System.out.print(n.s);
  }
}
