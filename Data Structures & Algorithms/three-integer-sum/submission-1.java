class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<String, List<Integer>> uniqueList = new HashMap<>();
        Arrays.sort(nums);
        for(int i=0; i < nums.length;i++){
            int[] nums_without_i = new int[nums.length - 1];
            int index = 0;
            for(int j=0;j<nums.length;j++){
                if(i==j) continue;
                else{
                    nums_without_i[index] = nums[j];
                    index++;
                }
            }
            List<int[]> result = twoSum(nums_without_i, -1 * nums[i]);
            if(result==null) continue;
            for(int[] res:result){
                int[] triplet = new int[3];
                triplet[0] = nums[i];
                triplet[1] = nums_without_i[res[0] - 1];
                triplet[2] = nums_without_i[res[1] - 1];
                Arrays.sort(triplet);
                String uniqueIdentifier = Arrays.stream(triplet)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(", "));
                if(!uniqueList.containsKey(uniqueIdentifier)){
                    List<Integer> integerList = new ArrayList<>();
                    for(int num:triplet) integerList.add(num);
                    uniqueList.put(uniqueIdentifier, integerList);
                }
            }
    }
        return new ArrayList<>(uniqueList.values());
    }

    public List<int[]> twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        List<int[]> res = new ArrayList<>();
        while(l < r){
            int sum = numbers[l] + numbers[r];
            if(sum == target){
                res.add(new int[] {l + 1, r + 1});
                l++;
            }
            else if(sum < target) l ++;
            else r --;
        }
        return res;
    }
}
