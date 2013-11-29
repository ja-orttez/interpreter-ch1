package visitor;import symboltable.*;import syntaxtree.*;import errors.*;public class BuildSymbolTableVisitor extends TypeDepthFirstVisitor {    private Table symbolTable;    private RamClass currClass;    private RamMethod currMethod;    public ErrorMsg message;    public BuildSymbolTableVisitor() {        symbolTable = new Table();        message = new ErrorMsg();    }    public Table getSymTab() {        return symbolTable;    }        public ErrorMsg getErrTab(){        return message;    }    // MainClass m;    // ClassDeclList cl;    public Type visit(Program n) {        n.m.accept(this);        for (int i = 0; i < n.cl.size(); i++) {            n.cl.elementAt(i).accept(this);        }        return null;    }    // Identifier i1,i2;    // Statement s;    public Type visit(MainClass n) {        symbolTable.addClass(n.i1.toString());        currClass = symbolTable.getClass(n.i1.toString());        // Ugly hack -- creating        // new IdentifierType("void") and new IdentifierType("String[]");        // not worth defining a VoidType and StringAryType         // for just a few occurrences                symbolTable.getClass(n.i1.s).addMethod("main", new IdentifierType("void"));        currMethod = symbolTable.getClass(n.i1.toString()).getMethod("main");        symbolTable.getMethod("main",                 currClass.getId()).addParam(n.i2.toString(), new IdentifierType("String[]"));                n.s.accept(this);        currMethod = null;        return null;    }    // Identifier i;    // VarDeclList vl;    // MethodDeclList ml;    public Type visit(ClassDeclSimple n) {        if (!symbolTable.addClass(n.i.toString())) {            message.complain("Class " + n.i.toString()                    + "is already defined");            //System.exit(-1);        }        currClass = symbolTable.getClass(n.i.toString());        for (int i = 0; i < n.vl.size(); i++) {            n.vl.elementAt(i).accept(this);        }        for (int i = 0; i < n.ml.size(); i++) {            n.ml.elementAt(i).accept(this);        }        return null;    }    // Type t;    // Identifier i;    public Type visit(VarDecl n) {        Type t = n.t.accept(this);        String id = n.i.toString();        if (currMethod == null) {            if (!currClass.addVar(id, t)) {                message.complain(id + "is already defined in "                        + currClass.getId());                //System.exit(-1);            }        } else {            if (!currMethod.addVar(id, t)) {                message.complain(id + "is already defined in "                        + currClass.getId() + "."                        + currMethod.getId());                //System.exit(-1);            }        }        return null;    }    // Type t;    // Identifier i;    // FormalList fl;    // VarDeclList vl;    // StatementList sl;    // Exp e;    public Type visit(MethodDecl n) {        Type t = n.t.accept(this);        String id = n.i.toString();        if (!currClass.addMethod(id, t)) {            message.complain("Method " + id                    + "is already defined in "                    + currClass.getId());            //System.exit(-1);        }        currMethod = currClass.getMethod(id);        for (int i = 0; i < n.fl.size(); i++) {            n.fl.elementAt(i).accept(this);        }        for (int i = 0; i < n.vl.size(); i++) {            n.vl.elementAt(i).accept(this);        }        for (int i = 0; i < n.sl.size(); i++) {            n.sl.elementAt(i).accept(this);        }        n.e.accept(this);        currMethod = null;        return null;    }    // Type t;    // Identifier i;    public Type visit(Formal n) {        Type t = n.t.accept(this);        String id = n.i.toString();        if (!currMethod.addParam(id, t)) {            message.complain("Formal" + id + "is already defined in "                    + currClass.getId() + "."                    + currMethod.getId());            //System.exit(-1);        }        return null;    }        public Type visit(And n){        return null;    }        public Type visit(ArrayAssign n){        return null;    }        public Type visit(ArrayLength n){        return null;    }        public Type visit(ArrayLookup n){        return null;    }        public Type visit(Assign n){        return null;    }        public Type visit(BooleanType n) {        return n;    }        public Type visit(Call n){        return null;    }        public Type visit(ClassDecl n){        return null;    }        public Type visit(ClassDeclExtends n){        return null;    }        public Type visit(ClassDeclList n){        return null;    }    public Type visit(IntArrayType n) {        return n;    }    public Type visit(IntegerType n) {        return n;    }    // String s;    public Type visit(IdentifierType n) {        return n;    }    // StatementList sl;    public Type visit(Block n) {        for (int i = 0; i < n.sl.size(); i++) {            n.sl.elementAt(i).accept(this);        }        return null;    }        public Type visit(Exp n){        return null;    }        public Type visit(ExpList n){        return null;    }        public Type visit(False n){        return null;    }        public Type visit(Foreach n){        return null;    }        public Type visit(FormalList n){        return null;    }        public Type visit(Identifier n){        return null;    }        public Type visit(IdentifierExp n){        return null;    }        public Type visit(If n){        return null;    }        public Type visit(IntegerLiteral n){        return null;    }        public Type visit(LessThan n){        return null;    }        public Type visit(LessThanEq n){        return null;    }        public Type visit(MethodDeclList n){        return null;    }        public Type visit(Minus n){        return null;    }        public Type visit(NewArray n){        return null;    }        public Type visit(NewObject n){        return null;    }        public Type visit(Not n){        return null;    }        public Type visit(Or n){        return null;    }        public Type visit(Plus n){        return null;    }        public Type visit(PlusEq n){        return null;    }        public Type visit(Print n){        return null;    }        public Type visit(Println n){        return null;    }        public Type visit(Statement n){        return null;    }        public Type visit(StatementList n){        return null;    }        public Type visit(This n){        return null;    }        public Type visit(Times n){        return null;    }        public Type visit(True n){        return null;    }        public Type visit(Type n){        return n;    }        public Type visit(VarDeclList n){        return null;    }        public Type visit(While n){        return null;    }        public Type visit(){        return null;    }}