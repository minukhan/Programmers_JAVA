import java.util.HashMap;

class Reporter_Quiz {
    public int[] Reporter_Quiz(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        boolean[][] checkReport = new boolean[id_list.length][id_list.length];
        
        HashMap <String, Integer> map = new HashMap<>();
        int[] reportCount = new int[checkReport.length];
        
        for(int i=0;i<id_list.length;i++){
            map.put(id_list[i],i);
        }
        
        for(int i=0;i<report.length;i++){
            String[] reportArray = report[i].split(" "); 
           
            if(!checkReport[map.get(reportArray[0])][map.get(reportArray[1])]){
                
                checkReport[map.get(reportArray[0])][map.get(reportArray[1])] = true;
                reportCount[map.get(reportArray[1])]++;
            }
        }

        for(int i=0;i<checkReport.length;i++){
            
            int AnswerReporterCount =0;
            
            for(int j=0;j<checkReport.length;j++){
                
                if(checkReport[i][j] && reportCount[j]>=k){
                    
                    AnswerReporterCount++;
                }
            }
            answer[i] = AnswerReporterCount;
        }
        
        
        return answer;
    }
}