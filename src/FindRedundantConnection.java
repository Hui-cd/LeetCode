/**
 * 树可以看成是一个连通且 无环的无向图。
 * 给定往一棵n 个节点 (节点值1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n中间，且这条附加的边不属于树中已存在的边。
 * 图的信息记录于长度为 n 的二维数组 edges，edges[i] = [ai, bi]表示图中在 ai 和 bi 之间存在一条边。
 * 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组edges中最后出现的边。
 */
public class FindRedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            if (find(parent, a) == find(parent, b)) {
                return edges[i];
            }
            parent[find(parent, a)] = find(parent, b);
        }
        return new int[2];

    }

    private int find(int[] parent, int a) {
        if (parent[a] == 0) {
            return a;
        }
        return find(parent, parent[a]);
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        FindRedundantConnection test = new FindRedundantConnection();
        int[] result = test.findRedundantConnection(edges);
        System.out.println(result[0] + " " + result[1]);
    }
}
