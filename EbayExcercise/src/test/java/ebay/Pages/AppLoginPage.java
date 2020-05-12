package ebay.Pages;

import java.io.IOException;

import com.ebay.Page.AppMasterPage;

public class AppLoginPage extends AppMasterPage
{
	public AppLoginPage() throws IOException
	{
		
	}

	public boolean doLogin(String UserName, String Password)
	{
		//click Sign in
		click("signin_btn");
		
		//username
		sendData("email_txtBox", UserName);
		
		//password
		sendData("password_txtBox", Password);
		
		//submit
		click("submit_btn");
		
		//
		return (isLinkPresent("logout_tab"));
	}

}
