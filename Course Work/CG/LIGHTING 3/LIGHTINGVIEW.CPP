///////////////////////////////////////////////////////////////////////////////
//
// LightingView.cpp : implementation of the CLightingView class
//
///////////////////////////////////////////////////////////////////////////////

#include "stdafx.h"
#include "Lighting.h"

#include "LightingDoc.h"
#include "LightingView.h"

#include <math.h> // for fabs()

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif


/////////////////////////////////////////////////////////////////////////////
// CLightingView

IMPLEMENT_DYNCREATE(CLightingView, COpenGLView)

BEGIN_MESSAGE_MAP(CLightingView, COpenGLView)
	//{{AFX_MSG_MAP(CLightingView)
		// NOTE - the ClassWizard will add and remove mapping macros here.
		//    DO NOT EDIT what you see in these blocks of generated code!
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CLightingView construction/destruction

CLightingView::CLightingView()
{
	// TODO: add construction code here
	m_Z = -6.0;
	m_rotY = 20.0;
	m_rotX = -35.0f;

	ToggleAnimationFlag();

	SelectStockScene(eStockSceneNone);
	
}

///////////////////////////////////////////////////////////////////////////////
// Control the animation
BOOL CLightingView::PreRenderScene( void )
{
	// toggle the velocity in the Z direction
	if ( m_Z <= -19.0  )
		{
		m_accelZ = fabs(m_accelZ);
		}
	else if (  m_Z >= -3.0 )
		{
		m_accelZ = -fabs(m_accelZ);
		}

	return ViewpointOriginRotation();
}



///////////////////////////////////////////////////////////////////////////////
BOOL CLightingView::RenderScene( void )
{

	// Need to add a check for the font here before assuming it's there...
	static GLuint myFont = GenerateDisplayListForFont( "Impact", 0.2f );
	
	GLfloat materialSpecular[4] = { 1.0f, 1.0f, 1.0f, 1.0f };
	GLfloat materialShininess[1] = { 128.0f };
	GLfloat materialAmbient[4] = { 0.25f, 0.25f, 0.25f, 1.0f };
	GLfloat materialDiffuse[4] = { 0.4f, 0.4f, 0.4f, 1.0f };

    GLfloat local_ambient[] = { 0.0f, 0.0f, 0.0f, 1.0f };
    
	::glEnable(GL_DEPTH_TEST);
    ::glDepthFunc(GL_LESS);


    ::glLightModelfv(GL_LIGHT_MODEL_AMBIENT, local_ambient);

    GLfloat ambient0[] =  { 0.0f, 0.0f, 0.0f, 1.0f };
    GLfloat diffuse0[] =  { 1.0f, 0.0f, 0.0f, 1.0f };
    GLfloat specular0[] = { 1.0f, 0.0f, 0.0f, 1.0f };
    GLfloat position0[] = { 2.0f, -1.5f, -1.5f, 1.0f };

    GLfloat ambient1[] =  { 0.0f, 0.0f, 0.0f, 1.0f };
    GLfloat diffuse1[] =  { 1.0f, 1.0f, 1.0f, 1.0f };
    GLfloat specular1[] = { 0.5f, 0.5f, 0.5f, 1.0f };
    GLfloat position1[] = { 2.0f, 1.0f, -1.0f, 0.0f };

    GLfloat ambient2[] =  { 0.0f, 0.0f, 0.0f, 1.0f };
    GLfloat diffuse2[] =  { 0.0f, 0.0f, 1.0f, 1.0f };
    GLfloat specular2[] = { 0.0f, 0.0f, 1.0f, 1.0f };
    GLfloat position2[] = { -0.5f, -0.5f, -1.0f, 1.0f };

	GLfloat ambient3[] =  { 0.0f, 0.0f, 0.0f, 1.0f };
    GLfloat diffuse3[] =  { 1.0f, 1.0f, 1.0f, 1.0f };
    GLfloat specular3[] = { 0.0f, 0.0f, 0.0f, 1.0f };
    GLfloat position3[] = { 2.0f, 0.5f, 0.5f, 0.0f };


	// Dispable lighting to draw some simple spheres that
	// represent the lights
	::glDisable( GL_LIGHTING );

	::glPushMatrix();
	::glColor3fv( diffuse0 );
	::glTranslatef( position0[0], position0[1], position0[2] );
  	::auxWireSphere( 0.15f );

	::glPopMatrix();

	::glPushMatrix();
	::glColor3fv( diffuse1 );
	::glTranslatef( position1[0], position1[1], position1[2] );
//  	::auxWireSphere( 0.15f );
	::glPopMatrix();

	::glPushMatrix();
	::glColor3fv( diffuse2 );
	::glTranslatef( position2[0], position2[1], position2[2] );
	::auxWireSphere( 0.15f );

	::glPopMatrix();

	::glPushMatrix();
	::glColor3fv( diffuse3 );
	::glTranslatef( position3[0], position3[1], position3[2] );
//  	::auxWireSphere( 0.15f );
	::glPopMatrix();

	::glEnable( GL_LIGHTING );

    ::glEnable(GL_LIGHT0);  
    ::glLightfv(GL_LIGHT0, GL_AMBIENT, ambient0);
    ::glLightfv(GL_LIGHT0, GL_POSITION, position0);
    ::glLightfv(GL_LIGHT0, GL_DIFFUSE, diffuse0);
    ::glLightfv(GL_LIGHT0, GL_SPECULAR, specular0);

    ::glEnable(GL_LIGHT1);
    ::glLightfv(GL_LIGHT1, GL_AMBIENT, ambient1);
    ::glLightfv(GL_LIGHT1, GL_POSITION, position1);
    ::glLightfv(GL_LIGHT1, GL_DIFFUSE, diffuse1);
    ::glLightfv(GL_LIGHT1, GL_SPECULAR, specular1);
	
    ::glEnable(GL_LIGHT2);  
    ::glLightfv(GL_LIGHT2, GL_AMBIENT, ambient2);
    ::glLightfv(GL_LIGHT2, GL_POSITION, position2);
    ::glLightfv(GL_LIGHT2, GL_DIFFUSE, diffuse2);
    ::glLightfv(GL_LIGHT2, GL_SPECULAR, specular2);

    ::glEnable(GL_LIGHT3);  
    ::glLightfv(GL_LIGHT3, GL_AMBIENT, ambient3);
    ::glLightfv(GL_LIGHT3, GL_POSITION, position3);
    ::glLightfv(GL_LIGHT3, GL_DIFFUSE, diffuse3);
    ::glLightfv(GL_LIGHT3, GL_SPECULAR, specular3);
 
	::glMaterialfv( GL_FRONT, GL_SPECULAR, materialSpecular );
	::glMaterialfv( GL_FRONT, GL_SHININESS, materialShininess );
	::glMaterialfv( GL_FRONT, GL_DIFFUSE, materialDiffuse );
	::glMaterialfv( GL_FRONT, GL_AMBIENT, materialAmbient );

	::glPushMatrix();
	::glTranslatef( -2.8f, 0.0f, 0.0f );
	GLTextOut( myFont, "OpenGL & Windows" );
	::glPopMatrix();

	return TRUE;
}

CLightingView::~CLightingView()
{
}


/////////////////////////////////////////////////////////////////////////////
// CLightingView message handlers
