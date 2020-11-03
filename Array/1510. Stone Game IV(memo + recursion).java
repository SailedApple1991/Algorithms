
// @lc code=start
class Solution {
    
    public  boolean winnerSquareGame(int n) {
        if(n == 0) return false;
        List<Integer> squareSums = new ArrayList<Integer>();
        for(int i = 1; i * i <= n; i++){
            squareSums.add(i * i);
        }
        
        Boolean[] memo = new Boolean[n + 1];
        
        //alice is the first pick player so we just return it
        return dfs(n, memo, squareSums);
        
    }
    
    private boolean dfs(int n, Boolean[] memo, List<Integer> squareSums){
        if(n == 0) return false;
        if(memo[n] != null) return memo[n];
        
        boolean canWin = false;
        //iterate every choice
        for(int i = 0; i < squareSums.size(); i++){
            int numPick = squareSums.get(i);
            // >n --> cannot pick stones
            if(numPick > n) {
                canWin = false;
                break;
            }
            else if(numPick == n){
                canWin = true;
                break;
            }
            else{
                if(!dfs(n - numPick, memo, squareSums)){
                    canWin = true;
                    break;
                }
            }
        }
        
        memo[n] = canWin;
        return canWin;
    }
}
// @lc code=end