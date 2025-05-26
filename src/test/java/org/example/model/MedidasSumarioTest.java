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
        // Não lança exceção se não houver medições
        Assertions.assertDoesNotThrow(() -> {
            String resultado = MedidasSumario.calcularMedidasSumarioParaTodosPacientes();
            Assertions.assertNotNull(resultado);
        });
    }
}
