import java.lang.Math;

public class Matr {
    public static void main(String[] args) {
        int[][] mas;
        int[][] out;
        mas = Str_2d_to_Int_2d(args);
        print_2d_arr(mas, mas.length, mas.length);
        out = create_B(mas);
        print_2d_arr(out, out.length, out.length);
    }


    private static int[][] Str_2d_to_Int_2d(String[] in) {
        int[][] mas = new int[(int) Math.sqrt(in.length)][(int) Math.sqrt(in.length)];
        for(int  i = 0; i<Math.sqrt(in.length); i++) {
            for(int j = 0; j<Math.sqrt(in.length); j++){
                mas[i][j] = Integer.parseInt(in[(int) (Math.sqrt(in.length) * j + i)]);
            }
        }
        return mas;
    }

    private static void print_2d_arr(int[][] arr, int len_i, int len_j) {
        int max_el = 0;
        int val = 0;
        for (int i = 0; i < len_i; i++) {
            for (int j = 0; j < len_j; j++) {
                if (String.valueOf(arr[i][j]).contains(".")) {//catch float/double
                    System.out.println("double/float!");
                } else {//catch byte, short, int, long
                    val = String.valueOf(arr[i][j]).length();
                }
                if (val > max_el) {
                    max_el = val;
                }
            }
        }
        int max_ind = Math.max(String.valueOf(len_i).length(), String.valueOf(len_j).length());
        int max = Math.max(max_el, max_ind);
        max++;
        System.out.print("j\\i|");
        for (int  i = 0; i<arr.length; i++) {
            System.out.print(i);
            for (int j = 0; j < (max-String.valueOf(i).length()); j++) System.out.print(" ");
        }
        System.out.println();

        for (int i=0; i < (4+((max)*len_i)); i++) {
            System.out.print("-");
        }
        System.out.println();

        for (int  j = 0; j<arr.length; j++) {
            System.out.print(j + "  |");
            for (int[] ints : arr) {
                System.out.print(ints[j]);
                for (int k = 0; k < (max - String.valueOf(ints[j]).length()); k++) System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[][] create_B (int[][] A) {
        int[][] B = new int[A.length][A[0].length];
        int s;
        for (int i = 0; i<B.length; i++) {
             for (int j = 0; j < B[i].length; j++) {
                 B[i][j] = 0;
             }
         }
         for (int i = 0; i<A.length; i++){
            for (int j = 0; j<A[i].length; j++){
                s = 0;
                for (int k = -1; k<=1; k++){
                    for (int l = -1; l<=1; l++){
                        try {
                            if ((A[i][j] == A[i+k][j+l]) && !((k == 0) && (l == 0))) {
                                s++;
                            }
                        } catch (IndexOutOfBoundsException ignored) {}
                    }
                }
                if (s>=2) {
                    B[i][j] = 1;
                }
            }
        }
        return B;
    }
}


