package FileReader;

import org.apache.commons.io.FileUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextFile implements AbstractFile {
    private File SOURCE;
    private String DATA;

    public TextFile(String content){
        DATA = content;
    }

    public TextFile(File source) throws IOException {
        SOURCE = source;
        load();
    }

    @Override
    public final Object get(String key) {
        return DATA;
    }

    @Override
    public final void set(String key, Object value) {
        DATA = value.toString();
    }

    @Override
    public final void load() throws IOException {
        DATA = FileUtils.readFileToString(SOURCE,"UTF-8");
    }

    @Override
    public final void save() throws IOException {
        BufferedWriter OUT = new BufferedWriter(new FileWriter(SOURCE));
        OUT.write(DATA);
        OUT.close();
    }

    @Override
    public final File getSource() {
        return SOURCE;
    }
}
