import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private Server() {}

    static void runServer(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        System.out.println("Connected");

        PrintStream printStream = new PrintStream(socket.getOutputStream());
        BufferedReader clientBufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboardBufferedReader = new BufferedReader(new InputStreamReader(System.in));

        printStream = new PrintStream(socket.getOutputStream());
        clientBufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        keyboardBufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String msgSendS, msgReceiveS;
        while (true) {
        while ((msgReceiveS = clientBufferedReader.readLine()) != null) {
            System.out.println(socket.getRemoteSocketAddress() + "| " + msgReceiveS); 

            msgSendS = keyboardBufferedReader.readLine();
            printStream.println(msgSendS);

        }
        clientBufferedReader.close();
        keyboardBufferedReader.close();
        printStream.close();
        socket.close();
        serverSocket.close();
        }
    }

}
