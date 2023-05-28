/**
 * @file Strength.cpp
 * @author Nicholas Walker
 * @date 05/28/2023
 * 
 * @brief Implements the "Strength" class
*/

#include "Ability.h"
#include <string>

using namespace std;

const string NAME{"STRENGTH"};

Strength::Strength(int pScore, int pRacialBoost)
    : Ability {NAME, pScore, pRacialBoost}
{}