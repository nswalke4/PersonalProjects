/**
 * @file Movies.cpp
 * @author Nicholas Walker
 * @date 03/01/23
 *
 * @brief Implements the "Movies" class
 */

#include <iostream>
#include "Movies.h"

bool Movies::add_movie(string pName, string pRating, int pTimes_watched)
{
    for (const auto &movie : movies)
        if (movie.get_name() == pName)
            return false;
    Movie new_movie {pName, pRating, pTimes_watched};
    movies.push_back(new_movie);
    return true;
}

void Movies::display() const
{
    cout << "\n==============Movies List==============" << endl;
    if (movies.size() == 0)
        cout << "\nSorry, No movies to display!\n" << endl;
    else
    {
        for (const auto &movie : movies)
            movie.display();
    }
    cout << "=======================================\n" << endl;
}

bool Movies::increment_watched(string movie_name)
{
    for (auto &movie : movies)
        if (movie.get_name() == movie_name)
        {
            movie.increment_times_watched();
            return true;
        }
    return false;
}

using namespace std;