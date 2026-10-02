import java.util.HashMap;
import java.util.Scanner;

public class ClimbingStairs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Solution solution = new Solution();

        System.out.println(solution.climbStairs(n));
    }
}

class Solution {

    public int climbStairs(int n) {
        return totalWays(0, n, new HashMap<>());
    }

    private int totalWays(
        int currentStair,
        int targetStair,
        HashMap<Integer, Integer> memo
    ) {

        if (currentStair == targetStair)
            return 1;

        if (currentStair > targetStair)
            return 0;

        if (memo.containsKey(currentStair))
            return memo.get(currentStair);

        int oneJump =
            totalWays(currentStair + 1, targetStair, memo);

        int twoJump =
            totalWays(currentStair + 2, targetStair, memo);

        int total = oneJump + twoJump;

        memo.put(currentStair, total);

        return total;
    }
}