package hooks;

import utils.Baseclass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Baseclass {
	@Before
	public void start() throws Exception {
		BrowserLaunch();
	}

	@After
	public void end() {
		closeApp();
	}
}
