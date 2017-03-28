package visitor;

import tree.*;

/**
 * Created by yannick on 22/03/17.
 */
public class VisitorExpressionHeight implements Visitor {
    private int height = 0;

    public int getHeight() {
        return this.height;
    }

    public void visitOperateurUnaire(OperateurUnaire opUnaire)
    {
        VisitorExpressionHeight visitorLeft = new VisitorExpressionHeight();

        opUnaire.getOpG().accept(visitorLeft);

        this.height += visitorLeft.getHeight() + 1;
    }

    public void visitOperateurBinaire(OperateurBinaire opBinaire)
    {
        VisitorExpressionHeight visitorLeft = new VisitorExpressionHeight();
        VisitorExpressionHeight visitorRight = new VisitorExpressionHeight();

        opBinaire.getOpG().accept(visitorLeft);
        opBinaire.getOpD().accept(visitorRight);

        this.height += Math.max(visitorLeft.getHeight(), visitorRight.getHeight()) + 1;
    }

    public void visitConstante(Constante constante)
    {
        this.height += 1;
    }

    public void visitNegation(Negation neg)
    {
        this.visitOperateurUnaire(neg);
    }
}
