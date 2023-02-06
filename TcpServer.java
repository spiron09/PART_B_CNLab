import java.io.IOException;
import java.io.*;
import java.net.*;
public class TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(3000);
        System.out.println("Server is listening");
        Socket s = ss.accept();
        System.out.println("Connection Established");

        InputStream is = s.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String filename = br.readLine();
        System.out.println("File name recieved: " + filename);

        BufferedReader content = new BufferedReader(new FileReader(filename));
        OutputStream os = s.getOutputStream();

        PrintWriter pw = new PrintWriter(os,true);
        String str;
        while((str = content.readLine()) != null) {
            pw.println(str);
        }
    }
}
