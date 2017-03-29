**Nom/Prénom Etudiant 1 : Yoann Lathuilière**

**Nom/Prénom Etudiant 2 : Yannick Montes**

# Rapport TP2

## Question 1 & 2

L'implémentation du pattern visiteur est une manière de répondre au problème posé au sein du TP.
Voici le diagramme de classe:
![diagramme classe](images/VisitorDiagram.png)

On crée une interface Visiteur. Cette dernière possède toutes les fonctions nécessaires à la visite d'un noeud en particulier (Opérateur unaire, binaire ou une constante).

```java
public interface Visitor 
{
    void visitUnaryOperator(UnaryOperator unaryOp);

    void visitBinarOperator(BinaryOperator binaryOp);

    void visitConstant(Constant constantOperator);

    void visitNegation(Negation negationOperator);
}
```


Par la suite, on crée des classes Visiteurs concrètes, représentant chacun un type de parcours spécifique au sein de l'arbre. Elles implémentent l'interface visiteur afin de surcharger les méthodes précédemment définies.

Enfin, un noeud possède une méthode accept(), lui permettant d'être visité par quelconque type de visiteur. 
Le traitement de cette fonction est très simple, il appelle la méthode de visite spécifique à son type. 
Un exemple avec la classe Addition: 
```java
public void accept(Visitor visitor)
{
    visitor.visitBinaryOperation(this); // This représente une Addition, qui est un opérateur binaire
}
```

L'intérêt du pattern est d'avoir à modifier qu'un seul fichier en cas d'ajout d'une méthode de parcours. 
En revanche, si l'on ajoute un élément, il faut modifier tous les fichiers.

## Question 3
On crée une classe PostifTraversal implémentant le visiteur classique créé auparavant.
Voici le code:

```java
public class PostfixTraversal implements Visitor 
{
    public void visitUnaryOperator(UnaryOperator unaryOperator)
    {
        unaryOperator.getLeftOperator().accept(this);
        System.out.print(unaryOperator.getOperator());
    }

    public void visitBinarOperator(BinaryOperator binaryOperator)
    {
        binaryOperator.getLeftOperator().accept(this);
        binaryOperator.getRightOperator().accept(this);
        System.out.print(binaryOperator.getOperator());
    }

    public void visitConstant(Constant constant)
    {
        System.out.print(constant.getValue());
    }

    public void visitNegation(Negation negation)
    {
        negation.getLeftOperator().accept(this);
        System.out.print(negation.getOperator());
    }
}
```

Ici, pour chaque opérateur, on parcourt d'abord le noeud gauche, ensuite le noeud droit, puis on termine avec le noeud lui-même.
L'implémentation montre clairement que pour les types de noeuds ne possédant pas de noeuds droits ou gauches, on passe à l'étape d'après.
Par exemple, pour la négation, il n'y a pas de noeud droit. Dans l'ordre, on visite donc d'abord le noeud gauche, puis directement le noeud lui-même.

Ici, on se préoccupe uniquement de l'affichage. La visite du noeud lui-même est donc représentée par une System.out.
Pour visiter un autre noeud, on passe le visiteur courant (this), à la méthode accepte de ce dernier.

## Question 4
On crée une classe VisitorComputeArithmeticExpression qui implémente le visiteur classique.
On ajoute à cette classe une propriété "result" qui contiendra le résultat du calcul arithmétique.

`````
private int result = 0;

public int getResult() 
{
    return this.result;
}
````

- Dans le cas de la visite d'une opération binaire, on va chercher en premier à calculer le résultat du noeud gauche (et de ses potentiels fils) pour l'ajouter ou le multiplier avec le résultat du noeud droit (et de ses potentiels fils).

- Dans le cas d'une constante, on va simplement ajouter au résultat la valeur de la constante

- Dans le cas d'une négation, on calculera la valeur du noeud gauche de l'opérateur pour le soustraire du résultat final
`````
public void visitBinarOperator(BinaryOperator binaryOperator)
{
    VisitorComputeArithmeticExpression calculatorLeft = new VisitorComputeArithmeticExpression();
    VisitorComputeArithmeticExpression calculatorRight = new VisitorComputeArithmeticExpression();
    binaryOperator.getLeftOperator().accept(calculatorLeft);
    binaryOperator.getRightOperator().accept(calculatorRight);

    if(binaryOperator instanceof Addition) {
        this.result += calculatorLeft.getResult() + calculatorRight.getResult();
    } else { // Multiplication
        this.result += calculatorLeft.getResult() * calculatorRight.getResult();
    }
}

