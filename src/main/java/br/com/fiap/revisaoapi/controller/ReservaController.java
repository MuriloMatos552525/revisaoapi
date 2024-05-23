package br.com.fiap.revisaoapi.controller;

import br.com.fiap.revisaoapi.dto.ReservaDTO;
import br.com.fiap.revisaoapi.model.Reserva;
import br.com.fiap.revisaoapi.service.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/reservas", produces = {"application/json"})
@Tag(name = "api-reserva")
public class ReservaController {
    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @Operation(summary = "Retorna todas as reservas em páginas de 3")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "204", description = "Nenhuma reserva encontrada", content = {
                    @Content(schema = @Schema())
            })
    })
    @GetMapping
    public ResponseEntity<Page<ReservaDTO>> findAll() {
        Page<ReservaDTO> reservasDTO = reservaService.findAll();
        if (reservasDTO.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            for (ReservaDTO reservaDTO : reservasDTO){
                Long id = reservaDTO.getId();
                reservaDTO.add(linkTo(methodOn(ReservaController.class)
                        .findById(id)).withSelfRel());
            }
        }
        return ResponseEntity.ok(reservasDTO);
    }

    @Operation(summary = "Retorna uma reserva específica por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "204", description = "Nenhuma reserva encontrada para o id informado", content = {
                    @Content(schema = @Schema())
            })
    })
    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> findById(@PathVariable Long id) {
        ReservaDTO reservaDTO = reservaService.findById(id);
        if (reservaDTO == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            reservaDTO.add(linkTo(methodOn(ReservaController.class)
                    .findAll()).withRel("Lista de Reservas"));
        }
        return ResponseEntity.ok(reservaDTO);
    }

    @Operation(summary = "Grava uma reserva")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Reserva gravada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação dos dados", content = {
                    @Content(schema = @Schema())
            })
    })
    @PostMapping
    public ResponseEntity<Reserva> save(@Valid @RequestBody Reserva reserva) {
        Reserva reservaSalva = reservaService.save(reserva);
        return new ResponseEntity<>(reservaSalva, HttpStatus.CREATED);
    }

    @Operation(summary = "Atualiza uma reserva com base no id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Reserva atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação dos dados", content = {
                    @Content(schema = @Schema())
            })
    })
    @PutMapping("/{id}")
    public ResponseEntity<Reserva> update(@PathVariable Long id, @Valid @RequestBody Reserva reserva) {
        Reserva reservaSalva = reservaService.update(id, reserva);
        return new ResponseEntity<>(reservaSalva, HttpStatus.CREATED);
    }

    @Operation(summary = "Exclui uma reserva com base no id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Reserva excluída com sucesso", content = {
                    @Content(schema = @Schema())
            })
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        reservaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
