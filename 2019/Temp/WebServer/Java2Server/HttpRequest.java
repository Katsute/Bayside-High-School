package WebServer.Java2Server;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public final class HttpRequest {
    public static String get(String url){
        return Unirest.get(url)
            .getBody()
            .toString();
    }

    public static String getRaw(String url) throws UnirestException {
        return Unirest.get(url)
            .asString()
            .getBody();
    }

    public static void post(String url){
        // Unirest.post(url);
    }
}
