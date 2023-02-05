/**
 * @file main.cpp
 * @author Nicholas Walker
 * @date 02/05/2023
 *
 * @brief Explore vectors in C++
 */

#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char *argv[])
{
    vector <int> vector1;
    vector <int> vector2;
    
    vector1.push_back(10);
    vector1.push_back(20);

    cout << "\nVector 1 Elements\n-----------------\nat(0) = " << vector1.at(0)
         << "\nat(1) = " << vector1.at(1) << "\n\nThe size of vector1 is "
         << vector1.size() << endl;
    
    vector2.push_back(100);
    vector2.push_back(200);

    cout << "\nVector 2 Elements\n-----------------\nat(0) = " << vector2.at(0)
         << "\nat(1) = " << vector2.at(1) << "\n\nThe size of vector2 is "
         << vector2.size() << endl;
      
    vector<vector<int>> vector_2d;

    vector_2d.push_back(vector1);

    vector_2d.push_back(vector2);

    cout << "\nVector 2D Elements\n------------------\nat(0).at(0) = " << vector_2d.at(0).at(0)
         << "\nat(0).at(1) = " << vector_2d.at(0).at(1) << "\nat(1).at(0) = " << vector_2d.at(1).at(0)
         << "\nat(1).at(1) = " << vector_2d.at(1).at(1) << "\n\nThe size of vector_2d is "
         << vector_2d.size() << endl;

    vector1.at(0) = 1000;

    cout << "\nVector 2D Elements\n------------------\nat(0).at(0) = " << vector_2d.at(0).at(0)
         << "\nat(0).at(1) = " << vector_2d.at(0).at(1) << "\nat(1).at(0) = " << vector_2d.at(1).at(0)
         << "\nat(1).at(1) = " << vector_2d.at(1).at(1) << "\n\nThe size of vector_2d is "
         << vector_2d.size() << endl;

    cout << "\nVector 1 Elements\n-----------------\nat(0) = " << vector1.at(0)
         << "\nat(1) = " << vector1.at(1) << "\n\nThe size of vector1 is "
         << vector1.size() << endl;

    // Answer these questions:
        // What did you expect?
            // I expect that the Vector_2D elements will not change, as the values from vector1 were
            // stored into vector_2d and not the reference to that vector.  So the print from vector_2d
            // will be the same as before, but the print for vector1 will show the updated value at
            // index 0.
        // Did the results show what you expected?
            // Yes, the results showed exactly what I explained above
        // What do you think happened?
            // As I mentioned in my response to the first question, when I ran the "push_back"
            // method on vector_2d to add vector1 in, all I did was store the data that was currently
            // saved in vector1.  I did not store an actual reference to vector1's data, just a copy
            // of that data.  So, when I updated the vale of vector1.at(0), it did not affect the
            // data saved in vector_2d, only the data saved in vector1.

    return 0;
}
