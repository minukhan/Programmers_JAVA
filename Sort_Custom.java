import java.util.*;

import java.lang.*;

import java.io.*;

class Student{

        String name ;

        int korean, english, math;
        public Student(String name, int korean, int english, int math){

            this.name = name;

            this.english = english;

            this.math = math;

            this.korean = korean;

        }

    }




class Sort_Custom {


    public static void Sort_Custom(String[] args) throws Exception {

        

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()); 

        List<Student> list = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++){

            st = new StringTokenizer(br.readLine()); 

            String name = st.nextToken();

            int korean = Integer.parseInt(st.nextToken());

            int english = Integer.parseInt(st.nextToken());

            int math = Integer.parseInt(st.nextToken());

            list.add( new Student(name,korean,english,math));

        }
        list.sort( (a, b) -> {

            if(a.korean != b.korean) return b.korean-a.korean; 

            if(a.english != b.english) return a.english-b.english;

            if(a.math != b.math) return b.math-a.math;

            return a.name.compareTo(b.name); 

        } );
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++){

            

            sb.append(list.get(i).name).append("\n");

        }
        String answer = sb.toString();
        System.out.println(answer);

    }

}
