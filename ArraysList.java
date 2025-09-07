import java.util.Scanner;

public class ArraysList {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        System.out.print("Masukan batas: \n");
       int a = sc.nextInt();
       int b[] = new int[a];
        for (int i = 0; i < b.length; i++) {
            System.out.print("angke ke-"+ i);
            b[i]=sc.nextInt();

        }
        System.out.println(b);
    }
}
