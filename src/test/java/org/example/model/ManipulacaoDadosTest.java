package org.example.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.example.exception.MedidaInvalidaException;

public class ManipulacaoDadosTest {
    @Test
    public void testListarPacientesOrdenadosSemPacientes() {
        Assertions.assertDoesNotThrow(() -> {
            ManipulacaoDados.listarPacientesOrdenados();
        });
    }
}
