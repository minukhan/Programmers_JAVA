class number_sort_count {
    public String number_sort_count(String s) {
        String answer = "";
        char[] arr = s.toCharArray();
        char change;
        
        // 버블 정렬로 문자열 정렬
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < s.length() - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    change = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = change;
                }
            }
        }
        
        boolean a = true;
        int count = 0;
        
        for (int i = 0; i < s.length() - 1; i++) {
            a = true;
            count = 0;
            while (a) {
                if (arr[i] == arr[i + 1]) {
                    count++;
                    i++;
                    if (i >= s.length() - 1) {
                        break;
                    }
                } else {
                    a = false;
                }
            }
            if (count == 0) {
                answer += arr[i];
            }
        }
        
        // 마지막 문자 처리
        if (s.length() > 1 && arr[s.length() - 1] != arr[s.length() - 2]) {
            answer += arr[s.length() - 1];
        } else if (s.length() == 1) {
            answer += arr[0];
        }
        
        return answer;
    }
}
