// Vamsi Gali   

#include "stdafx.h"   // stdafx.h is basically used in Microsoft Visual Studio to let the compiler know the files that are once compiled and no need to compile it from scratch
#include <Windows.h>  // This is the windows related header file which contains declarations for all of the functions in the windows api.
#include <stdio.h>    // This is the header file which is used for input output operations in c.
#include<iostream>    // This is the header file which is used for input output operations in c++.
DWORD CheckResult;    // This is the global variable of type DWORD

/*

checkEvenNumber is the function which takes parameter of type LPVOID and returns a value of type DWORD
This function checks whether the given number is even number or not.
If the given number number is even number then value 1 is stored into the variable CheckResult, else 0 is stored
LPVOID data types are defined as being a "pointer to a void object". LPVOID pointers can be used to point to different types of objects, without creating a compiler error
since we cannot perform arithmetic operations on LPVOID parameter type we are converting or type casting it to DWORD datatype;

*/
DWORD WINAPI checkEvenNumber(LPVOID numberGiven)
{
	DWORD userInput = *(DWORD*)numberGiven;

	if (userInput % 2 == 0)
	{
		CheckResult = 1;
	}
	else
	{
		CheckResult = 0;
	}
	return 0;
}

int main()
{
	DWORD ThreadId;         //ThreadId is the variable which consists of thread id;
	HANDLE ThreadHandle;    // When a thread is created a handle is returned which is stored in this variable.
	int userInputNumber;          // variable that is used to store the user input.
	std::cout << "Please enter number which you want to check whether it is even or not\n";
	std::cin >> userInputNumber;  // std::cin is used to take the input form the user.

	if (userInputNumber < 0)    // A small check to ensure that the user enters a number that is greater than zero.
	{
		std::cout << "You have entered a invalid number";
		std::cin.clear();
		std::cin.ignore(255, '\n');
		std::cin.get();
		return -1;
	}

	/*
	CreateThread is a win32 function which is used to create a thread
	// The information about the parameters is taken from the site http://msdn.microsoft.com/en-us/library/windows/desktop/ms682453(v=vs.85).aspx
	*/
	ThreadHandle = CreateThread(
		NULL,    // A pointer to a SECURITY_ATTRIBUTES structure that determines whether the returned handle can be inherited by child processes. If lpThreadAttributes is NULL, the handle cannot be inherited.
		0,       // The initial size of the stack, in bytes. The system rounds this value to the nearest page. If this parameter is zero, the new thread uses the default size for the executable
		checkEvenNumber, //A pointer to the application-defined function to be executed by the thread. This pointer represents the starting address of the thread
		&userInputNumber,  // A pointer to the application-defined function to be executed by the thread. This pointer represents the starting address of the thread
		0,            //The flags that control the creation of the thread.
		&ThreadId     // A pointer to a variable that receives the thread identifier. If this parameter is NULL, the thread identifier is not returned
		);


	/*
	Checking whether a thread is created or not.
	If the thread is created successfully then the if block is executed.

	*/
	if (ThreadHandle != NULL)
	{
		WaitForSingleObject(ThreadHandle, INFINITE);  // Waits until the specified object is in the signaled state or the time-out interval elapses that is it waits for the thread to complete its execution
		CloseHandle(ThreadHandle);                   // Closes an open object handle that is for closing the handle returned, on creation of thread.
		// it takes handle of the object(thread) as parameter
		/*

		Checking whether given number is even or not by comparing the value of CheckResult variable
		CheckResult=1   even number
		CheckResult=0   not a even number
		*/

		if (CheckResult == 1)
		{
			std::cout << "The number you have entered is a even number";
		}
		else
		{
			std::cout << "The number you have entered is not a even number";
		}


	}
	std::cin.clear();
	std::cin.ignore(255, '\n');
	std::cin.get();
	return 0;              // This is the return statement which need to be written as the main function expects a return type integer.
}

