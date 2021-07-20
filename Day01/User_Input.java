import java.util.Scanner;

public class User_Input {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int val_1 = input.nextInt(),
            val_2 = input.nextInt();
        System.out.println(val_1 + val_2);
        input.close();
    }
}
