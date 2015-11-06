#include "StdAfx.h"
#include "MoveGenerator.h"
#include <time.h>

MoveGenerator::MoveGenerator(void)
{
	srand( time(NULL) );
}


MoveGenerator::~MoveGenerator(void)
{
}

Move MoveGenerator::GenerateMove(int _dimension)
{
	int axis; //x = 0, y = 1, z = 2
	int index; //0, 1, 2, 3...dimension
	int direction; //0 for clockwise, 1 for counterclockwise

	axis = rand() % 3;
	index = rand() % _dimension;
	direction = rand() % 2;

	Move newMove;
	switch(axis)
	{
	case 0:
		newMove.axisOfRotation = Move::X;
		break;
	case 1:
		newMove.axisOfRotation = Move::Y;
		break;
	case 2:
		newMove.axisOfRotation = Move::Z;
		break;
	}
	switch(direction)
	{
	case 0:
		newMove.directionOfRotation = Move::CLOCKWISE;
		break;
	case 1:
		newMove.directionOfRotation = Move::COUNTERCLOCKWISE;
		break;
	}
	newMove.index = index;

	return newMove;
}