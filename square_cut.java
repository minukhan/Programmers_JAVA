class square_cut {
    public int square_cut(int M, int N) {
        int answer = 0;
        
        answer = M-1 + (N-1)*M;
        
        return answer;
    }
}