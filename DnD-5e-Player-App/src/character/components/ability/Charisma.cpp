/**
 * @file Charisma.cpp
 * @author Nicholas Walker
 * @date 05/28/2023
 * 
 * @brief Implements the "Charisma" class
*/

#include "Ability.h"
#include <string>

using namespace std;

const string NAME{"CHARISMA"};

Charisma::Charisma(int pScore, int pRacialBoost)
    : Ability {NAME, pScore, pRacialBoost}
{}