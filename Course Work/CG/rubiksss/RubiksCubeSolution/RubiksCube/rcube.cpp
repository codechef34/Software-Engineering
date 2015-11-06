#include "StdAfx.h"
#include "rcube.h"

#include "DefinedColorsGL.h"

RCube::RCube(int _dimension)
	:dimension(_dimension)
{

	//cubes(boost::extents[dimension][dimension][dimension]);
	cubeMoveList = new std::list<Move>();
	animationAngle = 0;
	animating = false;
	solving = false;
	InitializeFaceColors();
	InitializeCubes();
}

RCube::~RCube(void)
{
	delete cubeMoveList;
}

void RCube::Render()
{
	switch(currentMove.axisOfRotation)
	{
	case Move::Z:
		RenderBackToFront();
		break;
	case Move::Y:
		RenderBottomToTop();
		break;
	case Move::X:
		RenderLeftToRight();
		break;
	default:
		RenderBackToFront();
		break;
	}

	if(animationAngle == 90)
	{
		StopAnimation();
		if(solving)
			DoNextMove();
	}

}

void RCube::StopAnimation()
{
	animationAngle = 0;
	animating = false;
	DoMove(currentMove);
}

void RCube::StopSolving()
{
	solving = false;
	//may want to add code to clear the move lists of all cubes
	//as it is right now, they retain the move lists when the cube is solved
	//and add more when the cube is scrambled again
}

void RCube::InitializeFaceColors() //having default colors for now
								   //may extend it later to customize face colors	
{
	faceColors[FRONT] = Colors::White;
	faceColors[BACK] = Colors::Orange;
	faceColors[TOP] = Colors::Red;
	faceColors[BOTTOM] = Colors::Blue;
	faceColors[LEFT] = Colors::Yellow;
	faceColors[RIGHT] = Colors::Green;
}

void RCube::InitializeCubes()
{
	//I wonder if there's a way to refactor this set of iterative loops...probably
	for(int z = 0; z < dimension; z++)
	{
		for(int x = 0; x < dimension; x++)
		{			
			for(int y = 0; y < dimension; y++)
			{
				if(IsSurfaceIndex(x, y, z))
				{
					CreateSubCube(x, y, z);
				}
			}			
		}
	}
}


//These are the rotation functions
//They are meant to transfer the cubes to different locations in the cubes data structure when rotated
//They are extremely similar, and so in the future I will look to refactor these somewhat

//rotates the plane x = index about the x axis
void RCube::RotateX(Move _m)
{
	int index = _m.index;

	//create an array to store a copy of affected cube references
	RSubCube* copyOfCubeReferences[9][9]; //again will be creating a class to contain cube references later

	//here I make a copy of all the cubes that are about to be 'moved'
	for(int y = 0; y < dimension; y++)//build rows of cubes down the z axis
	{
		for(int z = 0; z < dimension; z++)
		{
			if(IsSurfaceIndex(index, y, z))
			{
				copyOfCubeReferences[y][z] = cubes[index][y][z];
			}
		}
	}
	
	//here I actually move the cubes
	for(int y = 0; y < dimension; y++)
	{
		for(int z = 0; z < dimension; z++)
		{
			if(IsSurfaceIndex(index, y, z)) //checks if this position is on the surface of the cube
			{
				//counterclockwise
				if(_m.directionOfRotation == Move::COUNTERCLOCKWISE)
				{
					cubes[index][y][z] = copyOfCubeReferences[z][dimension-1 - y];
					cubes[index][y][z]->AddMove(_m);
				}
				//clockwise
				else
				{
					cubes[index][y][z] = copyOfCubeReferences[dimension -1 - z][y];
					cubes[index][y][z]->AddMove(_m);
				}
			}
		}		
	}

}

//rotates the plane y = index, along the y axis
void RCube::RotateY(Move _m)
{
	int index = _m.index;

	//create an array to store a copy of affected cube references
	RSubCube* copyOfCubeReferences[9][9]; //again will be creating a class to contain cube references later

	//here I make a copy of all the cubes that are about to be 'moved'
	for(int z = 0; z < dimension; z++)//build rows of cubes down the z axis
	{
		for(int x = 0; x < dimension; x++)
		{
			if(IsSurfaceIndex(x, index, z))
			{
				copyOfCubeReferences[z][x] = cubes[x][index][z];
			}
		}
	}
	
	//here I actually move the cubes
	for(int z = 0; z < dimension; z++)
	{
		for(int x = 0; x < dimension; x++)
		{
			if(IsSurfaceIndex(x, index, z)) //checks if this position is on the surface of the cube
			{
				//counterclockwise
				if(_m.directionOfRotation == Move::COUNTERCLOCKWISE)
				{
					cubes[x][index][z] = copyOfCubeReferences[x][dimension-1 - z];
					cubes[x][index][z]->AddMove(_m);
				}
				//clockwise
				else
				{
					cubes[x][index][z] = copyOfCubeReferences[dimension -1 - x][z];
					cubes[x][index][z]->AddMove(_m);
				}
			}
		}		
	}


}

//rotates the plane z = index along the z axis
void RCube::RotateZ(Move _m)
{
	int index = _m.index;

	//create an array to store a copy of affected cube references
	RSubCube* copyOfCubeReferences[9][9]; //again will be creating a class to contain cube references later

	//here I make a copy of all the cubes that are about to be 'moved'
	for(int x = 0; x < dimension; x++)
	{
		for(int y = 0; y < dimension; y++)
		{
			if(IsSurfaceIndex(x, y, index))
			{
				copyOfCubeReferences[x][y] = cubes[x][y][index];
			}
		}
	}
	
	//here I actually move the cubes
	for(int x = 0; x < dimension; x++)
	{
		for(int y = 0; y < dimension; y++)
		{
			if(IsSurfaceIndex(x, y, index)) //checks if this position is on the surface of the cube
			{
				//counterclockwise
				if(_m.directionOfRotation == Move::COUNTERCLOCKWISE)
				{
					cubes[x][y][index] = copyOfCubeReferences[y][dimension-1 - x];
					cubes[x][y][index]->AddMove(_m);
				}
				//clockwise
				else
				{
					cubes[x][y][index] = copyOfCubeReferences[dimension -1 - y][x];
					cubes[x][y][index]->AddMove(_m);
				}
			}
		}		
	}
}

