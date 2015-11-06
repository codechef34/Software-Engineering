
// Implementation of function to load server DLL into client's process
//
// Create.cpp 
#include <iostream> 
#include "unknwn.h" // IUnknown definition file. 
#include "Create.h" 
using namespace std;

typedef IUnknown* (*CREATEFUNCPTR)();
/////////////////////////////// 
void _TRACE(const char* msg)
{
	cout << "Client :\t" << msg << endl;
}

////////////////////////////////////////// 
IUnknown* CallCreateInstance(char* dllname)
{
	//-----------------------------------------------------------------// 
	// Load dynamic link library into client's process. 
	// Loadlibrary maps a DLL module and returns a handle 
	// that can be used in GetProcAddress to get the 
	// address of a DLL function 
	//-----------------------------------------------------------------//
	_TRACE("Attempting to Load component's server...");
	HMODULE hm = ::LoadLibrary(dllname);
	if (hm == NULL)
	{
		_TRACE("CallCreateInstance:\tError: Cannot load the component's server.");
		return NULL;
	}

	// Get the address of CreateInstance function. 
	CREATEFUNCPTR Function = (CREATEFUNCPTR)::GetProcAddress(hm, "CreateInstance");

	if (Function == NULL)
	{
		_TRACE("Function is not found!.");
		return NULL;
	}

	_TRACE("Component's server is loaded successfully.");

	return Function();
}