package visitor;

import tree.*;

/**
 * Created by yannick on 22/03/17.
 */
public interface Visitor 
{
    void visitUnaryOperator(UnaryOperator unaryOp);

    void visitAddition(Addition addition);

    void visitMultiplication(Multiplication multiplication);

    void visitConstant(Constant constantOperator);

    void visitNegation(Negation negationOperator);
}
