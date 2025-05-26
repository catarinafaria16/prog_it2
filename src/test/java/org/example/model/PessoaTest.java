package org.example.model;

import org.example.utils.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PessoaTest {
    @Test
    public void testCriarPessoaPaciente() {
        Data dataNascimento = new Data(15, 7, 1995);
        Data dataInternamento = new Data(20, 5, 2025);
        Pessoa pessoa = new Paciente(10, "Ana Lopes", "F", dataNascimento, dataInternamento);
        Assertions.assertEquals(10, pessoa.getId());
        Assertions.assertEquals("Ana Lopes", pessoa.getNome());
        Assertions.assertEquals("F", pessoa.getSexo());
        Assertions.assertEquals(dataNascimento, pessoa.getDataNascimento());
    }

    @Test
    public void testCriarPessoaProfissional() {
        Data dataNascimento = new Data(2, 12, 1980);
        Pessoa pessoa = new ProfissionalSaude(11, "Pedro Ramos", "M", dataNascimento, "Pediatria");
        Assertions.assertEquals(11, pessoa.getId());
        Assertions.assertEquals("Pedro Ramos", pessoa.getNome());
        Assertions.assertEquals("M", pessoa.getSexo());
        Assertions.assertEquals(dataNascimento, pessoa.getDataNascimento());
    }
}
