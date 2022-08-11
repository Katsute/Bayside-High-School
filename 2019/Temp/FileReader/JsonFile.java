package FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonFile implements AbstractFile {
    private File SOURCE;
    private JSONObject DATA;

    public JsonFile(String content) throws ParseException {
        if(!content.startsWith("{")){
            content = "{" + content;
        }
        if(!content.endsWith("}")){
            content = content + "}";
        }

        DATA = (JSONObject) new JSONParser().parse(content);
    }

    public JsonFile(File source) throws IOException, ParseException {
        SOURCE = source;
        load();
    }

    @Override
    public final Object get(String key) {
        if(key == null){
            return DATA.toString();
        }else{
            return DATA.get(key);
        }
    }

    @Override @SuppressWarnings("unchecked")
    public final void set(String key, Object value) {
        DATA.put(key,value);
    }

    @Override
    public final void load() throws IOException, ParseException {
        FileReader IN = new FileReader(SOURCE);
        DATA = (JSONObject) new JSONParser().parse(IN);
        IN.close();
    }

    @Override
    public final void save() throws IOException {
        FileWriter OUT = new FileWriter(SOURCE);
        DATA.writeJSONString(OUT);
        OUT.close();
    }

    public final File getSource(){
        return SOURCE;
    }
}
