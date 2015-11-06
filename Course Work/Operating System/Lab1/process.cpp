//VAMSI GALI
//LAB - 1



#include "stdafx.h"  // stdafx.h is basically used in Microsoft Visual Studio to let the compiler know the files that are once compiled and no need to compile it from scratch.
#include <iostream>  // This is the header file which is used for input output operations in c++.
#include <windows.h> // This is the windows related header file which contains declarations for all of the functions in the windows api.
#include <stdio.h>   // This is the header file which is used for input output operations in c.
using namespace std;

int main(void)
{
	STARTUPINFO si;                    // pointer variable for the STARTUPINFO structure
	PROCESS_INFORMATION pi;            // pointer variable for the PROCESS_INFORMATION structure
	char ch;                           // ch is the variable of type character which is used to store the user input.             
	ZeroMemory(&si, sizeof(si));    // ZeroMemory function is used to clear a block of memory and its return type is void.
	si.cb = sizeof(si);               // The first parameter is the pointer pointing to the starting address of the block of memory to fill with zeros.
	ZeroMemory(&pi, sizeof(pi));    // The second parameter is the size of the block of memory to fill with zeros, in bytes.



	// CreateProcess() is the function used to create a child process
	// The information about the parameters is taken from the site http://msdn.microsoft.com/en-us/library/windows/desktop/ms682425(v=vs.85).aspx
	if (!CreateProcess(TEXT("C:\\WINDOWS\\system32\\mspaint.exe"),   // Application name to be executed.
		NULL,           // Command line need to be executed.
		NULL,           // A pointer to a SECURITY_ATTRIBUTES structure that determines whether the returned handle to the new process object can be inherited by child processes. If lpProcessAttributes is NULL, the handle cannot be inherited.
		NULL,           // A pointer to a SECURITY_ATTRIBUTES structure that determines whether the returned handle to the new thread object can be inherited by child processes. If lpThreadAttributes is NULL, the handle cannot be inherited
		FALSE,          // If this parameter TRUE, each inheritable handle in the calling process is inherited by the new process. If the parameter is FALSE, the handles are not inherited. Note that inherited handles have the same value and access rights as the original handles
		CREATE_NEW_CONSOLE, // The new process has a new console, instead of inheriting its parent's console (the default).
		NULL,           // A pointer to the environment block for the new process. If this parameter is NULL, the new process uses the environment of the calling process.
		NULL,           // The full path to the current directory for the process. The string can also specify a UNC path. If this parameter is NULL, the new process will have the same current drive and directory as the calling process.

		&si,            // Pointer pointing to STARTUPINFO structure
		&pi)           // Pointer pointing to PROCESS_INFORMATION structure
		)
	{
		printf("CreateProcess failed (%d).\n", GetLastError());   // If the process is created then this block of code is executed and a error is thrown which means process creation failed.
		return 0;
	}







	printf("\n%s\n", "Do you want exit the process the press (y)");  // This is used to ask the user whether he wants to exit the process or not, if yes asking him to press y

	ch = getchar();                                                   // This is used to take the input from the user
	printf(" \nThe character you entered is %c", ch);


	if (ch == 'y')                                                        // Checking whether the user has entered 'y' as input if yes it enters into the if loop
	{
		TerminateProcess(pi.hProcess, 0);                                                    // The second parameter is the exit code  used by process and threads to terminate. 

		// TerminateProcess() is the function which is used to terminate the process which takes two paramters
		// The first parameter is the handle to the process which is to be terminated.


	}


	// This piece code of two lines is used to Close process and thread handles.
	CloseHandle(pi.hProcess);
	CloseHandle(pi.hThread);
	cin.clear();
	cin.ignore(255, '\n');
	cin.get();
	return 0;                                                           // This is the return statement which need to be written as the main function expects a return type integer.
}
