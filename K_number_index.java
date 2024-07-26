import java.util.Arrays;

class K_number_index {

    public int[] K_number_index(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        for(int i=0;i<commands.length;i++){

            

            int count=0;

            

            int[] arr = new int[commands[i][1]-commands[i][0]+1];

            

            for(int j=commands[i][0];j<=commands[i][1];j++){

                arr[count] = array[j-1];

                count++;

            }

            Arrays.sort(arr);

            

            answer[i] = arr[commands[i][2]-1];

        }

        return answer;

    }

}