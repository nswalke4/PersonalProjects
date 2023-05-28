/**
 * @file TestAbilities.cpp
 * @author Nicholas Walker
 * @date 05/28/2023
 * 
 * @brief Implements the testing function for the "Ability" classes
*/

#include <iostream>

#include "TestSuite.h"
#include "../character/components/ability/Ability.h"

void TestSuite::runAbilitiesTest() const
{
    cout << "+------------------------------------------------+\n";
    cout << "|         Running Tests for: \"Abilities\"         |\n";
    cout << "+------------------------------------------------+\n";

    Strength str{3 , 1};
    Dexterity dex{12, 1};
    Constitution con{12, 1};
    Intelligence itg{10, 1};
    Wisdom wis{17, 1};
    Charisma cha{14, 1};

    cout << "\n" << str.printStr();
    cout << "\n" << str.printStr(true);
    cout << "\n" << dex.printStr();
    cout << "\n" << dex.printStr(true);
    cout << "\n" << con.printStr();
    cout << "\n" << con.printStr(true);
    cout << "\n" << itg.printStr();
    cout << "\n" << itg.printStr(true);
    cout << "\n" << wis.printStr();
    cout << "\n" << wis.printStr(true);
    cout << "\n" << cha.printStr();
    cout << "\n" << cha.printStr(true);

    cout << "\n" << str.getBaseScore() << "\t" << str.getRacialBoost() << "\t" << str.getScore() << "\t" << str.getModifier();
    cout << "\n" << dex.getBaseScore() << "\t" << dex.getRacialBoost() << "\t" << dex.getScore() << "\t" << dex.getModifier();
    cout << "\n" << con.getBaseScore() << "\t" << con.getRacialBoost() << "\t" << con.getScore() << "\t" << con.getModifier();
    cout << "\n" << itg.getBaseScore() << "\t" << itg.getRacialBoost() << "\t" << itg.getScore() << "\t" << itg.getModifier();
    cout << "\n" << wis.getBaseScore() << "\t" << wis.getRacialBoost() << "\t" << wis.getScore() << "\t" << wis.getModifier();
    cout << "\n" << cha.getBaseScore() << "\t" << cha.getRacialBoost() << "\t" << cha.getScore() << "\t" << cha.getModifier();

    cout << "\n\nSetting all scores to 21...\n";

    str.setScore(21);
    dex.setScore(21);
    con.setScore(21);
    itg.setScore(21);
    wis.setScore(21);
    cha.setScore(21);

    cout << "\n" << str.getBaseScore() << "\t" << str.getRacialBoost() << "\t" << str.getScore() << "\t" << str.getModifier();
    cout << "\n" << dex.getBaseScore() << "\t" << dex.getRacialBoost() << "\t" << dex.getScore() << "\t" << dex.getModifier();
    cout << "\n" << con.getBaseScore() << "\t" << con.getRacialBoost() << "\t" << con.getScore() << "\t" << con.getModifier();
    cout << "\n" << itg.getBaseScore() << "\t" << itg.getRacialBoost() << "\t" << itg.getScore() << "\t" << itg.getModifier();
    cout << "\n" << wis.getBaseScore() << "\t" << wis.getRacialBoost() << "\t" << wis.getScore() << "\t" << wis.getModifier();
    cout << "\n" << cha.getBaseScore() << "\t" << cha.getRacialBoost() << "\t" << cha.getScore() << "\t" << cha.getModifier();

    cout << "\n\nSetting all racial boosts to -3...\n";
    
    str.setRacialBoost(-3);
    dex.setRacialBoost(-3);
    con.setRacialBoost(-3);
    itg.setRacialBoost(-3);
    wis.setRacialBoost(-3);
    cha.setRacialBoost(-3);

    cout << "\n" << str.getBaseScore() << "\t" << str.getRacialBoost() << "\t" << str.getScore() << "\t" << str.getModifier();
    cout << "\n" << dex.getBaseScore() << "\t" << dex.getRacialBoost() << "\t" << dex.getScore() << "\t" << dex.getModifier();
    cout << "\n" << con.getBaseScore() << "\t" << con.getRacialBoost() << "\t" << con.getScore() << "\t" << con.getModifier();
    cout << "\n" << itg.getBaseScore() << "\t" << itg.getRacialBoost() << "\t" << itg.getScore() << "\t" << itg.getModifier();
    cout << "\n" << wis.getBaseScore() << "\t" << wis.getRacialBoost() << "\t" << wis.getScore() << "\t" << wis.getModifier();
    cout << "\n" << cha.getBaseScore() << "\t" << cha.getRacialBoost() << "\t" << cha.getScore() << "\t" << cha.getModifier();

    cout << "\n\n~~~~~~~~~~ End Abilities Testing ~~~~~~~~~~\n\n";
}