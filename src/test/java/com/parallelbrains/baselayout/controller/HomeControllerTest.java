package com.parallelbrains.baselayout.controller;

import com.parallelbrains.baselayout.controller.view.HomeController;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import static org.junit.Assert.assertEquals;

/**
 * todo We'll probably won't need controller tests when Backbone.js is integrated
 */
public class HomeControllerTest {

	@Test
	public void testController() {
		HomeController controller = new HomeController();
		Model model = new ExtendedModelMap();
        assertEquals("home", controller.home(model));
		
		Object message = model.asMap().get("controllerMessage");
        assertEquals("This project is under development", message);
	}
}
