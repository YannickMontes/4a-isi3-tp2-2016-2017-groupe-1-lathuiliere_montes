package visitor;

import tree.*;

/**
 * Created by yannick on 22/03/17.
 */
public class VisitorCalculateExpression implements Visitor {
    private int result = 0;

    public int getResult() {
        return this.result;
    }

    public void visitOperateurUnaire(OperateurUnaire opUnaire)
    {
        throw new UnsupportedOperationException();
    }

    public void visitOperateurBinaire(OperateurBinaire opBinaire)
    {
        VisitorCalculateExpression calculatorLeft = new VisitorCalculateExpression();
        VisitorCalculateExpression calculatorRight = new VisitorCalculateExpression();
        opBinaire.getOpG().accept(calculatorLeft);
        opBinaire.getOpD().accept(calculatorRight);

        if(opBinaire instanceof Addition) {
            this.result += calculatorLeft.getResult() + calculatorRight.getResult();
        } else { // Multiplication
            this.result += calculatorLeft.getResult() * calculatorRight.getResult();
        }
    }

    public void visitConstante(Constante constante)
    {
        this.result += constante.getValeur();
    }

    public void visitNegation(Negation neg)
    {
        VisitorCalculateExpression calculatorLeft = new VisitorCalculateExpression();
        neg.getOpG().accept(calculatorLeft);
        this.result += -calculatorLeft.getResult();
    }
}
