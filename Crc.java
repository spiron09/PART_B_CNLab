import java.util.Arrays;
import java.util.Scanner;

class Crc {
    static int[] Div (int[] a, int []b, int n,int m) {
        for (int i = 0; i < n; i++) {
            if(i == 7){
                break;
            }
            if (a[i] == 1){
                for(int j =0; j<m; j++){
                    a[i+j] ^= b[j];
                }
            }
            else {
                continue;
            }
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of databits:");
        int n = sc.nextInt();
        System.out.println("Enter the no of generator bits");
        int m = sc.nextInt();

        int[] d = new int[m+n-1];
        int[] g = new int [m];
        System.out.println("Enter data");
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }

        System.out.println("Enter generator data");
        for (int i = 0; i < m; i++) {
            g[i] = sc.nextInt();
        }

        System.out.println("Data bits are:");
        for (int i = 0; i < n; i++) {
            System.out.print(d[i]);
        }

        for (int i =n; i<m-1;i++){
            d[i++] = 0;
        }

        System.out.println("\nGenerator bits are:");
        for (int i = 0; i < m; i++) {
            System.out.print(g[i]);
        }

        int[] r = new int[d.length];

        for (int i = 0; i<d.length; i++){
            r[i] = d[i];
        }

        int[] crc = Div(r,g,n,m);

        for(int i = d.length-1; i>m+1; i--){
            d[i] = crc[i];
        }
        System.out.println("Checksum");
        System.out.println();
        for (int i = 0; i < m+n-1; i++) {
            System.out.print(d[i]);
        }
        System.out.println("Enter reciever data: ");

        int[] r_d = new int[(n+m-1) + m-1];
        for (int i = 0; i < n+m-1; i++) {
            r_d[i] = sc.nextInt();
        }
        int[] r_r = new int[r_d.length + m-1];
        // r = a;
        for (int i = 0; i<r_d.length; i++){
            r_r[i] = r_d[i];
        }
        System.out.println(Arrays.toString(r_r));
        int[] r_crc = Div(r_r,g,r_r.length,n);
        System.out.println(Arrays.toString(r_crc));
        boolean t = true;
        for (int i = 0; i < r_crc.length; i++) {
            if(r_crc[i] == 1){
                t = false;
            }
        }

        if(t){
            System.out.println("Correct Data");
        }
        else{
            System.out.println("Wrong Data");
        }

        sc.close();

    }
}