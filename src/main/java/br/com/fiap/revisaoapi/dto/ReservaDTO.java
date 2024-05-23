package br.com.fiap.revisaoapi.dto;

import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

public class ReservaDTO extends RepresentationModel<ReservaDTO> {
    private Long id;
    private Long clienteId;
    private String quarto;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;

    public ReservaDTO() {}

    public ReservaDTO(Long id, Long clienteId, String quarto, LocalDate dataCheckIn, LocalDate dataCheckOut) {
        this.id = id;
        this.clienteId = clienteId;
        this.quarto = quarto;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getQuarto() {
        return quarto;
    }

    public void setQuarto(String quarto) {
        this.quarto = quarto;
    }

    public LocalDate getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(LocalDate dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public LocalDate getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckOut(LocalDate dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }
}
