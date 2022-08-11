package FileReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile implements AbstractFile{
    private File SOURCE;
    private Properties DATA;

    public PropertiesFile(){
        DATA = new Properties();
    }

    public PropertiesFile(File source) throws IOException {
        SOURCE = source;
        load();
    }

    @Override
    public final Object get(String key) {
        return DATA.get(key);
    }

    @Override
    public final void set(String key, Object value) {
        DATA.setProperty(key,value.toString());
    }

    @Override
    public final void load() throws IOException {
        FileInputStream IN = new FileInputStream(SOURCE);
        DATA = new Properties();
        DATA.load(IN);
        IN.close();
    }

    @Override
    public void save() throws IOException {
        FileOutputStream OUT = new FileOutputStream(SOURCE);
        DATA.store(OUT,null);
        OUT.close();
    }

    @Override
    public File getSource() {
        return SOURCE;
    }
}
