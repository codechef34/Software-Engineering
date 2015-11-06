#pragma once

#include "rsubcube.h"

class RCube
{
public:
	RCube(int _dimension);
	~RCube(void);

	void Render();
	void AddMove(Move _m);
	void DoMove(Move _m);  //might need a better name for it. Carries out the given move
	void AnimateMove(Move _m);
	bool IsAnimating();
	void IncrementMoveAngle(GLfloat _angle);
	void Solve();

	enum Faces
	{
		FRONT = 0,
		BACK,
		TOP,
		BOTTOM,
		LEFT,
		RIGHT,
		NUMBER_OF_FACES
	};


private:
	int dimension;
	RSubCube* cubes[9][9][9]; //temporary for testing purposes.  Will use something more robust later
	ColorGL faceColors[NUMBER_OF_FACES]; //array of colors indexed by face
	std::list<Move>* cubeMoveList;

	Move currentMove;
	bool animating;
	bool solving;
	GLfloat animationAngle;

	void InitializeCubes();
	void InitializeFaceColors();
	void RenderBackToFront();
	void RenderBottomToTop();
	void RenderLeftToRight();
	void CreateSubCube(int x, int y, int z);
	void TranslateCube(int x, int y, int z);

	void RotateX(Move _m);
	void RotateY(Move _m);
	void RotateZ(Move _m);

	void StopAnimation();
	void DoNextMove();
	void StopSolving();
	
	bool IsSurfaceIndex(int x, int y, int z);



};

