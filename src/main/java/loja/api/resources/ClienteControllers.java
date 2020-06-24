package loja.api.resources;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import loja.api.dto.ClienteDto;
import loja.api.dto.UserDto;
import loja.api.model.entity.Cliente;
import loja.api.model.entity.User;
import loja.api.services.ClienteService;
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
@RequestMapping(value = "/api/clientes")
@RequiredArgsConstructor
@Slf4j
@Api("Cliente API")
public class ClienteControllers {

    private final ClienteService service;
    private final ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("CREATE A CLIENTE")
    public ClienteDto create(@RequestBody ClienteDto dto) {

        Cliente entity = modelMapper.map(dto, Cliente.class);
        entity = service.save(entity);
        return modelMapper.map(entity, ClienteDto.class);
    }

    @GetMapping
    public Page<ClienteDto> find(ClienteDto dto, Pageable pageRequest) {
        Cliente filter = modelMapper.map(dto, Cliente.class);
        Page<Cliente> result = service.find(filter, pageRequest);
        List<ClienteDto> list  =  result.getContent()
                .stream()
                .map( entity -> modelMapper.map(entity, ClienteDto.class))
                .collect(Collectors.toList());
        return new PageImpl<ClienteDto>( list, pageRequest, result.getTotalElements());
    }

}
