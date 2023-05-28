/**
 * @file Ability.cpp
 * @author Nicholas Walker
 * @date 05/28/2023
 * 
 * @brief Implements the base "Ability" class functions
*/

#include <string>

#include "Ability.h"

using namespace std;

Ability::Ability(string pName, int pScore, int pRacialBoost)
    : name{pName}, baseScore{pScore}, modifier{0}, racialBoost{pRacialBoost}, score{0}
{
    update();
}

int Ability::getBaseScore() const
{
    return baseScore;
}

int Ability::getModifier() const
{
    return modifier;
}

int Ability::getRacialBoost() const
{
    return racialBoost;
}

void Ability::setRacialBoost(const int pRacialBoost)
{
    racialBoost = pRacialBoost;
    update();
}

int Ability::getScore() const
{
    return score;
}

void Ability::setScore(const int pScore)
{
    baseScore = pScore;
    update();
}

const string Ability::printStr(const bool fullStr) const
{
    string out{name + " ability has a score of " + to_string(score) + ", which has a modifier of " + to_string(modifier)};
    if (fullStr)
        out += " (based on a base score of " + to_string(baseScore) + " and a racial boost of " + to_string(racialBoost) + ")";
    return out;
}