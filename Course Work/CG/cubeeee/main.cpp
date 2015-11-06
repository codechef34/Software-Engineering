// Win32Project1.cpp : Defines the entry point for the console application.
//

//#include "stdafx.h"

#include "cmath"
#include "cstdlib"
#include "ctime"
#include "vector"
#include "gl/glut.h"




class myCube;
class myRubixCube;
class myViewer;

void reshape(int a, int b);
void init();
void key(unsigned char key, int a, int b);
void specialkey(int key, int a, int b);
void display();
void differposition(int direction, int & x0, int & x1, int & x2, int & y0, int & y1, int & y2, int & z0, int & z1, int & z2);
void idle();


class myViewer
{
    double position[3];
    double v_alpha, v_beta, v_radius, v_min_radius;
public:
    myViewer(double alpha, double beta, double radius, double min_radius);

    void set_position();
    void special_keyboard(int key);

    void LookAtCentre();
};
myViewer::myViewer(double alpha, double beta, double radius, double min_radius)
{
    v_alpha = alpha; v_beta = beta; v_radius = radius; v_min_radius = min_radius;
    set_position();
}

void myViewer::set_position()
{
    double convert = 3.1415926535897932384626433832795 / 180.0;

    if (v_alpha >= 360)
        v_alpha -= 360;
    else if (v_alpha<0)
        v_alpha += 360;

    if (v_beta >= 360)
        v_beta -= 360;
    else if (v_beta<0)
        v_beta += 360;
    position[0] = (v_radius * cos(convert *  v_beta)) * cos(convert * v_alpha);
    position[1] = v_radius * sin(convert * v_beta);
    position[2] = (v_radius * cos(convert * v_beta)) * sin(convert * v_alpha);
}
void myViewer::special_keyboard(int key)
{
    switch (key)
    {
    case GLUT_KEY_LEFT:
        v_alpha += 2;  set_position();
        glutPostRedisplay(); break;
    case GLUT_KEY_RIGHT:
        v_alpha -= 2; set_position(); glutPostRedisplay(); break;
    case GLUT_KEY_DOWN:
        v_beta -= 2; set_position(); glutPostRedisplay(); break;
    case GLUT_KEY_UP:
        v_beta += 2; set_position(); glutPostRedisplay(); break;
    case GLUT_KEY_PAGE_UP:
        v_radius += 1; set_position(); glutPostRedisplay(); break;
    case GLUT_KEY_PAGE_DOWN:
        v_radius -= 1; if (v_radius<v_min_radius) v_radius = v_min_radius;
        set_position(); glutPostRedisplay(); break;
    }
}

void myViewer::LookAtCentre()
{
    if (v_beta>90 && v_beta<270)
        gluLookAt(position[0], position[1], position[2], 0, 0, 0, 0, -1, 0);
    else
        gluLookAt(position[0], position[1], position[2], 0, 0, 0, 0, 1, 0);
}
myViewer v(45, 45, 20, 10);

