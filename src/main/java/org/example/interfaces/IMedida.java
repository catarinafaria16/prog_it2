package org.example.interfaces;

import org.example.utils.Data;
import org.example.model.Paciente;
import org.example.model.ProfissionalSaude;

public interface IMedida {
    Data getDataRegisto();
    Paciente getPaciente();
    ProfissionalSaude getProfissionalSaude();
    String toString();
}
