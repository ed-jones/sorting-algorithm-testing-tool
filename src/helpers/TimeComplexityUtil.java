package helpers;

public class TimeComplexityUtil {
    public static void calcTimeComplexity(int comparisons, int arrLength) {
        int nSquared = (int) Math.pow(arrLength, 2);
        int logn = (int) Math.log(arrLength);
        int nlogn = arrLength * logn;
        int n = arrLength;
        
        int[] arr = {n, logn, nlogn, nSquared};

        int closestTime = findClosest(arr, comparisons);

        System.out.print("The algorithm's time complexity was approximately ");
        if(closestTime == n) {
            System.out.println("O(n)");
        } else if (closestTime == logn) {
            System.out.println("O(logn)");
        } else if (closestTime == nlogn) {
            System.out.println("O(nlogn)");
        } else {
            System.out.println("O(n^2)");
        }
    }

    private static int findClosest(int input[], int tar)
    {
        int n = input.length;

        if (tar <= input[0])
            return input[0];
        if (tar >= input[n - 1])
            return input[n - 1];
 
        int i = 0, j = n, mid = 0;
        while (i < j) {
            mid = (i + j) / 2;
 
            if (input[mid] == tar) {
                return input[mid];
            }
 
            if (tar < input[mid]) {
                if (mid > 0 && tar > input[mid - 1]) {
                    return closest(input[mid - 1], input[mid], tar);
                }
                j = mid;             
            } else {
                if (mid < n-1 && tar < input[mid + 1])
                    return closest(input[mid],
                          input[mid + 1], tar);               
                i = mid + 1; 
            }
        }

        return input[mid];
    }
 
    private static int closest(int el1, int el2, int tar)
    {
        if (tar - el1 >= el2 - tar) {
            return el2;
        } else {
            return el1;       
        }
    }
}
