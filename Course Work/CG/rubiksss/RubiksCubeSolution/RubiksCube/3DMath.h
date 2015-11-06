#include "Point3f.h"
#include "Vector3f.h"
#include "Matrix3f.h"
#include "Matrix4f.h"
#include "Quaternion.h"


	Point3f operator+(const Point3f &lhs, const Vector3f &rhs);
	Vector3f operator-(const Point3f &lhs, const Point3f &rhs);

	Vector3f operator+(const Vector3f &lhs, const Vector3f &rhs);
	Vector3f operator-(const Vector3f &lhs, const Vector3f &rhs);

	Vector3f operator*(float lhs, const Vector3f &rhs);
	Vector3f operator*(const Vector3f &lhs, float rhs);

	Matrix3f operator*(const Matrix3f &lhs, const Matrix3f &rhs);

	

	//perhaps add some matrix scalar multiplication operators

