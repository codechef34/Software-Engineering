#include "StdAfx.h"
#include "rsubcube.h"
#include "DefinedColorsGL.h"


RSubCube::RSubCube(GLfloat _size)
	: Cube(_size)
{
	SetFaceColors(Colors::Gray);
	SetBottomColor(Colors::DarkGray);
	SetTopColor(Colors::DarkGray);
	SetLeftColor(Colors::DarkGray);
	SetRightColor(Colors::DarkGray);
	moveList = new std::list<Move>();
}

RSubCube::RSubCube()
	: Cube(0)
{

}

RSubCube::~RSubCube(void)
{
	delete moveList;
}

void RSubCube::Render()
{
	RotateCube();
	Cube::Render();
}

void RSubCube::AddMove(Move _m)
{
	moveList->push_back(_m);
}

//iterates through the move list and rotates the cube so that its facing correctly
void RSubCube::RotateCube()
{
	for(std::list<Move>::reverse_iterator listIterator = moveList->rbegin(); listIterator != moveList->rend(); listIterator++)
	{
		GLfloat angle = 0;
		Move currentMove = *listIterator;
		if(currentMove.directionOfRotation == Move::CLOCKWISE)
			angle = -90;
		else angle = 90;

		switch(currentMove.axisOfRotation)
		{
		case Move::X:
				glRotatef(angle, 1, 0, 0);
				break;
		case Move::Y:
				glRotatef(angle, 0, 1, 0);
				break;
		case Move::Z:
				glRotatef(angle, 0, 0, 1);
				break;
			default:
				break;
		}
	}
}