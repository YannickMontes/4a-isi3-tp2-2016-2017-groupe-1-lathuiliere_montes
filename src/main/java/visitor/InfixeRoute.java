package visitor;

import tree.*;

/**
 * Created by yannick on 22/03/17.
 */
public class InfixeRoute implements Visitor {


    public void visitOperateurUnaire(OperateurUnaire opUnaire)
    {
        opUnaire.getOpG().accept(this);
        System.out.print(opUnaire.getOp());
    }

    public void visitOperateurBinaire(OperateurBinaire opBinaire)
    {
        if(opBinaire instanceof Multiplication) {
            System.out.print("(");
        }
        opBinaire.getOpG().accept(this);
        System.out.print(opBinaire.getOp());
        opBinaire.getOpD().accept(this);
        if(opBinaire instanceof Multiplication) {
            System.out.print(")");
        }
    }

    public void visitConstante(Constante constante)
    {
        System.out.print(constante.getValeur());
    }

    public void visitNegation(Negation neg)
    {
        System.out.print(String.format("(%s",neg.getOp()));
        neg.getOpG().accept(this);
        System.out.print(")");
    }
}
