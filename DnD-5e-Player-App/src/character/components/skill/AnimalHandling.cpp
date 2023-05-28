/**
 * @file AnimalHandling.cpp
 * @author Nicholas Walker
 * @date 05/28/2023
 * 
 * @brief Implements the "Animal Handling" class
*/

#include <string>

#include "Skill.h"

using namespace std;

const ABILITY_NAMES ABILITY_NAME{ABILITY_NAMES::WISDOM};
const string ACTIONS{"These are Animal Handling actions"};
const string NAME{"ANIMAL_HANDLING"};

AnimalHandling::AnimalHandling(int pBaseModifier, bool pIsProficient, int pProficiencyBonus)
    : Skill {NAME, ABILITY_NAME, ACTIONS, pBaseModifier, pIsProficient, pProficiencyBonus}
{}