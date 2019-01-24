package MFCWEBAPP.MFC;

public class VariablesDeclaration 
{
	//common for Listing page and Stock details page
	public static String URL = "https://www.stagemfc.com";
	public static String bengaluruCity = "//a[@data-id=\"Bangalore-Karnataka\"]";
	public static String buyMenu ="buy_menu";
	public static String usedCars= "//a[@href=\"/buy/used-cars/bangalore\"]";
	public static String certifiedCars = "//a[@href=\"/buy/used-cars/certified/bangalore\"]";
	
	//Customer details
	public static String customerMobile = "8792095030";
	public static String customerName = "SuchitraTest";
	public static String customerEmail = "abc1@gmail.com";
	
	//Email details
	public static String host = "imap.gmail.com";
	public static String protocol = "impas";
	public static String username = "mfcwebapp@gmail.com";
	public static String password = "Gmail.com123";
	
	//For Listing Page
	public static String findEle = "(//div[@class=\"stock_card_caption\"])[1]/a";
	public static String mobileField = "QuickAccessStockMobile_PP";
	public static String nameField = "QuickAccessStockName_PP";
	public static String OTPField = "QuickAccessStockverificationcode_PP";
	public static String emailfield = "QuickAccessStockEmail_PP";
	public static String submitDetails = "btnSubmitStockStoreLead";
	
	
	//For Stock details page
	public static String vehicle = "(//div[@class=\"ft_car_model image_aspect_container\"])[5]";
	public static String stockMobileField = "detail_QuickAccessStockMobile_PP";
	public static String stockNameField ="//input[@id=\"detail_QuickAccessStockName_PP\"]";
	public static String stockOTPField = "detail_QuickAccessStockverificationcode_PP";
	public static String stockEmailField = "detail_QuickAccessStockEmail_PP";
	public static String stockSubmitDetails = "btnLeadGenerate";
	
}
