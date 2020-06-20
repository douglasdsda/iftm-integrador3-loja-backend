package loja.api.resources;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import loja.api.dto.UserDto;
import loja.api.model.User;
import loja.api.services.UserServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/users")
@RequiredArgsConstructor
@Slf4j
@Api("User API")
public class UserControllers {

    private final UserServices service;
    private final ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("CREATE A USER")
    public UserDto create(@RequestBody  UserDto dto) {

        User entity = modelMapper.map(dto, User.class);
        //  Book.builder()
        // .author(dto.getAuthor())
        // .title(dto.getTitle())
        // .isbn(dto.getIsbn())
        //  .build();
        entity = service.save(entity);
        return modelMapper.map(entity, UserDto.class);
    }

}
