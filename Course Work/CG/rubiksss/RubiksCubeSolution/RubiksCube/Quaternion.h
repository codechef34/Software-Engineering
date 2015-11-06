#pragma once
#include "Vector3f.h"

//should probably make it like a Vector4f
class Quaternion
{
public:
	Quaternion(float _x, float _y, float _z, float w);
	~Quaternion(void);

	float X() const;
	float Y() const;
	float Z() const;
	float W() const;

private:
	Vector3f xyz;
	float w;
};

