package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2020/3/21
 * @Time 17:49
 */
public class Solution60 {
    public double[] twoSum(int n) {
        double[][] f = new double[n+1][6*n+1];
        f[0][0] = 1;
        for(int i=1; i<=n; i++)
            for(int j = i;j<=i*6; j++)
                for(int k = 1;k<=Math.min(j,6); k++)
                    f[i][j] += f[i-1][j-k];

        double total = Math.pow((double)6,(double)n);
        double[] ans = new double[5*n+1];
        for(int i=n;i<=6*n;i++){
            ans[i-n]=((double)f[n][i])/total;
        }
        return ans;

    }
}
