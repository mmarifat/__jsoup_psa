package com.mmarifat.web.scraping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mmarifat
 */
public class Connector {

    public static Connection localMysql;
    private static final String localMSPassword = "";
    private static final String localMSUsername = "";
    private static final String localMSHostPort = "";
    private static final String localMSDatabase = "";

    public static String selectSql;
    public static String lastSql = "";

    public static Connection connection;

    public Connection localMysql() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            localMysql = DriverManager.getConnection("jdbc:mysql://" + localMSHostPort + "/" + localMSDatabase, localMSUsername, localMSPassword);
            //System.out.println("mysqlLocal");
        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return localMysql;
    }

    public Connector() {
        connection = localMysql();
    }

    public int insert(String Table, HashMap<String, Object> data) {
        int flag = 0;
        String col = "";
        String dat = "";
        for (Entry m : data.entrySet()) {
            col += "`" + m.getKey().toString() + "`, ";
            dat += "? , ";
        }

        col = col.substring(0, col.length() - 2);
        dat = dat.substring(0, dat.length() - 2);
        lastSql = "INSERT INTO `" + Table + "`( " + col + " ) VALUES ( " + dat + " )";
        try {
            try (PreparedStatement ps = connection.prepareStatement(lastSql)) {
                int i = 1;
                for (Entry m : data.entrySet()) {
                    if (m.getValue().getClass().getTypeName().equals("byte[]")) {
                        ps.setBytes(i, (byte[]) m.getValue());
                    } else {
                        ps.setString(i, m.getValue().toString());
                    }
                    i++;
                }
                flag = ps.executeUpdate();
                ps.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public int countRow(String Table, HashMap<String, Object> where) {
        int count = 0;
        String whr = "";
        if (where != null) {
            for (Entry m : where.entrySet()) {
                whr += "`" + m.getKey().toString() + "` = '" + m.getValue().toString() + "' AND ";
            }
            whr = " WHERE " + whr.substring(0, whr.length() - 5);
        } else {
            whr = "";
        }
        String sql = "SELECT COUNT(*) AS count FROM  `" + Table + "`" + whr;
        // System.out.println(sql);
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            result.next();
            count = result.getInt("count");
            result.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
}
