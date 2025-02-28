class number_sort {
    public static void number_sort(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        String A = br.readLine();

        st = new StringTokenizer(A);

        for(int i=0;i<n;i++){

            list.add(Integer.parseInt(st.nextToken()));

        }

        list.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(A);

        for(int i=0;i<n;i++){

            int number = Integer.parseInt(st.nextToken());
            for(int j=0;j<list.size();j++){
                if(number==list.get(j)){
                    list.set(j,1001);
                    sb.append(j).append(" ");
                    break;

                }
            }
        }
            System.out.println(sb.toString());
    }
}

