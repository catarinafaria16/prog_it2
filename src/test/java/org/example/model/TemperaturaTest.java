package org.example.model;

import org.example.utils.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.example.exception.MedidaInvalidaException;

public class TemperaturaTest {
    @Test
    public void testCriarTemperaturaValida() throws MedidaInvalidaException {
        Temperatura temp = new Temperatura(36.5);
        Assertions.assertEquals(36.5, temp.getTemperatura());
    }

    @Test
    public void testCriarTemperaturaInvalida() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Temperatura(-2);
        });
    }
}
