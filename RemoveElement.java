public class RemoveElement {
        public int removeElement(int[] nums, int val) {

            int k = 0;
            for(int i=0; i < nums.length; i++){
                if(nums[i] != val){
                    nums[k] =  nums[i];
                    k+=1;
                }
            }
            return k;

    }

    public static void main(String[] args){
            RemoveElement solution = new RemoveElement();

            int[] nums = {3,2,2,3};
            int val = 3;

            System.out.println(solution.removeElement(nums, val));// Output: [2,2]
    }

}
