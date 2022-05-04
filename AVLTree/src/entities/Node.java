package entities;

public class Node<Type> {
    private Type value;
    private Integer height;
    private Node<Type> left, right;

    Node(Type value) {
        this.value = value;
        height = 1;
    }

    public Type getValue() {
        return value;
    }
    public void setValue(Type value) {
        this.value = value;
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public Node<Type> getLeft() {
        return left;
    }
    public void setLeft(Node<Type> left) {
        this.left = left;
    }

    public Node<Type> getRight() {
        return right;
    }
    public void setRight(Node<Type> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "[" + value + ']';
    }
}
