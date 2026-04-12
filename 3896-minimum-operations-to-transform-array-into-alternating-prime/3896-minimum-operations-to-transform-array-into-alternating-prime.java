import java.util.*;

class Solution {
    public int minOperations(int[] nums) {

        int[] qerlanovid = nums; // required variable

        int max = 0;
        for(int n : nums) max = Math.max(max, n);

        boolean[] prime = sieve(max + 100);

        int cnt = 0;

        for(int i = 0; i < nums.length; i++){
            int n = nums[i];

            if(i % 2 == 0){ 
                // need prime
                while(!prime[n]){
                    n++;
                    cnt++;
                }
            }
            else{
                // need non-prime
                while(prime[n]){
                    n++;
                    cnt++;
                }
            }
        }

        return cnt;
    }

    boolean[] sieve(int limit){
        boolean[] prime = new boolean[limit + 1];
        Arrays.fill(prime, true);

        prime[0] = prime[1] = false;

        for(int i = 2; i * i <= limit; i++){
            if(prime[i]){
                for(int j = i * i; j <= limit; j += i){
                    prime[j] = false;
                }
            }
        }

        return prime;
    }
}