package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.MovieList;
import util.DataUtil;

import java.util.*;
import java.util.stream.Collectors;

/*
    Goal: Create a datastructure from the given data:

    We have 2 arrays each containing lists, and videos respectively.
    Each video has a listId field indicating its parent list.
    We want to build an array of list objects, each with a name and a videos array.
    The videos array will contain the video's id and title.
    In other words we want to build the following structure:

    [
        {
            "name": "New Releases",
            "videos": [
                {
                    "id": 65432445,
                    "title": "The Chamber"
                },
                {
                    "id": 675465,
                    "title": "Fracture"
                }
            ]
        },
        {
            "name": "Thrillers",
            "videos": [
                {
                    "id": 70111470,
                    "title": "Die Hard"
                },
                {
                    "id": 654356453,
                    "title": "Bad Boys"
                }
            ]
        }
    ]

    DataSource: DataUtil.getLists(), DataUtil.getVideos()
    Output: the given datastructure
*/
public class Kata10 {
    public static List<Map> execute() {
        List<Map> lists = DataUtil.getLists();
        List<Map> videos = DataUtil.getVideos();


        return lists.stream()
                .map(list -> {
                    Set claves = list.keySet();
                    Collection values = list.values();

                    return ImmutableMap.of("name", values, "title", values);
                })
                .collect(Collectors.toUnmodifiableList());
    }

        /*
        filter(interestingMoment -> interestingMoment.getType().equals("Middle"))
                                .map(interestingMoment -> interestingMoment.getTime())
                                .collect(Collectors.toList())
        */

        /*
        List<Movie> movies = DataUtil.getMovies();
        List<Bookmark> bookMarks = DataUtil.getBookMarks();

        Stream<Integer> streaMovie = movies.stream().map(movie -> movie.getId());
        Stream<Integer> streamBookMarks = bookMarks.stream().map(bookmark -> bookmark.getId());

        return StreamUtils
                .zip(streaMovie, streamBookMarks, (a, b) -> ImmutableMap.of("videoId", a, "bookmarkId", b) )
                .collect(Collectors.toUnmodifiableList());



        return ImmutableList.of(ImmutableMap.of("name", "someName", "videos", ImmutableList.of(
                ImmutableMap.of("id", 5, "title", "The Chamber"),
                ImmutableMap.of("id", 3, "title", "Fracture")
        )));
         */

    public static void main(String[] args) {
        Kata10 kata10 =new Kata10();
        System.out.println(kata10.execute());
    }
}
