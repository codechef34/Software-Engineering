

#pragma once

struct Move
{
	enum Axis
	{
		X = 0,
		Y,
		Z
	};

	enum Direction
	{
		CLOCKWISE = 0,
		COUNTERCLOCKWISE
	};

	Axis axisOfRotation;
	Direction directionOfRotation;

	int index;  //represents which 'row' of cubes will rotate


};