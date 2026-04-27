import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    public void run(int portNumber) {
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Serveur démarré sur le port " + portNumber);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                RequestProcessor processor = new RequestProcessor(clientSocket);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
