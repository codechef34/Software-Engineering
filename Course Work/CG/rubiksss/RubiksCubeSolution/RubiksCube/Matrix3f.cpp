#include "StdAfx.h"
#include "Matrix3f.h"

Matrix3f::Matrix3f(void)
{
	Identity();
}

Matrix3f::Matrix3f(const Matrix3f &source)
{
	for(int i = 0; i < DimensionSquared; i++)
	{
		data[i] = source.data[i];
	}
}

Matrix3f::~Matrix3f(void)
{

}

void Matrix3f::Identity()
{
	//might be able to refactor this to be more generic using Dimension
	//will do for later however
	data[0] = 1.0; data[1] = 0.0; data[2] = 0.0;
	data[3] = 0.0; data[4] = 1.0; data[5] = 0.0;
	data[6] = 0.0; data[7] = 0.0; data[8] = 1.0;
}

float Matrix3f::At(int x, int y) const
{
	//add validation code to check for bounds

	return data[Dimension*y + x];
}

void Matrix3f::SetAt(int x, int y, float value)
{
	data[Dimension*y + x] = value;
}

void Matrix3f::Scale(float _scale)
{
	for(int i = 0; i < DimensionSquared; i++)
	{
		data[i] *= _scale;
	}
}

const float* Matrix3f::Data() const
{
	return data;
}

void Matrix3f::SetFromQuat(Quaternion* q)
{
	//code from NeHe arcball tutorial

	float n, s;
    float xs, ys, zs;
    float wx, wy, wz;
    float xx, xy, xz;
    float yy, yz, zz;

	n = (q->X() * q->X()) + (q->Y() * q->Y()) + (q->Z() * q->Z()) + (q->W() * q->W());
	s = (n > 0.0) ? (2.0 / n) : 0.0;

	xs = q->X() * s;	ys = q->Y() * s;	zs = q->Z() * s;
	wx = q->W() * xs;	wy = q->W() * ys;	wz = q->W() * zs;
	xx = q->X() * xs;	xy = q->X() * ys;	xz = q->X() * zs;
	yy = q->Y() * ys;	yz = q->Y() * zs;	zz = q->Z() * zs;


	//hate this code here.  Need to modify the interface later to make this easier and neater
	SetAt(0, 0, 1.0 - (yy + zz));	SetAt(0, 1, xy-wz);		SetAt(0, 2, xz + wy);
	SetAt(1, 0, xy + wz);	SetAt(1, 1, 1.0 - (xx + zz));	SetAt(1, 2, yz - wx);
	SetAt(2, 0, xz - wy);	SetAt(2, 1, yz + wx);	SetAt(2, 2, 1.0 - (xx + yy));
}

void Matrix3f::Zero()
{
	for(int i = 0; i < DimensionSquared; i++)
	{
		data[i] = 0;
	}
}

Matrix3f& Matrix3f::operator=(const Matrix3f &rhs)
{
	if(this == &rhs)
		return *this;

	else
	{
		for(int i = 0; i < DimensionSquared; i++)
		{
			data[i] = rhs.data[i];
		}
	}

	return *this;
}
