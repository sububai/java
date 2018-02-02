package spittr.web;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import spittr.data.SpitterRepository;

public class SpitterControllerTest {

	@Test
	public void shouldShowRegistration() throws Exception {
		SpitterController controller = new SpitterController();
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(get("/spitter/register"))
			.andExpect(view().name("registerForm"));
	}
	
	@Test
	public void shouldProcessRegistration() throws Exception {
		SpitterRepository mockRepository = mock(SpitterRepository.class);
		SpitterController controller = new SpitterController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(post("/spitter/register")
			.param("firstName", "Jack")
			.param("lastName", "Bauer")
			.param("username", "jbauer")
			.param("password", "24hours"))
			.andExpect(redirectedUrl("/spitter/jbauer"));
		//verify(mockRepository, atLeastOnce()).save(unsaved);
	}
}
