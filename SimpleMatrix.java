
import java.util.Scanner;

public class SimpleMatrix {
    public static void main(String args[]) {
        System.out.println("Enter row/column: ");
        Scanner s = new Scanner(System.in);
        int r = s.nextInt();
        int c = s.nextInt();
        int arr[][] = new int[r][c];
        
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++) {
                arr[i][j] = s.nextInt();
                
            }
        }
        int i = 0, j = 0;
        int a;
        System.out.println("Matrix is: ");
        
        while (i <= c/2 && j <= r/2) {
            for (a = i; a < c - j-1; a++) {
                System.out.print(arr[i][a] + ">");
            }
            
            for (a = j; a < r-j; a++){
                System.out.print(arr[a][c-j-1] + "|");
            }
            
            for (a = c-j-2; a >= j && r-i-1 != j; a--){
                System.out.print(arr[r-i-1][a] + "<");
            }
            
            for (a = r-i-2; a > i && c-j-1 != j; a--){
                System.out.print(arr[a][j] + "^");
            }
            
            i++;
            j++;
        }
        
        
    }
}
