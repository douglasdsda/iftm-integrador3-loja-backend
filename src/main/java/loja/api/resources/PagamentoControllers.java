package loja.api.resources;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import loja.api.dto.PagamentoDto;
import loja.api.dto.PagamentoDto;
import loja.api.model.entity.Pagamento;
import loja.api.model.entity.Pagamento;
import loja.api.services.CompraService;
import loja.api.services.PagamentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/pagamentos")
@RequiredArgsConstructor
@Slf4j
@Api("Pagamento API")
public class PagamentoControllers {

    private final PagamentoService service;
    private final ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("criar o Pagamento")
    public PagamentoDto create(@RequestBody PagamentoDto dto) {

        Pagamento entity = modelMapper.map(dto, Pagamento.class);
        entity = service.save(entity);
        return modelMapper.map(entity, PagamentoDto.class);
    }

    @GetMapping("/all")
    @ApiOperation("listar todos os pagamentos")
    public List<PagamentoDto> findAll() {

        List<Pagamento> result = service.findByAll();
        List<PagamentoDto> listDto =  result.stream().map( entity -> modelMapper.map(entity, PagamentoDto.class
            )).collect(Collectors.toList());
        return listDto;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
