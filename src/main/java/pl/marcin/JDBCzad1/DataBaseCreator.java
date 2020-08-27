package pl.marcin.JDBCzad1;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class DataBaseCreator{

    static Connection con;
    static String connectionString = "jdbc:hsqldb:file:DB-data/mojeDane;user=admin123;password=admin123";
    public void createAndLoadData() throws Exception {
        String createContacts = readToString("SQL/Movies_creator.sql");
        String populateContacts = readToString("SQL/Movies_loadData.sql");

        System.out.println("Attempting to create contacts DB ... ");


        try {
            con = DriverManager.getConnection(connectionString, "admin123", "admin123");

            con.createStatement().executeUpdate(createContacts);
           con.createStatement().executeUpdate(populateContacts);

        } catch (SQLException e) {
            throw e;
        } finally {
            con.close();
        }
    }

    public static String readToString(String fname) throws Exception {
        File file = new File(fname);
        String string = FileUtils.readFileToString(file, "utf-8");
        return string;
    }


}
