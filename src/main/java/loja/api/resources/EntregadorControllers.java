package loja.api.resources;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import loja.api.dto.*;
import loja.api.model.entity.Entrega;
import loja.api.model.entity.Entregador;
import loja.api.services.EntregadorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/entregadores")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
@Api("Entregador API")
public class EntregadorControllers {

    private final EntregadorService service;
    private final ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("CREATE A Entregador")
    public EntregadorDto create(@RequestBody EntregadorDto dto) {
        Entregador entity = modelMapper.map(dto, Entregador.class);
        entity = service.save(entity);
        return modelMapper.map(entity, EntregadorDto.class);

    }


    @PostMapping("/entrega")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("CREATE entrega")
    public void entrega(@RequestBody EntregaDto dto) {
        service.entrega(dto);

    }

    @GetMapping("/all")
    @ApiOperation("listar todos os Entregadores")
    public List<EntregadorDto> findAll() {

        List<Entregador> result = service.findByAll();
        List<EntregadorDto> listDto = result.stream().map( entity -> modelMapper.map(entity, EntregadorDto.class
            )).collect(Collectors.toList());
        return listDto;
    }

    @GetMapping("/entregas")
    @ApiOperation("listar entregas")
    public List<EntregaListaDto> findEntregas() {

        List<Entrega> result = service.findEntregas();
        List<EntregaListaDto> listDto = result.stream().map(entity -> modelMapper.map(new Entrega(entity.getEntregador(), new CompraDto(entity.getCompra()).toEntity()), EntregaListaDto.class
        )).collect(Collectors.toList());
        return listDto;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
