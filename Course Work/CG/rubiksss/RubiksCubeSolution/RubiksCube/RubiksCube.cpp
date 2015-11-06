// RubiksCube.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

#include "DefinedColorsGL.h"
#include "square.h"
#include "colorGL.h"
#include "cube.h"
#include "rcube.h"
#include "3DMath.h"
#include "Arcball.h"
#include "ArcBallNehe.h"
#include "MoveGenerator.h"
const unsigned int TIME = 75;

//global variables
GLsizei g_Window_Height = 500;
GLsizei g_Window_Width = 500;
GLfloat zAngle = 0;
GLfloat yAngle = 0;
GLfloat xAngle = 0;
bool isClicked = false;
bool isDragging = false;
RCube *rcube;
int rcubeDimension = 3;
int numMoves = 18;
MoveGenerator *generator;

Arcball* aBall;
Matrix3f* mLastRotation;   //matrix for last rotation
Matrix3f* mThisRotation;   //matrix for current rotation
Matrix4f* mTransformation; //transformaton matrix


#pragma region Callback Function Declarations
void display();

void reshape(GLsizei width, GLsizei height);

void keyboard(unsigned char key, int x, int y);

void mouse(int button, int state, int x, int y);

void motion(int x, int y);

void animate(int value);


#pragma endregion

void myInit();
void SetCamera( GLdouble width, GLdouble height );
void ResetCube(int dimension);

int main(int argc, char* argv[])
{
	//initialize the window
	glutInit(&argc, argv);
	glutInitDisplayMode( GLUT_RGBA | GLUT_DOUBLE);
	glutInitWindowSize(g_Window_Width, g_Window_Height);
	glutCreateWindow("Rubiks Cube");

	//assign callback functions
	glutDisplayFunc(display);
	glutReshapeFunc(reshape);
	glutKeyboardFunc(keyboard);
	glutMouseFunc(mouse);
	glutMotionFunc(motion);

	myInit();

	glutMainLoop();

	return 0;
}



void display()
{
	glClear( GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT );
	glLoadIdentity();
	glTranslatef(0,0,-6);
	glTranslatef(-2,0,0);
	glTranslatef(0, -2.2, 0);

	glPushMatrix();
	glMultMatrixf(mTransformation->Data());
	rcube->Render();
	glPopMatrix();

	glFlush();
	glutSwapBuffers();

}

void reshape(GLsizei width, GLsizei height)
{
	g_Window_Width = width;
	g_Window_Height = height;
	
	SetCamera( (GLdouble)g_Window_Width, (GLdouble)g_Window_Height);
	aBall->SetBounds((float)width, (float)height);
}

void keyboard(unsigned char key, int x, int y)
{


	if((key == 's' || key == 'S') && !rcube->IsAnimating()) //scramble cube
	{
		ResetCube(rcubeDimension);
		for(int i = 0; i < numMoves; i++)
		{
			Move newMove = generator->GenerateMove(rcubeDimension);
			rcube->DoMove(newMove);
			rcube->AddMove(newMove);
			glutPostRedisplay();
		}
	}


	if((key == 'f' || key == 'F') && !rcube->IsAnimating()) //solve cube
	{
		rcube->Solve();
		glutTimerFunc(TIME, animate, 0);
	}

	if( (key == 'r' || key == 'R') ) //reset cube
	{
		ResetCube(rcubeDimension);
	}

	if( (key == 'w' || key == 'W') ) //decrease dimension
	{
		if(rcubeDimension > 2)
		{
			ResetCube(rcubeDimension - 1);
		}
	}

	if( (key == 'e' || key == 'E') ) //increase dimension
	{
		if( rcubeDimension < 7 )
			ResetCube(rcubeDimension + 1);
	}

}

void ResetCube(int dimension)
{
	rcubeDimension = dimension;
	numMoves = (rcubeDimension * rcubeDimension) * 2;
	delete rcube;
	rcube = new RCube(rcubeDimension);
	mTransformation->Identity();
	mLastRotation->Identity();
	mThisRotation->Identity();
	glutPostRedisplay();
}

void mouse(int button, int state, int x, int y)
{

	if(button == GLUT_LEFT_BUTTON && state == GLUT_DOWN)
	{
		if(!isDragging)
		{
			isDragging = true;
			isClicked = true;
			*mLastRotation = *mThisRotation;
			aBall->Click(&Point3f(x, y, 0));
		}
	}
	if(button == GLUT_LEFT_BUTTON && state == GLUT_UP)
		if(isClicked)
		{
			isClicked = false;
			isDragging = false;
		}
}

void motion(int x, int y)
{

	if(isDragging)
	{
	if(isClicked)
	{

		Quaternion tQuat(0, 0, 0, 1);
		aBall->Drag(&Point3f(x, y, 0), &tQuat);	
		
		mThisRotation->SetFromQuat(&tQuat);
		*mThisRotation = *mThisRotation * *mLastRotation;
		mTransformation->SetRotation(mThisRotation);

		glutPostRedisplay();
	}
	}

}

void animate(int value)
{
	if(rcube->IsAnimating())
	{
		rcube->IncrementMoveAngle(15);
		glutPostRedisplay();
		glutTimerFunc(TIME, animate, 0);
	}
}



void myInit()
{
	GLfloat size = 2.0;
	mTransformation = new Matrix4f();
	mLastRotation = new Matrix3f();
	mThisRotation = new Matrix3f();
	rcube = new RCube(rcubeDimension);
	generator = new MoveGenerator();
	glClearColor(.75f, 0.75f, 0.75f, 1.0f);
	aBall = new Arcball(g_Window_Width, g_Window_Height);
	//set up viewing
	SetCamera( (GLdouble)g_Window_Width, (GLdouble)g_Window_Height);
	glEnable(GL_DEPTH_TEST);
	glEnable(GL_CULL_FACE);
	glCullFace(GL_BACK);

}

void SetCamera( GLdouble width, GLdouble height)
{
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	gluPerspective(45.0, ((GLdouble)g_Window_Width / (GLdouble)g_Window_Height), 1.0, 100);
	gluLookAt(2, 2, 5,
			  0, 0, 0,
			  0, 1, 0);
	//glOrtho(0.0, g_Window_Width, 0.0, g_Window_Height, -25.0, 1000.0);
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
	glViewport( 0, 0, g_Window_Width, g_Window_Height);
}