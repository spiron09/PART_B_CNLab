import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.*;
public class UdpServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(1234);
        DatagramPacket dp;
        byte[] buffer;
        Scanner sc;
        String info;

        while (true) {
            buffer = new byte[4000];
            dp = new DatagramPacket(buffer, buffer.length);
            ds.receive(dp);
            info = new String(buffer).trim();
            System.out.println(info);
            if(info.equalsIgnoreCase("exit")){
                break;
            }
        }

        ds.close();
    }
}
