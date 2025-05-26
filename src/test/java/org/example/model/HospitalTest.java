package org.example.model;

import org.example.utils.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HospitalTest {
    @Test
    public void testAdicionarPaciente() {
        Hospital hospital = new Hospital("Hospital Teste");
        Data dataNascimento = new Data(5, 3, 1985);
        Data dataInternamento = new Data(10, 4, 2024);
        Paciente paciente = new Paciente(3, "Carlos Dias", "M", dataNascimento, dataInternamento);
        boolean adicionado = hospital.adicionarPaciente(paciente);
        Assertions.assertTrue(adicionado);
        Assertions.assertTrue(Hospital.getLstPacientes().contains(paciente));
    }
}
