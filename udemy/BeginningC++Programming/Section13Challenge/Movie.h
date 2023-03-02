/**
 * @file Movie.h
 * @author Nicholas Walker
 * @date 03/01/23
 *
 * @brief Creates the "Movie" class and prototype functions
 */

#ifndef _MOVIE_H_
#define _MOVIE_H_

#include <iostream>

using namespace std;

class Movie
{
private:
    string name;        // Name of the movie
    string rating;      // Rating of the movie (i.e. 'G', 'PG','PG-13', 'R')
    int times_watched;  // Number of times this movie has been watched
public:
    // Constructor
    Movie(string pName = "NoTitle", string pRating = "G", int pTimes_watched = 0);

    // Copy Constructor
    Movie(const Movie &);

    // Getters
    string get_name() const { return name; };
    string get_rating() const { return rating; };
    int get_times_watched() const { return times_watched; };

    // Setters
    void set_name(string pName) { this->name = pName; };
    void set_rating(string pRating) { this->rating = pRating; };
    void set_times_watched(int pTimes_watched) { this->times_watched = pTimes_watched; };

    // Other Methods
    void display() const;
    void increment_times_watched() { ++times_watched; };
};

#endif // _MOVIE_H_