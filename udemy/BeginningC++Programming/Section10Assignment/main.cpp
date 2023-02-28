/**
 * @file main.cpp
 * @author Nicholas Walker
 * @date 02/07/0023
 *
 * @brief 
 */

#include <iostream>
#include <string>

using namespace std;

int main(int argc, char *argv[])
{
    string str {};
    cout << "Enter the string you would like to make a Letter Pyramid with:\n>> ";
    cin >> str;

    for (size_t i = 0; i < str.size(); i++)
    {
        string space (" ", str.size() - 1 - i);
        string out {space};
        for (int j=0; j < i; j++)
            out += str.at(j);
        for (int k=i; k >= 0; k--)
            out += str.at(k);
        out += space;
        cout << out << endl;
    }
    return 0;
}
