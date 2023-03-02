/**
 * @file Movies.h
 * @author Nicholas Walker
 * @date 03/01/23
 *
 * @brief Creates the "Movies" class and prototype functions
 */

#ifndef _MOVIES_H_
#define _MOVIES_H_

#include <iostream>
#include <vector>
#include "Movie.h"

using namespace std;

class Movies
{
private:
    vector<Movie> movies;
public:
    // Other Methods
    bool add_movie(string, string, int);
    void display() const;
    bool increment_watched(string);
};

#endif // _MOVIES_H_