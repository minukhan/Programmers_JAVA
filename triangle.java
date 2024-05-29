class triangle {

    public int triangle(int[] sides) {

        int answer = 0;

        int sum=0;

        int max=0;

        

        for (int i=0;i<sides.length;i++){

            if(max < sides[i]){

                max = sides[i];

            }

        }

        for (int i=0;i<sides.length;i++){

            if(max != sides[i]){

                sum += sides[i];

            }

        }

        

        if(max < sum){

            answer =1;

        }

        else{

            answer =2;

        }

        

        return answer;

    }

}