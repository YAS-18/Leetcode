class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> mp = new HashMap<>();
     
     // To count the occurences of each element
        for(int i=0 ; i<arr1.length ; i++){
            if(mp.containsKey(arr1[i])){
                int cnt = mp.get(arr1[i]);
                mp.put(arr1[i],++cnt);
            }
            else
                mp.put(arr1[i],1);       
        }
        
        int j=0; 
        
        // Update the arr1 As per arr2
        for(int i=0; i<arr2.length ; i++){
            while(mp.get(arr2[i]) != 0){
                arr1[j++] = arr2[i];
                int cnt = mp.get(arr2[i]);
                mp.put(arr2[i],--cnt);
            }
        }
        
        int k=j;
        
        // Put the remaining arr1 elements
        for(int i:mp.keySet()){
            if(mp.get(i) != 0){
                while(mp.get(i) != 0){
                arr1[j++] = i;
                int cnt = mp.get(i);
                mp.put(i,--cnt);
              }
            }
        }
        
        // Sorting the remaining elements.
        Arrays.sort(arr1,k,arr1.length);
        return arr1;
    }
}
