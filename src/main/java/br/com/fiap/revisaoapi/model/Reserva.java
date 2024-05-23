package br.com.fiap.revisaoapi.model;

import br.com.fiap.revisaoapi.validation.CheckOutAfterCheckIn;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "tb_reserva")
@CheckOutAfterCheckIn
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O cliente é obrigatório")
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @NotBlank(message = "O número do quarto é obrigatório")
    @Size(min = 1, max = 5, message = "O número do quarto deve ter entre 1 e 5 caracteres")
    @Column(name = "quarto")
    private String quarto;

    @NotNull(message = "A data de check-in é obrigatória")
    @FutureOrPresent(message = "A data de check-in deve ser no presente ou futuro")
    @Column(name = "data_check_in")
    private LocalDate dataCheckIn;

    @NotNull(message = "A data de check-out é obrigatória")
    @FutureOrPresent(message = "A data de check-out deve ser no presente ou futuro")
    @Column(name = "data_check_out")
    private LocalDate dataCheckOut;

    @NotBlank(message = "O status é obrigatório")
    @Size(max = 20, message = "O status deve ter no máximo 20 caracteres")
    @Column(name = "status")
    private String status;

    public Reserva() {}

    public Reserva(Long id, Cliente cliente, String quarto, LocalDate dataCheckIn, LocalDate dataCheckOut, String status) {
        this.id = id;
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
