package com.meiken;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        permute(new int[]{1,2,3,4,5}, 0);
    }

    public static void permute(int[] nums, int index){
        if(index == nums.length){
            // 已经无可替换
            for(int num : nums){
                System.out.print(num);
            }
            System.out.println();
        }

        for(int i=index; i<nums.length; i++){
            // 占据位置 index
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] =temp;

            permute(nums, index+1);

            nums[i] = nums[index];
            nums[index] = temp;
        }

    }
}
