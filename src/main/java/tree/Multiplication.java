package tree;

import visitor.Visitor;

public class Multiplication extends OperateurBinaire {

    public Multiplication(Noeud ng, Noeud nd) {
        super("*", ng, nd);
    }

    public void accept(Visitor visitor)
    {
        visitor.visitOperateurBinaire(this);
    }


}
