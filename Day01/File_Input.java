import java.io.FileInputStream;
import java.util.Scanner;
import java.io.IOException;

public class File_Input {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new FileInputStream("File_Input.in"));
        int val_1 = input.nextInt(),
            val_2 = input.nextInt();
        System.out.println(val_1 + val_2);
        input.close();
    }
}