public void visitConstant(Constant constant)
{
    this.result += constant.getValue();
}

public void visitNegation(Negation negation)
{
    VisitorComputeArithmeticExpression calculatorLeft = new VisitorComputeArithmeticExpression();
    negation.getLeftOperator().accept(calculatorLeft);
    this.result += -calculatorLeft.getResult();
}
````

Pour afficher le résultat d'une opération, on appelera simplement le visiteur créé sur la racine de notre expression et on retournera le résultat grâce à la méthode "getResult()".
`````
this.visitor = new VisitorComputeArithmeticExpression();
this.root.accept(this.visitor);

return ((VisitorComputeArithmeticExpression) this.visitor).getResult();
`````

## Question 5
Pour cette question, on reprend le même principe que pour la question précédente : on crée une propriété "height" qui sera incrémentée en fonction des visites.
`````
private int height = 0;

public int getHeight() 
{
    return this.height;
}
````

- Dans le cas d'une opération unaire, on va calculer la hauteur de son noeud gauche (sous-arbre) et y ajouter 1.

- Dans le cas d'une opération binaire, on applique le même traitement, calcul de la hauteur du sous-arbre, mais cette fois-ci, sur le noeud gauche et droit. On récupèrera la plus grande hauteur des deux et on y ajoutera 1.

- Dans le cas d'une constante, on ajoute 1 à la hauteur de l'arbre.

`````
public void visitUnaryOperator(UnaryOperator unaryOperator)
{
    VisitorComputeHeightTree visitorLeft = new VisitorComputeHeightTree();

    unaryOperator.getLeftOperator().accept(visitorLeft);

    this.height += visitorLeft.getHeight() + 1;
}

public void visitBinarOperator(BinaryOperator binaryOperator)
{
    VisitorComputeHeightTree visitorLeft = new VisitorComputeHeightTree();
    VisitorComputeHeightTree visitorRight = new VisitorComputeHeightTree();

    binaryOperator.getLeftOperator().accept(visitorLeft);
    binaryOperator.getRightOperator().accept(visitorRight);

    this.height += Math.max(visitorLeft.getHeight(), visitorRight.getHeight()) + 1;
}

public void visitConstant(Constant constant)
{
    this.height += 1;
}
`````

Comme pour la méthode précédente, on affichera la hauteur d'un arbre en appelant le visiteur créé sur la racine de notre arbre et on retournera le résultat grâce à la méthode "getHeight()".

`````
this.visitor = new VisitorComputeHeightTree();
this.root.accept(this.visitor);

return ((VisitorComputeHeightTree) this.visitor).getHeight();
`````


## Question 6
Le dernier parcours implémente, infixe, se base sur le même principe que les deux autres parcours. L'ordre est juste changé, on visitera d'abord la partie gauche d’un noeud, puis sa partie droite du noeud et enfin le noeud en lui-même.

Pour gérer les priorités, on ajoutera simplement des parenthèses dans les opérations binaires et les négations.


`````
public void visitUnaryOperator(UnaryOperator unaryOperator)
{
    unaryOperator.getLeftOperator().accept(this);
    System.out.print(unaryOperator.getOperator());
}

public void visitBinarOperator(BinaryOperator binaryOperator)
{
    if(binaryOperator instanceof Multiplication) 
    {
        System.out.print("(");
    }
    binaryOperator.getLeftOperator().accept(this);
    System.out.print(binaryOperator.getOperator());
    binaryOperator.getRightOperator().accept(this);
    if(binaryOperator instanceof Multiplication) {
        System.out.print(")");
    }
}

public void visitConstant(Constant constant)
{
    System.out.print(constant.getValue());
}

public void visitNegation(Negation negation)
{
    System.out.print(String.format("(%s",negation.getOperator()));
    negation.getLeftOperator().accept(this);
    System.out.print(")");
}
````