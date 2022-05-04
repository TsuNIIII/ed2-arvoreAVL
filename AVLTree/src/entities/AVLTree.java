package entities;

public class AVLTree<Type extends Comparable> {

    public Node<Type> raiz;

    public int Height(Node<Type> N) {
        if (N == null)
            return 0;
        return N.getHeight();
    }

    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public int getFatorBal(Node<Type> N) {
        if (N == null)
            return 0;
        return Height(N.getLeft()) - Height(N.getRight());
    }

    public Node<Type> RotaRight(Node<Type> y) {
        Node<Type> x = y.getLeft();
        Node<Type> z = x.getRight();

        x.setRight(y);
        y.setLeft(z);
        y.setHeight(max(Height(y.getLeft()), Height(y.getRight())) + 1);
        x.setHeight(max(Height(x.getLeft()), Height(x.getRight())) + 1);
        return x;
    }

    Node<Type> RotaLeftgetLeft(Node<Type> x) {
        Node<Type> y = x.getRight();
        Node<Type> z = y.getLeft();

        y.setLeft(x);
        x.setRight(z);
        x.setHeight(max(Height(x.getLeft()), Height(x.getRight())) + 1);
        y.setHeight(max(Height(y.getLeft()), Height(y.getRight())) + 1);
        return y;
    }

    public void inserir(Type value){
        this.raiz = inserirNo(this.raiz, value);
    }
    private Node<Type> inserirNo(Node<Type> No, Type value) {
        if (No == null) {
            return (new Node<Type>(value));
        }
        if (value.compareTo(No.getValue())<0)
            No.setLeft(inserirNo(No.getLeft(), value));
        else if (value.compareTo(No.getValue()) > 0)
            No.setRight(inserirNo(No.getRight(), value));
        else {
            return No;
        }
        No.setHeight(1 + max(Height(No.getLeft()), Height(No.getRight())));
        int FatorBal = getFatorBal(No);

        if (FatorBal > 1) {
            if (value.compareTo(No.getLeft().getValue()) < 0) {
                return RotaRight(No);
            } else if (value.compareTo(No.getLeft().getValue()) > 0) {
                No.setLeft(RotaLeftgetLeft(No.getLeft()));
                return RotaRight(No);
            }
        }
        if (FatorBal < -1) {
            if (value.compareTo(No.getRight().getValue()) > 0) {
                return RotaLeftgetLeft(No);
            } else if (value.compareTo(No.getRight().getValue()) < 0) {
                No.setRight(RotaRight(No.getRight()));
                return RotaLeftgetLeft(No);
            }
        }
        return No;
    }

    void preOrdem(Node<Type> No) {
        if (No != null) {
            System.out.print(No.getValue() + " ");
            preOrdem(No.getLeft());
            preOrdem(No.getRight());
        }
    }

    public void imprimir(){
        imprimir(this.raiz, "", true);
    }

    private void imprimir(Node<Type> ValueAtual, String indent, boolean ultimo) {
        if (ValueAtual != null) {
            System.out.print(indent);
            if (this.raiz == ValueAtual) indent += "  ";
            else if (ultimo) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }
            System.out.println(ValueAtual);
            imprimir(ValueAtual.getLeft(), indent, false);
            imprimir(ValueAtual.getRight(), indent, true);
        }
    }

    Node<Type> menorNo(Node<Type> No) {
        Node<Type> noAtual = No;

        while (noAtual.getLeft() != null)
            noAtual = noAtual.getLeft();
        return noAtual;
    }

    public void deletar(Type value){
           deletar(this.raiz, value);
    }

    public Node<Type> deletar(Node<Type> node, Type value) {
        if (node == null) {
            return null;
        }
        if (value.compareTo(node.getValue()) < 0)
            node.setLeft(deletar(node.getLeft(), value));
        else if (value.compareTo(node.getValue()) > 0)
            node.setRight(deletar(node.getRight(), value));
        else {
            if ((node.getLeft() == null) || (node.getRight() == null)) {
                Node<Type> temp = null;

                if (temp == node.getLeft())
                    temp = node.getRight();
                else
                    temp = node.getLeft();
                if (temp == null) {
                    temp = node;
                    node = null;
                } else{
                    node = temp;
                }
            } else {
                Node<Type> temp = menorNo(node.getRight());

                node.setValue(temp.getValue());
                node.setRight(deletar(node.getRight(), temp.getValue()));
            }
        }
        if (node == null) {
            return node;
        }
        node.setHeight(max(Height(node.getLeft()), Height(node.getRight())) + 1);
        int FatorBal = getFatorBal(node);

        if (FatorBal > 1) {
            if (getFatorBal(node.getLeft()) >= 0) {
                return RotaRight(node);
            } else {
                node.setLeft(RotaLeftgetLeft(node.getLeft()));
                return RotaRight(node);
            }
        }
        if (FatorBal < -1) {
            if (getFatorBal(node.getRight()) <= 0) {
                return RotaLeftgetLeft(node);
            } else {
                node.setRight(RotaRight(node.getRight()));
                return RotaLeftgetLeft(node);
            }
        }
        return node;
    }

}