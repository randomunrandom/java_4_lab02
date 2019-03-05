//import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int mas[];
//        mas = create_Int_arr_from_String_arr(args);
        mas = read_from_stdin();
        print_Int_arr(mas);
        square_Int_array(mas);
        print_Int_arr(mas);
        mas = sort_array(mas);
        print_Int_arr(mas);
    }
    private static int[] read_from_stdin() {
        Scanner in = new Scanner(System.in);
        System.out.println("----------");
        System.out.println("Введите размер массива");
        int n = in.nextInt();
        int mas[] = new int[n];
        for(int  i = 0; i<n; i++) {
            System.out.print((i + 1) + ": ");
            mas[i] = in.nextInt();
        }
        System.out.println("----------");
        return mas;
    }

    private static int[] create_Int_arr_from_String_arr(String in[]) {
        int mas[] = new int[in.length];
        for(int  i = 0; i<in.length; i++) {
            mas[i] = Integer.parseInt(in[i]);
        }
        return mas;
    }

    private static void print_Int_arr(int arr[]) {
        System.out.println("----------");
        for(int  i = 0; i<arr.length; i++) {
            System.out.println(i + ": " + arr[i]);
        }
        System.out.println("----------");
    }

    private static void square_Int_array(int arr[]) {
        for(int  i = 0; i<arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
    }

    private static int[] sort_array(int arr[]) {
        int mas[] = Arrays.copyOf(arr, arr.length);
        Arrays.sort(mas);
        return mas;
    }
}