void RCube::AnimateMove(Move _m)
{
	animating = true;
	currentMove = _m;
}

void RCube::DoMove(Move _m)
{
	int index = _m.index;

	switch(_m.axisOfRotation)
	{
		case Move::X:
				RotateX(_m);
				break;
		case Move::Y:
				RotateY(_m);
				break;
		case Move::Z:
				RotateZ(_m);
				break;
		default:
			break;
	}
}

void RCube::RenderLeftToRight()
{
	int index = currentMove.index;
	for(int x = 0; x < dimension; x++)
	{
		glPushMatrix();

		//animate the group of cubes
		if(x == index && animating)
		{
			if(currentMove.directionOfRotation == Move::COUNTERCLOCKWISE)
				glRotatef(animationAngle, 1, 0, 0);

			else
				glRotatef(animationAngle, -1, 0, 0);
		}

		for(int z = 0; z < dimension; z++)
		{
			for(int y = 0; y < dimension; y++)
			{
				if(IsSurfaceIndex(x, y, z))
				{
					glPushMatrix();
					TranslateCube(x, y, z);
					cubes[x][y][z]->Render();
					glPopMatrix();
				}				
			}
		}
		glPopMatrix();
	}	
}

void RCube::RenderBottomToTop()
{
	int index = currentMove.index;
	for(int y = 0; y < dimension; y++)
	{
		glPushMatrix();

		//animate the group of cubes
		if(y == index && animating)
		{
			if(currentMove.directionOfRotation == Move::COUNTERCLOCKWISE)
				glRotatef(animationAngle, 0, 1, 0);

			else
				glRotatef(animationAngle, 0, -1, 0);
		}

		for(int z = 0; z < dimension; z++)
		{
			for(int x = 0; x < dimension; x++)
			{
				if(IsSurfaceIndex(x, y, z))
				{
					glPushMatrix();
					TranslateCube(x, y, z);
					cubes[x][y][z]->Render();
					glPopMatrix();
				}				
			}
		}
		glPopMatrix();
	}	
}

void RCube::RenderBackToFront()
{	
	int index = currentMove.index;
	for(int z = 0; z < dimension; z++)
	{
		glPushMatrix();

		//animate the group of cubes
		if(z == index && animating)
		{
			if(currentMove.directionOfRotation == Move::COUNTERCLOCKWISE)
				glRotatef(animationAngle, 0, 0, 1);

			else
				glRotatef(animationAngle, 0, 0, -1);
		}

		for(int x = 0; x < dimension; x++)
		{
			for(int y = 0; y < dimension; y++)
			{
				if(IsSurfaceIndex(x, y, z))
				{
					glPushMatrix();
					TranslateCube(x, y, z);
					cubes[x][y][z]->Render();
					glPopMatrix();
				}				
			}
		}
		glPopMatrix();
	}	
}

//this method assumes 0,0,0 occurs in the cube's center, and so translates the iterative x,y,z into these coordinates
void RCube::TranslateCube(int x, int y, int z)
{
	GLfloat translation = (GLfloat)(dimension - 1)/2; //translating coordinates from the array's coordinates to cube coordinates 
	glTranslatef( (GLfloat)x - translation, (GLfloat)y - translation, (GLfloat)z - translation);
}

void RCube::CreateSubCube(int x, int y, int z)
{
	cubes[x][y][z] = new RSubCube(0.900); //temporary return value until implemented

	if(x == 0)
		cubes[x][y][z]->SetLeftColor(faceColors[LEFT]);
	if(x == dimension - 1)
		cubes[x][y][z]->SetRightColor(faceColors[RIGHT]);
	if(z == 0)
		cubes[x][y][z]->SetBackColor(faceColors[BACK]);
	if(z == dimension - 1)
		cubes[x][y][z]->SetFrontColor(faceColors[FRONT]);
	if(y == 0)
		cubes[x][y][z]->SetBottomColor(faceColors[BOTTOM]);
	if(y == dimension - 1)
		cubes[x][y][z]->SetTopColor(faceColors[TOP]);	
}

void RCube::AddMove(Move _m)
{
	cubeMoveList->push_back(_m);
}


bool RCube::IsAnimating()
{
	return animating;
}

void RCube::IncrementMoveAngle(GLfloat _angle)
{
	animationAngle += _angle;
}

void RCube::Solve()
{
	solving = true;
	DoNextMove();
}

void RCube::DoNextMove()
{
	if( !cubeMoveList->empty() )
	{
		currentMove = cubeMoveList->back();
		cubeMoveList->pop_back();
		if(currentMove.directionOfRotation == Move::CLOCKWISE)
			currentMove.directionOfRotation = Move::COUNTERCLOCKWISE;
		else
			currentMove.directionOfRotation = Move::CLOCKWISE;
		AnimateMove(currentMove);
	}
	else
		StopSolving();
}

bool RCube::IsSurfaceIndex(int x, int y, int z)
{
	if(x == 0 || x == dimension-1 || y == 0 || y == dimension -1 || z == 0 || z == dimension - 1)
		return true;
	else return false;
}