package arithmetic.expression;

import visitor.*;
import tree.Node;

public class ArithmeticExpression 
{
    private Node root;
    private Visitor visitor;

    public ArithmeticExpression(Node roots) 
    {
        this.root = roots;
    }

    public Node getRacine() 
    {
        return root;
    }

    public void afficherPostFixe() 
    {
        System.out.println("\nPostfix traversal:");
        this.visitor = new PostfixTraversal();
        this.root.accept(this.visitor);
    }

    public void afficherPreFixe()
    {
        System.out.println("\nPrefix traversal:");
        this.visitor = new PrefixTraversal();
        this.root.accept(this.visitor);
    }

    public int calculerValeur() 
    {
        this.visitor = new VisitorComputeArithmeticExpression();
        this.root.accept(this.visitor);

        return ((VisitorComputeArithmeticExpression) this.visitor).getResult();
    }

    public int calculerHauteur() 
    {
        this.visitor = new VisitorComputeHeightTree();
        this.root.accept(this.visitor);

        return ((VisitorComputeHeightTree) this.visitor).getHeight();
    }

    public void afficherInFixe() 
    {
        System.out.println("\nInfixe traversal:");
        this.visitor = new InfixTraversal();
        this.root.accept(this.visitor);
    }

}
