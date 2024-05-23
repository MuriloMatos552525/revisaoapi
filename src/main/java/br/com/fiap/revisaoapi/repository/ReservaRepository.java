package br.com.fiap.revisaoapi.repository;

import br.com.fiap.revisaoapi.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
