class Compare_to_study {
    public String[] Compare_to_study(String[] strings, int n) {
        String temp;

        for (int j = 0; j < strings.length; j++) {
            for (int i = 0; i < strings.length - 1 - j; i++) {
                if (strings[i].charAt(n) > strings[i + 1].charAt(n)) {
                    // n번째 문자를 기준으로 정렬
                    temp = strings[i];
                    strings[i] = strings[i + 1];
                    strings[i + 1] = temp;
                } else if (strings[i].charAt(n) == strings[i + 1].charAt(n)) {
                    // n번째 문자가 같으면 사전순으로 정렬
                    if (strings[i].compareTo(strings[i + 1]) > 0) {
                        temp = strings[i];
                        strings[i] = strings[i + 1];
                        strings[i + 1] = temp;
                    }
                }
            }
        }
        return strings;
    }
}
