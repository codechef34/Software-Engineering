#pragma once
#include "colorGL.h"
#include "Point2DGL.h"

class Square
{
public:
	Square(GLfloat _size);
	Square(GLfloat _size, ColorGL _color);
	Square(GLfloat _vertices[4][3]);
	Square(GLfloat _vertices[4][3], ColorGL _color);
	~Square(void);
	void Render();
	void SetCurrentColor(ColorGL _color);
	void SetPosition(Point2DGL _position);
	void SetPosition(GLfloat _X, GLfloat _Y);
	void RotateClockwise();
	void RotateCounterClockwise();
	void MoveUp();
	void MoveDown();
	void MoveRight();
	void MoveLeft();

private:
	GLfloat vertices[4][3]; //array of pointers, each index in an array pointing to a 3d coordinate
						  //starts at bottom leftand going counter clockwise
	
	//GLfloat vBottomLeft[3];	
	//GLfloat vBottomRight[3];	
	//GLfloat vTopRight[3];	
	//GLfloat vTopLeft[3];
	
	GLfloat size;
	ColorGL currentColor;
	Point2DGL position; //represents the 2D coordinates of the center of the square
	GLfloat originPosition[3]; //represents the coordinates of the center of the square
	GLfloat r; //this will be used as a radius for square rotation
	GLfloat angle; //this will be the angle of rotation (positive is counter clockwise, negative is clockwise
	void SetGlColor(ColorGL _color);
	void DrawSquare();
	void SetVertices();
};

