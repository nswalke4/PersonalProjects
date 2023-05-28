/**
 * @file TestSuite.h
 * @author Nicholas Walker
 * @date 05/28/2023
 * 
 * @brief Creates the "Test Suite" and declares the necessary functions for testing
*/

#ifndef _TESTSUITE_H_
#define _TESTSUITE_H_

using namespace std;

class TestSuite
{
    public:
        TestSuite() {};

        void runAbilitiesTest() const;
        void runSkillsTest() const;
};

#endif /* _TESTSUITE_H_ */