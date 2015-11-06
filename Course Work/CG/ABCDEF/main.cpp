
/*
 * This program create a window 400 x 400 pixels and draws a Rubik's cube.
 *
 * To terminate the program, press the esacpe key.  The mouse pointer must
 * be over the window.
 */

/* include files */
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <GL/gl.h>
#include <GL/glu.h>
#include "gl/glut.h"

#define MAIN_MENU_QUIT 0
#define WINDOW_X_SIZE 400
#define WINDOW_Y_SIZE 400
#define BUFSIZE 512

void initCube(void);
void drawRubiksCube(GLenum mode);
void drawOneSlice(char rotateAxis, GLint sliceNum, GLenum mode);
void printModel(void);
void get_face_and_ijk_of_cube(GLfloat x, GLfloat y, GLfloat z,
 			      GLint *face, GLint *i, GLint *j, GLint *k);
void get_slice_spin_direction(GLfloat clickx, GLfloat clicky, GLfloat clickz,
                              GLfloat x, GLfloat y, GLfloat z, GLint face,
                              GLint *dir);
void get_slice_spin_angle(GLint face, GLint spin_dir, GLfloat *spin);
void get_slice_spin_axis(GLint face, GLint spin_dir, char *axis);
void draw_slices(GLfloat spin, char axis, GLint i, GLint j, GLint k);
void update_slice(GLint face, char axis, GLint i, GLint j, GLint k,
                  GLfloat spin);
void scramble_rubik_cube(void);

GLfloat SliceSpin = 0.0;
GLfloat CubeSpinX = 0.0,  CubeSpinY = 0.0;

GLint MouseX, MouseY, PrevX, PrevY;
char RotationAxis;
GLint CubeI, CubeJ, CubeK;
/* back = 0, front = 1, right = 2, left = 3, bottom = 4, top = 5 */
GLint CubeFace;
/* up = 0, down = 1, left = 2, right = 3 */
GLint SliceSpinDirection = -1;
GLint DemoMode = 0;
GLint RotateCubeMode = 1;
GLint RotateSliceMode = 0;

/***************************************************************/
/* Initialize stuff											   */
/***************************************************************/

void init(void)
{
  glClearColor (0.0, 0.0, 0.0, 0.0);

  /* enable z-buffering */
  glEnable(GL_DEPTH_TEST);

  /* flat shading */
  glShadeModel (GL_FLAT);
}

/***************************************************************/
/* reshape function											   */
/***************************************************************/

void myReshape(GLsizei w, GLsizei h)
{
  GLfloat aspect;

  /* set the viewport to the size of the X-window */
  glViewport(0, 0, (GLsizei) w, (GLsizei) h);
  glMatrixMode(GL_PROJECTION);
  glLoadIdentity();

  /* set the window coordinates */
  aspect = (GLfloat)w / (GLfloat)h;
  /*    gluPerspective(60.0, aspect, 0.5, 50.0);*/
  glOrtho(-5.0, 5.0, -5.0, 5.0, -15.0, 15.0);

  glMatrixMode(GL_MODELVIEW);
  glLoadIdentity();
  glLoadIdentity();
}

/***************************************************************/
/* This function is called by "glut" whenever a key is pressed */
/***************************************************************/

static void keyboard(unsigned char key, int x, int y)
{
  switch (key) {
  case 27:					/* esc key */
    exit(0);
    break;
  }
}

/***************************************************************/
/* This function is called by "glut" whenever a key is pressed */
/***************************************************************/

