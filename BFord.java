
import java.util.Scanner;

public class BFord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int source;
        System.out.println("Enter number of vertices: ");
        n = sc.nextInt();
        int ad[][] = new int[n][n];

        System.out.println("Enter adjacency matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ad[i][j] = sc.nextInt();
            }
        }

        System.out.println("enter the source: ");
        source = sc.nextInt();

        belFord(ad,n,source);

        sc.close();

    }

    private static void belFord(int[][] ad, int n, int source) {
        int d[] = new int[n];

        for (int i = 0; i < d.length; i++) {
            d[i] = 999;
        }

        d[source] = 0;

        for (int i = 0; i < n; i++) {
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    if(d[u] != 999){
                        if (d[v] > d[u] + ad[u][v]) {
                            d[v] = d[u] + ad[u][v];
                        }
                    }
                }
            }
        }

        for (int i = 0; i < d.length; i++) {
            System.out.println("distance of" + source + "to" + i + "is:" + d[i]);
        }
    }


}