class myCube
{
    double cx, cy, cz, len;
    int color[6];
public:
    myCube();
    void set_color(int color);
    void display();
    void rotate(int axis, int direction);
    void set_length(double length);
    friend class myRubixCube;
};
myCube::myCube()
{
    cx = cy = cz = 0;
    len = 1;
    for (int i = 0; i<6; i++)
       color[i] = 0;
}
inline void myCube::set_length(double length)
{
    len = length;
}
void myCube::set_color(int color)
{
    switch (color)
    {
    case 0: glColor3f(1.0, 0.0, 0.0); break;
    case 1: glColor3f(0.0, 1.0, 0.0); break;
    case 2: glColor3f(0.0, 0.0, 1.0); break;
    case 3: glColor3f(0.0, 1.0, 1.0); break;
    case 4: glColor3f(1.0, 1.0, 0.0); break;
    case 5: glColor3f(1.0, 0.0, 1.0); break;
    case 6: glColor3f(0.7, 0.7, 0.7); break;
    default: glColor3f(0, 0, 0);
    }
}
void myCube::display()
{
    glPushMatrix();
    glTranslatef(cx, cy, cz);
    /*Face 1 XY-Plane (Behind)*/
    set_color(color[0]);

    glBegin(GL_POLYGON);
    glVertex3d(-len / 2, -len / 2, -len / 2); glVertex3d(-len / 2, len / 2, -len / 2); glVertex3d(len / 2, len / 2, -len / 2); glVertex3d(len / 2, -len / 2, -len / 2);
    glEnd();
    /*Face 2 XZ-Plane (Bottom)*/
    set_color(color[1]);
    glBegin(GL_POLYGON);
    glVertex3d(-len / 2, -len / 2, -len / 2); glVertex3d(len / 2, -len / 2, -len / 2); glVertex3d(len / 2, -len / 2, len / 2); glVertex3d(-len / 2, -len / 2, len / 2);
    glEnd();
    /*Face 3 YZ-Plane (Left)*/
    set_color(color[2]);

    glBegin(GL_POLYGON);
    glVertex3d(-len / 2, -len / 2, len / 2); glVertex3d(-len / 2, len / 2, len / 2); glVertex3d(-len / 2, len / 2, -len / 2); glVertex3d(-len / 2, -len / 2, -len / 2);
    glEnd();
    /*Face 4 XY-Plane (Front)*/
    set_color(color[3]);

    glBegin(GL_POLYGON);
    glVertex3d(len / 2, -len / 2, len / 2); glVertex3d(len / 2, len / 2, len / 2); glVertex3d(-len / 2, len / 2, len / 2); glVertex3d(-len / 2, -len / 2, len / 2);
    glEnd();
    /*Face 5 XZ-Plane (Top)*/
    set_color(color[4]);

    glBegin(GL_POLYGON);
    glVertex3d(-len / 2, len / 2, len / 2); glVertex3d(len / 2, len / 2, len / 2); glVertex3d(len / 2, len / 2, -len / 2); glVertex3d(-len / 2, len / 2, -len / 2);
    glEnd();
    /*Face 6 YZ-Plane (Right)*/
    set_color(color[5]);

    glBegin(GL_POLYGON);
    glVertex3d(len / 2, -len / 2, len / 2); glVertex3d(len / 2, len / 2, len / 2); glVertex3d(len / 2, len / 2, -len / 2); glVertex3d(len / 2, -len / 2, -len / 2);
    glEnd();
    glPopMatrix();
}
void myCube::rotate(int axis, int direction)
{
    int temp;
    switch (axis)
    {
    case 0:/*X-axis*/
        if (direction)/*Clock-Wise*/
        {
            temp = color[0]; color[0] = color[4]; color[4] = color[3]; color[3] = color[1]; color[1] = temp;
        }
        else/*Anti-Clock-Wise*/
        {
            temp = color[0]; color[0] = color[1]; color[1] = color[3]; color[3] = color[4]; color[4] = temp;
        }
        break;
    case 1:/*Y-axis*/
        if (direction)/*Clock-Wise*/
        {
            temp = color[0]; color[0] = color[2]; color[2] = color[3]; color[3] = color[5]; color[5] = temp;
        }
        else/*Anti-Clock-Wise*/
        {
            temp = color[0]; color[0] = color[5]; color[5] = color[3]; color[3] = color[2]; color[2] = temp;
        }
        break;
    case 2:/*Z-axis*/
        if (direction)/*Clock-Wise*/
        {
            temp = color[1]; color[1] = color[5]; color[5] = color[4]; color[4] = color[2]; color[2] = temp;
        }
        else/*Anti-Clock-Wise*/
        {
            temp = color[1]; color[1] = color[2]; color[2] = color[4]; color[4] = color[5]; color[5] = temp;
        }
        break;
    }
}
class myRubixCube
{

