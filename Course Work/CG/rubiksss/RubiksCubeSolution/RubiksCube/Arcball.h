#pragma once

#include "3DMath.h"

//based off of NeHe's Arcball class
class Arcball
{
public:
	Arcball(float _width, float _height);
	~Arcball(void);

	void SetBounds(float _width, float _height);

	//mouse down
	void Click(const Point3f* _point);

	//mouse drag
	void Drag(const Point3f* _point, Quaternion* qNewRotation);


protected:
	void MapToSphere(const Point3f* _point, Vector3f* _vector) const;

	Vector3f startVector;
	Vector3f endVector;
	float adjustWidth;
	float adjustHeight;


};

