/*Yimy 5 2015*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MovieRating{
  public static void main(String[] args) throws Exception {
    
   String fileToParse = "movies.csv";
   BufferedReader fileReader = null;

      Parser par = new Parser();


    final String DELIM = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
    int count = 0;
    try{
      String line = "";
      fileReader = new BufferedReader(new FileReader(fileToParse));
      
      //Read the file line by line
      while((line = fileReader.readLine()) != null){
        String[] tokens = line.split(DELIM);

          //skips movies that don't have the year, it may give the wrong rating for similar movie titles
        if(tokens.length < 2){continue;}
          par.parseUrl(tokens[0].replace("\"","").trim(), tokens[1].replace("\"", "").trim());

      }
     }catch(Exception e){
        e.printStackTrace();
      }finally
      {
        try{
          fileReader.close();
        }catch(IOException e){
          e.printStackTrace();
        }
      }

      par.printMovies();

   }//end main


}//end class
