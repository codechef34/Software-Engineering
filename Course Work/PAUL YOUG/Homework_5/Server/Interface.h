
// 
// Server interface.h 
// 
#include <objbase.h>

interface IComponent : IUnknown 
{ 
	virtual void __stdcall Print(const char* msg) = 0 ;
	virtual int __stdcall increment(int sum) = 0 ;
}; 

// Forward references for GUID 
extern "C" 
{ 
	extern const IID IID_IComponent ; 
}