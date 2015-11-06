#include "StdAfx.h"
#include "Quaternion.h"


Quaternion::Quaternion(float _x, float _y, float _z, float _w)
{
	xyz = Vector3f(_x, _y, _z);
	w = _w;
}


Quaternion::~Quaternion(void)
{
}

float Quaternion::X() const
{
	return xyz.X();
}

float Quaternion::Y() const
{
	return xyz.Y();
}

float Quaternion::Z() const
{
	return xyz.Z();
}

float Quaternion::W() const
{
	return w;
}