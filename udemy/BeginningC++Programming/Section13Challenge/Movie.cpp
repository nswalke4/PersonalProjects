/**
 * @file Movie.cpp
 * @author Nicholas Walker
 * @date 03/01/23
 *
 * @brief Implements the "Movie" class
 */

#include <iostream>
#include "Movie.h"

// Constructor
Movie::Movie(string pName, string pRating, int pTimes_watched)
    : name{pName}, rating{pRating}, times_watched{pTimes_watched} {
}

// Copy Constructor
Movie::Movie(const Movie &source)
    : Movie {source.get_name(), source.get_rating(), source.get_times_watched()} {
}

// Other Methods
void Movie::display() const
{
    cout << "\t" << this->get_name() << ", " << this->get_rating() << ", " << this->get_times_watched() << endl;
}

using namespace std;