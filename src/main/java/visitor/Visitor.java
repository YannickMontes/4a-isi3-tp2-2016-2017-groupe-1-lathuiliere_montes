package visitor;

import tree.OperateurBinaire;
import tree.Negation;
import tree.OperateurUnaire;
import tree.Constante;

/**
 * Created by yannick on 22/03/17.
 */
public interface Visitor {
    void visitOperateurUnaire(OperateurUnaire opUnaire);

    void visitOperateurBinaire(OperateurBinaire opBinaire);

    void visitConstante(Constante constante);

    void visitNegation(Negation neg);
}
