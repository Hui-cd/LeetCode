package Algorithm.AStarSearch;

public class Coord {
    public int x;
    public int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coord(Coord c) {
        this.x = c.x;
        this.y = c.y;
    }

    public boolean equals(Coord c) {
        return this.x == c.x && this.y == c.y;
    }

    public int hashCode() {
        return this.x * this.y;
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
