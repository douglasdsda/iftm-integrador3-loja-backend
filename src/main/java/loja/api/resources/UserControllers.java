package loja.api.resources;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import loja.api.dto.UserDto;
import loja.api.model.entity.User;
import loja.api.services.UserServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
        entity = service.save(entity);
        return modelMapper.map(entity, UserDto.class);
    }

    @GetMapping
    public Page<UserDto> find(UserDto dto, Pageable pageRequest) {
        User filter = modelMapper.map(dto, User.class);
        Page<User> result = service.find(filter, pageRequest);
        List<UserDto> list  =  result.getContent()
                .stream()
                .map( entity -> modelMapper.map(entity, UserDto.class))
                .collect(Collectors.toList());
        return new PageImpl<UserDto>( list, pageRequest, result.getTotalElements());
    }

}
