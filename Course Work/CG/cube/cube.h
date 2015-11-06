#include <cstdlib>
#include <iostream>
#include <windows.h>

using namespace std;

class cube {
      
    private:
      
    //init vars/////
      
    //up////////////white
    
    string u1;
    string u2;
    string u3;
    
    string u4;
    string u5;
    string u6;
    
    string u7;
    string u8;
    string u9;
    
    //front/////////green
    
    string f1;
    string f2;
    string f3;
    
    string f4;
    string f5;
    string f6;
    
    string f7;
    string f8;
    string f9;
    
    //left//////////orange
    
    string l1;
    string l2;
    string l3;
    
    string l4;
    string l5;
    string l6;
    
    string l7;
    string l8;
    string l9;
    
    //right/////////red
    
    string r1;
    string r2;
    string r3;
    
    string r4;
    string r5;
    string r6;
    
    string r7;
    string r8;
    string r9;
    
    //down//////////yellow
    
    string d1;
    string d2;
    string d3;
    
    string d4;
    string d5;
    string d6;
    
    string d7;
    string d8;
    string d9;
    
    //back//////////blue
    
    string b1;
    string b2;
    string b3;
    
    string b4;
    string b5;
    string b6;
    
    string b7;
    string b8;
    string b9;    
    
    //buffers
    
    string buffu1;
    string buffu2;
    string buffu3;
    string buffu4;
    string buffu5;
    string buffu6;
    string buffu7;
    string buffu8;
    string buffu9;
         
    string buffd1;
    string buffd2;
    string buffd3;
    string buffd4;
    string buffd5;
    string buffd6;
    string buffd7;
    string buffd8;
    string buffd9;
    
    string bufff1;
    string bufff2;
    string bufff3;
    string bufff4;
    string bufff5;
    string bufff6;
    string bufff7;
    string bufff8;
    string bufff9;  
    
    string buffb1;
    string buffb2;
    string buffb3;
    string buffb4;
    string buffb5;
    string buffb6;
    string buffb7;
    string buffb8;
    string buffb9;
    
    string buffl1;
    string buffl2;
    string buffl3;
    string buffl4;
    string buffl5;
    string buffl6;
    string buffl7;
    string buffl8;
    string buffl9;
    
    string buffr1;
    string buffr2;
    string buffr3;
    string buffr4;
    string buffr5;
    string buffr6;
    string buffr7;
    string buffr8;
    string buffr9;
    
    //array of moves// used in scramble and solution search
    static const string moves[];
    
    //string to hold solution
    string solution;
    string correctSolution;
    
    public:
           
    //set cube to solved position
    void setSolved () {
         
    u1 = "w";
    u2 = "w";
    u3 = "w";
    
    u4 = "w";
    u5 = "w";
    u6 = "w";
    
    u7 = "w";
    u8 = "w";
    u9 = "w";
    
    //front/////////green
    
    f1 = "g";
    f2 = "g";
    f3 = "g";
    
    f4 = "g";
    f5 = "g";
    f6 = "g";
    
    f7 = "g";
    f8 = "g";
    f9 = "g";
    
    //left//////////orange
    
    l1 = "o";
    l2 = "o";
    l3 = "o";
    
    l4 = "o";
    l5 = "o";
    l6 = "o";
    
    l7 = "o";
    l8 = "o";
    l9 = "o";
    
    //right/////////red
    
    r1 = "r";
    r2 = "r";
    r3 = "r";
    
    r4 = "r";
    r5 = "r";
    r6 = "r";
    
    r7 = "r";
    r8 = "r";
    r9 = "r";
    
    //down//////////yellow
    
    d1 = "y";
    d2 = "y";
    d3 = "y";
    
    d4 = "y";
    d5 = "y";
    d6 = "y";
    
    d7 = "y";
    d8 = "y";
    d9 = "y";
    
    //back//////////blue
    
    b1 = "b";
    b2 = "b";
    b3 = "b";
    
    b4 = "b";
    b5 = "b";
    b6 = "b";
    
    b7 = "b";
    b8 = "b";
    b9 = "b";    
    
}        

    //movement functions//there are 18 of these

