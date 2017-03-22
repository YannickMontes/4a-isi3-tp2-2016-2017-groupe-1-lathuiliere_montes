public class Addition extends OperateurBinaire {
    public Addition(Noeud ng, Noeud nd) {
        super("+", ng, nd);
    }

    public void accept(Visitor visitor)
    {
        visitor.visitOperateurBinaire(this);
    }


}
