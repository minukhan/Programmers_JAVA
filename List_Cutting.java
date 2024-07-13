class List_Cutting {
    public int[] List_Cutting(int n, int[] slicer, int[] num_list) {
        String numList ="";
        
        switch(n){
            case 1:{
                
                for(int i=0;i<slicer[1]+1;i++){
                    numList += num_list[i];
                    numList += " ";
                }
                break;
                
            }
            case 2:{
                
                for(int i=slicer[0];i<num_list.length;i++){
                    numList += num_list[i];
                    numList += " ";
                }
                
                break;
                
            }
            case 3:{
                
                for(int i=slicer[0];i<slicer[1]+1;i++){
                    numList += num_list[i];
                    numList += " ";
                }
                
                break;
            }
            case 4:{
                
                for(int i=slicer[0];i<slicer[1]+1;i=i+slicer[2]){
                    numList += num_list[i];
                    numList += " ";
                }
                
                break;
            }
        }
        
        String[] arr = numList.split(" ");
        int[] answer = new int[arr.length];
        
        for(int i=0;i<arr.length;i++){
            answer[i] = Integer.parseInt(arr[i]);
        }
        
        
        
        return answer;
    }
}