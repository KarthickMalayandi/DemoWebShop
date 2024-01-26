package genericLib;

import pomPages.CartPage;
import pomPages.HomePage;
import pomPages.LoginPage;
import pomPages.ProductDescriptionPage;
import pomPages.ProductListPage;
import pomPages.RegisterPage;

public class BaseClass {

	public WebUtilities webUtil=new WebUtilities();
	public AndroidUtilities androidUtil=new AndroidUtilities();
	public Utilities util=new Utilities();
	
	public HomePage hp=new HomePage();
	public RegisterPage rp=new RegisterPage();
	public LoginPage lp=new LoginPage();
	public ProductListPage plp=new ProductListPage();
	public ProductDescriptionPage pdp=new ProductDescriptionPage();
	public CartPage cp=new CartPage();
}
