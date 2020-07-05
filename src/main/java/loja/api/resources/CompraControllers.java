package loja.api.resources;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import loja.api.dto.CompraDto;
import loja.api.dto.CompraDto;
import loja.api.model.entity.Cliente;
import loja.api.model.entity.Compra;
import loja.api.model.entity.Compra;
import loja.api.services.CategoriaService;
import loja.api.services.CompraService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/compras")
@RequiredArgsConstructor
@Slf4j
@Api("Categoria API")
public class CompraControllers {

    private final CompraService service;
    private final ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("criar o Compra")
    public CompraDto create(@RequestBody CompraDto dto) {

        Compra entity = modelMapper.map(dto, Compra.class);
        entity = service.save(entity, dto.getIdCliente(), dto.getItens());
        return modelMapper.map(entity, CompraDto.class);
    }

    @GetMapping("/all")
    @ApiOperation("listar todos as compras")
    public List<CompraDto> findAll() {

        List<Compra> result = service.findByAll();
        List<CompraDto> listDto=   result.stream().map( entity -> modelMapper.map(entity, CompraDto.class
            )).collect(Collectors.toList());
        return listDto;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
