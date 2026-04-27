import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class HttpRequest {
    private String method;
    private String url;

    public HttpRequest(Socket socket) {
        readClientRequest(socket);
    }

    private void readClientRequest(Socket socket) {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String firstLine = input.readLine();
            if (firstLine != null && !firstLine.isEmpty()) {
                String[] parts = firstLine.split(" ");
                method = parts[0];
                url = parts[1];
            }

            String line = input.readLine();
            while (line != null && !line.isEmpty()) {
                line = input.readLine();
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }
}
