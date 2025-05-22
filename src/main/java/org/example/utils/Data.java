package org.example.utils;

public class Data {

    private int ano;
    private int mes;
    private int dia;

    private static final int ANO_POR_OMISSAO = 1;
    private static final int MES_POR_OMISSAO = 1;
    private static final int DIA_POR_OMISSAO = 1;

    private static String[] nomeDiaDaSemana = {"Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado"};
    private static int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static String[] nomeMes = {"Inválido", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

    public Data(int ano, int mes, int dia) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
    }

    public Data(Data data) {
        this.ano = data.ano;
        this.mes = data.mes;
        this.dia = data.dia;
    }

    public Data() {
        this.ano = ANO_POR_OMISSAO;
        this.mes = MES_POR_OMISSAO;
        this.dia = DIA_POR_OMISSAO;
    }

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }

    public void setData(int ano, int mes, int dia) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
    }

    public String toString() {
        return this.determinarDiaDaSemana() + ", " + this.dia + " de " + nomeMes[mes] + " de " + ano;
    }

    public String toAnoMesDiaString() {
        return String.format("%04d/%02d/%02d", ano, mes, dia);
    }

    public String determinarDiaDaSemana() {
        int totalDias = contarDias();
        totalDias = totalDias % 7;
        return nomeDiaDaSemana[totalDias];
    }

    public boolean isMaior(Data outraData) {
        int totalDias = contarDias();
        int totalDias1 = outraData.contarDias();
        return totalDias > totalDias1;
    }

    public int calcularDiferenca(Data outraData) {
        int totalDias = this.contarDias();
        int totalDias1 = outraData.contarDias();
        return Math.abs(totalDias - totalDias1);
    }

    public int calcularDiferenca(int ano, int mes, int dia) {
        int totalDias = contarDias();
        Data outraData = new Data(ano, mes, dia);
        int totalDias1 = outraData.contarDias();
        return Math.abs(totalDias - totalDias1);
    }

    public static boolean isAnoBissexto(int ano) {
        return ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0;
    }

    private int contarDias() {
        int totalDias = 0;

        for (int i = 1; i < ano; i++) {
            totalDias += isAnoBissexto(i) ? 366 : 365;
        }
        for (int i = 1; i < mes; i++) {
            totalDias += diasPorMes[i];
        }
        totalDias += (isAnoBissexto(ano) && mes > 2) ? 1 : 0;
        totalDias += dia;

        return totalDias;
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        final Data other = (Data) outroObjeto;
        return this.ano == other.ano && this.mes == other.mes && this.dia == other.dia;
    }

    public int compareTo(Data outraData) {
        if (this.isMaior(outraData)) {
            return 1;
        } else if (this.equals(outraData)) {
            return 0;
        } else {
            return -1;
        }
    }
}