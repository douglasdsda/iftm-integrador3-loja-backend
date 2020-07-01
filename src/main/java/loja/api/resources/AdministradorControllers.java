package loja.api.resources;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import loja.api.dto.AdministradorDto;
import loja.api.dto.ClienteDto;
import loja.api.model.entity.Administrador;
import loja.api.model.entity.Cliente;
import loja.api.services.AdministradorService;
import loja.api.services.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/administradores")
@RequiredArgsConstructor
@Slf4j
@Api("Administrador API")
public class AdministradorControllers {

    private final AdministradorService service;
    private final ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("criar o administrador")
    public AdministradorDto create(@RequestBody AdministradorDto dto) {

        Administrador entity = modelMapper.map(dto, Administrador.class);
        entity = service.save(entity);
        return modelMapper.map(entity, AdministradorDto.class);
    }

    @GetMapping("/all")
    @ApiOperation("listar todos os administradores")
    public List<AdministradorDto> findAll() {

        List<Administrador> result = service.findByAll();
        List<AdministradorDto> listDto=   result.stream().map( entity -> modelMapper.map(entity, AdministradorDto.class
            )).collect(Collectors.toList());
        return listDto;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
