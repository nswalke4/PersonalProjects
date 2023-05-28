/**
 * @file Dexterity.cpp
 * @author Nicholas Walker
 * @date 05/28/2023
 * 
 * @brief Implements the "Dexterity" class
*/

#include "Ability.h"
#include <string>

using namespace std;

const string NAME{"DEXTERITY"};

Dexterity::Dexterity(int pScore, int pRacialBoost)
    : Ability {NAME, pScore, pRacialBoost}
{}