    myCube c[27];
    double len, theta;
    int direction, cubepos[3][3][3];
    bool rotating;
    std::vector<int> axis, plane,
        keypressed/*0=axis change, 1=plane change, 2=clockwise rot, 3=anticlockwise rot*/;
public:
    bool solving;
    myRubixCube(double length);
    void set_centre();
    void display();
    void rotate_cube_plane();
    void display_rotation();
    void rotation_idle_func();
    void keyboard(unsigned char key);
    friend void differposition(int direction, int & a0, int & a1, int & a2, int & b0, int & b1, int & b2, int & c0, int & c1, int & c2);
    void randomize();

};
myRubixCube::myRubixCube(double length)
{
    len = length;
    plane.push_back(2);
    axis.push_back(0);
    solving, rotating = false;
    theta = 0;
    direction = 0;
    int p = 0, i, j, k;
    for (i = 0; i<27; i++)
        c[i].set_length(len);

    for (i = 0; i<9; i++)
    {
        c[i].color[2] = 3; c[i + 18].color[5] = 6;
    }
    for (i = 0; i<27; i += 9)
    {
        c[i + 5].color[0] = 1; c[i + 8].color[0] = 1; c[i + 2].color[0] = 1;
        c[i + 2].color[1] = 2; c[i + 1].color[1] = 2; c[i].color[1] = 2;
        c[i].color[3] = 4; c[i + 3].color[3] = 4; c[i + 6].color[3] = 4;
        c[i + 6].color[4] = 5; c[i + 7].color[4] = 5; c[i + 8].color[4] = 5;
    }
    for (i = 0; i<3; i++)
        for (j = 0; j<3; j++)
            for (k = 0; k<3; k++)
                cubepos[i][j][k] = p++;
    set_centre();
}

void myRubixCube::randomize()
{


    int i, j=22, k, random_var=13456;

    for (i = 0; i<random_var; i++)
    {
        k = j;
        while (j == k || (j == 2 && k == 3) || (j == 3 && k == 2))
            j = rand() % 4;
        keypressed.push_back(k);
        switch (k)
        {
        case 0:
            axis.push_back(rand() % 3);
            break;
        case 1:
            plane.push_back(rand() % 3);
            break;
        case 2:
            direction = 0;
            rotating = false;
            rotate_cube_plane();
            break;
        case 3:
            direction = 1;
            rotating = false;
            rotate_cube_plane();
            break;
        }
    }
}