    void U () {
         
         string buffu1 = u1;
         string buffu2 = u2;
         string buffu3 = u3;
         string buffu4 = u4;
         string buffu6 = u6;
         string buffu7 = u7;
         string buffu8 = u8;
         string buffu9 = u9;
         
         u1 = buffu7;
         u2 = buffu4;
         u3 = buffu1;
         u4 = buffb8;
         u6 = buffb2;
         u7 = buffl9;
         u8 = buffl6;
         u9 = buffl3;
         
         ////
         
         string bufff1 = f1;
         string bufff2 = f2;
         string bufff3 = f3;
         
         string buffr1 = r1;
         string buffr2 = r2;
         string buffr3 = r3;
         
         string buffb1 = b1;
         string buffb2 = b2;
         string buffb3 = b3;
         
         string buffl1 = l1;
         string buffl2 = l2;
         string buffl3 = l3;
         
         f1 = buffr1;
         f2 = buffr2;
         f3 = buffr3;
         
         r1 = buffb1;
         r2 = buffb2;
         r3 = buffb3;
         
         b1 = buffl1;
         b2 = buffl2;
         b3 = buffl3;
         
         l1 = bufff1;
         l2 = bufff2;
         l3 = bufff3;        
         
}
    
void Ui () {
         
         string bufff1 = f1;
         string bufff2 = f2;
         string bufff3 = f3;
         
         string buffr1 = r1;
         string buffr2 = r2;
         string buffr3 = r3;
         
         string buffb1 = b1;
         string buffb2 = b2;
         string buffb3 = b3;
         
         string buffl1 = l1;
         string buffl2 = l2;
         string buffl3 = l3;
         
         f1 = buffl1;
         f2 = buffl2;
         f3 = buffl3;
         
         r1 = bufff1;
         r2 = bufff2;
         r3 = bufff3;
         
         b1 = buffr1;
         b2 = buffr2;
         b3 = buffr3;
         
         l1 = buffb1;
         l2 = buffb2;
         l3 = buffb3;        
         
}

void U2 () {
         
         string bufff1 = f1;
         string bufff2 = f2;
         string bufff3 = f3;
         
         string buffr1 = r1;
         string buffr2 = r2;
         string buffr3 = r3;
         
         string buffb1 = b1;
         string buffb2 = b2;
         string buffb3 = b3;
         
         string buffl1 = l1;
         string buffl2 = l2;
         string buffl3 = l3;
         
         f1 = buffb1;
         f2 = buffb2;
         f3 = buffb3;
         
         r1 = buffl1;
         r2 = buffl2;
         r3 = buffl3;
         
         b1 = bufff1;
         b2 = bufff2;
         b3 = bufff3;
         
         l1 = buffr1;
         l2 = buffr2;
         l3 = buffr3;
         
}

void D () {
         
         string bufff7 = f7;
         string bufff8 = f8;
         string bufff9 = f9;
         
         string buffr7 = r7;
         string buffr8 = r8;
         string buffr9 = r9;
         
         string buffb7 = b7;
         string buffb8 = b8;
         string buffb9 = b9;
         
         string buffl7 = l7;
         string buffl8 = l8;
         string buffl9 = l9;
         
         f7 = buffr7;
         f8 = buffr8;
         f9 = buffr9;
         
         r7 = buffb7;
         r8 = buffb8;
         r9 = buffb9;
         
         b7 = buffl7;
         b8 = buffl8;
         b9 = buffl9;
         
         l7 = bufff7;
         l8 = bufff8;
         l9 = bufff9;        
         
}

void Di () {
         
         string bufff7 = f7;
         string bufff8 = f8;
         string bufff9 = f9;
         
         string buffr7 = r7;
         string buffr8 = r8;
         string buffr9 = r9;
         
         string buffb7 = b7;
         string buffb8 = b8;
         string buffb9 = b9;
         
         string buffl7 = l7;
         string buffl8 = l8;
         string buffl9 = l9;
         
         f7 = buffl7;
         f8 = buffl8;
         f9 = buffl9;
         
         r7 = bufff7;
         r8 = bufff8;
         r9 = bufff9;
         
         b7 = buffr7;
         b8 = buffr8;
         b9 = buffr9;
         
         l7 = buffb7;
         l8 = buffb8;
         l9 = buffb9;        
         
}

void D2 () {
         
         string bufff7 = f7;
         string bufff8 = f8;
         string bufff9 = f9;
         
         string buffr7 = r7;
         string buffr8 = r8;
         string buffr9 = r9;
         
         string buffb7 = b7;
         string buffb8 = b8;
         string buffb9 = b9;
         
         string buffl7 = l7;
         string buffl8 = l8;
         string buffl9 = l9;
         
         f7 = buffb7;
         f8 = buffb8;
         f9 = buffb9;
         
         r7 = buffl7;
         r8 = buffl8;
         r9 = buffl9;
         
         b7 = bufff7;
         b8 = bufff8;
         b9 = bufff9;
         
         l7 = buffr7;
         l8 = buffr8;
         l9 = buffr9;
         
}

void F () {
     
         string buffu7 = u7;
         string buffu8 = u8;
         string buffu9 = u9;
         
         string buffr1 = r1;
         string buffr4 = r4;
         string buffr7 = r7;
         
         string buffd3 = d3;
         string buffd2 = d2;
         string buffd1 = d1;
         
         string buffl9 = l9;
         string buffl6 = l6;
         string buffl3 = l3;
         
         u7 = buffl9;
         u8 = buffl6;
         u9 = buffl3;
         
         r1 = buffu7;
         r4 = buffu8;
         r7 = buffu9;
         
         d3 = buffr1;
         d2 = buffr4;
         d1 = buffr7;
         
         l9 = buffd3;
         l6 = buffd2;
         l3 = buffd1;     
     
}

void Fi () {
     
         string buffu7 = u7;
         string buffu8 = u8;
         string buffu9 = u9;
         
         string buffr1 = r1;
         string buffr4 = r4;
         string buffr7 = r7;
         
         string buffd3 = d3;
         string buffd2 = d2;
         string buffd1 = d1;
         
         string buffl9 = l9;
         string buffl6 = l6;
         string buffl3 = l3;
         
         u7 = buffr1;
         u8 = buffr4;
         u9 = buffr7;
         
         r1 = buffd3;
         r4 = buffd2;
         r7 = buffd1;
         
         d3 = buffl9;
         d2 = buffl6;
         d1 = buffl3;
         
         l9 = buffu7;
         l6 = buffu8;
         l3 = buffu9;     
     
}

void F2 () {
     
         string buffu7 = u7;
         string buffu8 = u8;
         string buffu9 = u9;
         
         string buffr1 = r1;
         string buffr4 = r4;
         string buffr7 = r7;
         
         string buffd3 = d3;
         string buffd2 = d2;
         string buffd1 = d1;
         
         string buffl9 = l9;
         string buffl6 = l6;
         string buffl3 = l3;
         
         u7 = buffd3;
         u8 = buffd2;
         u9 = buffd1;
         
         r1 = buffl9;
         r4 = buffl6;
         r7 = buffl3;
         
         d3 = buffu7;
         d2 = buffu8;
         d1 = buffu9;
         
         l9 = buffr1;
         l6 = buffr4;
         l3 = buffr7;
     
}

void B () {
     
         string buffu1 = u1;
         string buffu2 = u2;
         string buffu3 = u3;
         
         string buffr3 = r3;
         string buffr6 = r6;
         string buffr9 = r9;
         
         string buffd9 = d9;
         string buffd7 = d7;
         string buffd8 = d8;
         
         string buffl7 = l7;
         string buffl4 = l4;
         string buffl1 = l1;
         
         u1 = buffl7;
         u2 = buffl4;
         u3 = buffl1;
         
         r3 = buffu1;
         r6 = buffu2;
         r9 = buffu3;
         
         d9 = buffr3;
         d7 = buffr6;
         d8 = buffr9;
         
         l7 = buffd9;
         l4 = buffd7;
         l1 = buffd8;     
     
}

void Bi () {
     
         string buffu1 = u1;
         string buffu2 = u2;
         string buffu3 = u3;
         
         string buffr3 = r3;
         string buffr6 = r6;
         string buffr9 = r9;
         
         string buffd9 = d9;
         string buffd7 = d7;
         string buffd8 = d8;
         
         string buffl7 = l7;
         string buffl4 = l4;
         string buffl1 = l1;
         
         u1 = buffr3;
         u2 = buffr6;
         u3 = buffr9;
         
         r3 = buffd9;
         r6 = buffd7;
         r9 = buffd8;
         
         d9 = buffl7;
         d7 = buffl4;
         d8 = buffl1;
         
         l7 = buffu1;
         l4 = buffu2;
         l1 = buffu3;     
     
}

void B2 () {
     
         string buffu1 = u1;
         string buffu2 = u2;
         string buffu3 = u3;
         
         string buffr3 = r3;
         string buffr6 = r6;
         string buffr9 = r9;
         
         string buffd9 = d9;
         string buffd7 = d7;
         string buffd8 = d8;
         
         string buffl7 = l7;
         string buffl4 = l4;
         string buffl1 = l1;
         
         u1 = buffd9;
         u2 = buffd7;
         u3 = buffd8;
         
         r3 = buffl7;
         r6 = buffl4;
         r9 = buffl1;
         
         d9 = buffu1;
         d7 = buffu2;
         d8 = buffu3;
         
         l7 = buffr3;
         l4 = buffr6;
         l1 = buffr9;
              
}

void L () {
     
         string buffu7 = u7;
         string buffu4 = u4;
         string buffu1 = u1;
         
         string buffb3 = b3;
         string buffb6 = b6;
         string buffb9 = b9;
         
         string buffd7 = d7;
         string buffd4 = d4;
         string buffd1 = d1;
         
         string bufff7 = f7;
         string bufff4 = f4;
         string bufff1 = f1;
         
         u7 = buffb3;
         u4 = buffb6;
         u1 = buffb9;
         
         b3 = buffd7;
         b6 = buffd4;
         b9 = buffd1;
         
         d7 = bufff7;
         d4 = bufff4;
         d1 = bufff1;
         
         f7 = buffu7;
         f4 = buffu4;
         f1 = buffu1;    
     
}

void Li () {
     
         string buffu7 = u7;
         string buffu4 = u4;
         string buffu1 = u1;
         
         string buffb3 = b3;
         string buffb6 = b6;
         string buffb9 = b9;
         
         string buffd7 = d7;
         string buffd4 = d4;
         string buffd1 = d1;
         
         string bufff7 = f7;
         string bufff4 = f4;
         string bufff1 = f1;
         
         u7 = bufff7;
         u4 = bufff4;
         u1 = bufff1;
         
         b3 = buffu7;
         b6 = buffu4;
         b9 = buffu1;
         
         d7 = buffb3;
         d4 = buffb6;
         d1 = buffb9;
         
         f7 = buffd7;
         f4 = buffd4;
         f1 = buffd1;
     
}

void L2 () {
     
         string buffu7 = u7;
         string buffu4 = u4;
         string buffu1 = u1;
         
         string buffb3 = b3;
         string buffb6 = b6;
         string buffb9 = b9;
         
         string buffd7 = d7;
         string buffd4 = d4;
         string buffd1 = d1;
         
         string bufff7 = f7;
         string bufff4 = f4;
         string bufff1 = f1;
         
         u7 = buffd7;
         u4 = buffd4;
         u1 = buffd1;
         
         b3 = bufff7;
         b6 = bufff4;
         b9 = bufff1;
         
         d7 = buffu7;
         d4 = buffu4;
         d1 = buffu1;
         
         f7 = buffb3;
         f4 = buffb6;
         f1 = buffb9;
     
}

void R () {
     
         string buffu9 = u9;
         string buffu6 = u6;
         string buffu3 = u3;
         
         string buffb1 = b1;
         string buffb4 = b4;
         string buffb7 = b7;
         
         string buffd9 = d9;
         string buffd6 = d6;
         string buffd3 = d3;
         
         string bufff9 = f9;
         string bufff6 = f6;
         string bufff3 = f3;
         
         u9 = bufff9;
         u6 = bufff6;
         u3 = bufff3;
         
         b1 = buffu9;
         b4 = buffu6;
         b7 = buffu3;
         
         d9 = buffb1;
         d6 = buffb4;
         d3 = buffb7;
         
         f9 = buffd9;
         f6 = buffd6;
         f3 = buffd3;     
     
}

void Ri () {
     
         string buffu9 = u9;
         string buffu6 = u6;
         string buffu3 = u3;
         
         string buffb1 = b1;
         string buffb4 = b4;
         string buffb7 = b7;
         
         string buffd9 = d9;
         string buffd6 = d6;
         string buffd3 = d3;
         
         string bufff9 = f9;
         string bufff6 = f6;
         string bufff3 = f3;
         
         u9 = buffb1;
         u6 = buffb4;
         u3 = buffb7;
         
         b1 = buffd9;
         b4 = buffd6;
         b7 = buffd3;
         
         d9 = bufff9;
         d6 = bufff6;
         d3 = bufff3;
         
         f9 = buffu9;
         f6 = buffu6;
         f3 = buffu3;     
     
}

void R2 () {
     
         string buffu9 = u9;
         string buffu6 = u6;
         string buffu3 = u3;
         
         string buffb1 = b1;
         string buffb4 = b4;
         string buffb7 = b7;
         
         string buffd9 = d9;
         string buffd6 = d6;
         string buffd3 = d3;
         
         string bufff9 = f9;
         string bufff6 = f6;
         string bufff3 = f3;
         
         u9 = buffd9;
         u6 = buffd6;
         u3 = buffd3;
         
         b1 = bufff9;
         b4 = bufff6;
         b7 = bufff3;
         
         d9 = buffu9;
         d6 = buffu6;
         d3 = buffu3;
         
         f9 = buffb1;
         f6 = buffb4;
         f3 = buffb7;
     
}

void move (string mv) {
     
     if (mv == "U") {
                U();                
     } else if (mv == "Ui") {
                Ui();                
     } else if (mv == "U2") {
                U2();                
     } else if (mv == "D") {
                D();                
     } else if (mv == "Di") {
                Di();                
     } else if (mv == "D2") {
                D2();                
     } else if (mv == "F") {
                F();                
     } else if (mv == "Fi") {
                Fi();                
     } else if (mv == "F2") {
                F2();                
     } else if (mv == "B") {
                B();                
     } else if (mv == "Bi") {
                Bi();                
     } else if (mv == "B2") {
                B2();                
     } else if (mv == "L") {
                L();                
     } else if (mv == "Li") {
                Li();                
     } else if (mv == "L2") {
                L2();                
     } else if (mv == "R") {
                R();                
     } else if (mv == "Ri") {
                Ri();                
     } else if (mv == "R2") {
                R2();                
     } else {
            cout << mv << " is not a valid move" << endl;       
     }

}

void scramble () {
     srand(time(NULL));
     int num_moves = ((rand() % 10000)+1);
     cout << "scrambling" << endl;
     Sleep(2000);
     for (int i=0; i<num_moves; i++) {
         int move_to_make = (rand() % 18);
         move(moves[move_to_make]);
         cout << moves[move_to_make] << endl;
     }
     cout << "number of moves the cube was scrambled by: " << num_moves << endl;
}

bool checkSolved () {
     
    if (    
    u1 != "w") { return false; } if (
    u2 != "w") { return false; } if (
    u3 != "w") { return false; } if (
    
    u4 != "w") { return false; } if (
    u5 != "w") { return false; } if (
    u6 != "w") { return false; } if (
    
    u7 != "w") { return false; } if (
    u8 != "w") { return false; } if (
    u9 != "w") { return false; } if (
    
    //front/////////green
    
    f1 != "g") { return false; } if (
    f2 != "g") { return false; } if (
    f3 != "g") { return false; } if (
    
    f4 != "g") { return false; } if (
    f5 != "g") { return false; } if (
    f6 != "g") { return false; } if (
    
    f7 != "g") { return false; } if (
    f8 != "g") { return false; } if (
    f9 != "g") { return false; } if (
    
    //left//////////orange
    
    l1 != "o") { return false; } if (
    l2 != "o") { return false; } if (
    l3 != "o") { return false; } if (
    
    l4 != "o") { return false; } if (
    l5 != "o") { return false; } if (
    l6 != "o") { return false; } if (
    
    l7 != "o") { return false; } if (
    l8 != "o") { return false; } if (
    l9 != "o") { return false; } if (
    
    //right/////////red
    
    r1 != "r") { return false; } if (
    r2 != "r") { return false; } if (
    r3 != "r") { return false; } if (
    
    r4 != "r") { return false; } if (
    r5 != "r") { return false; } if (
    r6 != "r") { return false; } if (
    
    r7 != "r") { return false; } if (
    r8 != "r") { return false; } if (
    r9 != "r") { return false; } if (
    
    //down//////////yellow
    
    d1 != "y") { return false; } if (
    d2 != "y") { return false; } if (
    d3 != "y") { return false; } if (
    
    d4 != "y") { return false; } if (
    d5 != "y") { return false; } if (
    d6 != "y") { return false; } if (
    
    d7 != "y") { return false; } if (
    d8 != "y") { return false; } if (
    d9 != "y") { return false; } if (
    
    //back//////////blue
    
    b1 != "b") { return false; } if (
    b2 != "b") { return false; } if (
    b3 != "b") { return false; } if (
    
    b4 != "b") { return false; } if (
    b5 != "b") { return false; } if (
    b6 != "b") { return false; } if (
    
    b7 != "b") { return false; } if (
    b8 != "b") { return false; } if (
    b9 != "b") { return false; }                                             
    
    return true;
     
}

void findSolution () {
       solution = "";
       if (checkSolved()) {
          cout << "solution: " << solution;
       } else {
       
              for (int i=0;i<18;i++) {
                  //new thread
                        //cube 
                        //cube.move(moves[i])
                        //cube.solution = solution+moves[i]
                        //findSolution()
                   }
       }  
}
};
