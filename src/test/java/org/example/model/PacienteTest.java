package org.example.model;

import org.example.utils.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PacienteTest {
    @Test
    public void testCriarPaciente() {
        Data dataNascimento = new Data(1, 1, 2000);
        Data dataInternamento = new Data(1, 5, 2024);
        Paciente paciente = new Paciente(1, "João Silva", "M", dataNascimento, dataInternamento);
        Assertions.assertEquals(1, paciente.getId());
        Assertions.assertEquals("João Silva", paciente.getNome());
        Assertions.assertEquals("M", paciente.getSexo());
        Assertions.assertEquals(dataNascimento, paciente.getDataNascimento());
        Assertions.assertNotNull(paciente);
    }
}
