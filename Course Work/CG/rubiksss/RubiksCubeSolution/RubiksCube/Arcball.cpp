#include "StdAfx.h"
#include "Arcball.h"

//sphere constants:
//Diameter = 2.0
//Radius = 1.0
//RSquared = 1.0

Arcball::Arcball(float _width, float _height)
{
	startVector = Vector3f(0, 0, 0);
	endVector = Vector3f(0, 0, 0);

	SetBounds(_width, _height);
}


Arcball::~Arcball(void)
{
}

void Arcball::SetBounds(float _width, float _height)
{
	adjustWidth = 1.0 /( (_width-1) * 0.5);
	adjustHeight = 1.0 /( (_height-1) * 0.5);
}

void Arcball::MapToSphere(const Point3f* _point, Vector3f* _vector) const
{
	Point3f tempPoint;
	float length;

	//Copy parameter into temp point
	tempPoint = *_point;

	//Adjust point coords and scale down to range of [-1 ... 1]
	float adjustedX;
	float adjustedY;
	adjustedX = (tempPoint.X() * adjustWidth) - 1.0;
	adjustedY = 1.0 - (tempPoint.Y() * adjustHeight);
	tempPoint = Point3f(adjustedX, adjustedY, 0);

	//compute the length of the vector to the point from the center
	*_vector = (tempPoint - Point3f(0, 0, 0));
	length = _vector->Magnitude();

	//if the point is mapped outside of the sphere (length > RSquared)
	if( (length * length) > 1.0)
	{
		//normalize the vector
		_vector->Normalize(); 
	}
	//else it's on the inside
	else
	{
		*_vector = *_vector + Vector3f(0, 0, 1.0 - length);
	}
}

void Arcball::Click(const Point3f* _point)
{
	MapToSphere(_point, &startVector);
}

void Arcball::Drag(const Point3f* _point, Quaternion* qNewRotation)
{
	MapToSphere(_point, &endVector);

	if(qNewRotation)
	{
		Vector3f vPerpendicular;

		//compute the vector perpendicular to the begin and end vectors
		vPerpendicular = Vector3f::Cross(&startVector, &endVector); 

		//compute the length of the perpendicular vecotr
		if(vPerpendicular.Magnitude() > 0)
		{
			//return the perpendicular vector as the transform
			*qNewRotation = Quaternion(vPerpendicular.X(), vPerpendicular.Y(), vPerpendicular.Z(), Vector3f::Dot(&startVector, &endVector));
		}
		else
		{
			//the begin and end vectors coincide, so return an identity transform
			*qNewRotation = Quaternion(0, 0, 0, 0);
		}
	}
}

