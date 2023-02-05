import java.io.IOException;
import java.io.*;
import java.net.*;
public class TcpClient {
    public static void main(String[] args) throws IOException{
        Socket cs = new Socket(InetAddress.getLocalHost(), 3000);
        System.out.println("Enter file name");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filename = br.readLine();

        OutputStream os = cs.getOutputStream();
        PrintWriter pw = new PrintWriter(os,true);
        pw.println(filename);

        InputStream is = cs.getInputStream();
        BufferedReader content = new BufferedReader(new InputStreamReader(is));

        String str;
        while((str = content.readLine()) != null) {
            System.out.println(str);
        }
    }
}
