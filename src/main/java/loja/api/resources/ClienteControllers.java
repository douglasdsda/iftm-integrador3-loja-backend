package loja.api.resources;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import loja.api.dto.AdministradorDto;
import loja.api.dto.ClienteDto;
import loja.api.model.entity.Administrador;
import loja.api.model.entity.Cliente;
import loja.api.services.ClienteService;
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
    public Page<ClienteDto> find(String nome, Pageable pageRequest) {

        Page<Cliente> result = service.find(nome, pageRequest);
        List<ClienteDto> list  =  result.getContent()
                .stream()
                .map( entity -> modelMapper.map(entity, ClienteDto.class))
                .collect(Collectors.toList());
        return new PageImpl<ClienteDto>( list, pageRequest, result.getTotalElements());
    }



    @GetMapping("/all")
    public List<ClienteDto> findAll() {

        List<Cliente> result = service.findByAll();
        List<ClienteDto> listDto=   result.stream().map( entity -> modelMapper.map(entity, ClienteDto.class
        )).collect(Collectors.toList());
        return listDto;
    }

}
