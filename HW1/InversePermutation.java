import java.util.Scanner;

public class InversePermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            if(x < 0 || x >= n) return;
            else a[i] = x;
        }
        int[] b = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(a[j] == i){
                    b[i] = j;
                    break;
                }
                else continue;
            }
            b[a[i]] = i;
        }
        for(int i = 0; i < n; i++){
            System.out.print(b[i]+" ");
        }
    }
}
