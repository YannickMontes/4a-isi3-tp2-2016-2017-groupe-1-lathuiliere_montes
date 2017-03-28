package tree;

import visitor.Visitor;

public class Negation extends OperateurUnaire {
    public Negation(Noeud n) {
        super("-", n);
    }

    public void accept(Visitor visitor)
    {
        visitor.visitNegation(this);
    }

}
