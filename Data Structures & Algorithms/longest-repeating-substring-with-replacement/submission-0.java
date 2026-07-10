class Solution {
    public int characterReplacement(String s, int k) {
        HashMap <Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        int result = 0;

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c,0) + 1);
            max = Math.max(max, map.get(c));

            int len = right - left + 1;
            int lon = len;
            if(len - max > k){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);            
                left++;
                lon--;
            }
            
            result = Math.max(lon, result);
        }
        return result;
    }
}
