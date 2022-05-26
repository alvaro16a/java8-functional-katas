package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream()
                .map(movieList -> movieList.getVideos())
                .flatMap(movie -> movie.stream())
                .map(movie -> ImmutableMap.of(
                        "id", movie.getId(),
                        "title", movie.getTitle(),
                        "time", movie.getInterestingMoments().stream()
                                .filter(interestingMoment -> interestingMoment.getType().equals("Middle"))
                                .map(interestingMoment -> interestingMoment.getTime())
                                .collect(Collectors.toList())
                        ,
                        "boxart",movie.getBoxarts().stream()
                                .reduce((parcialBoxArt,boxArt)->{
                                    var area=boxArt.getHeight()*boxArt.getWidth();
                                    var areaParcial=parcialBoxArt.getHeight()*parcialBoxArt.getWidth();
                                    if(area < areaParcial) parcialBoxArt=boxArt;
                                    return parcialBoxArt;
                                })
                                .map(boxArt -> boxArt.getUrl())))
                .collect(Collectors.toList());
    }
}
