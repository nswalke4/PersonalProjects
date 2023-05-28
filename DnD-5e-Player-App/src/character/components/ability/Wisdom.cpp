/**
 * @file Wisdom.cpp
 * @author Nicholas Walker
 * @date 05/28/2023
 * 
 * @brief Implements the "Wisdom" class
*/

#include "Ability.h"
#include <string>

using namespace std;

const string NAME{"WISDOM"};

Wisdom::Wisdom(int pScore, int pRacialBoost)
    : Ability {NAME, pScore, pRacialBoost}
{}