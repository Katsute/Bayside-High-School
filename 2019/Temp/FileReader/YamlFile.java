package FileReader;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlWriter;
import com.esotericsoftware.yamlbeans.document.YamlDocument;
import com.esotericsoftware.yamlbeans.document.YamlDocumentReader;
import com.esotericsoftware.yamlbeans.document.YamlSequence;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class YamlFile implements AbstractFile {
    private File SOURCE;
    private YamlDocument DATA;

    public YamlFile(String content) throws YamlException {
        DATA = new YamlDocumentReader(content).read();
    }

    public YamlFile(File source) throws Exception {
        SOURCE = source;
        load();
    }

    @Override
    public final Object get(String key) throws YamlException {
        return DATA.getEntry(key);
    }

    public final List getList(String key) throws YamlException {
        List<String> list = new ArrayList<>();
        YamlSequence seq = (YamlSequence) DATA.getEntry(key).getValue();
        for(int index = 0; index < seq.size();index++){
            list.add(seq.getElement(index).toString());
        }
        return list;
    }

    @Override
    public final void set(String key, Object value) throws YamlException {
        DATA.setEntry(key,value.toString());
    }

    public final void setValue(String key, List value) throws YamlException {
        YamlSequence seq = new YamlSequence();
        for(int index = 0; index < value.size(); index++){
            seq.addElement(String.valueOf(value.get(index)));
        }
        DATA.setEntry(key,seq);
    }

    @Override
    public final void load() throws Exception {
        FileReader IN = new FileReader(SOURCE);
        DATA = new YamlDocumentReader(IN).read();
        IN.close();
    }

    @Override
    public final void save() throws IOException {
        FileWriter OUT = new FileWriter(SOURCE);
        YamlWriter OUT2 = new YamlWriter(OUT);

        OUT2.write(DATA);
        OUT2.close();
        OUT.close();
    }

    public final File getSource(){
        return SOURCE;
    }
}
