package WebServer;

import FileReader.AbstractFile;
import FileReader.TextFile;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;

public class HtmlFile implements AbstractFile {
    private File SOURCE;
    private Document DATA;

    public HtmlFile(String content){
        DATA = Jsoup.parse(content);
    }

    public HtmlFile(File source) throws IOException {
        SOURCE = source;
        load();
    }

    @Override
    public final Object get(String id) {
        if(id == null){
            return DATA.toString();
        }else{
            return DATA.getElementById(id);
        }
    }

    @Override
    public final void set(String key, Object value) {

    }

    @Override
    public void load() throws IOException {
        try{
            DATA = Jsoup.connect(SOURCE.getPath()).get();
        }catch (MalformedURLException | IllegalArgumentException ignored){
            DATA = Jsoup.parse(new TextFile(SOURCE).get(null).toString());
        }
    }

    @Override
    public final void save() throws IOException {
        BufferedWriter writer = new BufferedWriter( new FileWriter(SOURCE.getPath()));
        writer.write(DATA.toString());
        writer.close();
    }

    public final File getSource(){
        return SOURCE;
    }
}
