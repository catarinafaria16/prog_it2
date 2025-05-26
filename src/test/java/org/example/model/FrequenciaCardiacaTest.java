package org.example.model;

import org.example.utils.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.example.exception.MedidaInvalidaException;

public class FrequenciaCardiacaTest {
    @Test
    public void testCriarFrequenciaCardiacaValida() throws MedidaInvalidaException {
        FrequenciaCardiaca fc = new FrequenciaCardiaca(70);
        Assertions.assertEquals(70, fc.getFrequencia());
    }

    @Test
    public void testCriarFrequenciaCardiacaInvalida() {
        Assertions.assertThrows(MedidaInvalidaException.class, () -> {
            new FrequenciaCardiaca(-10);
        });
    }
}
