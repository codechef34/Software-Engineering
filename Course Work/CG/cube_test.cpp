

#ifdef __APPLE__
#include <GLUT/glut.h>
#else
#include <GL/glut.h>
#endif
#include <stdio.h>
#include <stdarg.h>
#include <math.h>

#include <time.h>
#define ESC 27
#define GLUT_KEY_RIGHT 1
#define GLUT_KEY_LEFT 2
#define GLUT_KEY_UP 3
#define GLUT_KEY_DOWN 4

// Vertices of the cube, centered at the origin.
GLfloat vertices[][3] = { {-1.0,-1.0,-1.0}, {1.0,-1.0,-1.0}, {1.0,1.0,-1.0},
	{-1.0,1.0,-1.0}, {-1.0,-1.0,1.0}, {1.0,-1.0,1.0}, {1.0,1.0,1.0}, {-1.0,1.0,1.0} };

// Colors of the vertices.
GLfloat colors[][3] = { {0.0,0.0,0.0}, {1.0,0.0,0.0}, {1.0,1.0,0.0}, {0.0,1.0,0.0},
	{0.0,0.0,1.0}, {1.0,0.0,1.0}, {1.0,1.0,1.0}, {0.0,1.0,1.0} };

// Indices of the vertices to make up the six faces of the cube.
GLubyte cubeIndices[24] = {0,3,2,1, 2,3,7,6, 0,4,7,3, 1,2,6,5, 4,5,6,7, 0,1,5,4};
// angle of rotation for the camera direction
float angle=0.0;
// actual vector representing the camera's direction
float lx=0.0f,lz=-1.0f;
// XZ position of the camera
float x=0.0f,z=5.0f;

GLfloat theta[] = {0.0, 0.0, 0.0};  /* initial rotation angles  */
GLint axis = 2;                     /* initial axis of rotation */
GLdouble viewer[]= {0.0, 0.0, 5.0}; /* initial viewer location  */
bool rotating = true;               /* rotating initially on    */


void colorcube(void);
void display(void);
void spinCube(void);
void mouse(int btn, int state, int x, int y);
void keys(unsigned char key, int x, int y);
//void specialKeys( int key, int x, int y );
void processSpecialKeys(int key, int xx, int yy);
void Keyboard(unsigned char key, int x, int y);
void myReshape(int w, int h);
void sleep (clock_t wait);

int main(int argc, char **argv)
{
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
    glutInitWindowSize(400, 400);
    glutInitWindowPosition (100, 50);
    glutCreateWindow("colorcube");
    glutReshapeFunc(myReshape);
    glutDisplayFunc(display);
	glutIdleFunc(spinCube);
	glutMouseFunc(mouse);
	//glutKeyboardFunc (Keyboard);
	glutSpecialFunc(processSpecialKeys);
	glEnable(GL_DEPTH_TEST);
	glShadeModel (GL_FLAT);
    colorcube ();
    glutMainLoop();
}

// This function sets up the vertex arrays for the color cube.
void colorcube(void)
{
	glEnableClientState (GL_COLOR_ARRAY);
	glEnableClientState (GL_VERTEX_ARRAY);
	glVertexPointer (3, GL_FLOAT, 0, vertices);
	glColorPointer (3, GL_FLOAT, 0, colors);
}

// This function is the display callback. It draws the cube from the current viewing point.
void display(void)
{

    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

    /* Update viewer position in modelview matrix */

	glLoadIdentity();
	//gluLookAt(viewer[0], viewer[1], viewer[2], 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);

	// Set the camera
	//gluLookAt(	x, 1.0f, z,
			x+lx, 1.0f,  z+lz,
			0.0f, 1.0f,  0.0f);
			  gluPerspective(60.0, GLfloat(w) / GLfloat(h), 0.5, 40.0);

    /* Rotate cube */

	glRotatef(theta[0], 1.0, 0.0, 0.0);
	glRotatef(theta[1], 0.0, 1.0, 0.0);
	glRotatef(theta[2], 0.0, 0.0, 1.0);

	/* Draw the cube and switch buffers */

    glDrawElements (GL_QUADS, 24, GL_UNSIGNED_BYTE, cubeIndices);
	glutSwapBuffers();
}

/* This function is the idle callback. It spins the cube 2 degrees about the selected axis. */
void spinCube(void)
{
    if (rotating)
    {
	    theta[axis] += 2.0;
	    if( theta[axis] > 360.0 ) theta[axis] -= 360.0;
	    glutPostRedisplay();
		sleep (25);
    }
}

/* This is the mouse callback function. The mouse buttons determine which axis to rotate about. */
void mouse(int btn, int state, int x, int y)
{
    if(btn==GLUT_LEFT_BUTTON && state == GLUT_DOWN) { axis = 0; rotating = true; }
    if(btn==GLUT_MIDDLE_BUTTON && state == GLUT_DOWN) { axis = 1; rotating = true; }
    if(btn==GLUT_RIGHT_BUTTON && state == GLUT_DOWN) { axis = 2; rotating = true; }
}

void processSpecialKeys(int key, int xx, int yy) {

	float fraction = 0.1f;

	switch (key) {
		case 1 :
			angle -= 0.01f;
			lx = sin(angle);
			lz = -cos(angle);
			break;
		case 2 :
			angle += 0.01f;
			lx = sin(angle);
			lz = -cos(angle);
			break;
		case 3 :
			x += lx * fraction;
			z += lz * fraction;
			break;
		case 4 :
			x -= lx * fraction;
			z -= lz * fraction;
			break;
	}
}

/* This is the keyboard callback function. Keys change the viewer's position as well as turn
   rotation on and off. */


 /* void Keyboard(unsigned char key, int x, int y)
{
  switch (key)
  {
  case 27:             // ESCAPE key
	  exit (0);
	  break;
  }
  if((key == 's') || (key == 'S')) rotating = !rotating;
  //  Right arrow - increase rotation by 5 degree
if (key == '1')
  theta[0]-= 5;

//  Left arrow - decrease rotation by 5 degree
else if (key == '2')
  theta[0]+= 5;

else if (key == '3')
  theta[1] -= 5;

else if (key == '4')
  theta[1] += 5;
  else if (key=='6')
    theta[2]-=5;
  else if (key=='7')
    theta[2]+=5;

}
*/


/* This is the reshape callback function. It produces a perspective projection of the cube. */
 void myReshape(int w, int h)
{
    //GLfloat aspect=(GLfloat)w/(GLfloat)h;
	glViewport(0, 0, w, h);
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	gluPerspective(45.0, (double)w/(double)h, 2.0, 20.0);
	//glOrtho(-2.0,2.0,-2.0/aspect,2.0/aspect,-10.0,10.0);
	glMatrixMode(GL_MODELVIEW);
}

/* Pauses for a specified number of milliseconds. */
void sleep (clock_t wait)
{
   clock_t goal;
   goal = wait + clock();
   while (goal > clock());
}
