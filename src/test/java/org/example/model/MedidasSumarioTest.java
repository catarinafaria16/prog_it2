package org.example.model;

import org.example.utils.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.example.exception.MedidaInvalidaException;

import java.util.ArrayList;
import java.util.List;

public class MedidasSumarioTest {
    @Test
    public void testCalcularMedidasSumarioParaTodosPacientesSemMedidas() {
        // Espera que seja lançada MedidaInvalidaException se não houver medições
        Assertions.assertThrows(MedidaInvalidaException.class, () -> {
            MedidasSumario.calcularMedidasSumarioParaTodosPacientes();
        });
    }
}
