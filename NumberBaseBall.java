import java.util.Scanner;

class NumberBaseBall {
    public final static int N = 4;

    static class Node {
        int one;
        int two;
        int three;
        int four;

        public Node(int one, int two, int three, int four) {
            this.one = one;
            this.two = two;
            this.three = three;
            this.four = four;
        }
    }

    public static Node[] list;
    public static int listSize;
    public static int[] visited;

    public void doUserImplementation(int[] guess) {
        list = new Node[5040];
        visited = new int[10];
        listSize = 0;

        dfs(0, new int[N]);

        Node[] nextList = new Node[5040];
        while (true) {
            Node node = list[0];
            guess[0] = node.one;
            guess[1] = node.two;
            guess[2] = node.three;
            guess[3] = node.four;

            Solution.Result result = Solution.query(guess);
            if (result.strike == N) break;

            int nextSize = 0;
            for (int i = 0; i < listSize; i++) {
                Node next = list[i];
                Solution.Result current = compare(node, next);
                if (result.strike == current.strike && result.ball == current.ball) {
                    nextList[nextSize++] = next;
                }
            }
            for (int i = 0; i < nextSize; i++) {
                list[i] = nextList[i];
            }
            listSize = nextSize;
        }
    }

    public static Solution.Result compare(Node node, Node next) {
        int stCount = 0, ballCount = 0;
    
        if (node.one == next.one) {
            stCount++;
        } else if (containCheck(next, node.one)) {
            ballCount++;
        }
    
        if (node.two == next.two) {
            stCount++;
        } else if (containCheck(next, node.two)) {
            ballCount++;
        }
    
        if (node.three == next.three) {
            stCount++;
        } else if (containCheck(next, node.three)) {
            ballCount++;
        }
    
        if (node.four == next.four) {
            stCount++;
        } else if (containCheck(next, node.four)) {
            ballCount++;
        }
    
        Solution.Result result = new Solution.Result();
        result.strike = stCount;
        result.ball   = ballCount;
        return result;
    }


    public static boolean containCheck(Node node, int index) {
        if (node.one == index) return true;
        if (node.two == index) return true;
        if (node.three == index) return true;
        if (node.four == index) return true;
        return false;
    }

    public static void dfs(int count, int[] value) {
        if (count == N) {
            list[listSize++] = new Node(value[0], value[1], value[2], value[3]);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            value[count] = i;
            dfs(count + 1, value);
            visited[i] = 0;
        }
    }
}
