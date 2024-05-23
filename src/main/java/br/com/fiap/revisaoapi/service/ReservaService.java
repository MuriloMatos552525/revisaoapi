package br.com.fiap.revisaoapi.service;

import br.com.fiap.revisaoapi.dto.ReservaDTO;
import br.com.fiap.revisaoapi.model.Cliente;
import br.com.fiap.revisaoapi.model.Reserva;
import br.com.fiap.revisaoapi.repository.ClienteRepository;
import br.com.fiap.revisaoapi.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final ClienteRepository clienteRepository;
    private static final Pageable customPageable = PageRequest.of(0, 3, Sort.by("dataCheckIn").ascending());

    @Autowired
    public ReservaService(ReservaRepository reservaRepository, ClienteRepository clienteRepository) {
        this.reservaRepository = reservaRepository;
        this.clienteRepository = clienteRepository;
    }

    public Page<ReservaDTO> findAll() {
        return reservaRepository.findAll(customPageable).map(this::toDTO);
    }

    public ReservaDTO findById(Long id) {
        Optional<Reserva> reserva = reservaRepository.findById(id);
        return reserva.map(this::toDTO).orElse(null);
    }

    public Reserva save(Reserva reserva) {
        Optional<Cliente> cliente = clienteRepository.findById(reserva.getCliente().getId());
        cliente.ifPresent(reserva::setCliente);
        return reservaRepository.save(reserva);
    }

    public Reserva update(Long id, Reserva reserva) {
        Optional<Reserva> reservaOptional = reservaRepository.findById(id);
        if (reservaOptional.isPresent()) {
            Reserva reservaUpdate = reservaOptional.get();
            Optional<Cliente> cliente = clienteRepository.findById(reserva.getCliente().getId());
            cliente.ifPresent(reservaUpdate::setCliente);
            reservaUpdate.setQuarto(reserva.getQuarto());
            reservaUpdate.setDataCheckIn(reserva.getDataCheckIn());
            reservaUpdate.setDataCheckOut(reserva.getDataCheckOut());
            reservaUpdate.setStatus(reserva.getStatus());
            return reservaRepository.save(reservaUpdate);
        }
        return null;
    }

    public void delete(Long id) {
        Optional<Reserva> reservaOptional = reservaRepository.findById(id);
        reservaOptional.ifPresent(reservaRepository::delete);
    }

    private ReservaDTO toDTO(Reserva reserva) {
        ReservaDTO reservaDTO = new ReservaDTO();
        reservaDTO.setId(reserva.getId());
        reservaDTO.setClienteId(reserva.getCliente().getId());
        reservaDTO.setQuarto(reserva.getQuarto());
        reservaDTO.setDataCheckIn(reserva.getDataCheckIn());
        reservaDTO.setDataCheckOut(reserva.getDataCheckOut());
        return reservaDTO;
    }
}
