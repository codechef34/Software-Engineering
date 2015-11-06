package MainSystem.Admin;

import com.admin.ui.ForgotPass;

import MainSystem.Main.Controller;
import MainSystem.Main.*;

public class LoginController 
{
	private String username = "";
	private String password = "";	
	
	LoginGUI loginGUIObject;
	private Controller parent;
	
	public LoginController (Controller controller)
	{
	    this.parent = controller;
	}
	
    private String getUsername()
    {
		return username;
	}

	private void setUsername(String username)
	{
		this.username = username;
	}

	private String getPassword()
	{
		return password;
	}

	private void setPassword(String password)
	{
		this.password = password;
	}

	public void displayErrorMessage (String message) 
    {
        //throw new UnsupportedOperationException ();
    }
    
    public void validateCredentials (String username, String password)
    {
        if (parent.validateCredentials (username, password))
        {
            loginGUIObject.closeWindow ();
            this.parent.requestMainStartup ();
        }
        else
        {
            loginGUIObject.displayErrorMessage ("Invalid credentials, please reenter!");
        }
    	setUsername(username);
    	setPassword(password);
    }
    
    public void showLoginGUI()
    {
    	loginGUIObject = new LoginGUI(this);
    }

    public void forgotPassword () {
        new ForgotPass ();
    }
}
 