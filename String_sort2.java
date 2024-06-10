class String_sort2 {
    public int String_sort2(String my_string) {
        int answer = 0;
        String k = "";
        int len = my_string.length();
        
        for (int i = 0; i < len; i++) {
            char currentChar = my_string.charAt(i);
            if (Character.isDigit(currentChar)) {
                k += currentChar;
            } else {
                if (!k.equals("")) {
                    answer += Integer.parseInt(k);
                    k = "";
                }
            }
        }

        // 마지막에 남아 있는 숫자 처리
        if (!k.equals("")) {
            answer += Integer.parseInt(k);
        }

        return answer;
    }
}
