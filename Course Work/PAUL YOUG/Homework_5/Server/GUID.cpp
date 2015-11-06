// 
// GUID.cpp - Interface ID 
// 
#include <objbase.h> 

extern "C" 
{ 
	extern const IID IID_IComponent = 
	{ 0x853b4626, 0x393a, 0x44df, //Data1,Data2,Data3 
	{ 0xb1, 0x3e, 0x64, 0xca, 0xbe, 0x53, 0x5d, 0xbf } }; //Data4 
	
	// The extern is required to allocate memory for C++ constants. 
}