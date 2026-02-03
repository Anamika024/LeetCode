class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int p = -1, q = -1;
        if(n<4) return false;
        for(int i=1; i<n-1; i++) {
            if(nums[i-1]<nums[i] && nums[i]>nums[i+1]) {
                p=i;
                break;
            }
        }
        if(p==-1) return false;
        for(int i=p+1; i<n-1; i++) {
            if(nums[i-1]>nums[i] && nums[i]<nums[i+1]) {
                q=i;
                break;
            }  
            
        }
        if(q==-1)return false;
        System.out.print(p+" " + q);
        for(int i=1; i<=p; i++) {
            if(nums[i-1]>=nums[i]) return false;
        }
        for(int i=p+1; i<=q; i++) {
            if(nums[i-1]<=nums[i]) return false;
        }
        for(int i=q+1; i<=n-1; i++) {
            if(nums[i-1]>=nums[i]) return false;
        }
        
        return true;
    }
}