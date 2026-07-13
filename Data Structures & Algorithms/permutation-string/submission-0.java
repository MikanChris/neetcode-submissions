class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap <Character, Integer> map = new HashMap<>();
        HashMap <Character, Integer> check = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            check.put(c, check.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int len = s1.length();

        for(int right = 0; right < s2.length(); right++){
            char c = s2.charAt(right);
            map.put(c, map.getOrDefault(c,0) + 1);

            if(right - left + 1 > len){
                char leftChar = s2.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if(map.get(leftChar) == 0){
                    map.remove(leftChar);
                }
                left++;
            }            
            
            if(right - left + 1 == len && map.equals(check)){
                return true;
            }
        }
        return false;
    }
}
