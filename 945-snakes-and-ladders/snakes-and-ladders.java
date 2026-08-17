class Solution {

    int[] getId(int val, int n) {

        // 0-based logical row from the bottom
        int rowFromBottom = (val - 1) / n;

        // Actual matrix row
        int i = n - 1 - rowFromBottom;

        // Position inside the logical row
        int j = (val - 1) % n;

        // Every alternate row is reversed
        if (rowFromBottom % 2 == 1) {
            j = n - 1 - j;
        }

        return new int[]{i, j};
    }

    public int snakesAndLadders(int[][] board) {

        int n = board.length;
        int target = n * n;

        Deque<Integer> dq = new ArrayDeque<>();

        boolean[] visited = new boolean[target + 1];

        // Start at square 1
        dq.addLast(1);
        visited[1] = true;

        int moves = 0;

        while (!dq.isEmpty()) {

            int size = dq.size();

            for (int k = 0; k < size; k++) {

                int current = dq.pollFirst();

                if (current == target) {
                    return moves;
                }

                // Try all dice outcomes
                for (int dice = 1; dice <= 6; dice++) {

                    int next = current + dice;

                    if (next > target) {
                        break;
                    }

                    // Convert square number -> board coordinates
                    int[] pos = getId(next, n);

                    int i = pos[0];
                    int j = pos[1];

                    // Snake / ladder
                    if (board[i][j] != -1) {
                        next = board[i][j];
                    }

                    // Visit this resulting square
                    if (!visited[next]) {

                        visited[next] = true;
                        dq.addLast(next);
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}