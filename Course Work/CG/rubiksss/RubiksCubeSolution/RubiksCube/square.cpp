#include "stdafx.h"

#include "square.h"
#include "MathConstants.h"


Square::Square(GLfloat _size)
{
	size = _size;
	//position.X = 0;
	//position.Y = 0;
	originPosition[0] = 0;
	originPosition[1] = 0;
	originPosition[2] = 0;
	r = (sqrtf( 2.0 ) * size)/2;
	angle = (GLfloat)(PI * 45 /180);
	SetVertices();
}

Square::Square(GLfloat _size, ColorGL _color)
{
	size = _size;
	//position.X = 0;
	//position.Y = 0;
	originPosition[0] = 0;
	originPosition[1] = 0;
	originPosition[2] = 0;
	currentColor = _color;
	//r and angle implementation are left out for now
}

Square::~Square(void)
{
}



void Square::Render()
{
	DrawSquare();
}

#pragma region Modifier functions

void Square::SetCurrentColor(ColorGL _color)
{
	currentColor = _color;
}

void Square::SetPosition(Point2DGL _position)
{
	position = _position;	
}

void Square::SetPosition(GLfloat _X, GLfloat _Y)
{
	//position.X = _X;
	//position.Y = _Y;
	originPosition[0] = _X;
	originPosition[1] = _Y;
	SetVertices();
}

#pragma endregion

#pragma region Square Navigation

void Square::RotateClockwise()
{
	angle -= PI/12;
}

void Square::RotateCounterClockwise()
{
	angle += PI/12;
}

void Square::MoveLeft()
{

}

void Square::MoveRight()
{

}

void Square::MoveDown()
{

}

void Square::MoveUp()
{

}

#pragma endregion

#pragma region Private Member Functions

void Square::DrawSquare()
{

	SetGlColor(currentColor);
	glBegin(GL_QUADS);

		//glVertex3f(position.X - size/2, position.Y - size/2, 0.0); //bottom left
		//glVertex3f(position.X + size/2, position.Y - size/2, 0.0); //bottom right
		//glVertex3f(position.X + size/2, position.Y + size/2, 0.0); //top right
		//glVertex3f(position.X - (size/2), position.Y + size/2, 0.0); //top left
		//glVertex3f(position.X - (cos(angle)*r), position.Y - (sin(angle)*r), 0.0); //bottom left
		//glVertex3f(position.X + (sin(angle)*r), position.Y - (cos(angle)*r), 0.0); //bottom right
		//glVertex3f(position.X + (cos(angle)*r), position.Y + (sin(angle)*r), 0.0); //top right
		//glVertex3f(position.X - (sin(angle)*r), position.Y + (cos(angle)*r), 0.0); //top left


		glVertex3fv(vertices[0]);
		glVertex3fv(vertices[1]);
		glVertex3fv(vertices[2]);
		glVertex3fv(vertices[3]);

	glEnd();
	//glFlush();
}

void Square::SetGlColor(ColorGL _color)
{
	glColor3f(_color.Red, _color.Green, _color.Blue);
}

void Square::SetVertices()
{
	//setting x, y coordinates for all vertices
	//This code assumes that the square will not rotate itself
	//along its Y-axis

	vertices[0][0] = originPosition[0] - size/2; //bottom left
	vertices[0][1] = originPosition[1] - size/2;

	vertices[1][0] = originPosition[0] + size/2; //bottom right
	vertices[1][1] = originPosition[1] - size/2;
	  
	vertices[2][0] = originPosition[0] + size/2; ///top right
	vertices[2][1] = originPosition[1] + size/2;

	vertices[3][0] = originPosition[0] - size/2; //top left
	vertices[3][1] = originPosition[1] + size/2;

	//z coordinate for all vertices is the same
	for(int i = 0; i < 4; i++)
		vertices[i][2] = originPosition[2];

}

#pragma endregion