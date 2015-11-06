#include "StdAfx.h"
#include "Matrix4f.h"

Matrix4f::Matrix4f(void)
{
	Identity();
}

Matrix4f::Matrix4f(const Matrix4f &source)
{
	for(int i = 0; i < DimensionSquared; i++)
	{
		data[i] = source.data[i];
	}
}

Matrix4f::~Matrix4f(void)
{

}

void Matrix4f::Identity()
{
	//might be able to refactor this to be more generic using Dimension
	//will do for later however
	data[0] = 1.0;	data[1] = 0.0;	data[2] = 0.0;	data[3] = 0.0;
	data[4] = 0.0;	data[5] = 1.0;	data[6] = 0.0;	data[7] = 0.0;
	data[8] = 0.0;	data[9] = 0.0;	data[10] = 1.0;	data[11] = 0.0;
	data[12] = 0.0;	data[13] = 0.0;	data[14] = 0.0;	data[15] = 1.0;
}

void Matrix4f::Scale(float _scale)
{
	for(int i = 0; i < DimensionSquared; i++)
	{
		data[i] *= _scale;
	}
}

float Matrix4f::At(int col, int row) const
{
	//you should add validation code to make sure the indexes aren't out of bounds
	return data[Dimension*row + col];
}

void Matrix4f::SetAt(int col, int row, float value)
{
	data[Dimension*row + col] = value;
}

const float* Matrix4f::Data() const
{
	return data;
}

void Matrix4f::SetRotationScale(const Matrix4f* source)
{
	const float* sourceData = source->Data();
	for(int i = 0; i < 3; i++)
	{
		for(int j = 0; j < 3; j++)
		{
			data[4*i + j] = sourceData[4*i + j];
		}
	}
}

void Matrix4f::SetRotationScale(const Matrix3f* source)
{
	const float* sourceData = source->Data();
	for(int i = 0; i < 3; i++)
		for(int j = 0; j < 3; j++)
		{
			data[4*i + j] = sourceData[3*i + j];
		}
}

void Matrix4f::SetRotation(const Matrix3f* source)
{
	float scale;
	scale = SVD(NULL, NULL);
	SetRotationScale(source);
	Scale(scale);
}

void Matrix4f::GetRotationScale(Matrix3f* target)
{
	for(int i = 0; i < 3; i++)
		for(int j = 0; j < 3; j++)
		{
			target->SetAt(j, i, data[4*i +j]);
		}
}

float Matrix4f::SVD(Matrix3f* mRotation3, Matrix4f* mRotation4)
{
	float s, n;

	s = 0;
	for(int i = 0; i < 3; i++)
		for(int j = 0; j < 3; j++)
			s += (data[4*i + j] * data[4*i + j]);
	s /= 3.0;
	s = sqrt(s);

	if(mRotation3)
	{

		GetRotationScale(mRotation3);
		//this is going to get ugly.  going to have to redesign this some day

		for(int j = 0; j < 3; j++)//iterate rows
		{
			//n = 1 / magnitude of the jth rotation row in this matrix
			n = 0;
			for(int i = 0; i < 3; i++) //iterate columns
				n += (data[4*j + i]*data[4*j + i]);
			n = sqrt(n);
			n = 1.0 / n;

			for(int i = 0; i < 3; i++)
			{
				float element = mRotation3->At(j, i);
				mRotation3->SetAt(j, i, n * element);
			}
		}
	}

	if(mRotation4)
	{
		if (mRotation4 != this)
		{
			mRotation4->SetRotationScale(this);
		}

		for(int j = 0; j < 3; j++)//iterate rows
		{
			//n = 1 / magnitude of the jth rotation row in this matrix
			n = 0;
			for(int i = 0; i < 3; i++) //iterate columns
				n += (data[4*j + i]*data[4*j + i]);
			n = sqrt(n);
			n = 1.0 / n;

			for(int i = 0; i < 3; i++)
			{
				float element = mRotation4->At(j, i);
				mRotation4->SetAt(j, i, n * element);
			}
		}
	}

	return s;
}