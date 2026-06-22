class Solution {

    public String encode(List<String> strs) {
        String encoded_string = "";
        for(String s : strs){
            encoded_string += s.length() + "#" + s; 
        }

        return encoded_string;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        int i = 0;

        while(i < str.length()){

            // 找到 #
            int j = str.indexOf('#', i);
    
            // 读出长度 len
            String lenStr = str.substring(i, j);
            int len = Integer.parseInt(lenStr);

            // 取出字符串
            String word = str.substring(j + 1, j + 1 + len);
            // 放进 res
            res.add(word);
            // 移动 i
            i = j + 1 + len;
        }

        return res;
    }
}
