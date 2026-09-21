class Solution {
    public List<Integer> partitionLabels(String s) {
        int[][] indexes = new int[26][2];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(indexes[c-'a'][0]==-1){
                indexes[c-'a'][0] = i;
            }else{
                indexes[c - 'a'][1] = i;
            }
        }
        char c = s.charAt(0);
        int last_index = indexes[c-'a'][1];
        List<Integer> res = new ArrayList<>();
        int i=1;
        int start_index = 0;
        
        if(last_index==0){
            res.add(1);
            start_index = 1;
        }
        while(i<s.length()){
            c = s.charAt(i);
            if(indexes[c-'a'][1]> last_index){
                last_index = indexes[c-'a'][1];
            }
            System.out.println(c + " " + last_index + " " + start_index + " " + i);
            if(i==last_index){
                res.add((i - start_index) + 1);
                 start_index = i + 1;
            }
            i+=1;
        }

        return res;
    }
}
