package Algorithm.Search;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node <T> {
    public T value;
    public List<Node<T>> subNodes;

    public Node(T value,List<Node<T>> subNodes) {
        this.value = value;
        this.subNodes = subNodes;
    }

    public Node(T value) {
        this.value = value;
        this.subNodes = new ArrayList<Node<T>>();
    }

    public T getValue() {
        return value;
    }

    public List<Node<T>> getSubNodes() {
        return subNodes;
    }


    public void addSubNode(Node<T> subNode){
        subNodes.add(subNode);
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setSubNodes(List<Node<T>> subNodes) {
        this.subNodes = subNodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node<?> node)) return false;
        return getValue().equals(node.getValue()) && getSubNodes().equals(node.getSubNodes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getSubNodes());
    }

}
