#pragma once
#include "Vector3f.h"

class Point3f
{

public:
	Point3f();
	Point3f(float _x, float _y, float _z);
	Point3f(const Point3f &source);
	~Point3f();

	float X() const;
	float Y() const;
	float Z() const;

	Point3f& operator=(const Point3f &rhs);


private:
	float x;
	float y;
	float z;
};



