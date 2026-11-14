public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        
        if (i == j) {
            return 0;
        }

        int numVertices = m.length;
        
        int[] queue = new int[numVertices];
        int head = 0; 
        int tail = 0; 
        
        boolean[] visited = new boolean[numVertices];
        int[] distances = new int[numVertices];

        queue[tail] = i;
        tail++;
        visited[i] = true;
        distances[i] = 0;

        while (head < tail) {
            int currentVertex = queue[head];
            head++;

            if (currentVertex == j) {
                return distances[j];
            }

            int[] neighbors = getNeighbors(m, currentVertex);
            
            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    distances[neighbor] = distances[currentVertex] + 1;
                    visited[neighbor] = true;
                    
                    queue[tail] = neighbor;
                    tail++;
                }
            }
        }

        return -1;
    }

    // ==========================================
    //               helper methods
    // ==========================================

    private static int[] getNeighbors(int[][] m, int vertex) {
        
        int numNeighbors = countNeighbors(m, vertex);
        
        int[] neighbors = new int[numNeighbors];
        int index = 0;
        
        for (int candidate = 0; candidate < m.length; candidate++) {
            if (m[vertex][candidate] == 1) { 
                neighbors[index] = candidate;
                index++;
            }
        }
        
        return neighbors;
    }

    
    private static int countNeighbors(int[][] m, int vertex) {
        int count = 0;
        for (int candidate = 0; candidate < m.length; candidate++) {
            if (m[vertex][candidate] == 1) {
                count++;
            }
        }
        return count;
    }

    // ==========================================

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}