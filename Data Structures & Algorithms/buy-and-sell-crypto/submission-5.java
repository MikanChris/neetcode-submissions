class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minPrice = prices[0];
        int maxPro = 0;
        
        for(int i = 0; i < n; i++){
            if(minPrice > prices[i]){
                minPrice = prices[i];
            }
            if((prices[i] - minPrice) > maxPro){
                maxPro = prices[i] - minPrice;
            }
        }

        if(maxPro < 0){
            maxPro = 0;
        }
        return maxPro;
    }
}
