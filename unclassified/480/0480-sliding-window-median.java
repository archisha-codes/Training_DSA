import java.util.*;

class Solution {

    PriorityQueue<Integer> maxHeap =
        new PriorityQueue<>(Collections.reverseOrder());

    PriorityQueue<Integer> minHeap =
        new PriorityQueue<>();

    HashMap<Integer, Integer> delayed =
        new HashMap<>();

    int maxSize = 0;
    int minSize = 0;

    public double[] medianSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        double[] ans = new double[n - k + 1];

        // Add first k elements
        for (int i = 0; i < k; i++) {
            add(nums[i]);
        }

        ans[0] = median();

        // Slide window
        for (int i = k; i < n; i++) {

            // Remove outgoing element
            remove(nums[i - k]);

            // Add incoming element
            add(nums[i]);

            ans[i - k + 1] = median();
        }

        return ans;
    }

    private void add(int num) {

        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
            maxSize++;
        } else {
            minHeap.add(num);
            minSize++;
        }

        balance();
    }

    private void remove(int num) {

        // Mark for deletion
        delayed.put(num, delayed.getOrDefault(num, 0) + 1);

        if (num <= maxHeap.peek()) {
            maxSize--;
        } else {
            minSize--;
        }

        clean(maxHeap);
        clean(minHeap);

        balance();
    }

    private void balance() {

        // Max heap should have same size
        // or one extra element
        if (maxSize > minSize + 1) {

            minHeap.add(maxHeap.poll());

            maxSize--;
            minSize++;

            clean(maxHeap);
        }

        if (maxSize < minSize) {

            maxHeap.add(minHeap.poll());

            minSize--;
            maxSize++;

            clean(minHeap);
        }
    }

    private void clean(PriorityQueue<Integer> heap) {

        while (!heap.isEmpty()
                && delayed.getOrDefault(heap.peek(), 0) > 0) {

            int num = heap.poll();

            delayed.put(num, delayed.get(num) - 1);

            if (delayed.get(num) == 0) {
                delayed.remove(num);
            }
        }
    }

    private double median() {

        if (maxSize == minSize) {

            return ((double) maxHeap.peek()
                    + (double) minHeap.peek()) / 2.0;
        }

        return maxHeap.peek();
    }
}