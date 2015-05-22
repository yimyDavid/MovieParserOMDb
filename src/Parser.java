/*Yimy 5 2015*/

import java.io.*;

import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

public class Parser {

    //Container to store and sort the movies
    ArrayList<Movies> movieList = new ArrayList<Movies>();
    ArrayList<String> noRating = new ArrayList<String>();
    ArrayList<String> noInfo = new ArrayList<String>();

    public void parseUrl(String title, String year) throws UnsupportedEncodingException {


        String movieTitle = URLEncoder.encode(title, "UTF-8"); //handles spaces and other characters
        //Url String preparation
        String urlString = "http://www.omdbapi.com/?t=" + movieTitle + "&y=" + year;

        try {
            String movieInfo = IOUtils.toString(new URL(urlString));
            JSONObject genreJsonObject = (JSONObject) JSONValue.parseWithException(movieInfo);

            // get the title and the rating as strings
            String mtitle = (String) genreJsonObject.get("Title");
            String rating = (String)genreJsonObject.get("imdbRating");

            if((mtitle !=null || rating != null)) {
                if (!rating.equals("N/A")) {
                    movieList.add(new Movies(mtitle, Float.parseFloat(rating)));
                } else {
                    noRating.add(mtitle);
                }
            }else{
                noInfo.add(title);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void printMovies(){

        //to sort by title replace the second argument with the correct comparator(to be implemented)
        Collections.sort(movieList, Movies.ratingComparator);
        for(Movies str: movieList){
            System.out.println(str);
        }

       /* System.out.println("MOVIES WITH NO RATING");
        for(String nr: noRating){
            System.out.println(nr);
        }

        System.out.println("MOVIES WITH NO INFO");
        for(String ni: noInfo){
            System.out.println(ni);
        }
        System.out.println("mr: " + movieList.size()+ "  nr: " + noRating.size() + "  ni: " + noInfo.size() );*/
    }



}
