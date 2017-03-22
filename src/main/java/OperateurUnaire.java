public abstract class OperateurUnaire implements Noeud {
    private String op;
    private Noeud opG;

    OperateurUnaire(String s, Noeud nG, Noeud nD) {
        op = s;
        opG = nG;
    }

    public String getOp() {
        return op;
    }

    public Noeud getOpG() {
        return opG;
    }
}
