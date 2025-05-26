package org.example.model;

import org.example.utils.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProfissionalSaudeTest {
    @Test
    public void testCriarProfissionalSaude() {
        Data dataNascimento = new Data(10, 2, 1990);
        ProfissionalSaude profissional = new ProfissionalSaude(2, "Maria Costa", "F", dataNascimento, "Cardiologia");
        Assertions.assertEquals(2, profissional.getId());
        Assertions.assertEquals("Maria Costa", profissional.getNome());
        Assertions.assertEquals("F", profissional.getSexo());
        Assertions.assertEquals(dataNascimento, profissional.getDataNascimento());
        Assertions.assertEquals("Cardiologia", profissional.getEspecialidade());
    }
}
