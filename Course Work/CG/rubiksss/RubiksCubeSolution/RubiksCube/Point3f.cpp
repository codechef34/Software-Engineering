#include "StdAfx.h"
#include "Point3f.h"


Point3f::Point3f(void)
{
}

Point3f::Point3f(float _x, float _y, float _z)
{
	x = _x;
	y = _y;
	z = _z;
}

Point3f::Point3f(const Point3f &source)
{
	x = source.x;
	y = source.y;
	z = source.z;
}

Point3f::~Point3f(void)
{
}

Point3f& Point3f::operator=(const Point3f &rhs)
{
	if (this == &rhs)
		return *this;

	x = rhs.x;
	y = rhs.y;
	z = rhs.z;

	return *this;
}

float Point3f::X() const
{
	return x;
}

float Point3f::Y() const
{
	return y;
}

float Point3f::Z() const
{
	return z;
}
