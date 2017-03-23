/**
 * Created by yannick on 22/03/17.
 */
public class PrefixRoute implements Visitor {


    public void visitOperateurUnaire(OperateurUnaire opUnaire)
    {
        System.out.println(opUnaire.getOp());
        opUnaire.getOpG().accept(this);
    }

    public void visitOperateurBinaire(OperateurBinaire opBinaire)
    {
        System.out.println(opBinaire.getOp());
        opBinaire.getOpG().accept(this);
        opBinaire.getOpD().accept(this);
    }

    public void visitConstante(Constante constante)
    {
        System.out.println(constante.getValeur());
    }

    public void visitNegation(Negation neg)
    {
        System.out.println(neg.getOp());
        neg.getOpG().accept(this);
    }
}
