package es.dg.avan.jtools;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;


/**
 * Test de JUnit integrado con Maven a través de un plugin en el pom.
 */
@RunWith(JUnitPlatform.class)
public class AppTest{
	@BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {
    }

    @Test
    @DisplayName("Test que ocurre correctamente")
    void succeedingTest() {
    }

    @Test
    void failingTest() {
    	//fail("a failing test");
    }

	@Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }

}
