package JinSS_coding_YT;

public class Lotto {
    
    private int[] ball;
    
    public Lotto(){
        ball = new int[6];
    }

    public int[] getBall(){
        return ball;
    }

    // {4,6,1,8,7,9}안의 수와 5를 비교하면 false
    // 6과 비교하면 true
    private boolean isSame(int[] a, int b){
        boolean isS = false;
        for (int i=0; i<a.length; i++){
            if (a[i] == b){
                isS = true;
                break;
            }
        }
        return isS;
    }

    // 원하는 수의 배열 만들기
    public void make(){
        int cnt = 0;
        while (true){
            //Math.random() 0<=n<1까지 실수 => 0 ~ 0.99999999
            int b = (int)(Math.random()*45)+1 ;// => 0 ~ 44.99999 => 1 ~ 45.9999
            if (!(isSame(ball, b))){
                ball[cnt++] = b;
            }
            if (cnt == 6){
                break;
            }
        }
    }

}
