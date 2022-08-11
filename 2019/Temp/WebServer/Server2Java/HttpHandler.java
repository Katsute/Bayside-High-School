package WebServer.Server2Java;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class HttpHandler implements com.sun.net.httpserver.HttpHandler {
    @Override
    public final void handle(HttpExchange httpExchange) {
        try {
            String content = handleRequest(httpExchange);
            httpExchange.sendResponseHeaders(200, content.length());

            OutputStream OUT = httpExchange.getResponseBody();
            OUT.write(content.getBytes());
            OUT.close();
        } catch (IOException ignored) {
        }
    }

    public String handleRequest(HttpExchange exchange){
        return "";
    }
}
