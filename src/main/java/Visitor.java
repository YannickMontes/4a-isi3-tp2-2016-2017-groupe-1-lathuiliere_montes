/**
 * Created by yannick on 22/03/17.
 */
public interface Visitor {
    void visitOperateurUnaire(OperateurUnaire opUnaire);

    void visitOperateurBinaire(OperateurBinaire opBinaire);

    void visitConstante(Constante constante);

}
