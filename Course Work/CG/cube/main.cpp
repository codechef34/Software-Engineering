#include <cstdlib>
#include <iostream>

#include "cube.h"

using namespace std;

int main(int argc, char *argv[])
{
    
    cube rc;
    rc.setSolved();
    rc.scramble();
    rc.findSolution();
    
    system("PAUSE");
    return 0;
}

