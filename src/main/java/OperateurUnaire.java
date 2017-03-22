public abstract class OperateurUnaire implements Noeud {
    private String op;
    private Noeud opG;
    private Noeud opD;

    OperateurUnaire(String s, Noeud nG, Noeud nD) {
        op = s;
        opG = nG;
        opD = nD;
    }

    public String getOp() {
        return op;
    }

    public Noeud getOpG() {
        return opG;
    }

    public Noeud getOpD() {
        return opD;
    }
}
