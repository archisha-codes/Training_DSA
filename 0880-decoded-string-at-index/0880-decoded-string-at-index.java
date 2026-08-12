class Solution {
    public String decodeAtIndex(String s, int k) {

        long size = 0;

        // Find decoded length
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                size++;
            } else {
                size *= ch - '0';
            }
        }

        // Work backwards
        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                size /= ch - '0';
                k = (int)(k % size);

                if (k == 0) {
                    k = (int) size;
                }
            } else {
                if (k == size) {
                    return String.valueOf(ch);
                }

                size--;
            }
        }

        return "";
    }
}