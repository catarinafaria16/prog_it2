package org.example.model;

import org.example.exception.MedidaInvalidaException;
import org.example.utils.Data;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PercentagemCriticosTest {

    private ProfissionalSaude profissional;

    @BeforeEach
    public void setup() throws MedidaInvalidaException {
        profissional = new ProfissionalSaude(1, "Dra. Ana", "F", new Data(1980, 1, 1), "MED001");
        Hospital.getLstProfissionais().clear();
        Hospital.getLstPacientes().clear();
        Hospital.getLstProfissionais().add(profissional);

        // Paciente 1 - Crítico (frequência cardíaca crítica)
        Paciente p1 = new Paciente(1, "João", "M", new Data(2000, 1, 1), new Data(2025, 5, 25));
        Hospital.adicionarFrequenciaCardiaca(new Data(2025, 5, 25), 190.0, p1, profissional);
        Hospital.adicionarTemperatura(new Data(2025, 5, 25), 36.5, p1, profissional);
        Hospital.adicionarSaturacao(new Data(2025, 5, 25), 96.0, p1, profissional);
        new Hospital("Hospital Teste").adicionarPaciente(p1);

        // Paciente 2 - Não crítico
        Paciente p2 = new Paciente(2, "Maria", "F", new Data(1995, 3, 10), new Data(2025, 5, 25));
        Hospital.adicionarFrequenciaCardiaca(new Data(2025, 5, 25), 80.0, p2, profissional);
        Hospital.adicionarTemperatura(new Data(2025, 5, 25), 36.5, p2, profissional);
        Hospital.adicionarSaturacao(new Data(2025, 5, 25), 96.0, p2, profissional);
        new Hospital("Hospital Teste").adicionarPaciente(p2);
    }

    @Test
    public void testCalcularPercentagemCriticos() {
        double percentagem = ManipulacaoDados.calcularPercentagemPacientesCriticos();
        assertEquals(50.0, percentagem, 0.1);
    }
}