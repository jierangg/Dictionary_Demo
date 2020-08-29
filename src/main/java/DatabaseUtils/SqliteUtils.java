package DatabaseUtils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class SqliteUtils {
    public static DataSource dataSource=null;
    public SqliteUtils() {
        if (dataSource==null){
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl("jdbc:sqlite::resource:lookup.db");
            config.setUsername("root");
            config.setPassword("password");
            config.addDataSourceProperty("connectionTimeout", "1000"); // 连接超时：1秒
            config.addDataSourceProperty("idleTimeout", "60000"); // 空闲超时：60秒
            config.addDataSourceProperty("maximumPoolSize", "10"); // 最大连接数：10
            dataSource = new HikariDataSource(config);
        }
    }
    public static DataSource getDataSource() {
        return dataSource;
    }
}
