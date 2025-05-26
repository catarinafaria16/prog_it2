package org.example.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
/**
 * Classe utilitária para leitura e validação de dados inseridos via consola.
 */
public class Utils {
    /**
     * Lê uma linha de texto da consola.
     *
     * @param strPrompt Texto a exibir ao utilizador.
     * @return String inserida pelo utilizador.
     */
    static public String readLineFromConsole(String strPrompt) {
        try {
            System.out.println(strPrompt);
            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);
            return in.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Lê um número inteiro da consola, com validação.
     *
     * @param strPrompt Texto a exibir ao utilizador.
     * @return Valor inteiro introduzido.
     */
    public static int readIntFromConsole(String strPrompt) {
        do {
            try {
                String strInt = readLineFromConsole(strPrompt);
                int iInt = Integer.parseInt(strInt);
                return iInt;
            } catch (NumberFormatException ex) {
                //Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }
    /**
     * Lê um número decimal da consola, com validação.
     *
     * @param strPrompt Texto a exibir ao utilizador.
     * @return Valor decimal introduzido.
     */
    public static double readDoubleFromConsole(String strPrompt) {
        do {
            try {
                String strDouble = readLineFromConsole(strPrompt);
                double iDouble = Double.parseDouble(strDouble);
                return iDouble;
            } catch (NumberFormatException ex) {
                //Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }
    /**
     * Lê uma data da consola no formato dd-MM-yyyy, com validação.
     *
     * @param strPrompt Texto a exibir ao utilizador.
     * @return Objeto {@link Data} com a data introduzida.
     */
    public static Data readDateFromConsole(String strPrompt) {
        do {
            try {
                String strData = readLineFromConsole(strPrompt);
                String[] arr = strData.split("-");
                int dia = Integer.parseInt(arr[0]);
                int mes = Integer.parseInt(arr[1]);
                int ano = Integer.parseInt(arr[2]);

                // Valida se a data é válida no calendário
                java.time.LocalDate.of(ano, mes, dia); 
                return new Data(dia, mes, ano);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
                System.out.println("Formato inválido. Use o formato dd-MM-yyyy.");
            } catch (java.time.DateTimeException e) {
                System.out.println("Data inválida: a data introduzida não existe no calendário.");            }
        } while (true);
    }
    /**
     * Pede confirmação ao utilizador com uma pergunta de sim/não.
     *
     * @param sMessage Mensagem a mostrar.
     * @return true se o utilizador confirmar com 's' (sim), false se 'n' (não).
     */
    static public boolean confirma(String sMessage) {
        String strConfirma;
        do {
            strConfirma = Utils.readLineFromConsole(sMessage);
        } while (!strConfirma.equalsIgnoreCase("s") && !strConfirma.equalsIgnoreCase("n"));

        return strConfirma.equalsIgnoreCase("s");
    }

    /**
     * Lê e valida o sexo do utilizador (M ou F).
     *
     * @param strPrompt Texto a exibir ao utilizador.
     * @return "M" ou "F".
     */
    public static String readSexoFromConsole(String strPrompt) {
        String sexo;
        do {
            sexo = readLineFromConsole(strPrompt);
            if (!sexo.equalsIgnoreCase("M") && !sexo.equalsIgnoreCase("F")) {
                System.out.println("Sexo inválido. Por favor, digite M para masculino ou F para feminino.");
            }
        } while (!sexo.equalsIgnoreCase("M") && !sexo.equalsIgnoreCase("F"));
        return sexo;
    }
    /**
     * Lê e valida o nome de um paciente.
     *
     * @param strtPrompt Texto a exibir ao utilizador.
     * @return Nome válido (apenas letras e espaços).
     */
    public static String readNomePaFromConsole(String strtPrompt) { 
        String nome;
        do {
            nome = Utils.readLineFromConsole("Introduza o nome do paciente: ");
            if (!nome.matches("[a-zA-ZÀ-ÿ\\s]+")) {
                System.out.println("Nome inválido. Use apenas letras e espaços.");
            }
        } while (!nome.matches("[a-zA-ZÀ-ÿ\\s]+"));
        return nome;
    }
    public static String readNomeProFromConsole(String strtPrompt) { 
        String nome;
        do {
            nome = Utils.readLineFromConsole("Introduza o nome do profissional: ");
            if (!nome.matches("[a-zA-ZÀ-ÿ\\s]+")) {
                System.out.println("Nome inválido. Use apenas letras e espaços.");
            }
        } while (!nome.matches("[a-zA-ZÀ-ÿ\\s]+"));
        return nome;
    }
    /**
     * Lê e valida a especialidade de um profissional.
     *
     * @param strtPrompt Texto a exibir ao utilizador.
     * @return Especialidade válida (apenas letras e espaços).
     */
    public static String readNomeEspFromConsole(String strtPrompt) { 
        String nome;
        do {
            nome = Utils.readLineFromConsole("Introduza o especialidade do profissional: ");
            if (!nome.matches("[a-zA-ZÀ-ÿ\\s]+")) {
                System.out.println("Especialidade inválida. Use apenas letras e espaços.");
            }
        } while (!nome.matches("[a-zA-ZÀ-ÿ\\s]+"));
        return nome;
    }
}