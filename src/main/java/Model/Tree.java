package Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Tree<T> {

    private T value;
    private Tree<T> left;
    private Tree<T> right;

    public Tree(T value) {
        this.value = value;
    }

    public Tree(T value, T left, T right) {
        this.value = value;
        this.setLeft(left);
        this.setRight(right);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Tree<T> getLeft() {
        return left;
    }

    public void setLeft(T left) {
        this.setLeft(new Tree<T>(left));
    }

    public void setLeft(Tree<T> left) {
        this.left = left;
    }

    public Tree<T> getRight() {
        return right;
    }

    public void setRight(T right) {
        this.setRight(new Tree<T>(right));
    }

    public void setRight(Tree<T> right) {
        this.right = right;
    }

    public boolean isLeaf() {
        return getLeft() == null && getRight() == null;
    }
}
