package com.cmuhatia.library.library.usermanagement;

import com.cmuhatia.library.library.usermanagement.resources.ModuleResourceTest;
import com.cmuhatia.library.library.usermanagement.resources.StatusResourceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient(timeout = "30000")
class UsermanagementApplicationTests {

	/**
	 * Rest test client
	 */
	@Autowired
	protected WebTestClient webClient;
	/**
	 * Current server running port
	 */
	@LocalServerPort
	private int port;
	/**
	 * Base url
	 */
	protected String baseUrl;

	/**
	 * Setup
	 */
	@BeforeEach
	public void setup() {
		this.baseUrl = "http://localhost:" + port;
	}

	@Test
	void statusResource() {
		StatusResourceTest statusResource = new StatusResourceTest(webClient);
		statusResource.statusTests();
	}

	@Test
	void moduleResource(){
		ModuleResourceTest moduleResourceTest = new ModuleResourceTest(webClient);
		moduleResourceTest.moduleTests();
	}

}
