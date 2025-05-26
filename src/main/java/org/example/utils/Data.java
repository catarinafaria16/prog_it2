package org.example.utils;

/**
 * Classe que representa uma data com dia, mês e ano.
 * Inclui métodos para manipulação e comparação de datas.
 */
public class Data {

    private int ano;
    private int mes;
    private int dia;
    public Data data;

    private static final int ANO_POR_OMISSAO = 1;
    private static final int MES_POR_OMISSAO = 1;
    private static final int DIA_POR_OMISSAO = 1;

    private static String[] nomeDiaDaSemana = {"Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado"};
    private static int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static String[] nomeMes = {"Inválido", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

    /**
     * Cria uma instância de {@link Data} a partir de uma string no formato "dd-MM-aaaa".
     *
     * @param dataString String representando a data no formato "dd-MM-aaaa".
     * @return Uma nova instância de {@link Data}.
     */
    public static Data fromString(String dataString) {
        String[] partes = dataString.split("-");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int ano = Integer.parseInt(partes[2]);
        return new Data(dia, mes, ano);
    }

    /**
     * Construtor para criar uma data com valores específicos.
     *
     * @param dia Dia da data.
     * @param mes Mês da data.
     * @param ano Ano da data.
     */
    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    /**
     * Construtor para criar uma instância copiando outra data.
     *
     * @param data Instância de {@link Data} a ser copiada.
     */
    public Data(Data data) {
        this.ano = data.ano;
        this.mes = data.mes;
        this.dia = data.dia;
    }

    /**
     * Construtor que cria uma data com valores padrão.
     */
    public Data() {
        this.ano = ANO_POR_OMISSAO;
        this.mes = MES_POR_OMISSAO;
        this.dia = DIA_POR_OMISSAO;
    }

    /**
     * Retorna o ano da data.
     *
     * @return Ano da data.
     */
    public int getAno() {
        return ano;
    }

    /**
     * Retorna o mês da data.
     *
     * @return Mês da data.
     */
    public int getMes() {
        return mes;
    }

    /**
     * Retorna o dia da data.
     *
     * @return Dia da data.
     */
    public int getDia() {
        return dia;
    }

    /**
     * Define valores para o dia, mês e ano da data.
     *
     * @param ano Ano da data.
     * @param mes Mês da data.
     * @param dia Dia da data.
     */
    public void setData(int ano, int mes, int dia) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
    }

    /**
     * Retorna uma representação textual da data no formato "Dia da semana, dia de mês de ano".
     *
     * @return Representação textual da data.
     */
    @Override
    public String toString() {
        return this.determinarDiaDaSemana() + ", " + this.dia + " de " + nomeMes[mes] + " de " + ano;
    }

    /**
     * Retorna a data no formato "aaaa/MM/dd".
     *
     * @return Representação da data no formato "aaaa/MM/dd".
     */
    public String toAnoMesDiaString() {
        return String.format("%04d/%02d/%02d", ano, mes, dia);
    }

    /**
     * Determina o dia da semana correspondente à data.
     *
     * @return Nome do dia da semana.
     */
    public String determinarDiaDaSemana() {
        int totalDias = contarDias();
        totalDias = totalDias % 7;
        return nomeDiaDaSemana[totalDias];
    }

    /**
     * Verifica se a instância atual é posterior a outra data.
     *
     * @param outraData Outra instância de {@link Data}.
     * @return {@code true} se a instância atual for posterior; caso contrário, {@code false}.
     */
    public boolean isMaior(Data outraData) {
        int totalDias = contarDias();
        int totalDias1 = outraData.contarDias();
        return totalDias > totalDias1;
    }

    /**
     * Verifica se um ano é bissexto.
     *
     * @param ano Ano a ser verificado.
     * @return {@code true} se o ano for bissexto; caso contrário, {@code false}.
     */
    public static boolean isAnoBissexto(int ano) {
        return ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0;
    }

    /**
     * Conta o número total de dias desde o início do calendário até a data atual.
     *
     * @return O número total de dias.
     */
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

    /**
     * Compara esta data com outra data.
     *
     * @param outraData A data a ser comparada.
     * @return Um valor negativo se esta data for menor, 0 se forem iguais, ou um valor positivo se esta data for maior.
     */
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