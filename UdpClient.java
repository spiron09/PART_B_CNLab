import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        DatagramPacket dp;
        byte [] buffer;
        String info;
        Scanner sc;
        while (true){
            sc = new Scanner(System.in);
            info = sc.nextLine();
            buffer = info.getBytes();
            dp = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("Localhost"), 1234);
            ds.send(dp);
            if(info.equalsIgnoreCase("exit")){
                break;
            }
        }
        ds.close();
    }
}
