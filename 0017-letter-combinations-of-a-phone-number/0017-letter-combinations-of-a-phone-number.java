class Solution {

    List<String> result = new ArrayList<>();

    String[] letters = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return result;
        }

        backtrack(digits, 0, new StringBuilder());

        return result;
    }

    void backtrack(String digits, int index, StringBuilder current) {

        // All digits processed
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get letters for current digit
        String possibleLetters =
            letters[digits.charAt(index) - '0'];

        // Try every letter
        for (char ch : possibleLetters.toCharArray()) {

            // Choose
            current.append(ch);

            // Explore
            backtrack(digits, index + 1, current);

            // Undo
            current.deleteCharAt(current.length() - 1);
        }
    }
}