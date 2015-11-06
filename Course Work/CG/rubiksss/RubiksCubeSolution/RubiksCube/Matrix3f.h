#pragma once

#include "Quaternion.h"

//can I refactor these two classes into a base class
//oh yes
//will be on my todo list when I make another pass on these classes
class Matrix3f
{
public:
	Matrix3f(void);
	Matrix3f(const Matrix3f &source);
	~Matrix3f(void);

	void Identity();
	void Scale(float _scale);
	float At(int x, int y) const;
	void SetAt(int x, int y, float value);
	
	static const int Dimension = 3;
	static const int DimensionSquared = 9;
	const float* Data() const;

	void Zero();
	void SetFromQuat(Quaternion* q);

	Matrix3f& operator=(const Matrix3f &rhs);

private:
	float data[DimensionSquared];

};

