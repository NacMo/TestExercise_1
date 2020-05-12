package ebay.Pages;

import java.io.IOException;

import org.openqa.selenium.Keys;

import com.ebay.Page.AppMasterPage;

public class AppHomescreen extends AppMasterPage
{
	public AppHomescreen() throws IOException 
	{
		
	}

	public boolean purchaseItem(String searchItem)
	{
		click("search_box"); //click on search box
		
		sendSearchData("search_box",searchItem,Keys.ENTER); //send item name in search box
		return false;
		
		
	}

}
