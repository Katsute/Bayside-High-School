package WebServer.Server2Java;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public final class StaticHttpHandler extends HttpHandler {
    private final String content;

    public StaticHttpHandler(String content){
        this.content = content;
    }

    @Override
    public String handleRequest(HttpExchange exchange) {
        return content;
    }
}
