package org.example.model;

import org.example.exception.MedidaInvalidaException;
import org.example.utils.Data;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScoreGravidadeTest {

    private ProfissionalSaude profissional;
    private Paciente paciente;

    @BeforeEach
    public void setup() throws MedidaInvalidaException {
        profissional = new ProfissionalSaude(1, "Dra. Ana", "F", new Data(1980, 1, 1), "MED001");
        Hospital.getLstProfissionais().clear();
        Hospital.getLstPacientes().clear();
        Hospital.getLstProfissionais().add(profissional);

        paciente = new Paciente(1, "João", "M", new Data(2000, 1, 1), new Data(2025, 5, 25));
        new Hospital("Hospital Teste").adicionarPaciente(paciente);

        // Simular medições com valores que deverão dar um score moderado
        Hospital.adicionarFrequenciaCardiaca(new Data(2025, 5, 25), 110.0, paciente, profissional); // score 3
        Hospital.adicionarTemperatura(new Data(2025, 5, 25), 38.0, paciente, profissional);         // score 3
        Hospital.adicionarSaturacao(new Data(2025, 5, 25), 93.0, paciente, profissional);           // score 3
    }

    @Test
    public void testCalculoScoreGravidadeModerado() {
        double score = paciente.calcularScoreGravidadeUltimasMedicoes();

        assertTrue(score >= 2.1 && score <= 3.5, "Score deveria estar em gravidade moderada");
        System.out.println("Score calculado: " + score);
    }
}