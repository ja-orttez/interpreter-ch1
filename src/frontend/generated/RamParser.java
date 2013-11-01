/* Generated By:JavaCC: Do not edit this line. RamParser.java */
    package frontend.generated;
    import syntaxtree.*;
    public class RamParser implements RamParserConstants {

/*
void Goal() :
{}
{  
    ( RamToken() )*  <EOF> 
}

void RamToken():
{}
{
  <CLASS>  |  <IDENTIFIER> | <LBRACE> | <PUBLIC> | <STATIC> | <VOID> |
  <MAIN> | <LPAREN> | <STRING> | <LSQPAREN> | <RSQPAREN> | <RPAREN> | <RBRACE> |
  <PLUSEQ> | <SEMICOLON> | <RETURN> | <COMMA> | <INTEGER> | <BOOLEAN> | <ASSIGN> |
  <IF> | <ELSE> | <WHILE> | <FOREACH> | <COLON> | <PRINT> | <PRINTLN> | <AND> |
  <OR> | <LESSTHAN> | <LESSTHANOREQ> | <EQUALITY> | <PLUS> | <MINUS> | <TIMES> |
  <DOT> | <LENGTH> | <INTEGER_LITERAL> | <TRUE> | <FALSE> | <THIS> | <NEW> |
  <END>
}
*/
  static final public Program Goal() throws ParseException {
    MainClass m;
    ClassDeclList cl = new ClassDeclList();
    ClassDecl c;
    m = MainClass();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CLASS:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      c = ClassDecl();
                        cl.addElement(c);
    }
    jj_consume_token(0);
      {if (true) return new Program(m, cl);}
    throw new Error("Missing return statement in function");
  }

  static final public MainClass MainClass() throws ParseException {
    Identifier i1;
    Identifier i2;
    Statement s;
    jj_consume_token(CLASS);
    jj_consume_token(IDENTIFIER);
                   i1 = new Identifier(token.image);
    jj_consume_token(LBRACE);
    jj_consume_token(PUBLIC);
    jj_consume_token(STATIC);
    jj_consume_token(VOID);
    jj_consume_token(MAIN);
    jj_consume_token(LPAREN);
    jj_consume_token(STRING);
    jj_consume_token(LBRAC);
    jj_consume_token(RBRAC);
    jj_consume_token(IDENTIFIER);
                   i2 = new Identifier(token.image);
    jj_consume_token(RPAREN);
    jj_consume_token(LBRACE);
    s = Statement();
    jj_consume_token(RBRACE);
    jj_consume_token(RBRACE);
      {if (true) return new MainClass(i1, i2, s);}
    throw new Error("Missing return statement in function");
  }

  static final public ClassDecl ClassDecl() throws ParseException {
    Identifier i;
    VarDeclList vl = new VarDeclList();
    MethodDeclList ml = new MethodDeclList();
    VarDecl v;
    MethodDecl m;
    jj_consume_token(CLASS);
    jj_consume_token(IDENTIFIER);
                   i = new Identifier(token.image);
    jj_consume_token(LBRACE);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BOOLEAN:
      case INT:
      case IDENTIFIER:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
      v = VarDecl();
                      vl.addElement(v);
    }
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PUBLIC:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_3;
      }
      m = MethodDecl();
                         ml.addElement(m);
    }
    jj_consume_token(RBRACE);
      {if (true) return new ClassDeclSimple(i, vl, ml);}
    throw new Error("Missing return statement in function");
  }

  static final public VarDecl VarDecl() throws ParseException {
    Type t;
    Identifier i;
    t = Type();
    jj_consume_token(IDENTIFIER);
                   i = new Identifier(token.image);
    jj_consume_token(END);
      {if (true) return new VarDecl(t, i);}
    throw new Error("Missing return statement in function");
  }

  static final public MethodDecl MethodDecl() throws ParseException {
    Type t;
    Identifier i;
    FormalList fl = new FormalList();
    VarDeclList vl = new VarDeclList();
    VarDecl v;
    StatementList sl = new StatementList();
    Statement s;
    Exp e;
    jj_consume_token(PUBLIC);
    t = Type();
    jj_consume_token(IDENTIFIER);
                   i = new Identifier(token.image);
    jj_consume_token(LPAREN);
    fl = FormalList();
    jj_consume_token(RPAREN);
    jj_consume_token(LBRACE);
    label_4:
    while (true) {
      if (jj_2_1(2)) {
        ;
      } else {
        break label_4;
      }
      v = VarDecl();
                                   vl.addElement(v);
    }
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LBRACE:
      case IF:
      case WHILE:
      case PRINT:
      case PRINTLN:
      case IDENTIFIER:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_5;
      }
      s = Statement();
                        sl.addElement(s);
    }
    jj_consume_token(RETURN);
    e = Exp();
    jj_consume_token(END);
    jj_consume_token(RBRACE);
      {if (true) return new MethodDecl(t, i, fl, vl, sl, e);}
    throw new Error("Missing return statement in function");
  }

  static final public Formal Formal() throws ParseException {
    Type t;
    Identifier i;
    t = Type();
    jj_consume_token(IDENTIFIER);
                   i = new Identifier(token.image);
      {if (true) return new Formal(t, i);}
    throw new Error("Missing return statement in function");
  }

  static final public FormalList FormalList() throws ParseException {
    FormalList fl = new FormalList();
    Type t;
    Identifier i;
    Formal f;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case BOOLEAN:
    case INT:
    case IDENTIFIER:
      t = Type();
      jj_consume_token(IDENTIFIER);
                       i = new Identifier(token.image);
          fl.addElement(new Formal(t, i));
      label_6:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[4] = jj_gen;
          break label_6;
        }
        f = FormalRest();
                             fl.addElement(f);
      }
      break;
    default:
      jj_la1[5] = jj_gen;
      ;
    }
      {if (true) return fl;}
    throw new Error("Missing return statement in function");
  }

  static final public Formal FormalRest() throws ParseException {
    Type t;
    Identifier i;
    jj_consume_token(COMMA);
    t = Type();
    jj_consume_token(IDENTIFIER);
                   i = new Identifier(token.image);
      {if (true) return new Formal(t, i);}
    throw new Error("Missing return statement in function");
  }

  static final public Type Type() throws ParseException {
    if (jj_2_2(3)) {
      jj_consume_token(INT);
      jj_consume_token(LBRAC);
      jj_consume_token(RBRAC);
      {if (true) return new IntArrayType();}
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BOOLEAN:
        jj_consume_token(BOOLEAN);
                {if (true) return new BooleanType();}
        break;
      case INT:
        jj_consume_token(INT);
            {if (true) return new IntegerType();}
        break;
      case IDENTIFIER:
        jj_consume_token(IDENTIFIER);
                    {if (true) return new IdentifierType(token.image);}
        break;
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    throw new Error("Missing return statement in function");
  }

  static final public Statement Statement() throws ParseException {
    StatementList sl = new StatementList();
    Statement s1;
    Exp e1;
    Statement s2;
    Exp e2;
    Identifier i;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LBRACE:
      jj_consume_token(LBRACE);
      label_7:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LBRACE:
        case IF:
        case WHILE:
        case PRINT:
        case PRINTLN:
        case IDENTIFIER:
          ;
          break;
        default:
          jj_la1[7] = jj_gen;
          break label_7;
        }
        s1 = Statement();
                         sl.addElement(s1);
      }
      jj_consume_token(RBRACE);
      {if (true) return new Block(sl);}
      break;
    case IF:
      jj_consume_token(IF);
      jj_consume_token(LPAREN);
      e1 = Exp();
      jj_consume_token(RPAREN);
      s1 = Statement();
      jj_consume_token(ELSE);
      s2 = Statement();
      {if (true) return new If(e1, s1, s2);}
      break;
    case WHILE:
      jj_consume_token(WHILE);
      jj_consume_token(LPAREN);
      e1 = Exp();
      jj_consume_token(RPAREN);
      s1 = Statement();
      {if (true) return new While(e1, s1);}
      break;
    case PRINT:
      jj_consume_token(PRINT);
      jj_consume_token(LPAREN);
      e1 = Exp();
      jj_consume_token(RPAREN);
      jj_consume_token(END);
      {if (true) return new Print(e1);}
      break;
    case PRINTLN:
      jj_consume_token(PRINTLN);
      jj_consume_token(LPAREN);
      e1 = Exp();
      jj_consume_token(RPAREN);
      jj_consume_token(END);
      {if (true) return new Println(e1);}
      break;
    default:
      jj_la1[8] = jj_gen;
      if (jj_2_3(2)) {
        jj_consume_token(IDENTIFIER);
                   i = new Identifier(token.image);
        jj_consume_token(LBRAC);
        e1 = Exp();
        jj_consume_token(RBRAC);
        jj_consume_token(ASSIGN);
        e2 = Exp();
        jj_consume_token(END);
      {if (true) return new ArrayAssign(i, e1, e2);}
      } else if (jj_2_4(2)) {
        jj_consume_token(IDENTIFIER);
                   i = new Identifier(token.image);
        jj_consume_token(ASSIGN);
        e1 = Exp();
        jj_consume_token(END);
      {if (true) return new Assign(i, e1);}
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case IDENTIFIER:
          jj_consume_token(IDENTIFIER);
                   i = new Identifier(token.image);
          jj_consume_token(PLUSEQ);
          e1 = Exp();
          jj_consume_token(END);
      {if (true) return new PlusEq(i, e1);}
          break;
        default:
          jj_la1[9] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
    throw new Error("Missing return statement in function");
  }

  static final public Exp Exp() throws ParseException {
    Exp e;
    e = AndExp();
      {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  static final public Exp AndExp() throws ParseException {
    Exp e1, e2;
    e1 = EqualityExp();
    label_8:
    while (true) {
      if (jj_2_5(2)) {
        ;
      } else {
        break label_8;
      }
      jj_consume_token(AND);
      e2 = EqualityExp();
          e1 = new And(e1, e2);
    }
      {if (true) return e1;}
    throw new Error("Missing return statement in function");
  }

  static final public Exp EqualityExp() throws ParseException {
    Exp e;
    e = RelationalExp();
      {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  static final public Exp RelationalExp() throws ParseException {
    Exp e1, e2;
    e1 = AdditiveExp();
    label_9:
    while (true) {
      if (jj_2_6(2)) {
        ;
      } else {
        break label_9;
      }
      jj_consume_token(LESSTHAN);
      e2 = AdditiveExp();
          e1 = new LessThan(e1, e2);
    }
      {if (true) return e1;}
    throw new Error("Missing return statement in function");
  }

  static final public Exp AdditiveExp() throws ParseException {
    Exp e1, e2;
    e1 = MultiplicativeExp();
    label_10:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MINUS:
        ;
        break;
      default:
        jj_la1[10] = jj_gen;
        break label_10;
      }
      if (jj_2_7(2)) {
        jj_consume_token(PLUS);
        e2 = MultiplicativeExp();
          e1 = new Plus(e1, e2);
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case MINUS:
          jj_consume_token(MINUS);
          e2 = MultiplicativeExp();
          e1 = new Minus(e1, e2);
          break;
        default:
          jj_la1[11] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
      {if (true) return e1;}
    throw new Error("Missing return statement in function");
  }

  static final public Exp MultiplicativeExp() throws ParseException {
    Exp e1, e2;
    e1 = UnaryExp();
    label_11:
    while (true) {
      if (jj_2_8(2)) {
        ;
      } else {
        break label_11;
      }
      jj_consume_token(TIMES);
      e2 = UnaryExp();
          e1 = new Times(e1, e2);
    }
      {if (true) return e1;}
    throw new Error("Missing return statement in function");
  }

  static final public Exp UnaryExp() throws ParseException {
    Exp e;
    boolean inNot = false;
    label_12:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SEMICOLON:
        ;
        break;
      default:
        jj_la1[12] = jj_gen;
        break label_12;
      }
      jj_consume_token(SEMICOLON);
                    inNot = !inNot;
    }
    e = SuffixExp();
      if (inNot)
        {if (true) return new Not(e);}
      else
        {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  static final public Exp SuffixExp() throws ParseException {
    Exp e1;
    Exp e2;
    ExpList el;
    Identifier i;
    e1 = PrefixExp();
    label_13:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LBRAC:
      case DOT:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_13;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LBRAC:
        jj_consume_token(LBRAC);
        e2 = Exp();
        jj_consume_token(RBRAC);
          {if (true) return new ArrayLookup(e1, e2);}
        break;
      default:
        jj_la1[14] = jj_gen;
        if (jj_2_9(2)) {
          jj_consume_token(DOT);
          jj_consume_token(IDENTIFIER);
                             i = new Identifier(token.image);
          jj_consume_token(LPAREN);
          el = ExpList();
          jj_consume_token(RPAREN);
          {if (true) return new Call(e1, i, el);}
        } else {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case DOT:
            jj_consume_token(DOT);
            jj_consume_token(LENGTH);
                         {if (true) return new ArrayLength(e1);}
            break;
          default:
            jj_la1[15] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
        }
      }
    }
      {if (true) return e1;}
    throw new Error("Missing return statement in function");
  }

  static final public Exp PrefixExp() throws ParseException {
    Identifier i;
    Exp e;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER_LITERAL:
      jj_consume_token(INTEGER_LITERAL);
                        {if (true) return new IntegerLiteral(Integer.parseInt(token.image));}
      break;
    case TRUE:
      jj_consume_token(TRUE);
             {if (true) return new True();}
      break;
    case FALSE:
      jj_consume_token(FALSE);
              {if (true) return new False();}
      break;
    case IDENTIFIER:
      jj_consume_token(IDENTIFIER);
                   {if (true) return new IdentifierExp(token.image);}
      break;
    case LPAREN:
      jj_consume_token(LPAREN);
      e = Exp();
      jj_consume_token(RPAREN);
      {if (true) return e;}
      break;
    case THIS:
      jj_consume_token(THIS);
             {if (true) return new This();}
      break;
    default:
      jj_la1[16] = jj_gen;
      if (jj_2_10(2)) {
        jj_consume_token(NEW);
        jj_consume_token(INT);
        jj_consume_token(LBRAC);
        e = Exp();
        jj_consume_token(RBRAC);
      {if (true) return new NewArray(e);}
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case NEW:
          jj_consume_token(NEW);
          jj_consume_token(IDENTIFIER);
                   i = new Identifier(token.image);
          jj_consume_token(LPAREN);
          jj_consume_token(RPAREN);
      {if (true) return new NewObject(i);}
          break;
        default:
          jj_la1[17] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
    throw new Error("Missing return statement in function");
  }

  static final public ExpList ExpList() throws ParseException {
    ExpList el = new ExpList();
    Exp e;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LPAREN:
    case SEMICOLON:
    case FALSE:
    case NEW:
    case THIS:
    case TRUE:
    case INTEGER_LITERAL:
    case IDENTIFIER:
      e = Exp();
                    el.addElement(e);
      label_14:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[18] = jj_gen;
          break label_14;
        }
        e = ExpRest();
                          el.addElement(e);
      }
      break;
    default:
      jj_la1[19] = jj_gen;
      ;
    }
      {if (true) return el;}
    throw new Error("Missing return statement in function");
  }

  static final public Exp ExpRest() throws ParseException {
    Exp e;
    jj_consume_token(COMMA);
    e = Exp();
      {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  static private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  static private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  static private boolean jj_2_5(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_5(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  static private boolean jj_2_6(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_6(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(5, xla); }
  }

  static private boolean jj_2_7(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_7(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(6, xla); }
  }

  static private boolean jj_2_8(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_8(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(7, xla); }
  }

  static private boolean jj_2_9(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_9(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(8, xla); }
  }

  static private boolean jj_2_10(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_10(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(9, xla); }
  }

  static private boolean jj_3_1() {
    if (jj_3R_15()) return true;
    return false;
  }

  static private boolean jj_3_7() {
    if (jj_scan_token(PLUS)) return true;
    if (jj_3R_18()) return true;
    return false;
  }

  static private boolean jj_3R_23() {
    if (jj_3R_27()) return true;
    return false;
  }

  static private boolean jj_3R_34() {
    if (jj_scan_token(NEW)) return true;
    return false;
  }

  static private boolean jj_3R_17() {
    if (jj_3R_18()) return true;
    return false;
  }

  static private boolean jj_3_10() {
    if (jj_scan_token(NEW)) return true;
    if (jj_scan_token(INT)) return true;
    return false;
  }

  static private boolean jj_3R_33() {
    if (jj_scan_token(THIS)) return true;
    return false;
  }

  static private boolean jj_3R_32() {
    if (jj_scan_token(LPAREN)) return true;
    return false;
  }

  static private boolean jj_3R_22() {
    if (jj_scan_token(SEMICOLON)) return true;
    return false;
  }

  static private boolean jj_3_6() {
    if (jj_scan_token(LESSTHAN)) return true;
    if (jj_3R_17()) return true;
    return false;
  }

  static private boolean jj_3R_31() {
    if (jj_scan_token(IDENTIFIER)) return true;
    return false;
  }

  static private boolean jj_3R_19() {
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_22()) { jj_scanpos = xsp; break; }
    }
    if (jj_3R_23()) return true;
    return false;
  }

  static private boolean jj_3R_30() {
    if (jj_scan_token(FALSE)) return true;
    return false;
  }

  static private boolean jj_3R_29() {
    if (jj_scan_token(TRUE)) return true;
    return false;
  }

  static private boolean jj_3R_21() {
    if (jj_3R_17()) return true;
    return false;
  }

  static private boolean jj_3R_28() {
    if (jj_scan_token(INTEGER_LITERAL)) return true;
    return false;
  }

  static private boolean jj_3R_27() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_28()) {
    jj_scanpos = xsp;
    if (jj_3R_29()) {
    jj_scanpos = xsp;
    if (jj_3R_30()) {
    jj_scanpos = xsp;
    if (jj_3R_31()) {
    jj_scanpos = xsp;
    if (jj_3R_32()) {
    jj_scanpos = xsp;
    if (jj_3R_33()) {
    jj_scanpos = xsp;
    if (jj_3_10()) {
    jj_scanpos = xsp;
    if (jj_3R_34()) return true;
    }
    }
    }
    }
    }
    }
    }
    return false;
  }

  static private boolean jj_3R_15() {
    if (jj_3R_20()) return true;
    if (jj_scan_token(IDENTIFIER)) return true;
    return false;
  }

  static private boolean jj_3_8() {
    if (jj_scan_token(TIMES)) return true;
    if (jj_3R_19()) return true;
    return false;
  }

  static private boolean jj_3_4() {
    if (jj_scan_token(IDENTIFIER)) return true;
    if (jj_scan_token(ASSIGN)) return true;
    return false;
  }

  static private boolean jj_3R_16() {
    if (jj_3R_21()) return true;
    return false;
  }

  static private boolean jj_3R_26() {
    if (jj_scan_token(IDENTIFIER)) return true;
    return false;
  }

  static private boolean jj_3R_18() {
    if (jj_3R_19()) return true;
    return false;
  }

  static private boolean jj_3R_25() {
    if (jj_scan_token(INT)) return true;
    return false;
  }

  static private boolean jj_3_9() {
    if (jj_scan_token(DOT)) return true;
    if (jj_scan_token(IDENTIFIER)) return true;
    return false;
  }

  static private boolean jj_3R_24() {
    if (jj_scan_token(BOOLEAN)) return true;
    return false;
  }

  static private boolean jj_3_3() {
    if (jj_scan_token(IDENTIFIER)) return true;
    if (jj_scan_token(LBRAC)) return true;
    return false;
  }

  static private boolean jj_3_5() {
    if (jj_scan_token(AND)) return true;
    if (jj_3R_16()) return true;
    return false;
  }

  static private boolean jj_3_2() {
    if (jj_scan_token(INT)) return true;
    if (jj_scan_token(LBRAC)) return true;
    if (jj_scan_token(RBRAC)) return true;
    return false;
  }

  static private boolean jj_3R_20() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_2()) {
    jj_scanpos = xsp;
    if (jj_3R_24()) {
    jj_scanpos = xsp;
    if (jj_3R_25()) {
    jj_scanpos = xsp;
    if (jj_3R_26()) return true;
    }
    }
    }
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public RamParserTokenManager token_source;
  static JavaCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[20];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x80000000,0x40000000,0x0,0x2000,0x20000,0x40000000,0x40000000,0x2000,0x2000,0x0,0x3000000,0x2000000,0x8000,0x40800,0x800,0x40000,0x200,0x0,0x20000,0x8200,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x80020,0x200,0x9800c,0x0,0x80020,0x80020,0x9800c,0x1800c,0x80000,0x0,0x0,0x0,0x0,0x0,0x0,0xc6002,0x100,0x0,0xc6102,};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[10];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public RamParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public RamParser(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new JavaCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new RamParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public RamParser(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new JavaCharStream(stream, 1, 1);
    token_source = new RamParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public RamParser(RamParserTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(RamParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[54];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 20; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 54; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 10; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
            case 4: jj_3_5(); break;
            case 5: jj_3_6(); break;
            case 6: jj_3_7(); break;
            case 7: jj_3_8(); break;
            case 8: jj_3_9(); break;
            case 9: jj_3_10(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

                            }
