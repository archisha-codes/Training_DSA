import java.util.*;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int totalUnits = 0;
        for (int[] box : boxTypes) {
            int count = Math.min(truckSize, box[0]);
            totalUnits += count * box[1];
            truckSize -= count;
            if (truckSize == 0) break;
        }
        return totalUnits;
    }
}
