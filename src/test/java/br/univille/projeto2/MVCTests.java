package br.univille.projeto2;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MVCTests {
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mvc;

	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	public void testHome() throws Exception{
		String url = "/api";
		
		System.out.println(mvc.perform(get(url)).andDo(print()));
	}
	
	@Test
	public void testFindItem() throws Exception{
		String url = "/api/itens/1";
		
		System.out.println(mvc.perform(get(url)).andDo(print()));
		
		mvc.perform(get(url)).andExpect(status().isOk()).andExpect(jsonPath("preco", equalTo(25.0)));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
