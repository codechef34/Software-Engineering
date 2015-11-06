
//Server Implementation

#include <iostream>
#include <objbase.h>
#include <cstdio>
#include <cstdlib>
#include "Interface.h"

//Definition of the Component's class 
class CComponent : public IComponent 
{ 
	//IUnknown interface's methods: 
	virtual HRESULT __stdcall QueryInterface(const IID& iid, void** ppv) ; 
 
	// method for incrementing the reference count variable "m_cRef“ 
	virtual ULONG __stdcall AddRef(); 
 
	// method for decrementing the reference count variable "m_cRef“ 
	virtual ULONG __stdcall Release(); 
 
	//IComponent interface's method: 
	virtual void __stdcall Print(const char* msg); 
	virtual int __stdcall increment(int sum);

public: 
	CComponent() ;// Constructor 
	~CComponent();// Destructor 

private: 
	long m_cRef ;// The reference count variable 
}; 

// Constructor  
CComponent::CComponent() 
{ 
	Print("Constructing the component...") ; 
	m_cRef=0; 
} 
 
// Destructor 
CComponent::~CComponent() 
{ 
	Print("Destructing the component...") ; 
}

//AddRef method 
ULONG __stdcall CComponent::AddRef() 
{ 
	Print("Incrementing the reference count variable..."); 
	return InterlockedIncrement(&m_cRef); 
}

// Release method  
ULONG __stdcall CComponent::Release() 
{ 
	Print("Decrementing the reference count variable..."); 
	if(InterlockedDecrement(&m_cRef) == 0) 
	{ 
		delete this ; 
		return 0 ; 
	} 

	return m_cRef ; 
} 


//-----------------------------// 
//QueryInterface implementation 
//-----------------------------// 
HRESULT __stdcall CComponent::QueryInterface(const IID& iid, void** ppv) 
{ 
	if (iid == IID_IUnknown) 
	{ 
		Print("Returning pointer to IUnknown...") ; 
		*ppv = static_cast<IComponent*>(this) ; 
	} 
	else if (iid == IID_IComponent) 
	{ 
		Print("Returning pointer to IComponent interface...") ; 
		*ppv = static_cast<IComponent*>(this) ; 
	} 
	else 
	{ 
		Print("Interface is not supported!.") ; 
		*ppv = NULL ; 
		return E_NOINTERFACE ; 
	} 

	//The reinterpret_cast operator allows any pointer to be converted into 
	//any other pointer type. 
 
	reinterpret_cast<IUnknown*>(*ppv)->AddRef() ; 
	
	// Incrementing the Reference count variable 
	return S_OK ; 
}

void __stdcall CComponent::Print(const char* msg) 
{ 
	std::cout <<"-----------------------"<< std::endl; 
	std::cout <<msg<<std::endl; 
	std::cout <<"-----------------------"<< std::endl; 
} 

int __stdcall CComponent::increment(int sum)
{
	int newsum = sum + 1;
	
	return newsum;		
}

// 
// Exporting the Creation function 
// 
extern "C" IUnknown* CreateInstance() 
{ 
	IUnknown* pIUnknown = static_cast<IComponent*>(new CComponent); 
	pIUnknown->AddRef() ; 
	return pIUnknown ; 
}