#pragma once

#include "Matrix3f.h"

class Matrix4f
{
public:
	Matrix4f(void);
	Matrix4f(const Matrix4f &source);
	~Matrix4f(void);

	void Identity();
	void Scale(float _scale);
	float At(int col, int row) const;
	void SetAt(int col, int row, float value);


	static const int Dimension = 4;
	static const int DimensionSquared = 16;
	const float* Data() const;

	void SetRotationScale(const Matrix4f* source);
	void SetRotationScale(const Matrix3f* source);

	void SetRotation(const Matrix3f* source);

	float SVD(Matrix3f* mRotation3, Matrix4f* mRotation4);

	void GetRotationScale(Matrix3f* target);

private:
	float data[DimensionSquared];
	

};

