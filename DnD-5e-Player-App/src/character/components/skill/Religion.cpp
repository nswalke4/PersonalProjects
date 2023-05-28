/**
 * @file Religion.cpp
 * @author Nicholas Walker
 * @date 05/28/2023
 * 
 * @brief Implements the "Religion" class
*/

#include <string>

#include "Skill.h"

using namespace std;

const ABILITY_NAMES ABILITY_NAME{ABILITY_NAMES::INTELLIGENCE};
const string ACTIONS{"These are Religion actions"};
const string NAME{"RELIGION"};

Religion::Religion(int pBaseModifier, bool pIsProficient, int pProficiencyBonus)
    : Skill {NAME, ABILITY_NAME, ACTIONS, pBaseModifier, pIsProficient, pProficiencyBonus}
{}