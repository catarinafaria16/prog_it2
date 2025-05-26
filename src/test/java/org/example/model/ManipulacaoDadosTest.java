package org.example.model;

import org.example.exception.MedidaInvalidaException;
import org.example.utils.Data;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManipulacaoDadosTest {

    private Paciente paciente;

    @BeforeEach
    public void setup() throws MedidaInvalidaException {
        Data dataNasc = new Data(2000, 1, 1);
        Data dataIntern = new Data(2025, 5, 25);

        paciente = new Paciente(123, "João", "M", dataNasc, dataIntern);
        ProfissionalSaude profissional = new ProfissionalSaude(1, "Dra. Ana", "F", new Data(1980, 1, 1), "MED001");

        Hospital hospital = new Hospital("Hospital Teste");
        hospital.adicionarPaciente(paciente);
        hospital.adicionarProfissionalSaude(profissional);

        Hospital.adicionarFrequenciaCardiaca(new Data(2025, 5, 25), 80.0, paciente, profissional);
        Hospital.adicionarTemperatura(new Data(2025, 5, 25), 37.0, paciente, profissional);
        Hospital.adicionarSaturacao(new Data(2025, 5, 25), 95.0, paciente, profissional);
    }

    @Test
    public void testAlterarSinaisVitaisAumento10Porcento() throws MedidaInvalidaException {
        ManipulacaoDados.alterarSinaisVitais(10.0);

        FrequenciaCardiaca fc = Paciente.getUltimaFrequenciaCardiaca();
        Temperatura temp = Paciente.getUltimaTemperatura();
        Saturacao sat = Paciente.getUltimaSaturacaoOxigenio();

        assertEquals(88.0, fc.getFrequencia(), 0.01);
        assertEquals(40.7, temp.getTemperatura(), 0.01);
        assertEquals(104.5, sat.getSaturacao(), 0.01);
    }

    @Test
    public void testAlterarSinaisVitaisReducao20Porcento() throws MedidaInvalidaException {
        ManipulacaoDados.alterarSinaisVitais(-20.0);

        FrequenciaCardiaca fc = Paciente.getUltimaFrequenciaCardiaca();
        Temperatura temp = Paciente.getUltimaTemperatura();
        Saturacao sat = Paciente.getUltimaSaturacaoOxigenio();

        assertEquals(64.0, fc.getFrequencia(), 0.01);
        assertEquals(29.6, temp.getTemperatura(), 0.01);
        assertEquals(76.0, sat.getSaturacao(), 0.01);
    }
}