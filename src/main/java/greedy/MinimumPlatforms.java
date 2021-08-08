/*
Minimum Platforms - GFG

Link: https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1

Problem:
Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms
required for the railway station so that no train is kept waiting. Consider that all the trains arrive at the same day
and leave on the same day. Arrival and departure time can never be the same for a train, but we can have arrival time of
one train equal to departure time of the other. At any given instance of time, same platform can not be used for both
departure of a train and arrival of another train. In such cases, we need different platforms.

Ex 1:
Input: n = 6
arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
Output: 3
Explanation:
Minimum 3 platforms are required to
safely arrive and depart all trains.

Ex 2:
Input: n = 3
arr[] = {0900, 1100, 1235}
dep[] = {1000, 1200, 1240}
Output: 1
Explanation: Only 1 platform is required to
safely manage the arrival and departure
of all trains.

Expected Time Complexity: O(nLogn)
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ n ≤ 50000
0000 ≤ A[i] ≤ D[i] ≤ 2359
 */

package greedy;

import java.util.*;
import java.io.*;

class MinimumPlatforms
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while(t-- > 0)
        {
            String[] str = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);

            int[] arr = new int[n];
            int[] dep = new int[n];

            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);

            System.out.println(findPlatform(arr, dep, n));
        }
    }

    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int[] arr, int[] dep, int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);

        int requiredPlatforms = 1;
        int maxPlatforms = 1;
        int arrIdx = 1;
        int depIdx = 0;

        while (arrIdx < n && depIdx < n) {
            if (arr[arrIdx] <= dep[depIdx]) {
                requiredPlatforms++;
                arrIdx++;
            } else {
                requiredPlatforms--;
                depIdx++;
            }
            maxPlatforms = Math.max(maxPlatforms, requiredPlatforms);
        }

        return maxPlatforms;
    }
}
