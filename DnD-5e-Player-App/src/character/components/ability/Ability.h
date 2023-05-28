/**
 * @file Ability.h
 * @author Nicholas Walker
 * @date 05/28/2023
 * 
 * @brief Declares the base "Ability" class and its subclasses
*/

#ifndef _ABILITY_H_
#define _ABILITY_H_

#include <string>
#include <cmath>

using namespace std;

class Ability
{
    public:
        Ability(string name, int pScore = 0, int pRacialBoost = 0);

        int getBaseScore() const;
        int getModifier() const;
        int getRacialBoost() const;
        void setRacialBoost(const int);
        int getScore() const;
        void setScore(const int);

        const string printStr(const bool fullStr = false) const;

    private:
        int baseScore;
        int modifier;
        string name;
        int racialBoost;
        int score;

        void update()
        {
            this->score = this->baseScore + this->racialBoost;
            this->modifier = floor((this->score - 10) / 2.0);
        }
    
};

class Charisma : public Ability
{
    public:
        Charisma(int pScore = 0, int pRacialBoost = 0);
};

class Constitution : public Ability
{
    public:
        Constitution(int pScore = 0, int pRacialBoost = 0);
};

class Dexterity : public Ability
{
    public:
        Dexterity(int pScore = 0, int pRacialBoost = 0);
};

class Intelligence : public Ability
{
    public:
        Intelligence(int pScore = 0, int pRacialBoost = 0);
};

class Strength : public Ability
{
    public:
        Strength(int pScore = 0, int pRacialBoost = 0);
};

class Wisdom : public Ability
{
    public:
        Wisdom(int pScore = 0, int pRacialBoost = 0);
};

#endif /* _ABILITY_H */