package Main;

import java.sql.*;

public class DBHelper {
    private Connection conn;
    private Statement stmt;
    /*
            * Constructor
     */
    public DBHelper(String filePath) throws SQLException{
        String url = "jdbc:sqlite:" + filePath;

        conn = DriverManager.getConnection(url);
        stmt = conn.createStatement();
    }
    /*
            * Select
     */
    public ResultSet selectQuery(String tableName) throws SQLException {
        String sql = String.format("SELECT * FROM %s", tableName);
        return stmt.executeQuery(sql);
    }

    public ResultSet selectQuery(String tableName, String conditions) throws SQLException{
        String sql = String.format("SELECT * FROM %s WHERE %s",tableName, conditions);
        return stmt.executeQuery(sql);
    }
    /*
            * Insert
     */
    public void insertQuery(String tableName, String columns, String values) throws SQLException{
        String sql = String.format("INSERT INTO %s(%s) VALUES(%s)", tableName, columns, values);
        stmt.executeUpdate(sql);
    }

    public void insertQuery(String tableName, String[] columns, String[] values) throws SQLException{
        String cl = "";
        for(int index = 0; index < columns.length; index ++){
            cl += columns[index] + ",";
        }
        cl = cl.substring(0,cl.length()-1); // Void last comma
        String vl = "";
        for(int index = 0; index < values.length; index ++){
            vl += "\"" + values[index] + "\"" + ",";
        }
        vl = vl.substring(0,vl.length()-1); // Void last comma

        String sql = String.format("INSERT INTO %s(%s) VALUES (%s)", tableName, cl, vl);
        stmt.executeUpdate(sql);
    }
    /*
            * Update
     */
    public void updateQuery(String tableName, String valueChange, String conditions) throws SQLException{
        String sql = String.format("UPDATE %s SET %s WHERE %s", tableName, valueChange, conditions);
        stmt.executeUpdate(sql);
    }

    public void updateQuery(String tableName, String[] columns, String[] values, String conditions) throws SQLException{
        String vc = "";
        for(int index = 0; index< columns.length; index ++){
            vc += columns[index] + " = '" + values[index] + "',";
        }
        vc = vc.substring(0,vc.length()-1); // Void last comma

        String sql = String.format("UPDATE %s SET %s WHERE %s", tableName, vc, conditions);
        stmt.executeUpdate(sql);
    }

    public void updateQuery(String tableName, String[] valueChange, String conditions) throws SQLException{
        String vc = "";
        for(int index = 0; index< valueChange.length; index ++){
            vc += valueChange[index] + ",";
        }
        vc = vc.substring(0,vc.length()-1); // Void last comma

        String sql = String.format("UPDATE %s SET %s WHERE %s", tableName, vc, conditions);
        stmt.executeUpdate(sql);
    }
    /*
            * Delete
     */
    public void deleteQuery(String tableName, String conditions) throws SQLException{
        String sql = String.format("DELETE FROM %s WHERE %s", tableName, conditions);
        stmt.executeUpdate(sql);
    }
}