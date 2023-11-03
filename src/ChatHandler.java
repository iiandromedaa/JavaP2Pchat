import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatHandler {

    public static void main(String[] args) throws Exception {
        final String os = System.getProperty("os.name");
        Scanner scanscan = new Scanner(System.in);
        System.out.println("Welcome to Jchat! Your host is: " + InetAddress.getLocalHost().getHostAddress());
        switch(CLUtility.switchValidator("1) Host \n2) Connect to host \n3) Exit", 3, scanscan)) {
            case 1:
                CLUtility.clear(os);
                try {
                    Server.runServer();
                } catch (IOException e) {
                    System.exit(1);
                }
            case 2:
                CLUtility.clear(os);
                while (true) {
                    try {
                        System.out.println("Enter host to connect: ");
                        String host = scanscan.next();
                        Client.runClient(host);
                        break;
                    } catch (ConnectException e) {
                        System.out.println("Connection refused.");
                    } catch (UnknownHostException e) {
                        System.out.println("Host is invalid or unreachable.");
                    }
                }
            case 3:
                scanscan.close();
                System.exit(0);
        }
    }
    
}
