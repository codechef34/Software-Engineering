#pragma once
class MoveGenerator
{
public:
	MoveGenerator(void);
	~MoveGenerator(void);

	Move GenerateMove(int _dimension);
};

