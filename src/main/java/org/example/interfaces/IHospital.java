package org.example.interfaces;

import org.example.model.Paciente;
import org.example.model.ProfissionalSaude;
import java.util.List;

public interface IHospital {
    boolean adicionarPaciente(Paciente paciente);
    String toString();
}