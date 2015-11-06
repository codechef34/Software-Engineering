#pragma once
#include "square.h"

class Cube
{
public:
	Cube(GLfloat _size);
	Cube();
	~Cube(void);
	virtual void Render();

	void SetLeftColor(ColorGL _color);
	void SetRightColor(ColorGL _color);
	void SetTopColor(ColorGL _color);
	void SetBottomColor(ColorGL _color);
	void SetFrontColor(ColorGL _color);
	void SetBackColor(ColorGL _color);

	void SetFaceColors(ColorGL _front, ColorGL _back, ColorGL _top, ColorGL _bottom, ColorGL _right, ColorGL _left);
	void SetFaceColors(ColorGL _all);

protected:
	Square *frontSquare;
	Square *backSquare;
	Square *rightSquare;
	Square *leftSquare;
	Square *topSquare;
	Square *bottomSquare;

private:
	//I considered storing these into a collection or an array
	//but decided against it in the end

	//I also could have defined the cube by its eight vertices as well
	//but I wanted the parent object to be responsible for the matrix transforms
	//and thus the cube object should not be aware of its position


	GLfloat size; //size of the cube

	void RenderSquares();
	void tempSetColors(); //temporary function to set colors of squares
};

