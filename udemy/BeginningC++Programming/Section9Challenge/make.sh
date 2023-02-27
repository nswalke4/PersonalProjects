

## About
##   This script is a basic script that will build and/or run the Section 9 Challenge Program

HELP ()
{
    echo "################## C++ Build / Run Script ##################"
    echo "  This is a basic script that will make building and running"
    echo "  C++ programs easier.  As I am having trouble using the"
    echo "  Windows \"PATH\" variable correclty, I am writing this"
    echo "  script to make it easier to test this project."
    echo ""
    echo "  NOTE: This script is set to only work for the Section 9"
    echo "        challenge program."
    echo ""
    echo "USAGE:"
    echo "     Build  -  \`./make.sh -b\`"
    echo "     Run    -  \`./make.sh -r\`"
    echo "     Both   -  \`./make.sh -br\`"
    echo "############################################################"
}

build=false
run=false
file_name=main.cpp
exe_name=main.exe
compiler=C:\\Users\\nicholas.walker\\Documents\\x86_64-8.1.0-release-posix-seh-rt_v6-rev0\\mingw64\\bin\\g++.exe

if [ $# -eq 0 ]
then
    echo "No arguments given...  Showing 'Help' and exiting"
    HELP
    exit
fi

while getopts brh flag
do
    case "${flag}" in
        b) build=true;;
        r) run=true;;
        h)  # Display help menu
            HELP
            exit
            ;;
        \?) # Invalid option
            echo "Error: Invalid option"
            exit;;
    esac
done

if [ "$build" = true ]
then
    echo "Build requested"
    [ -e $exe_name ] && rm $exe_name
    $compiler $file_name -o $exe_name
fi

if [ "$run" = true ]
then
    echo "Run requested"
    sleep 1
    clear
    ./$exe_name
fi