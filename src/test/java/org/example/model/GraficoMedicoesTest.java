package org.example.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GraficoMedicoesTest {
    @Test
    public void testImprimirGraficoSemPacientes() {
        // Não deve lançar exceção mesmo sem pacientes
        Assertions.assertDoesNotThrow(() -> {
            GraficoMedicoes.imprimirGrafico();
        });
    }
}
