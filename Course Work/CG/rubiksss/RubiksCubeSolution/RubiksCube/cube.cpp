#include "StdAfx.h"
#include "cube.h"
#include "DefinedColorsGL.h"


Cube::Cube(GLfloat _size)
{
	size = _size;
	frontSquare = new Square(size);
	backSquare = new Square(size);
	rightSquare = new Square(size);
	leftSquare = new Square(size);
	bottomSquare = new Square(size);
	topSquare = new Square(size);
}

Cube::Cube()
{
	size = 0;
	frontSquare = new Square(size);
	backSquare = new Square(size);
	rightSquare = new Square(size);
	leftSquare = new Square(size);
	bottomSquare = new Square(size);
	topSquare = new Square(size);
}

Cube::~Cube(void)
{
	delete topSquare;
	delete bottomSquare;
	delete rightSquare;
	delete leftSquare;
	delete frontSquare;
	delete backSquare;
}

void Cube::Render()
{
	RenderSquares();
}

void Cube::RenderSquares()
{

	//render the front square
	glPushMatrix();
	glTranslatef(0.0, 0.0, size/2); //move square to the front
	frontSquare->Render();
	glPopMatrix();

	//render the back square
	glPushMatrix();
	glTranslatef(0.0, 0.0, -size/2); //move square to the back
	glRotatef(180.0, 0.0, 1.0, 0.0); //flip the square 180 degrees on y axis
	backSquare->Render();
	glPopMatrix();



	//render the left square
	glPushMatrix();
	glTranslatef(-size/2, 0.0, 0.0); //move square to the left
	glRotatef(-90.0, 0.0, 1.0, 0.0); //rotate it 90 degree counter clockwise along y axis
	leftSquare->Render();
	glPopMatrix();

	//render the top square
	glPushMatrix();
	glTranslatef(0.0, size/2, 0.0); //move the square up
	glRotatef(-90.0, 1.0, 0.0, 0.0); //rotate square 90 degrees counter clockwise along x axis
	topSquare->Render();
	glPopMatrix();

	//render the bottom square
	glPushMatrix();
	glTranslatef(0.0, -size/2, 0.0); //move the square down
	glRotatef(90.0, 1.0, 0.0, 0.0); //rotate square 90 degrees clockwise along x axis
	bottomSquare->Render();
	glPopMatrix();

	//render the right square
	glPushMatrix();
	glTranslatef(size/2, 0.0, 0.0); //move square to the right
	glRotatef(90.0, 0.0, 1.0, 0.0); //rotate it 90 degrees counter clockwise along y axis
	rightSquare->Render();
	glPopMatrix();


}

	void Cube::SetLeftColor(ColorGL _color)
	{
		leftSquare->SetCurrentColor(_color);
	}
	void Cube::SetRightColor(ColorGL _color)
	{
		rightSquare->SetCurrentColor(_color);
	}
	void Cube::SetTopColor(ColorGL _color)
	{
		topSquare->SetCurrentColor(_color);
	}
	void Cube::SetBottomColor(ColorGL _color)
	{
		bottomSquare->SetCurrentColor(_color);
	}
	void Cube::SetFrontColor(ColorGL _color)
	{
		frontSquare->SetCurrentColor(_color);
	}
	void Cube::SetBackColor(ColorGL _color)
	{
		backSquare->SetCurrentColor(_color);
	}

	void Cube::SetFaceColors(ColorGL _front, ColorGL _back, ColorGL _top, ColorGL _bottom, ColorGL _right, ColorGL _left)
	{

	}

	void Cube::SetFaceColors(ColorGL _all)
	{
		backSquare->SetCurrentColor(_all);
		topSquare->SetCurrentColor(_all);
		frontSquare->SetCurrentColor(_all);
		bottomSquare->SetCurrentColor(_all);
		leftSquare->SetCurrentColor(_all);
		rightSquare->SetCurrentColor(_all);
	}

//this is a temporary function to set the colors of the squares
//will need to implement an interface to allow the cube creator
//to set the colors of the faces
void Cube::tempSetColors()
{
	frontSquare->SetCurrentColor(Colors::Blue);
	backSquare->SetCurrentColor(Colors::Red);
	rightSquare->SetCurrentColor(Colors::Green);
	leftSquare->SetCurrentColor(Colors::Purple);
	bottomSquare->SetCurrentColor(Colors::Yellow);
	topSquare->SetCurrentColor(Colors::White);
}