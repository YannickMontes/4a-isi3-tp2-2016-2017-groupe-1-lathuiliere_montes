package tree;

import visitor.Visitor;

public interface Noeud
{
    void accept(Visitor visitor);
}
