import java.util.Scanner;

public class LeakyBucket {
    public static void main(String[] args) {
        int buc_size, buc_cont, rem_buc_cont, recv_pkt, op_rate, n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter bucket size: ");
        buc_size = sc.nextInt();
        System.out.println("Enter output rate: ");
        op_rate = sc.nextInt();
        System.out.println("Enter number of packets: ");
        n = sc.nextInt();
        int [] pkts = new int[n];
        System.out.println("Enter packets: ");
        for (int i = 0; i < n; i++) {
            pkts[i] = sc.nextInt();
        }
        rem_buc_cont = 0;
        buc_cont = 0;
        System.out.println("Recv_Packet\t Buc_Content\t Acc/Rej\t Rem_Buc_Content");
        for (int i = 0; i < n; i++) {
            recv_pkt = pkts[i];
            buc_cont = rem_buc_cont + recv_pkt;

            if (buc_cont > buc_size){
                buc_cont = rem_buc_cont;
                rem_buc_cont = buc_cont - op_rate;
                System.out.println(recv_pkt +"\t"+ buc_cont + "\tRej\t" + rem_buc_cont);
            }
            else {
                rem_buc_cont = buc_cont - op_rate;
                System.out.println(recv_pkt +"\t" + buc_cont + "\tAcc\t" + rem_buc_cont);
            }

        }
        while (rem_buc_cont>0){
            buc_cont = rem_buc_cont;
            rem_buc_cont = rem_buc_cont - op_rate;
            if (rem_buc_cont < 0) {
                rem_buc_cont = 0;
            }
        }
        System.out.println("-" +"\t" + buc_cont + "\t--\t" + rem_buc_cont);

    }
}