void myRubixCube::display_rotation()
{
    int i, j, k;
    double angle, disp = len + 0.2;

    if (direction) angle = -theta;
    else angle = theta;

    glPushMatrix();
    switch (axis.back())
    {
    case 0:
        for (i = 0; i<3; i++)
        {
            if (i != plane.back())
            {
                for (j = 0; j<3; j++)
                    for (k = 0; k<3; k++)
                        c[cubepos[i][j][k]].display();
            }
        }
        glRotated(angle, 1, 0, 0);
        for (j = 0; j<3; j++)
            for (k = 0; k<3; k++)
                c[cubepos[plane.back()][j][k]].display();
        break;
    case 1:
        for (j = 0; j<3; j++)
        {
            if (j != plane.back())
            {
                for (i = 0; i<3; i++)
                    for (k = 0; k<3; k++)
                        c[cubepos[i][j][k]].display();
            }
        }
        glRotated(angle, 0, 1, 0);
        for (i = 0; i<3; i++)
            for (k = 0; k<3; k++)
                c[cubepos[i][plane.back()][k]].display();
        break;
    case 2:
        for (k = 0; k<3; k++)
        {
            if (k != plane.back())
            {
                for (i = 0; i<3; i++)
                    for (j = 0; j<3; j++)
                        c[cubepos[i][j][k]].display();
            }
        }
        glRotated(angle, 0, 0, 1);
        for (i = 0; i<3; i++)
            for (j = 0; j<3; j++)
                c[cubepos[i][j][plane.back()]].display();
        break;
    }
    if (axis.back() == 0)
    {
        if (plane.back() == 0) glTranslated(-disp, 0, 0);
        else if (plane.back() == 2) glTranslated(disp, 0, 0);
        glRotatef(90, 0, 1, 0);
    }
    else if (axis.back() == 1)
    {
        if (plane.back() == 0) glTranslated(0, -disp, 0);
        else if (plane.back() == 2) glTranslated(0, disp, 0);
        glRotatef(90, 1, 0, 0);
    }
    else
    {
        if (plane.back() == 0) glTranslated(0, 0, disp);
        else if (plane.back() == 2) glTranslated(0, 0, -disp);
    }
    glColor4f(1, 1, 1, 0.3);
    glRectd(-(len*2.25), -(len*2.25), (len*2.25), (len*2.25));
    glPopMatrix();
}
void myRubixCube::rotation_idle_func()
{
if (rotating)
{
if (theta >= (double)90)
{
glutIdleFunc(NULL);
rotating = false;
theta = 0.0;
rotate_cube_plane();
}
else
theta += +0.5;
glutPostRedisplay();
}
}
void myRubixCube::set_centre()
{
    int i, j, k;
    double dist = len + 0.2;
    for (j = 0; j<3; j++)
    {
        for (k = 0; k<3; k++)
        {
            c[cubepos[0][j][k]].cx = -dist;
            c[cubepos[1][j][k]].cx = 0;
            c[cubepos[2][j][k]].cx = dist;
        }
    }
    for (i = 0; i<3; i++)
    {
        for (j = 0; j<3; j++)
        {
            c[cubepos[i][j][0]].cz = dist;
            c[cubepos[i][j][1]].cz = 0;
            c[cubepos[i][j][2]].cz = -dist;
        }
    }
    for (i = 0; i<3; i++)
    {
        for (k = 0; k<3; k++)
        {
            c[cubepos[i][0][k]].cy = -dist;
            c[cubepos[i][1][k]].cy = 0;
            c[cubepos[i][2][k]].cy = dist;
        }
    }
}
void myRubixCube::display()
{
    GLfloat global_ambient[] = { 0.5f, 0.5f, 0.5f, 1.0f };
    if (!rotating)
    {
        double disp = len + 0.2;
        glPushMatrix();
        for (int i = 0; i<27; i++)
            c[i].display();

        if (axis.back() == 0)
        {
            if (plane.back() == 0) glTranslated(-disp, 0, 0);
            else if (plane.back() == 2) glTranslated(disp, 0, 0);
            glRotatef(90, 0, 1, 0);
        }
        else if (axis.back() == 1)
        {
            if (plane.back() == 0) glTranslated(0, -disp, 0);
            else if (plane.back() == 2) glTranslated(0, disp, 0);
            glRotatef(90, 1, 0, 0);
        }
        else
        {
            if (plane.back() == 0) glTranslated(0, 0, len);
            else if (plane.back() == 2) glTranslated(0, 0, -len);
        }
        glColor4f(1, 1, 1, 0.3);
        glRectd(-(len*2.25), -(len*2.25), (len*2.25), (len*2.25));

        glPopMatrix();
    }
    else
        display_rotation();
}
void differposition(int direction, int & a0, int & a1, int & a2, int & b0, int & b1, int & b2, int & c0, int & c1, int & c2)
{
    int temp;
    if (direction)
    {
        temp = a0; a0 = a2; a2 = c2; c2 = c0; c0 = temp;
        temp = b0; b0 = a1; a1 = b2; b2 = c1; c1 = temp;
    }
    else
    {
        temp = a0; a0 = c0; c0 = c2; c2 = a2; a2 = temp;
        temp = b0; b0 = c1; c1 = b2; b2 = a1; a1 = temp;
    }
}
void myRubixCube::rotate_cube_plane()
{
    if (!rotating)
    {
        int i, j, k;
        if (plane.back() != 0 && plane.back() != 1 && plane.back() != 2)
            exit(2);
        switch (axis.back())
        {
        case 0:
            differposition(direction, cubepos[plane.back()][0][0], cubepos[plane.back()][0][1], cubepos[plane.back()][0][2], cubepos[plane.back()][1][0], cubepos[plane.back()][1][1], cubepos[plane.back()][1][2], cubepos[plane.back()][2][0], cubepos[plane.back()][2][1], cubepos[plane.back()][2][2]);
            break;
        case 1:
            differposition(direction, cubepos[2][plane.back()][0], cubepos[2][plane.back()][1], cubepos[2][plane.back()][2], cubepos[1][plane.back()][0], cubepos[1][plane.back()][1], cubepos[1][plane.back()][2], cubepos[0][plane.back()][0], cubepos[0][plane.back()][1], cubepos[0][plane.back()][2]);
            break;
        case 2:
            differposition(direction, cubepos[0][0][plane.back()], cubepos[1][0][plane.back()], cubepos[2][0][plane.back()], cubepos[0][1][plane.back()], cubepos[1][1][plane.back()], cubepos[2][1][plane.back()], cubepos[0][2][plane.back()], cubepos[1][2][plane.back()], cubepos[2][2][plane.back()]);
            break;
        default:
            exit(2);
        }
        set_centre();

        switch (axis.back())
        {
        case 0:
            for (j = 0; j < 3; j++)
                for (k = 0; k < 3; k++)
                    c[cubepos[plane.back()][j][k]].rotate(0, direction);
            break;
        case 1:
            for (i = 0; i < 3; i++)
                for (k = 0; k < 3; k++)
                    c[cubepos[i][plane.back()][k]].rotate(1, direction);
            break;
        case 2:
            for (i = 0; i < 3; i++)
                for (j = 0; j < 3; j++)
                    c[cubepos[i][j][plane.back()]].rotate(2, direction);
            break;
        }

    }
    else
        glutIdleFunc(idle);
        ;
}
void myRubixCube::keyboard(unsigned char key)
{
    if (!rotating)
    {
        switch (key)
        {

        case '>':
        case '.':
            direction = 1;
            keypressed.push_back(3);
            rotating = true;
            rotate_cube_plane();
            break;
        case ',':
        case '<':
            direction = 0;
            keypressed.push_back(2);
            rotating = true;
            rotate_cube_plane();
            break;
        case 'x':
        case 'X':
            axis.push_back(0);
            keypressed.push_back(0);
            break;
        case 'y':
        case 'Y':
            axis.push_back(1);
            keypressed.push_back(0);
            break;
        case 'z':
        case 'Z':
            axis.push_back(2);
            keypressed.push_back(0);
            break;
        case '1':
            plane.push_back(0);
            keypressed.push_back(1);
            break;
        case '2':
            plane.push_back(1);
            keypressed.push_back(1);
            break;
        case '3':
            plane.push_back(2);
            keypressed.push_back(1);
            break;

        }
    }
}
myRubixCube r(2);

