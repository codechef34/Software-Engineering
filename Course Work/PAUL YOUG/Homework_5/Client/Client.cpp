
//
// Client Implementation File
//
// Client.cpp 
#include <iostream> 
#include <objbase.h> 
#include <chrono>

#include <ctime>
#include "Interface.h" 
#include "Create.h" 
using namespace std; 

void TRACE(const char* msg) 
{ 
	cout << "Client :\t" << msg <<endl;
}

//--------// // Client //--------// 

int main() 
{ 
	HRESULT hr ;
	// Get the name of the component to use. 
	char dllname[20]; 
	cout << "Enter the filename of component's server [Component.dll]:"; 
	cin >> dllname; 
	cout << endl<<endl; 
	// calling the CreateInstance function in the DLL in order to create the component. 
	TRACE("Getting an IUnknown interface pointer...") ; 
	IUnknown* pIUnknown = CallCreateInstance(dllname) ; 
	if (pIUnknown == NULL) 
	{ 
		TRACE("CallCreateInstance Failed!."); 
		return 1; 
	} 
	
	TRACE("Succeeded getting IUnknown interface."); 
	TRACE("Quering the component's interface by QueryInterface method..."); 
	IComponent* pIComponent ; 
	hr = pIUnknown->QueryInterface(IID_IComponent, (void**)&pIComponent);

	if (SUCCEEDED(hr)) 
	{ 
		TRACE("Succeeded getting IComponent interface."); 
		TRACE("Calling the Print method of the component...\n");  

		
		 std::chrono::time_point<std::chrono::system_clock> start, end;
		
		int sum = 0;
		long long average = 0;
		cout << "The initial value of 'sum' is: " << sum << endl << endl;
		cout << "Calling the server's increment function 1000 times ... ";
		start = std::chrono::system_clock::now();
		for(int i = 0; i < 1000; i++)
		{
			

			sum = pIComponent->increment(sum);

			
		}
		end = std::chrono::system_clock::now();
		cout << "Complete." << endl << endl;
	

		std::chrono::duration<double> elapsed_seconds = end - start;
		std::time_t end_time = std::chrono::system_clock::to_time_t(end);

		std::cout << "finished computation at " << std::ctime(&end_time)
			<< "Average Response Time: " << elapsed_seconds.count()<< "s\n";
		

		cout << "The current value of 'sum' is now: " << sum << endl << endl;
	
		cout << endl;
		

		pIComponent->Release() ; 
	} 
	else 
	{ 
		TRACE("Unable to get the inteface."); 
	} 
	
	TRACE("Releasing the Component..."); 
	pIUnknown->Release() ; 
	
	return 0 ; 
}