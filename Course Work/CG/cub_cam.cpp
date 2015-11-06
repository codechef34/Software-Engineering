

#ifdef __APPLE_CC__
#include <GLUT/glut.h>
#else
#include <GL/glut.h>
#endif
#include <cmath>

namespace myCube {


GLint vertices[8][3] = {
  {0, 0, 0}, {0, 0, 1}, {0, 1, 0}, {0, 1, 1},
  {1, 0, 0}, {1, 0, 1}, {1, 1, 0}, {1, 1, 1}};

GLint faces[6][4] = {
  {1, 5, 7, 3}, {5, 4, 6, 7}, {4, 0, 2, 6},
  {3, 7, 6, 2}, {0, 1, 3, 2}, {0, 4, 5, 1}};

GLfloat vertexColors[8][3] = {
  {0.0,0.0,0.0}, {1.0,0.0,0.0}, {1.0,1.0,0.0}, {0.0,1.0,0.0},
	{0.0,0.0,1.0}, {1.0,0.0,1.0}, {1.0,1.0,1.0}, {0.0,1.0,1.0}};

void myDraw() {
  glBegin(GL_QUADS);
  for (int i = 0; i < 6; i++) {
    for (int j = 0; j < 4; j++) {
      glColor3fv((GLfloat*)&vertexColors[faces[i][j]]);
      glVertex3iv((GLint*)&vertices[faces[i][j]]);
    }
  }
  glEnd();
}
}

void myDisplay() {
  glClear(GL_COLOR_BUFFER_BIT);
  myCube::myDraw();
  glFlush();
  glutSwapBuffers();
}

void timer(int v) {
  static GLfloat x = 0.0;
  x += 0.01;
  glLoadIdentity();
  gluLookAt(10*cos(x), 6*cos(x)-1, 5*cos(x/3)+2, 0, 0, 0, 0, 1, 0);
  //gluLookAt(20*cos(u/8.0)+12,5*sin(u/8.0)+1,10*cos(u/8.0)+2, 0,0,0, 0,1,0);
  glutPostRedisplay();
  glutTimerFunc(1600/60.0, timer, v);
}

void myReshape(int w, int h) {
  glViewport(0, 0, w, h);
  glMatrixMode(GL_PROJECTION);
  glLoadIdentity();
  gluPerspective(60.0, GLfloat(w) / GLfloat(h), 0.5, 40.0);
  glMatrixMode(GL_MODELVIEW);
}

void init() {
  glEnable(GL_CULL_FACE);
  glCullFace(GL_BACK);
}

int main(int argc, char** argv) {
  glutInit(&argc, argv);
  glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
  glutInitWindowSize(500, 500);
  glutCreateWindow("The RGB Color Cube");
  glutReshapeFunc(myReshape);
  glutTimerFunc(100, timer, 0);
  glutDisplayFunc(myDisplay);
  init();
  glutMainLoop();
}
