import java.util.Scanner;

public class Sudoko {

    public static boolean isValidSet(int[] arr){
        boolean[] check = new boolean[10];
        for(int a : arr){
            if(a < 1 || a > 9 || check[a]) return false;
            else check[a] = true;
        }
        return true;
    }

    public static boolean isSudoko(int[][] arr){
        for(int i = 0; i < 9; i++){
            if(!isValidSet(arr[i])) return false;
        }

        for(int i = 0; i < 9; i++){
            int[] cot = new int[9];
            for(int j = 0; j < 9; j++){
                cot[j] = arr[j][i];
            }
            if(!isValidSet(cot)) return false;
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                int[] block = new int[9];
                int index = 0;
                for(int l = i*3; l < i*3 + 3; l++){
                    for(int r = j*3; r < j*3 + 3; r++){
                        block[index++] = arr[l][r];
                    }
                }
                if(!isValidSet(block)) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] a = new int[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                a[i][j] = sc.nextInt();
            }
        }
        if(isSudoko(a)) System.out.println("sudoko hợp lệ !");
        else System.out.println("sudoko không hợp lệ !");
    }
}
