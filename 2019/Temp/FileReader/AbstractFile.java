package FileReader;

import java.io.File;

public interface AbstractFile {
    Object get(String key) throws Exception;

    void set(String key, Object value) throws Exception;

    void load() throws Exception;

    void save() throws Exception;

    File getSource();
}
