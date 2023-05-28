#include <iostream>
#include "test/TestSuite.h"

using namespace std;

const bool RUN_TESTS{true};

int main()
{
    cout << "Welcome to the 'DnD 5e Charactor Application'" << endl << endl;
    cout << "Developed by Nicholas Walker (n_s_w@comcast.net)" << endl;

    if (RUN_TESTS)
    {
        cout << "\n~~~~~~~~~~ BEGIN TESTING PROCEDURE ~~~~~~~~~~\n\n";
        TestSuite test{};
        test.runAbilitiesTest();
        test.runSkillsTest();
    }

    return 0;
}
