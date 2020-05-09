package hotel.dao;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBHelper {

	public static Connection ConnectToDB() throws Exception {
		Context context = new InitialContext();
                DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/EWebServices");
                Connection c = dataSource.getConnection();
                return c;
	}

}