void display(void)
{
  glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
  glMatrixMode(GL_MODELVIEW);
  glPopMatrix();
  glPushMatrix();

  if (DemoMode) {
    gluLookAt(5.0, 5.0, 5.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
/*     glRotatef(DemoSpin, 0.5, 0.5, 0.5); */
    glRotatef(CubeSpinX, 1.0, 0.0, 0.0);
    glRotatef(CubeSpinY, 0.0, 1.0, 0.0);
    drawRubiksCube(GL_RENDER);
  }
  else if (RotateCubeMode) {
    gluLookAt(5.0, 5.0, 5.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
    glRotatef(CubeSpinX, 1.0, 0.0, 0.0);
    glRotatef(CubeSpinY, 0.0, 1.0, 0.0);
    drawRubiksCube(GL_RENDER);
  }
  else if (RotateSliceMode) {
    gluLookAt(5.0, 5.0, 5.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
    glRotatef(CubeSpinX, 1.0, 0.0, 0.0);
    glRotatef(CubeSpinY, 0.0, 1.0, 0.0);
    get_slice_spin_axis(CubeFace, SliceSpinDirection, &RotationAxis);
    draw_slices(SliceSpin, RotationAxis, CubeI, CubeJ, CubeK);
  }
  glutSwapBuffers();
}

/***************************************************************/
/* callback for mouse click.								   */
/***************************************************************/

void mouse(int button, int state, int x, int y) {
  GLint viewport[4];
  GLdouble model[16], proj[16];
  GLfloat z;
  GLdouble wx, wy, wz;

  if (button == GLUT_LEFT_BUTTON && state == GLUT_DOWN) {
    glGetIntegerv(GL_VIEWPORT, viewport);
    glGetDoublev(GL_MODELVIEW_MATRIX, model);
    glGetDoublev(GL_PROJECTION_MATRIX, proj);

    MouseX = x;
    MouseY = viewport[3]-y;
    PrevX = x;
    PrevY = y;

    glReadPixels(x, viewport[3]-y, 1, 1, GL_DEPTH_COMPONENT, GL_FLOAT, &z);
    gluUnProject((GLfloat)x, (GLfloat) viewport[3]-y, z,
		     model, proj, viewport, &wx, &wy, &wz);

    get_face_and_ijk_of_cube(wx, wy, wz, &CubeFace, &CubeI, &CubeJ, &CubeK);

    if (CubeI == -1 && CubeJ == -1 && CubeK == -1) {
      RotateCubeMode = 1;
      RotateSliceMode = 0;
    }
    else {
      RotateCubeMode = 0;
      RotateSliceMode = 1;
    }
    fflush(stdout);
  }
  else if (button == GLUT_LEFT_BUTTON && state == GLUT_UP) {
    if (RotateSliceMode)
      update_slice(CubeFace, RotationAxis, CubeI, CubeJ, CubeK, SliceSpin);
    RotateCubeMode = 1;
    RotateSliceMode = 0;
    SliceSpinDirection = -1;
    SliceSpin = 0.0;
    glutPostRedisplay();
  }
}

/***************************************************************/
/* callback for passive mouse motion.						   */
/***************************************************************/

void motion(int x, int y) {
  GLint viewport[4];
  GLdouble model[16], proj[16];
  int deltax;
  int deltay;
  GLfloat z;
  GLdouble wx, wy, wz;
  static int count = 0;
  GLdouble ClickWx, ClickWy, ClickWz;

  if (RotateCubeMode) {
    deltax = x - MouseX;
    deltay = y - MouseY;
    MouseX = x;
    MouseY = y;
    if (abs(deltax) > abs(deltay)) {	/* rotate about y-axis */
      if (deltax > 0)
        CubeSpinY += 3.0;
      else
        CubeSpinY -= 3.0;
      if (CubeSpinY > 360.0)
        CubeSpinY -= 360.0;
      if (CubeSpinY < 0.0)
        CubeSpinY += 360.0;
    }
    else {				/* rotate about x-axis */
      if (deltay < 0)
        CubeSpinX += 1.0;
      else
        CubeSpinX -= 1.0;
      if (CubeSpinX > 360.0)
        CubeSpinX -= 360.0;
      if (CubeSpinX < 0.0)
        CubeSpinX += 360.0;
    }
  }
  else if (RotateSliceMode) {
    glGetIntegerv(GL_VIEWPORT, viewport);
    glGetDoublev(GL_MODELVIEW_MATRIX, model);
    glGetDoublev(GL_PROJECTION_MATRIX, proj);

    glReadPixels(PrevX, viewport[3]-PrevY, 1, 1, GL_DEPTH_COMPONENT,
		   GL_FLOAT, &z);
    gluUnProject((GLfloat)PrevX, (GLfloat) viewport[3]-PrevY, z, model,
		   proj, viewport, &ClickWx, &ClickWy, &ClickWz);
    glReadPixels(x, viewport[3]-y, 1, 1, GL_DEPTH_COMPONENT, GL_FLOAT, &z);
    gluUnProject((GLfloat)x, (GLfloat) viewport[3]-y, z, model, proj,
			viewport, &wx, &wy, &wz);

    get_slice_spin_direction(ClickWx, ClickWy, ClickWz, wx, wy, wz, CubeFace,
				 &SliceSpinDirection);
    get_slice_spin_angle(CubeFace, SliceSpinDirection, &SliceSpin);
    if (SliceSpin > 360.0)
      SliceSpin -= 360.0;
    if (SliceSpin < 0.0)
      SliceSpin += 360.0;
    PrevX = x;
    PrevY = y;
  }
  glutPostRedisplay();
}

/***************************************************************/
/* idle action:  spin the cube while in demo mode.			   */
/***************************************************************/

void spinDisplay(void)
{
  if (DemoMode) {
    CubeSpinX = CubeSpinX + 1.0;
    CubeSpinY = CubeSpinY + 1.0;
    if (CubeSpinX > 360.0)
      CubeSpinX = CubeSpinX - 360.0;
    if (CubeSpinY > 360.0)
      CubeSpinY = CubeSpinY - 360.0;
    glutPostRedisplay();
  }
}

/***************************************************************/
/* process the main menu.									   */
/***************************************************************/

static void selectMainMenu(int selection)
{
  switch (selection) {
  case MAIN_MENU_QUIT:
    exit(0);
  case 1:
    scramble_rubik_cube();
    break;
  case 2: 			/* rotate cube */
    DemoMode = 1;
    RotateCubeMode = 0;
    RotateSliceMode = 0;
    break;
  case 3:			/* stop rotate */
    DemoMode = 0;
    RotateCubeMode = 1;
    RotateSliceMode = 0;
    break;
  case 4: 			/* reset */
    DemoMode = 0;
    RotateCubeMode = 1;
    RotateSliceMode = 0;
    CubeSpinX = CubeSpinY = 0.0;
    initCube();
    break;
  }
  glutPostRedisplay();
}

/***************************************************************/
/* MAIN FUNCTION											   */
/***************************************************************/

int main(int argc, char** argv)
{

    /* use glut to create a 400x400 window with single buffering, rgb color */
    glutInit(&argc, argv);
    glutInitDisplayMode (GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
    glutInitWindowSize (WINDOW_X_SIZE, WINDOW_Y_SIZE);
    glutInitWindowPosition (100, 100);
    glutCreateWindow(argv[0]);
    init();

    initCube();

    /* set callback to draw OpenGL */
    glutDisplayFunc(display);

    /* set callback when window resized */
    glutReshapeFunc(myReshape);

    /* set callback for keyboard input */
    glutKeyboardFunc(keyboard);

    /* animation callback */
    glutIdleFunc(spinDisplay);

    glutMouseFunc(mouse);
    glutMotionFunc(motion);

    /* create the main menu */
    glutCreateMenu(selectMainMenu);

    glutAddMenuEntry("Scramble", 1);
    glutAddMenuEntry("Rotate Cube", 2);
    glutAddMenuEntry("Stop Rotate", 3);
    glutAddMenuEntry("Reset", 4);

    /* add quit option to main menu */
    glutAddMenuEntry("Quit", MAIN_MENU_QUIT);

    /* when right mouse button is pressed, menu will appear */
    glutAttachMenu(GLUT_RIGHT_BUTTON);

    /* start glut's event loop */
    glutMainLoop();

    return(0);
}
