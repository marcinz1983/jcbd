package pl.marcin.JDBCzad1.moviesDAO;

import pl.marcin.JDBCzad1.models.MoviesDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MoviesDAO {

    private static Connection connection;

    public MoviesDAO(Connection connection) {
        this.connection = connection;
    }

    public List<MoviesDB> getAll() throws SQLException {
        List<MoviesDB> myMovies = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement("select * from Movies");
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String genre = resultSet.getString("genre");
            String yearOfRelease = resultSet.getString("yearOfRelease");
            //System.out.println(id + " : " + title + " : " + genre + " : " + yearOfRelease);
            MoviesDB moviesDB = new MoviesDB(id, title, genre, yearOfRelease);
            myMovies.add(moviesDB);
        }
        ps.close();
        resultSet.close();
        return myMovies;
    }


    public static void updateMovie(int idToupdate, MoviesDB movieToupdate) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement
                ("update Movies set title = ?, genre = ?,yearOfRelease  = ? where id = ?");
        preparedStatement.setString(1, movieToupdate.getTitle());
        preparedStatement.setString(2, movieToupdate.getGenre());
        preparedStatement.setString(3, movieToupdate.getYearofRelase());
        preparedStatement.setInt(4, idToupdate);

        int updatecheck = preparedStatement.executeUpdate();
        if (updatecheck == 0)
            System.out.println("aktualizacja nie powiodla sie");
        else {
            System.out.println("Zaktualizowano film na indeksie : " + idToupdate);
        }
        preparedStatement.close();

    }

    public int deleteMovie(int idToDelete){
        PreparedStatement preparedStatement = null;
        int deleteResoult = 0;
        try {
           preparedStatement = connection.prepareStatement("DELETE FROM Movies WHERE id = ?");
            preparedStatement.setInt(1,idToDelete);
            deleteResoult=  preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deleteResoult;
    }


}