
# Compiler options: 
# /c compile without linking 
# CL cl.exe is a 32-bit tool that controls the Microsoft C and C++ 
# compilers and linker. 
# The compilers produce Common Object File Format (COFF) object (.obj) files. 
# The linker produces executable (.exe) files or dynamic-link libraries (DLLs). 
################################## 
# Linker options: 
# 
# /DEF Passes a module-definition (.def) file to the linker 
# /DEBUG Creates debugging information 
# /DLL Builds a DLL

CPP_FLAGS=/c /MTd /Zi /Od /D_DEBUG
EXE_LINK_FLAGS=/DEBUG
DLL_LINK_FLAGS=/DLL /DEBUG

LIBS=UUID.lib 

############################################# 
# Targets: 
# CodeProject is just a pseudotarget 
# 
CodeProject : component 

component : Component.dll

######################################### 
# Shared source files: 
# 
GUID.obj : GUID.cpp 
	cl $(CPP_FLAGS) GUID.cpp 
	
########################################## 
# Component source files: 
# 
Component.obj : Component.cpp Interface.h 
	cl $(CPP_FLAGS) Component.cpp 
	
######################################## 
# Link component: 
# 
Component.dll : Component.obj GUID.obj Component.def 
	link $(DLL_LINK_FLAGS) /DEF:Component.def Component.obj GUID.obj 
$(LIBS) /DEF:Component.def

