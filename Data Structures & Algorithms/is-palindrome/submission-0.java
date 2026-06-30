class Solution {
    public boolean isPalindrome(String s) {
        String s1 = "";
        for(int i = 0; i < s.length(); i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                s1 += s.charAt(i);
            }
        }
        s1 = s1.toLowerCase();
        System.out.println("s1:" + s1);
        int mid = 0;
        String right = "";

        if(s1.length() % 2 == 0){
            mid = s1.length() / 2;
            right = s1.substring(mid);
        }else{
            mid = (s1.length() - 1) / 2;
            right = s1.substring(mid+1);
        }
        
        String reversed = new StringBuilder(right).reverse().toString();
        System.out.println("right:" + right);
        System.out.println("(0,mid):" + s1.substring(0,mid));
            
        return s1.substring(0,mid).equals(reversed);


        // if(s1.length() % 2 == 0){
        //     System.out.println("s1.length() % 2 == 0");
        //     int mid = s1.length() / 2;
        //     String right = s1.substring(mid);
        //     String reversed = new StringBuilder(right).reverse().toString();
        //     System.out.println("right:" + right);
            
        //     return s1.substring(0,mid-1).equals(reversed);
        // }else{
        //     System.out.println("!s1.length() % 2 == 0");
            
        //     return true;
        // }
    }
}
