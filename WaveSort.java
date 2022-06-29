import java.util.LinkedList;
import java.util.Queue;

class Node {
    int x, y, distance;

    Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.distance = dist;
    }
}

class lee {
    static int M = 5;
    static int N = 5;

    static boolean isValid(int mat[][], boolean[][] visited, int row, int col) {
        return ((row >= 0) && (row < M)) && ((col >= 0) && (col < N)) && (mat[row][col] == 1) && (!visited[row][col]);
    }

    public class WaveSort {
        public static void main(String[] args) {
            int[][] matrix = {
                    { 1, 0, 1, 1, 1 },
                    { 1, 0, 1, 0, 1 },
                    { 1, 1, 1, 0, 1 },
                    { 0, 0, 0, 0, 1 },
                    { 1, 1, 1, 0, 1 },
                    { 1, 1, 0, 0, 0 } };

            bfs(matrix, 0, 0, 3, 4);
        }

        private static void bfs(int[][] matrix, int sourceX, int sourceY, int targetX, int targetY) {
            int[] row = new int[] { -1, 0, 0, 1 };
            int[] col = new int[] { 0, -1, 1, 0 };

            int minDistance = Integer.MAX_VALUE;
            boolean[][] visited = new boolean[M][N];
            visited[sourceX][sourceY] = true;

            Queue<Node> q = new LinkedList<>();
            q.add(new Node(sourceX, sourceY, 0));
            while (!q.isEmpty()) {
                Node currentNode = q.poll();
                if (currentNode.x == targetX && currentNode.y == targetY) {
                    minDistance = currentNode.distance;
                    break;
                }

                for (int k = 0; k < 4; k++) {
                    int newX = currentNode.x + row[k];
                    int newY = currentNode.y + col[k];
                    if (isValid(matrix, visited, newX, newY)) {
                        visited[newX][newY] = true;
                        Node n = new Node(newX, newY, currentNode.distance + 1);
                        q.add(n);
                    }

                }
            }

            if (minDistance == Integer.MAX_VALUE) {
                System.out.println("Destination can't be reached");
            } else {
                System.out.println("The shortest path has length: " + minDistance);
            }
        }

    }
}
