/**
 * @file Skill.cpp
 * @author Nicholas Walker
 * @date 05/28/2023
 * 
 * @brief Implements the base "Skill" class funcitons
 */

#include <string>

#include "Skill.h"

using namespace std;

Skill::Skill(string pName, ABILITY_NAMES pAbility, string pActions, int pBaseModifier, bool pIsProficient,
             int pProficiencyBonus)
    : name{pName}, abilityName{pAbility}, actions{pActions}, baseModifier{pBaseModifier}, isProficient{pIsProficient},
      proficiencyBonus{pProficiencyBonus}
{
    update();
}

const string Skill::getActionsStr() const
{
    return actions;
}

const string Skill::printStr(const bool fullStr) const
{
    string out{name + " skill has a modifier value of " + to_string(modifier)};
    if (isProficient)
    {
        out += " and is a 'proficient' skill";
        if (fullStr)
        {
            out += " (based on a base modifier value of " + to_string(baseModifier) + " and a proficiency bonus of " +
                   to_string(proficiencyBonus) + ")";
        }
    }
    return out;
}