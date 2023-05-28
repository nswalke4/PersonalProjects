/**
 * @file Skill.h
 * @author Nicholas Walker
 * @date 05/28/2023
 * 
 * @brief Declares the base "Skill" class and its subclasses
*/

#ifndef _SKILL_H_
#define _SKILL_H_

#include <string>

#include "../../../Enums.h"

using namespace std;

class Skill
{
    public:
        Skill(string pName, ABILITY_NAMES pAbility = ABILITY_NAMES::INVALID, string pActions = "<not implemented>",
              int pBaseModifier = 0, bool pIsProficient = false, int pProficiencyBonus = 0);

        const string getActionsStr() const;
        const string printStr(const bool fullStr = false) const;

    private:
        ABILITY_NAMES abilityName;
        string actions;
        int baseModifier;
        bool isProficient;
        int modifier;
        string name;
        int proficiencyBonus;

        void update()
        {
            this->modifier = this->baseModifier;
            if (this->isProficient) {
                this->modifier += this->proficiencyBonus;
            }
        }
};

class Acrobatics : public Skill
{
    public:
        Acrobatics(int pBaseModifier = 0, bool pIsProficient = false, int pProficiencyBonus = 0);
};

class AnimalHandling : public Skill
{
    public:
        AnimalHandling(int pBaseModifier = 0, bool pIsProficient = false, int pProficiencyBonus = 0);
};

class Arcana : public Skill
{
    public:
        Arcana(int pBaseModifier = 0, bool pIsProficient = false, int pProficiencyBonus = 0);
};

class Athletics : public Skill
{
    public:
        Athletics(int pBaseModifier = 0, bool pIsProficient = false, int pProficiencyBonus = 0);
};

class Deception : public Skill
{
    public:
        Deception(int pBaseModifier = 0, bool pIsProficient = false, int pProficiencyBonus = 0);
};

class History : public Skill
{
    public:
        History(int pBaseModifier = 0, bool pIsProficient = false, int pProficiencyBonus = 0);
};

class Insight : public Skill
{
    public:
        Insight(int pBaseModifier = 0, bool pIsProficient = false, int pProficiencyBonus = 0);
};

class Intimidation : public Skill
{
    public:
        Intimidation(int pBaseModifier = 0, bool pIsProficient = false, int pProficiencyBonus = 0);
};

class Investigation : public Skill
{
    public:
        Investigation(int pBaseModifier = 0, bool pIsProficient = false, int pProficiencyBonus = 0);
};

class Medicine : public Skill
{
    public:
        Medicine(int pBaseModifier = 0, bool pIsProficient = false, int pProficiencyBonus = 0);
};

class Nature : public Skill
{
    public:
        Nature(int pBaseModifier = 0, bool pIsProficient = false, int pProficiencyBonus = 0);
};

class Perception : public Skill
{
    public:
        Perception(int pBaseModifier = 0, bool pIsProficient = false, int pProficiencyBonus = 0);
};

class Performance : public Skill
{
    public:
        Performance(int pBaseModifier = 0, bool pIsProficient = false, int pProficiencyBonus = 0);
};

class Persuasion : public Skill
{
    public:
        Persuasion(int pBaseModifier = 0, bool pIsProficient = false, int pProficiencyBonus = 0);
};

class Religion : public Skill
{
    public:
        Religion(int pBaseModifier = 0, bool pIsProficient = false, int pProficiencyBonus = 0);
};

class SleightOfHand : public Skill
{
    public:
        SleightOfHand(int pBaseModifier = 0, bool pIsProficient = false, int pProficiencyBonus = 0);
};

class Stealth : public Skill
{
    public:
        Stealth(int pBaseModifier = 0, bool pIsProficient = false, int pProficiencyBonus = 0);
};

class Survival : public Skill
{
    public:
        Survival(int pBaseModifier = 0, bool pIsProficient = false, int pProficiencyBonus = 0);
};

#endif /* _SKILL_H_ */