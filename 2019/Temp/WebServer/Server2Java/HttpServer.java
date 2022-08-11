package WebServer.Server2Java;

import JavaX.Variable.Tuple.TwoPointVariable;
import KttStyle.Style.ConsoleStyle;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class HttpServer {
    private com.sun.net.httpserver.HttpServer server;

    public HttpServer(int port) throws IOException {
        server = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(port),0);
        server.setExecutor(null);
    }

    public final void start(){
        server.start();
        System.out.println(ConsoleStyle.GREEN + "Server started at " + server.getAddress() + ConsoleStyle.RESET);
    }

    public final void stop(){
        server.stop(0);
        System.out.println(ConsoleStyle.RED + "Server stopped" + ConsoleStyle.RESET);
    }

    public final void createPage(String path, String content){
        if(!path.startsWith("/"))
            path = "/" + path;
        server.createContext(path, new StaticHttpHandler(content));
    }

    public final void createPage(String path, HttpHandler handler){
        if(!path.startsWith("/"))
            path = "/" + path;
        server.createContext(path,handler);
    }

    public final void replacePage(String path, String content){
        if(!path.startsWith("/"))
            path = "/" + path;
        deletePage(path);
        createPage(path, content);
    }

    public final void replacePage(String path, HttpHandler handler){
        if(!path.startsWith("/"))
            path = "/" + path;
        deletePage(path);
        createPage(path, handler);
    }

    public final void deletePage(String path){
        if(!path.startsWith("/"))
            path = "/" + path;
        server.removeContext(path);
    }

    public static List<TwoPointVariable> queryToList(String query){
        List<TwoPointVariable> data = new ArrayList<>();

        for(String param : query.split("&")){
            String key, value;
            if(
                param.contains("=") &&
                param.indexOf("=") == param.lastIndexOf("=")
            ){
                key = param.substring(0,param.indexOf("="));
                value = param.substring(param.indexOf("=") + 1);
            }else{
                key = param;
                value = "";
            }
            value = value.replaceAll("\\+", " ");
            data.add(new TwoPointVariable(key, value));
        }
        return data;
    }

}
