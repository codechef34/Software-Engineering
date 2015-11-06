#pragma once


class Vector3f
{
public:
	Vector3f(void);
	Vector3f(float _x, float _y, float _z);
	Vector3f(const Vector3f &source);
	~Vector3f(void);

	float X() const;
	float Y() const;
	float Z() const;

	float Magnitude() const;

	Vector3f& operator=(const Vector3f &rhs);
	//Vector3f& operator+(const Vector3f &rhs);
	//Vector3f& operator-(const Vector3f &rhs);


	void Normalize();

	
	static Vector3f Cross(Vector3f* v1, Vector3f* v2);
	static float Dot(Vector3f* v1, Vector3f* v2);

private:
	float x;
	float y;
	float z;
};

