#include "stdafx.h"
#include "3DMath.h"

Point3f operator+(const Point3f &lhs, const Vector3f &rhs)
{
	float newX, newY, newZ;
	newX = lhs.X() + rhs.X();
	newY = lhs.Y() + rhs.Y();
	newZ = lhs.Z() + rhs.Z();
	return Point3f(newX, newY, newZ);
}


Vector3f operator-(const Point3f &lhs, const Point3f &rhs)
{
	float newX = lhs.X() - rhs.X();
	float newY = lhs.Y() - rhs.Y();
	float newZ = lhs.Z() - rhs.Z();
	return Vector3f(newX, newY, newZ);
}

Vector3f operator+(const Vector3f &lhs, const Vector3f &rhs)
{
	float newX, newY, newZ;
	newX = lhs.X() + rhs.X();
	newY = lhs.Y() + rhs.Y();
	newZ = lhs.Z() + rhs.Z();
	return Vector3f(newX, newY, newZ);
}

Vector3f operator-(const Vector3f &lhs, const Vector3f &rhs)
{
	float newX, newY, newZ;
	newX = lhs.X() - rhs.X();
	newY = lhs.Y() - rhs.Y();
	newZ = lhs.Z() - rhs.Z();
	return Vector3f(newX, newY, newZ);
}

Vector3f operator*(float lhs, const Vector3f &rhs)
{
	float newX, newY, newZ;
	newX = lhs * rhs.X();
	newY = lhs * rhs.Y();
	newZ = lhs * rhs.Z();
	return Vector3f(newX, newY, newZ);
}

Vector3f operator*(const Vector3f &lhs, float rhs)
{
	float newX, newY, newZ;
	newX = rhs * lhs.X();
	newY = rhs * lhs.Y();
	newZ = rhs * lhs.Z();
	return Vector3f(newX, newY, newZ);
}

Matrix3f operator*(const Matrix3f &lhs, const Matrix3f &rhs)
{
	float newData[9];

	newData[0] =  (lhs.At(0, 0) * rhs.At(0, 0)) + (lhs.At(0, 1) * rhs.At(1, 0)) + (lhs.At(0, 2) * rhs.At(2, 0));
	newData[1] =  (lhs.At(0, 0) * rhs.At(0, 1)) + (lhs.At(0, 1) * rhs.At(1, 1)) + (lhs.At(0, 2) * rhs.At(2, 1));
	newData[2] =  (lhs.At(0, 0) * rhs.At(0, 2)) + (lhs.At(0, 1) * rhs.At(1, 2)) + (lhs.At(0, 2) * rhs.At(2, 2));

	newData[3] =  (lhs.At(1, 0) * rhs.At(0, 0)) + (lhs.At(1, 1) * rhs.At(1, 0)) + (lhs.At(1, 2) * rhs.At(2, 0));
	newData[4] =  (lhs.At(1, 0) * rhs.At(0, 1)) + (lhs.At(1, 1) * rhs.At(1, 1)) + (lhs.At(1, 2) * rhs.At(2, 1));
	newData[5] =  (lhs.At(1, 0) * rhs.At(0, 2)) + (lhs.At(1, 1) * rhs.At(1, 2)) + (lhs.At(1, 2) * rhs.At(2, 2));

	newData[6] =  (lhs.At(2, 0) * rhs.At(0, 0)) + (lhs.At(2, 1) * rhs.At(1, 0)) + (lhs.At(2, 2) * rhs.At(2, 0));
	newData[7] =  (lhs.At(2, 0) * rhs.At(0, 1)) + (lhs.At(2, 1) * rhs.At(1, 1)) + (lhs.At(2, 2) * rhs.At(2, 1));
	newData[8] =  (lhs.At(2, 0) * rhs.At(0, 2)) + (lhs.At(2, 1) * rhs.At(1, 2)) + (lhs.At(2, 2) * rhs.At(2, 2));

	Matrix3f newMatrix;
	for(int i = 0; i < 3; i++)
		for(int j = 0; j < 3; j++)
			newMatrix.SetAt(i, j, newData[3*i + j]);

	return newMatrix;
}