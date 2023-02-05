#include <iostream>

int main()
{
    int favNum;

    std::cout << "Enter your favorite number between 1 and 100:  ";
    std::cin >> favNum;
    std::cout << "Amazing!!  That's my favorite number too!\nNo really!!  "
        << favNum << " is my favorite number!" << std::endl;

    return 0;
}