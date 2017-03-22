/**
 * Created by yannick on 22/03/17.
 */
public interface Visitor {
    void visitConstant(Constante constante);

    void visitMultiplication(Multiplication mul);

    void visitNegation(Negation negation);

    void visitAddition(Addition add);

}