int main(int argc, char * argv[])
{
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_RGB | GLUT_DOUBLE | GLUT_DEPTH);
    glutInitWindowSize(100, 800);
    glutCreateWindow("Rubix's Cube");
    glutDisplayFunc(display);
    glutReshapeFunc(reshape);
    glutKeyboardFunc(key);
    glutSpecialFunc(specialkey);
    init();
    glutMainLoop();
}
void idle()
{
r.rotation_idle_func();
}
void reshape(int w, int h)
{
    glViewport(0, 0, w, h);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluPerspective(70, (GLfloat)w / (GLfloat)h, 1, 200);
    glMatrixMode(GL_MODELVIEW);
}
void key(unsigned char key, int x, int y)
{
    switch (key)
    {


    case 27:
        exit(0);
        break;
    case 'n':

        r.randomize();
        glutPostRedisplay();

        break;
    case '.':
    case ',':
    case 'x':
    case 'y':
    case 'z':
    case '1': case '2': case '3':
        r.keyboard(key);
        glutPostRedisplay();
        break;
        r.keyboard(key);
        glutPostRedisplay();
        break;
    }
}
void specialkey(int key, int x, int y)
{
    switch (key)
    {
    case GLUT_KEY_LEFT: case GLUT_KEY_RIGHT:
    case GLUT_KEY_DOWN:    case GLUT_KEY_UP:
    case GLUT_KEY_PAGE_UP:case GLUT_KEY_PAGE_DOWN:
        v.special_keyboard(key); break;

    }
}
void init()
{
    r.randomize();
    glClearColor(0.2, 0.2, 0.2, 1.0);
    glEnable(GL_SMOOTH);
    glEnable(GL_DEPTH_TEST);
    glEnable(GL_BLEND);
    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
}
void display()
{
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    glLoadIdentity();
    v.LookAtCentre();
    glTranslatef(-5, 0, 0);
    r.display();
    glFlush();
    glutSwapBuffers();

}
