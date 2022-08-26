package widget;

import org.testng.annotations.Test;

import library.BaseTest;
import pageLocators.WidgetLoactors;

public class Menu extends BaseTest{

	
	@Test
	public void manualTest() {

		lib.clickElement(WidgetLoactors.leftNavigation_menu);

		lib.enterIntoFrame(0);

		lib.hoverToElement(WidgetLoactors.menu_electronics);

		lib.hoverToElement(WidgetLoactors.menu_electronics_carHifi);

		lib.customeWait(5);

	}

}
