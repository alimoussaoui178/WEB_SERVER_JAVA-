import java.net.Socket;

public class RequestProcessor {
    private HttpContext context;

    public RequestProcessor(Socket socket) {
        this.context = new HttpContext(socket);
    }

    private void process() {
        String url = context.getRequest().getUrl();

        if (url.equals("/")) {
            context.getResponse().ok("OK");
        } else {
            context.getResponse().notFound("Not Found");
        }

        context.close();
    }
}
