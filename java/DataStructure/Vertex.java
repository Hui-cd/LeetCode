package DataStructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vertex<T extends Comparable<T>> implements Comparable<Vertex<T>> {

    private T value = null;
    private int weight =0;
    private List<Edge<T>> edges = new ArrayList<Edge<T>>();

    public Vertex(T value){
        this.value = value;
    }
    public Vertex(T value, int weight){
        this.value =value;
        this.weight =weight;
    }

    public Vertex(Vertex<T> vertex){
        this(vertex.value, vertex.weight);
        this.edges.addAll(vertex.edges);
    }

    public int getWeight() {
        return weight;
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }

    public T getValue() {
        return value;
    }

    public void setEdges(List<Edge<T>> edges) {
        this.edges = edges;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void addEdge(Edge<T> edge){
        edges.add(edge);
    }
    public boolean pathTo(Vertex<T> v){
        for (Edge<T> e: edges){
            if (e.to.equals(v)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int code = this.value.hashCode() + this.weight + this.edges.size();
        return code;
    }

    @Override
    public boolean equals(Object v1) {
        if (!(v1 instanceof Vertex)){
            return false;
        }
        final Vertex<T> v = (Vertex<T>) v1;
        final boolean weightEquals = this.weight == v.weight;
        if (!weightEquals)
            return false;
        final boolean edgesSizeEquals = this.edges.size() == v.edges.size();
        if (!edgesSizeEquals)
            return false;

        final boolean valuesEquals = this.value.equals(v.value);
        if (!valuesEquals)
            return false;

        final Iterator<Edge<T>> iter1 = this.edges.iterator();
        final Iterator<Edge<T>> iter2 = v.edges.iterator();
        while (iter1.hasNext() && iter2.hasNext()) {
            // Only checking the cost
            final Edge<T> e1 = iter1.next();
            final Edge<T> e2 = iter2.next();
            if (e1.cost != e2.cost)
                return false;
        }
       return true;
    }

    @Override
    public int compareTo(Vertex<T> v) {
        final int valueComp = this.value.compareTo(v.value);
        if (valueComp != 0)
            return valueComp;
        if (this.weight < v.weight)
            return -1;
        if (this.weight > v.weight)
            return 1;
        if (this.edges.size() < v.edges.size())
            return -1;
        if (this.edges.size() > v.edges.size())
            return 1;
        final Iterator<Edge<T>> iter1 = this.edges.iterator();
        final Iterator<Edge<T>> iter2 = v.edges.iterator();
        while (iter1.hasNext() && iter2.hasNext()) {
            // Only checking the cost
            final Edge<T> e1 = iter1.next();
            final Edge<T> e2 = iter2.next();
            if (e1.cost < e2.cost)
                return -1;
            if (e1.cost > e2.cost)
                return 1;
        }

        return 0;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Value").append(this.value).append("Weight").append(this.weight).append("\n");
        for (Edge<T> e : edges)
            stringBuilder.append("\t").append(e.toString());
        return stringBuilder.toString();
    }
}
