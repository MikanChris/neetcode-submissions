class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits.length() == 0){
            return result;
        }

        backtrack(digits, 0, new StringBuilder(), result);

        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> result){
        if(index == digits.length()){
            result.add(current.toString());
            return;
        }

        String[] map = {
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

        char digit = digits.charAt(index);  // '2'
        int number = digit - '0';           // 2
        String letters = map[number];       // "abc"

        for (char c : letters.toCharArray()) {
            current.append(c);

            backtrack(digits, index + 1, current, result);

            current.deleteCharAt(current.length() - 1);
        }

    }
}
