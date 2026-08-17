class Solution {
    public int removeDuplicates(int[] arr) {

        int i = 0;        // index of last unique element
        int unique = 1;  // count of unique elements
        int cm = 1;      // current moving pointer
        int n = arr.length;

        while (cm < n) {
            if (arr[cm] == arr[cm - 1]) {
                cm++;
                continue;
            }

            arr[i + 1] = arr[cm];
            i++;
            unique++;
            cm++;
        }
        return unique;
    }
}


