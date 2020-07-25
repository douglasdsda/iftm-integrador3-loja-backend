package loja.api.resources;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import loja.api.dto.CategoriaDto;
import loja.api.dto.CategoriaDto;
import loja.api.model.entity.Categoria;
import loja.api.model.entity.Categoria;
import loja.api.services.AdministradorService;
import loja.api.services.CategoriaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/categorias")
@RequiredArgsConstructor
@Slf4j
@Api("Categoria API")
public class CategoriaControllers {

    private final CategoriaService service;
    private final ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("criar o categoria")
    public CategoriaDto create(@RequestBody CategoriaDto dto) {

        Categoria entity = modelMapper.map(dto, Categoria.class);
        entity = service.save(entity);
        return modelMapper.map(entity, CategoriaDto.class);
    }

    @GetMapping("/all")
    @ApiOperation("listar todos os categorias")
    public List<CategoriaDto> findAll() {

        List<Categoria> result = service.findByAll();
        List<CategoriaDto> listDto=   result.stream().map( entity -> modelMapper.map(entity, CategoriaDto.class
            )).collect(Collectors.toList());
        return listDto;
    }

    @PutMapping("/{id}")
    @ApiOperation("update de categoria")
    public  CategoriaDto  update(@RequestBody CategoriaDto dto,@PathVariable Long id) {
        Categoria entity = modelMapper.map(dto, Categoria.class);
        entity = service.update(entity, id);
        return modelMapper.map(entity, CategoriaDto.class);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
