public class loops {
    public static void main(String[] args){
        int sum = 0;
        int sum2 = 0;
        for (int i = 0; i < 10; ++i){
            sum += i;
        }
        for (int i = 0; i < 10; i++){
            sum2 += i;
        }System.out.println(sum);
        System.out.println(sum2);
    }
}