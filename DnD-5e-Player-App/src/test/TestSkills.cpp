/**
 * @file TestSkills.cpp
 * @author Nicholas Walker
 * @date 05/28/2023
 * 
 * @brief Implements the testing function for the "Skill" classes
*/

#include <iostream>

#include "TestSuite.h"
#include "../character/components/skill/Skill.h"

void TestSuite::runSkillsTest() const
{
    cout << "+------------------------------------------------+\n";
    cout << "|          Running Tests for:  \"Skills\"          |\n";
    cout << "+------------------------------------------------+\n";

    Acrobatics acrobatics{1};
    AnimalHandling animalHandling{4};
    Arcana arcana{0};
    Athletics athletics{3};
    Deception deception{2};
    History history{0};
    Insight insight{4, true, 2};
    Intimidation intimidation{2};
    Investigation investigation{0};
    Medicine medicine{4, true, 2};
    Nature nature{0};
    Perception perception{4};
    Performance performance{2};
    Persuasion persuasion{2};
    Religion religion{0, true, 2};
    SleightOfHand sleightOfHand{1};
    Stealth stealth{1};
    Survival survival{4, true, 2};

    cout << "\n" << acrobatics.getActionsStr() << "\n" << acrobatics.printStr() << "\n" << acrobatics.printStr(true);
    cout << "\n" << animalHandling.getActionsStr() << "\n" << animalHandling.printStr() << "\n" << animalHandling.printStr(true);
    cout << "\n" << arcana.getActionsStr() << "\n" << arcana.printStr() << "\n" << arcana.printStr(true);
    cout << "\n" << athletics.getActionsStr() << "\n" << athletics.printStr() << "\n" << athletics.printStr(true);
    cout << "\n" << deception.getActionsStr() << "\n" << deception.printStr() << "\n" << deception.printStr(true);
    cout << "\n" << history.getActionsStr() << "\n" << history.printStr() << "\n" << history.printStr(true);
    cout << "\n" << insight.getActionsStr() << "\n" << insight.printStr() << "\n" << insight.printStr(true);
    cout << "\n" << intimidation.getActionsStr() << "\n" << intimidation.printStr() << "\n" << intimidation.printStr(true);
    cout << "\n" << investigation.getActionsStr() << "\n" << investigation.printStr() << "\n" << investigation.printStr(true);
    cout << "\n" << medicine.getActionsStr() << "\n" << medicine.printStr() << "\n" << medicine.printStr(true);
    cout << "\n" << nature.getActionsStr() << "\n" << nature.printStr() << "\n" << nature.printStr(true);
    cout << "\n" << perception.getActionsStr() << "\n" << perception.printStr() << "\n" << perception.printStr(true);
    cout << "\n" << performance.getActionsStr() << "\n" << performance.printStr() << "\n" << performance.printStr(true);
    cout << "\n" << persuasion.getActionsStr() << "\n" << persuasion.printStr() << "\n" << persuasion.printStr(true);
    cout << "\n" << religion.getActionsStr() << "\n" << religion.printStr() << "\n" << religion.printStr(true);
    cout << "\n" << sleightOfHand.getActionsStr() << "\n" << sleightOfHand.printStr() << "\n" << sleightOfHand.printStr(true);
    cout << "\n" << stealth.getActionsStr() << "\n" << stealth.printStr() << "\n" << stealth.printStr(true);
    cout << "\n" << survival.getActionsStr() << "\n" << survival.printStr() << "\n" << survival.printStr(true);

    cout << "\n\n~~~~~~~~~~ End Skills Testing ~~~~~~~~~~\n\n";

}