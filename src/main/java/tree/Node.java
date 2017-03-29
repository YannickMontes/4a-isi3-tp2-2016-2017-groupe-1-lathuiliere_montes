package tree;

import visitor.Visitor;

public interface Node
{
    void accept(Visitor visitor);
}
