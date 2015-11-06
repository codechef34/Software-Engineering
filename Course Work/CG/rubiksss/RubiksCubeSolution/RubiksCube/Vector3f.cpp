#include "StdAfx.h"
#include "Vector3f.h"


Vector3f::Vector3f(void)
{
}

Vector3f::Vector3f(float _x, float _y, float _z)
{
	x = _x;
	y = _y;
	z = _z;
}

Vector3f::Vector3f(const Vector3f &source)
{
	x = source.x;
	y = source.y;
	z = source.z;
}

Vector3f::~Vector3f(void)
{
}

Vector3f& Vector3f::operator=(const Vector3f &rhs)
{
	if (this == &rhs)
		return *this;

	x = rhs.x;
	y = rhs.y;
	z = rhs.z;

	return *this;
}

Vector3f Vector3f::Cross(Vector3f* v1, Vector3f* v2)
{
	float newX, newY, newZ;
	newX = (v1->y * v2->z) - (v1->z * v2->y);
	newY = (v1->z * v2->x) - (v1->x * v2->z);
	newZ = (v1->x * v2->y) - (v1->y * v2->x);

	return Vector3f(newX, newY, newZ);
}

float Vector3f::Dot(Vector3f* v1, Vector3f* v2)
{
	float scalar;
	scalar = (v1->x * v2->x) + (v1->y * v2->y) + (v1->z * v2->z);
	return scalar;
}

void Vector3f::Normalize()
{
	float magnitude = Magnitude();
	x /= magnitude;
	y /= magnitude;
	z /= magnitude;
}

float Vector3f::Magnitude() const
{
	float xSquared, ySquared, zSquared;
	xSquared = pow(x, 2);
	ySquared = pow(x, 2);
	zSquared = pow(z, 2);
	
	return sqrt(xSquared + ySquared + zSquared);
}

float Vector3f::X() const
{
	return x;
}

float Vector3f::Y() const
{
	return y;
}

float Vector3f::Z() const
{
	return z;
}