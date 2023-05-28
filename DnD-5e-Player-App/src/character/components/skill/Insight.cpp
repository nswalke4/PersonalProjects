/**
 * @file Insight.cpp
 * @author Nicholas Walker
 * @date 05/28/2023
 * 
 * @brief Implements the "Insight" class
*/

#include <string>

#include "Skill.h"

using namespace std;

const ABILITY_NAMES ABILITY_NAME{ABILITY_NAMES::WISDOM};
const string ACTIONS{"These are Insight actions"};
const string NAME{"INSIGHT"};

Insight::Insight(int pBaseModifier, bool pIsProficient, int pProficiencyBonus)
    : Skill {NAME, ABILITY_NAME, ACTIONS, pBaseModifier, pIsProficient, pProficiencyBonus}
{}