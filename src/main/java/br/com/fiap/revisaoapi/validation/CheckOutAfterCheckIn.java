package br.com.fiap.revisaoapi.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CheckOutAfterCheckInValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckOutAfterCheckIn {
    String message() default "A data de check-out deve ser posterior à data de check-in";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
