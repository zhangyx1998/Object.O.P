/*
 * Code By Yuxuan Zhang, 2160909016
 * Xian Jiao Tong University
 */

public class Loop{
    public static void main(String[] args) {
        System.out.println("N\t10*N\t100*N\t1000*N");
        for (int N = 1; N <= 5; N++){
            System.out.println(
                N + "\t" + 10 * N + "\t" + 100 * N + "\t" + 1000 * N
            );
        }
    }
}