/**
 * @file Intelligence.cpp
 * @author Nicholas Walker
 * @date 05/28/2023
 * 
 * @brief Implements the "Intelligence" class
*/

#include "Ability.h"
#include <string>

using namespace std;

const string NAME{"INTELLIGENCE"};

Intelligence::Intelligence(int pScore, int pRacialBoost)
    : Ability {NAME, pScore, pRacialBoost}
{}