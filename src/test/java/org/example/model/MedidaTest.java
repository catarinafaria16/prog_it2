package org.example.model;

import org.example.utils.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.example.exception.MedidaInvalidaException;

public class MedidaTest {
    @Test
    public void testCriarMedidaValida() throws MedidaInvalidaException {
        Data data = new Data(1, 1, 2025);
        Paciente paciente = new Paciente(1, "Teste Paciente", "M", data, data);
        ProfissionalSaude profissional = new ProfissionalSaude(2, "Teste Prof", "F", data, "Clínica Geral");
        Medida medida = new Medida(data, paciente, profissional);
        Assertions.assertEquals(data, medida.getDataRegisto());
        Assertions.assertEquals(paciente, medida.getPaciente());
        Assertions.assertEquals(profissional, medida.getProfissionalSaude());
    }
}
