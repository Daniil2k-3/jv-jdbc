package mate.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unable to load JDBC driver", e);
        }
    }

    public static Connection getConnection() {
        try {
            Properties dbProperties = new Properties();
            dbProperties.put("user", "root");
            dbProperties.put("password", "gnrPswrd");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/taxi_app_db",
                    dbProperties);
        } catch (SQLException f) {
            throw new RuntimeException("Connection failed", f);
        }
    }
}