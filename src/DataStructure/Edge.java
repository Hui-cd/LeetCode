package DataStructure;

public class Edge <T extends Comparable<T>> implements Comparable<Edge<T>>{

    public Vertex<T> from = null;
    public Vertex<T> to = null;
    public int cost = 0;

    public Edge(Vertex from,Vertex to, int cost){
        if (from == null || to == null)
            throw (new NullPointerException("Both 'to' and 'from' vertices need to be non-NULL."));
        this.from = from;
        this.to = to;
        this.cost =cost;
    }

    public Edge(Edge e){
        this(e.from,e.to, e.cost);
    }

    public int getCost() {
        return cost;
    }

    public Vertex<T> getFrom() {
        return from;
    }

    public Vertex<T> getTo() {
        return to;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setTo(Vertex<T> to) {
        this.to = to;
    }

    public void setFrom(Vertex<T> from) {
        this.from = from;
    }

    @Override
    public int hashCode() {
        int cost = this.cost*(this.getFrom().hashCode())*(this.getTo().hashCode());
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge<?> edge)) return false;
        return getCost() == edge.getCost() && getFrom().equals(edge.getFrom()) && getTo().equals(edge.getTo());
    }

    @Override
    public int compareTo(Edge e) {
        if (this.cost < e.cost)
            return -1;
        if (this.cost > e.cost)
            return 1;

        final int from = this.from.compareTo(e.from);
        if (from != 0)
            return from;

        final int to = this.to.compareTo(e.to);
        if (to != 0)
            return to;

        return 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[ ").append(from.getValue()).append("(").append(from.getWeight()).append(") ").append("]").append(" -> ")
                .append("[ ").append(to.getValue()).append("(").append(to.getWeight()).append(") ").append("]").append(" = ").append(cost).append("\n");
        return builder.toString();
    }
}
