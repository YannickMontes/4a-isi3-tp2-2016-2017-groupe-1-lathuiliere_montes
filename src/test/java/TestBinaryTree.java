import arithmetic.expression.ArithmeticExpression;
import tree.Addition;
import tree.Constant;
import tree.Multiplication;
import tree.Negation;

public class TestBinaryTree {

    public static void main(String[] args) 
    {
        //1+2*3+-4=3
        Addition root = new Addition(new Addition(new Constant(1),
                new Multiplication(new Constant(2), new Constant(3))),
                new Negation(new Constant(4)));
        ArithmeticExpression exp = new ArithmeticExpression(root);


        exp.afficherInFixe();
        System.out.println("");
        exp.afficherPreFixe();
        System.out.println("");
        System.out.println("\nCompute arithmetic expression: " + exp.calculerValeur());
        System.out.println("\nCompute height: " + exp.calculerHauteur());
        exp.afficherPostFixe();
    }
}
