/**
 * @file History.cpp
 * @author Nicholas Walker
 * @date 05/28/2023
 * 
 * @brief Implements the "History" class
*/

#include <string>

#include "Skill.h"

using namespace std;

const ABILITY_NAMES ABILITY_NAME{ABILITY_NAMES::INTELLIGENCE};
const string ACTIONS{"These are History actions"};
const string NAME{"HISTORY"};

History::History(int pBaseModifier, bool pIsProficient, int pProficiencyBonus)
    : Skill {NAME, ABILITY_NAME, ACTIONS, pBaseModifier, pIsProficient, pProficiencyBonus}
{}