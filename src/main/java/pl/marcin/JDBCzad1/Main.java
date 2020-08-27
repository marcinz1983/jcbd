package pl.marcin.JDBCzad1;

import pl.marcin.JDBCzad1.models.MoviesDB;
import pl.marcin.JDBCzad1.moviesDAO.MoviesDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {


        DataBaseCreator dataBaseCreator = new pl.marcin.JDBCzad1.DataBaseCreator();
        dataBaseCreator.createAndLoadData();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection
                    ("jdbc:hsqldb:file:DB-data/mojeDane;user=admin123;password=admin123"
                            , "admin123", "admin123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        MoviesDAO moviesDAO = new MoviesDAO(connection);
        moviesDAO.getAll().forEach(System.out::println);


        MoviesDB moviesDB = new MoviesDB("Obcy","SF","1990");
        System.out.println("****************");

        moviesDAO.updateMovie(2,moviesDB);

        System.out.println("****************\n");

        moviesDAO.getAll().forEach(System.out::println);

        System.out.println("****************\n");

        moviesDAO.deleteMovie(2);

        moviesDAO.getAll().forEach(System.out::println);








        connection.close();
    }
}


