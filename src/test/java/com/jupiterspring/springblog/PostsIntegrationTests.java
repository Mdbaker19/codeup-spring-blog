package com.jupiterspring.springblog;

import com.jupiterspring.springblog.model.User;
import com.jupiterspring.springblog.repositories.PostRepository;
import com.jupiterspring.springblog.repositories.UserRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpSession;
import java.time.MonthDay;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringblogApplication.class)
@AutoConfigureMockMvc
public class PostsIntegrationTests {


    private User testUser;
    private HttpSession httpSession;

    @Autowired
    private MockMvc mvc;

    @Autowired
    UserRepository userDao;

    @Autowired
    PostRepository postDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Before
    public void setup() throws Exception {
        testUser = userDao.findByUsername("testUser");

        if(testUser == null){
            User newUser = new User();
            newUser.setUsername("matt");
            newUser.setPassword(passwordEncoder.encode("password"));
            newUser.setEmail("testUser@codeup.com");
            testUser = userDao.save(newUser);
        }

//        httpSession = this.mvc.perform(post("/login").with(csrf())
//                .param("username", "testUser")
//                .param("password", "pass"))
//                .andExpect(status().is(HttpStatus.FOUND.value()))
//                .andExpect(redirectedUrl("/ads"))
//                .andReturn()
//                .getRequest()
//                .getSession();
    }

}
