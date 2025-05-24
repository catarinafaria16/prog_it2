package org.example.utils;

public class ScoreGravidade {

    public static double calcularScore(double fc, double temp, double spo2) {
        double fcScore = pontuarFrequencia(fc);
        double tempScore = pontuarTemperatura(temp);
        double spo2Score = pontuarSaturacao(spo2);

        return (fcScore * 0.3) + (tempScore * 0.4) + (spo2Score * 0.3);
    }

    public static String interpretarScore(double score) {
        if (score <= 2.0) return "Gravidade Baixa";
        else if (score <= 3.5) return "Gravidade Moderada";
        else return "Gravidade Alta";
    }

    private static int pontuarFrequencia(double fc) {
        if (fc < 40 || fc > 140) return 5;
        else if (fc < 50 || fc > 120) return 4;
        else if (fc < 60 || fc > 100) return 3;
        else if (fc < 70 || fc > 90) return 2;
        else return 1;
    }

    private static int pontuarTemperatura(double temp) {
        if (temp < 34 || temp > 41) return 5;
        else if (temp < 35 || temp > 39) return 4;
        else if (temp < 36 || temp > 38) return 3;
        else if (temp < 36.5 || temp > 37.5) return 2;
        else return 1;
    }

    private static int pontuarSaturacao(double spo2) {
        if (spo2 < 70) return 5;
        else if (spo2 < 80) return 4;
        else if (spo2 < 90) return 3;
        else if (spo2 < 94) return 2;
        else return 1;
    }
}