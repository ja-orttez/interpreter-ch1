package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class Foreach extends Statement {
  public Type t;
  public Identifier id1;
  public Identifier id2;
  public Statement s;

  public Foreach(Type at, Identifier i1, Identifier i2, Statement as) {
    t=at; id1=i1; id2=i2; s=as; 
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Type accept(TypeVisitor v) {
    return v.visit(this);
  }
}

