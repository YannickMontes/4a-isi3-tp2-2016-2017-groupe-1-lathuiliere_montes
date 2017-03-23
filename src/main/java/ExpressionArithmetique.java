public class ExpressionArithmetique {
    private Noeud racine;
    private Visitor visitor;

    public ExpressionArithmetique(Noeud racine) {
        this.racine = racine;
    }

    public Noeud getRacine() {
        return racine;
    }

    public void afficherPostFixe() {
        System.out.println("\n postfixe:");
        this.visitor = new PostfixRoute();
        this.racine.accept(this.visitor);
    }

    public void afficherPreFixe()
    {
        System.out.println("\n Prefix route:");
        this.visitor = new PrefixRoute();
        this.racine.accept(this.visitor);
    }

    public int calculerValeur() {
        // TODO
        return 0;
    }

    public int calculerHauteur() {
        // TODO
        return 0;
    }

    public void afficherInFixe() {
        System.out.println("\n infixe:");
        this.visitor = new InfixeRoute();
        this.racine.accept(this.visitor);
    }

}
