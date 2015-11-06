#pragma once
#include "cube.h"

class RSubCube :
	public Cube
{
public:
	RSubCube(GLfloat _size);
	RSubCube();
	~RSubCube(void);
	void Render();
	void AddMove(Move _m);

private:
	std::list<Move>* moveList;
	void RotateCube();
};

