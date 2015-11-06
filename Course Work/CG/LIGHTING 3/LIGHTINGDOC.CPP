// LightingDoc.cpp : implementation of the CLightingDoc class
//

#include "stdafx.h"
#include "Lighting.h"

#include "LightingDoc.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CLightingDoc

IMPLEMENT_DYNCREATE(CLightingDoc, CDocument)

BEGIN_MESSAGE_MAP(CLightingDoc, CDocument)
	//{{AFX_MSG_MAP(CLightingDoc)
		// NOTE - the ClassWizard will add and remove mapping macros here.
		//    DO NOT EDIT what you see in these blocks of generated code!
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CLightingDoc construction/destruction

CLightingDoc::CLightingDoc()
{
	// TODO: add one-time construction code here

}

CLightingDoc::~CLightingDoc()
{
}

BOOL CLightingDoc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: add reinitialization code here
	// (SDI documents will reuse this document)

	return TRUE;
}

/////////////////////////////////////////////////////////////////////////////
// CLightingDoc serialization

void CLightingDoc::Serialize(CArchive& ar)
{
	if (ar.IsStoring())
	{
		// TODO: add storing code here
	}
	else
	{
		// TODO: add loading code here
	}
}

/////////////////////////////////////////////////////////////////////////////
// CLightingDoc diagnostics

#ifdef _DEBUG
void CLightingDoc::AssertValid() const
{
	CDocument::AssertValid();
}

void CLightingDoc::Dump(CDumpContext& dc) const
{
	CDocument::Dump(dc);
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CLightingDoc commands
