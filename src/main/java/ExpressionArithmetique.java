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
        // TODO

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
        this.visitor.

    }

}
