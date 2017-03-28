package visitor;

import tree.Constante;
import tree.Negation;
import tree.OperateurUnaire;
import tree.OperateurBinaire;

/**
 * Created by yannick on 22/03/17.
 */
public class PrefixRoute implements Visitor {


    public void visitOperateurUnaire(OperateurUnaire opUnaire)
    {
        System.out.print(opUnaire.getOp());
        opUnaire.getOpG().accept(this);
    }

    public void visitOperateurBinaire(OperateurBinaire opBinaire)
    {
        System.out.print(opBinaire.getOp());
        opBinaire.getOpG().accept(this);
        opBinaire.getOpD().accept(this);
    }

    public void visitConstante(Constante constante)
    {
        System.out.print(constante.getValeur());
    }

    public void visitNegation(Negation neg)
    {
        System.out.print(neg.getOp());
        neg.getOpG().accept(this);
    }
}
