import java.util.*;

public class Main {
    static int maxSum = Integer.MIN_VALUE;
    static int N;
    static int[] b,nums;
    static boolean[] v;
    static void dfs(int cnt){
        if(cnt == N){
            maxSum = Math.max(maxSum,calculateDifference(b));
            return;
        }
        for(int i=0; i<N; i++){
            if(v[i]) continue;
            v[i] = true;
            b[cnt] = nums[i];
            dfs(cnt+1);
            v[i] = false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N];
        v = new boolean[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        b = new int[N];
        
        dfs(0);

        System.out.println(maxSum);
    }
    
    static int calculateDifference(int[] nums) {
        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            sum += Math.abs(nums[i] - nums[i - 1]);
        }
        return sum;
    }
}
