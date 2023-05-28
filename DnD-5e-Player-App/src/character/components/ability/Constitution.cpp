/**
 * @file Constitution.cpp
 * @author Nicholas Walker
 * @date 05/28/2023
 * 
 * @brief Implements the "Constitution" class
*/

#include "Ability.h"
#include <string>

using namespace std;

const string NAME{"CONSTITUTION"};

Constitution::Constitution(int pScore, int pRacialBoost)
    : Ability {NAME, pScore, pRacialBoost}
{}