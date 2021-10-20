class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> set = new HashSet<>();
        
        int l = 0;
        int r = 0;
        int ans = 0;
        
        while (r <s.length()){
            if (set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            } else {
                set.add(s.charAt(r));
                ans = Math.max(ans, r-l+1);
                r++;
            }
        }       
        return ans;        
    }
}