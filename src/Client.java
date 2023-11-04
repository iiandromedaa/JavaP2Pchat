import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

    private Client() {}

    static void runClient(String host, int port) throws IOException {
        Socket socket = new Socket(host, port);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        BufferedReader ServerbufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboardBufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String msgSend, msgReceive;

        while (!(msgSend = keyboardBufferedReader.readLine()).equals("byeee")) {
            dataOutputStream.writeBytes(msgSend + "\n");
            
            msgReceive = ServerbufferedReader.readLine();
            System.out.println(socket.getRemoteSocketAddress() + "| " + msgReceive); 
        }
        dataOutputStream.close();
        ServerbufferedReader.close();
        keyboardBufferedReader.close();
        socket.close();
    }

}

