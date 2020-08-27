package pl.marcin.JDBCzad1.models;


public class MoviesDB {
     private Integer id;
     private String title;
     private String genre;
     private  String yearofRelase;


    public MoviesDB(Integer id, String title, String genre,String yearofRelase) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.yearofRelase = yearofRelase;
    }

    public MoviesDB( String title, String genre,String yearofRelase) {
        this.title = title;
        this.genre = genre;
        this.yearofRelase = yearofRelase;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYearofRelase() {
        return yearofRelase;
    }

    public void setYearofRelase(String yearofRelase) {
        this.yearofRelase = yearofRelase;
    }

    @Override
    public String toString() {
        return "MoviesDB{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", yearofRelase='" + yearofRelase + '\'' +
                '}';
    }

}
