# include <iostream>
# include <conio.h>
# include <graphics.h>
# include <math.h>

using namespace std;

char IncFlag;
int PolygonPoints[4][2] =
    {{10,100},{110,100},{110,200},{10,200}};

int RefX = 10;
int RefY = 100;

void PolyLine()
{
    int iCnt;
    cleardevice();
    line(0,240,640,240);
    line(320,0,320,480);
    for (iCnt=0; iCnt<4; iCnt++)
    {
        line(PolygonPoints[iCnt][0],PolygonPoints[iCnt][1],
          PolygonPoints[(iCnt+1)%4][0],PolygonPoints[(iCnt+1)%4][1]);
    }
}

void Translate(int Direction)
{
    int iCnt;
    for (iCnt=0; iCnt<4; iCnt++)
    {
        PolygonPoints[iCnt][0] += Direction*RefX;
        PolygonPoints[iCnt][1] -= Direction*RefY;
    }
}

void Rotate()
{
    float Angle;
    int iCnt;
    int Tx,Ty;
    Translate(-1);
    cout<<endl;
    Angle = 30.0*(22.0/7.0)/180.0;
    for (iCnt=0; iCnt<4; iCnt++)
    {
        Tx = PolygonPoints[iCnt][0];
        Ty = PolygonPoints[iCnt][1];
        PolygonPoints[iCnt][0] = (Tx - 320)*cos(Angle) -
                     (Ty - 240)*sin(Angle) + 320;
        PolygonPoints[iCnt][1] = (Tx - 320)*sin(Angle) +
                     (Ty - 240)*cos(Angle) + 240;
    }
    Translate(1);
}

int  main()
{
    int gDriver = DETECT, gMode;
    int iCnt;
    initgraph(&gDriver, &gMode, "C:\\TC\\BGI");
    for (iCnt=0; iCnt<4; iCnt++)
    {
        PolygonPoints[iCnt][0] += 320;
        PolygonPoints[iCnt][1] = 240 - PolygonPoints[iCnt][1];
    }
    PolyLine();
    getch();
    Rotate();
    PolyLine();
    getch();
}
