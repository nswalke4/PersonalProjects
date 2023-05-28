/**
 * @file Acrobatics.cpp
 * @author Nicholas Walker
 * @date 05/28/2023
 * 
 * @brief Implements the "Acrobatics" class
*/

#include <string>

#include "Skill.h"

using namespace std;

const ABILITY_NAMES ABILITY_NAME{ABILITY_NAMES::DEXTERITY};
const string ACTIONS{"These are Acrobatics actions"};
const string NAME{"ACROBATICS"};

Acrobatics::Acrobatics(int pBaseModifier, bool pIsProficient, int pProficiencyBonus)
    : Skill {NAME, ABILITY_NAME, ACTIONS, pBaseModifier, pIsProficient, pProficiencyBonus}
{}