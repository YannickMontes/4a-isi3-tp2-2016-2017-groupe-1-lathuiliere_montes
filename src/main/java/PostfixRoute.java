/**
 * Created by yannick on 22/03/17.
 */
public class PostfixRoute implements Visitor {


    public void visitOperateurUnaire(OperateurUnaire opUnaire) {
        System.out.println(opUnaire.getOpG());
        System.out.println(opUnaire.getOp());
        //System.out.println(opUnaire.getOpD());
    }

    public void visitOperateurBinaire(OperateurBinaire opBinaire) {
        System.out.println(opBinaire);
    }

    public void visitConstante(Constante constante) {
        System.out.println(constante);
    }
}
