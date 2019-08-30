package zoom.us.springdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import zoom.us.springdemo.client.ZoomClient;
import zoom.us.springdemo.dao.Userdao;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"app=test"})
@AutoConfigureMockMvc
@EnableConfigurationProperties(Auth.class)
@TestPropertySource("classpath:test.properties")
@TestConfiguration("SpringBootTest.class")
public class SpringdemoApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private Auth auth;

	@Value("${app}")
	private String app;

	@MockBean
	private Userdao userDao;

	@MockBean
	private ZoomClient zoomClient;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testUserdao(){

    System.out.println(userDao.createUser("aa"+app));
    System.out.println(auth.getAuthorize());
	}

}
