class Solution {
    public String minWindow(String s, String t) {
        HashMap <Character, Integer> need = new HashMap<>();
        HashMap <Character, Integer> window = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            need.put(c,need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int formed = 0;
        String answer = "";

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);

            window.put(c,window.getOrDefault(c, 0) + 1);
            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()){
                formed++;
            }
            
            while (formed == need.size()) {
                String current = s.substring(left, right + 1);
                char leftChar = s.charAt(left);
                
                if (answer.isEmpty() || current.length() < answer.length()) {
                    answer = current;
                }
                if (need.containsKey(leftChar)&& window.get(leftChar).intValue() == need.get(leftChar).intValue()) {
                    formed--;
                }
                window.put(leftChar, window.get(leftChar) - 1);
                left++;
            }
            
        }
        return answer;
    }
}
