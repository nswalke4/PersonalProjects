/**
 * @file Deception.cpp
 * @author Nicholas Walker
 * @date 05/28/2023
 * 
 * @brief Implements the "Deception" class
*/

#include <string>

#include "Skill.h"

using namespace std;

const ABILITY_NAMES ABILITY_NAME{ABILITY_NAMES::CHARISMA};
const string ACTIONS{"These are Deception actions"};
const string NAME{"DECEPTION"};

Deception::Deception(int pBaseModifier, bool pIsProficient, int pProficiencyBonus)
    : Skill {NAME, ABILITY_NAME, ACTIONS, pBaseModifier, pIsProficient, pProficiencyBonus}
{}