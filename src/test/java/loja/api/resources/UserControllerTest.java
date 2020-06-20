package loja.api.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import loja.api.dto.UserDto;
import loja.api.model.entity.User;
import loja.api.services.UserServices;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest(controllers = UserControllers.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    static String USER_API = "/api/users";

    @Autowired
    MockMvc mvc;


    @MockBean
    UserServices service;

    @Test
    @DisplayName("Deve criar um Usuario com Sucesso.")
    public void createUserTest() throws Exception {
        UserDto dto = createNewUser();
        User savedUser = creadUser();
        BDDMockito.given(service.save(Mockito.any(User.class))).willReturn(savedUser);

        String json = new ObjectMapper().writeValueAsString(dto);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(USER_API)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mvc
                .perform(request)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id").value(1l))
                .andExpect(jsonPath("userName").value(dto.getUserName()));
    }

    @Test
    @DisplayName("Deve filtrar users")
    public void findBooksTest() throws Exception {
        Long id =  1l;

        User user = User.builder()
                .id(id)
                .userName(createNewUser().getUserName())

                .build();
        BDDMockito.given( service.find(Mockito.any(User.class), Mockito.any(Pageable.class)))
                .willReturn( new PageImpl<User>(Arrays.asList(user), PageRequest.of(0,100), 1));

        String queryString = String.format("?user=%s&page=0&size=100",
                user.getUserName(),user.getUserName());
        MockHttpServletRequestBuilder request  = MockMvcRequestBuilders.get(USER_API.concat(queryString))
                .accept(MediaType.APPLICATION_JSON);
        mvc
                .perform( request)
                .andExpect(status().isOk())
                .andExpect( jsonPath("content", Matchers.hasSize(1)))
                .andExpect( jsonPath("totalElements").value(1))
                .andExpect(jsonPath("pageable.pageSize").value(100))
                .andExpect(jsonPath("pageable.pageNumber").value(0));
    }


    private UserDto createNewUser() {
        return UserDto.builder().userName("douglas").build();
    }

    private User creadUser() {
        return User.builder().id(1l).userName("douglas").build();
    }


}
