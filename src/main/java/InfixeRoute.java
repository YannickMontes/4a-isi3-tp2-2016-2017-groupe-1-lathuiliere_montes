/**
 * Created by yannick on 22/03/17.
 */
public class InfixeRoute implements Visitor {


    public void visitOperateurUnaire(OperateurUnaire opUnaire)
    {
        System.out.println(opUnaire.getOpG());
        System.out.println(opUnaire.getOp());
    }

    public void visitOperateurBinaire(OperateurBinaire opBinaire)
    {
        System.out.println(opBinaire.getOpG());
        System.out.println(opBinaire.getOp());
        System.out.println(opBinaire.getOpD());
    }

    public void visitConstante(Constante constante)
    {
        System.out.println(constante.getValeur());
    }
}
