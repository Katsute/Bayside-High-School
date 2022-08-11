package FileReader;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLFile implements AbstractFile {
    private File SOURCE;
    private Connection DATA;

    public SQLFile(File source) throws SQLException {
        SOURCE = source;
        load();
    }

    @Override
    public Object get(String key) {
        return null;
    }

    @Override
    public void set(String key, Object value) {

    }

    @Override
    public void load() throws SQLException {
        DATA = DriverManager.getConnection(SOURCE.getPath());
    }

    @Override
    public void save() {

    }

    @Override
    public File getSource() {
        return SOURCE;
    }

    public ResultSet getTable(String table) throws SQLException {
        return DATA.createStatement().executeQuery(
            String.format(
                "SELECT * FROM %s",
                table
            )
        );
    }

    public ResultSet getTable(String table, String conditions) throws SQLException {
        return DATA.createStatement().executeQuery(
            String.format(
                "SELECT * FROM %s WHERE %s",
                table, conditions
            )
        );
    }

    public void insertValue(String table, String key, String value) throws SQLException {
        DATA.createStatement().executeUpdate(
            String.format(
                    "INSERT INTO %s(%s) VALUES(%s)",
                    table, key, value
            )
        );
    }

    public void insertValue(String table, String[] keys, String[] values) throws SQLException {
        StringBuilder cTemp = new StringBuilder();

        for(String key:keys){
            cTemp.append(key).append(",");
        }
        cTemp.delete(cTemp.length()-1,cTemp.length());

        StringBuilder vTemp = new StringBuilder();

        for(String val:values){
            vTemp.append(val).append(",");
        }
        vTemp.delete(vTemp.length()-1,vTemp.length());

        insertValue(table,cTemp.toString(),vTemp.toString());
    }

    public void updateValue(String table, String formula, String conditions) throws SQLException {
        DATA.createStatement().executeUpdate(
            String.format(
                "UPDATE %s SET %s WHERE %s",
                table,formula,conditions
            )
        );
    }

    public void updateValue(String table, String[] keys, String[] values, String condition) throws SQLException {
        StringBuilder temp = new StringBuilder();

        for(int index = 0; index < keys.length; index++){
            temp.append(keys[index]).append(" = '").append(values[index]).append("',");
        }

        temp.delete(temp.length()-1,temp.length());

        DATA.createStatement().executeUpdate(
            String.format(
                "UPDATE %s SET %s WHERE %s",
                table, temp.toString(), condition
            )
        );
    }

    public void updateValue(String table, String[] formulas, String conditions) throws SQLException {
        StringBuilder temp = new StringBuilder();
        for(String formula:formulas){
            temp.append(formula).append(",");
        }
        temp.delete(temp.length()-1,temp.length());

        DATA.createStatement().executeUpdate(
            String.format(
                "UPDATE %s SET %s WHERE %s",
                table, temp.toString(), conditions
            )
        );
    }

    public void deleteValue(String table, String conditions) throws SQLException {
        DATA.createStatement().executeUpdate(
            String.format(
                "DELETE FROM %s WHERE %s",
                    table, conditions
            )
        );
    }
}
