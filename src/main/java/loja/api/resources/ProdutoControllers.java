package loja.api.resources;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import loja.api.dto.CategoriaDto;
import loja.api.dto.ProdutoDto;
import loja.api.model.entity.Categoria;
import loja.api.model.entity.Produto;
import loja.api.services.ProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/produtos")
@RequiredArgsConstructor
@Slf4j
@Api("Produto API")
public class ProdutoControllers {

    private final ProdutoService service;
    private final ModelMapper modelMapper;

    /*
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("criar o Produto")
    public ProdutoDto create(@RequestBody ProdutoDto dto) {

        Produto entity = modelMapper.map(dto, Produto.class);
        entity = service.save(entity);
        return modelMapper.map(entity, ProdutoDto.class);
    }
 */
    @GetMapping("/all")
    @ApiOperation("listar todos os produtos")
    public List<ProdutoDto> findAll() {

        List<Produto> result = service.findByAll();
        List<ProdutoDto> listDto = result.stream().map( entity -> modelMapper.map(entity, ProdutoDto.class
            )).collect(Collectors.toList());
        return listDto;
    }

    @PostMapping()
    @ApiOperation("criar produto com categoria")
    public ResponseEntity<ProdutoDto> insert( @RequestBody ProdutoDto dto) {
        ProdutoDto newDto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newDto.getIdProduto()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @PutMapping("/{id}")
    @ApiOperation("update de produto")
    public ProdutoDto update(@RequestBody ProdutoDto dto, @PathVariable Long id) {
        Produto entity = modelMapper.map(dto, Produto.class);
        entity = service.update(entity, id);
        return modelMapper.map(entity, ProdutoDto.class);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
