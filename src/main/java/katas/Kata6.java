package katas;

import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.Movie;
import util.DataUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

       return movies.stream()
                .map(movie -> movie.getBoxarts())
                .flatMap(listBox -> listBox.stream())
                .reduce((parcialBoxArt,boxArt)->{
                    var area=boxArt.getHeight()*boxArt.getWidth();
                    var areaParcial=parcialBoxArt.getHeight()*parcialBoxArt.getWidth();
                    if(area > areaParcial) parcialBoxArt=boxArt;
                    return parcialBoxArt;
                })
                .map(boxArt -> boxArt.getUrl()).stream()
               .collect(Collectors.toList()).toString();

    }
}
