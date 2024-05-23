package br.com.fiap.revisaoapi.validation;

import br.com.fiap.revisaoapi.model.Reserva;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckOutAfterCheckInValidator implements ConstraintValidator<CheckOutAfterCheckIn, Reserva> {
    @Override
    public boolean isValid(Reserva reserva, ConstraintValidatorContext context) {
        if (reserva.getDataCheckIn() == null || reserva.getDataCheckOut() == null) {
            return true;
        }
        return reserva.getDataCheckOut().isAfter(reserva.getDataCheckIn());
    }
}
