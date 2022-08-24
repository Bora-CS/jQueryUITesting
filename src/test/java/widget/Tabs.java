package widget;

import org.testng.Assert;

import library.BaseTest;
import pageLocators.WidgetLoactors;

public class Tabs extends BaseTest{
	
	
	String expectingFirstTabMessage="Proin elit arcu, rutrum commodo, vehicula tempus, commodo a, risus. Curabitur nec arcu. Donec sollicitudin mi sit amet mauris. Nam elementum quam ullamcorper ante. Etiam aliquet massa et lorem. Mauris dapibus lacus auctor risus. Aenean tempor ullamcorper leo. Vivamus sed magna quis ligula eleifend adipiscing. Duis orci. Aliquam sodales tortor vitae ipsum. Aliquam nulla. Duis aliquam molestie erat. Ut et mauris vel pede varius sollicitudin. Sed ut dolor nec orci tincidunt interdum. Phasellus ipsum. Nunc tristique tempus lectus.";

	String expectingSecondTabMessage ="";
	String expectingThirdTabMessage = "";
	
	
	public void defaultTest() {
		
		lib.clickElement(WidgetLoactors.leftNavigation_tabs);
		
		lib.enterIntoFrame(0);
		
		lib.clickElement(WidgetLoactors.Tabs_nuncTab);
		
		String firstTabmessage = lib.getText(WidgetLoactors.Tabs_1st_message);
		
		Assert.assertEquals(firstTabmessage, expectingFirstTabMessage);

		
		
		lib.clickElement(WidgetLoactors.Tabs_proinTab);
		String secondTabMessage = lib.getText(WidgetLoactors.Tabs_2nd_message);
		Assert.assertEquals(secondTabMessage, expectingSecondTabMessage);
		
		
		lib.clickElement(WidgetLoactors.Tabs_3rdTab);
		String thirdTabMessage = lib.getText(WidgetLoactors.Tabs_3rd_message);
		Assert.assertEquals(thirdTabMessage, expectingThirdTabMessage);
		
	}
	
	
	
}
