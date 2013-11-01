package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class PlusEq extends Statement {
  public Identifier i;
  public Exp e;

  public PlusEq(Identifier ai, Exp ae) {
    i=ai; e=ae; 
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public Type accept(TypeVisitor v) {
    return v.visit(this);
  }
}

