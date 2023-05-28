/**
 * @file SleightOfHand.cpp
 * @author Nicholas Walker
 * @date 05/28/2023
 * 
 * @brief Implements the "Sleight of Hand" class
*/

#include <string>

#include "Skill.h"

using namespace std;

const ABILITY_NAMES ABILITY_NAME{ABILITY_NAMES::DEXTERITY};
const string ACTIONS{"These are Sleight of Hand actions"};
const string NAME{"SLEIGHT_OF_HAND"};

SleightOfHand::SleightOfHand(int pBaseModifier, bool pIsProficient, int pProficiencyBonus)
    : Skill {NAME, ABILITY_NAME, ACTIONS, pBaseModifier, pIsProficient, pProficiencyBonus}
{}