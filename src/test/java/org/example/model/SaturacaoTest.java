package org.example.model;

import org.example.utils.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.example.exception.MedidaInvalidaException;

public class SaturacaoTest {
    @Test
    public void testCriarSaturacaoValida() throws MedidaInvalidaException {
        Saturacao sat = new Saturacao(98);
        Assertions.assertEquals(98, sat.getSaturacao());
    }

    @Test
    public void testCriarSaturacaoInvalida() {
        Assertions.assertThrows(MedidaInvalidaException.class, () -> {
            new Saturacao(-5);
        });
    }
}
