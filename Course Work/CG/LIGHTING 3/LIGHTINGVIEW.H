// LightingView.h : interface of the CLightingView class
//
/////////////////////////////////////////////////////////////////////////////
#include "..\Cpp\Cd-image\Shared\COpenGLView.h"


class CLightingView : public COpenGLView
{
protected: // create from serialization only
	CLightingView();
	DECLARE_DYNCREATE(CLightingView)

// Attributes
public:

// Operations
public:
	virtual BOOL PreRenderScene( void );
	virtual BOOL RenderScene( void );



// Implementation
public:
	virtual ~CLightingView();

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CLightingView)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};
