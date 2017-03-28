package visitor;

import tree.Constante;
import tree.Negation;
import tree.OperateurUnaire;
import tree.OperateurBinaire;

/**
 * Created by yannick on 22/03/17.
 */
public class PostfixRoute implements Visitor {


    public void visitOperateurUnaire(OperateurUnaire opUnaire)
    {
        opUnaire.getOpG().accept(this);
        System.out.println(opUnaire.getOp());
    }

    public void visitOperateurBinaire(OperateurBinaire opBinaire)
    {
        opBinaire.getOpG().accept(this);
        opBinaire.getOpD().accept(this);
        System.out.println(opBinaire.getOp());
    }

    public void visitConstante(Constante constante)
    {
        System.out.println(constante.getValeur());
    }

    public void visitNegation(Negation neg)
    {
        neg.getOpG().accept(this);
        System.out.println(neg.getOp());
    }
}
