/*Yimy 5 2015*/
import java.util.Comparator;

public class Movies {

    private String movieTitle;
    private float movieRating;

    public Movies(String movieTitle, float movieRating){
        this.movieTitle = movieTitle;
        this.movieRating = movieRating;
    }

    //Comparator for sorting the movies by imdb rating
    //To sort by title, create a new comparator with almost the same structure
    public static Comparator<Movies> ratingComparator = new Comparator<Movies>() {
        @Override
        public int compare(Movies m1, Movies m2) {
            float movie1 = m1.getRating();
            float movie2 = m2.getRating();

            if(movie1 > movie2) return -1;
            if(movie1 < movie2) return 1;
            return 0;
        }
    };

    //Getters and Setters respectively
    public String getMovieTitle(){
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle){
        this.movieTitle = movieTitle;
    }

    public float getRating(){
        return movieRating;
    }

    public void setmovieRating(float movieRating){
        this.movieRating = movieRating;
    }

    @Override
    public String toString(){
        return movieTitle + " -- " + movieRating;
    }
}
