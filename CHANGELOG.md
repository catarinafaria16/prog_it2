# CHANGELOG.md

Este ficheiro descreve, de forma resumida e percetível, o propósito de cada página (classe) principal do projeto, para facilitar a compreensão do sistema.

## src/main/java/org/example/ui/

- **Main.java**
  - Classe principal do sistema. Inicializa o hospital, prepara o registo de pacientes e arranca o menu principal da aplicação.

- **MenuUI.java**
  - Responsável por apresentar o menu interativo ao utilizador, capturar as opções escolhidas e executar as ações correspondentes (registo, listagem, etc).

- **RegistarPaciente.java**
  - Gere o registo de novos pacientes, pedindo dados ao utilizador e adicionando-os ao hospital. Permite também introduzir medições para cada paciente.

- **RegistarProfissional.java**
  - Gere o registo de novos profissionais de saúde, pedindo dados ao utilizador e adicionando-os à lista do hospital.

- **Ficheiro.java**
  - Responsável por ler e gravar dados de pacientes e medições em ficheiros, permitindo importar/exportar informação.

## src/main/java/org/example/model/

- **Hospital.java**
  - Representa o hospital, gerindo listas de pacientes e profissionais, e permitindo o registo e manipulação de medições.

- **Paciente.java**
  - Representa um paciente, com dados pessoais e histórico de medições. Permite obter informações clínicas e estatísticas.

- **ProfissionalSaude.java**
  - Representa um profissional de saúde, com especialidade e histórico de medições realizadas.

- **Pessoa.java**
  - Classe abstrata base para pessoas (paciente ou profissional), com atributos comuns como id, nome, sexo e data de nascimento.

- **ManipulacaoDados.java**
  - Classe utilitária para manipulação de dados de pacientes e medições: ordenação, estatísticas, gravação em ficheiros, etc.

- **Medida.java**
  - Representa uma medição clínica associada a um paciente e profissional, padronizando operações sobre medições.

- **FrequenciaCardiaca.java**
  - Representa uma medição de frequência cardíaca, com validação dos valores.

- **Saturacao.java**
  - Representa uma medição de saturação de oxigénio, com validação dos valores.

- **Temperatura.java**
  - Representa uma medição de temperatura corporal, com validação dos valores.

- **MedidasSumario.java**
  - Calcula estatísticas (mínimos, máximos, médias, desvios padrão) dos sinais vitais dos pacientes.

- **GraficoMedicoes.java**
  - Imprime gráficos simplificados (barras) dos últimos valores de sinais vitais dos pacientes.

## src/main/java/org/example/interfaces/

- **IHospital.java**
  - Interface que define operações básicas para um hospital (adicionar paciente, etc).

- **IMedida.java**
  - Interface que define operações básicas para uma medição clínica.

- **IPessoa.java**
  - Interface que define operações básicas para uma pessoa (id, nome, sexo, data nascimento).

## src/main/java/org/example/exception/

- **MedidaInvalidaException.java**
  - Exceção personalizada para sinalizar erros em medições inválidas.

## src/main/java/org/example/utils/

- **Data.java**
  - Classe para manipulação e comparação de datas (dia, mês, ano).

- **Utils.java**
  - Classe utilitária para leitura e validação de dados inseridos via consola.

## src/test/java/org/example/model/

- **PacienteTest.java**
  - Testa a criação e métodos principais da classe Paciente.
- **ProfissionalSaudeTest.java**
  - Testa a criação e métodos da classe ProfissionalSaude.
- **HospitalTest.java**
  - Testa o registo e listagem de pacientes no hospital.
- **FrequenciaCardiacaTest.java**
  - Testa a criação e validação de medições de frequência cardíaca.
- **SaturacaoTest.java**
  - Testa a criação e validação de medições de saturação de oxigénio.
- **TemperaturaTest.java**
  - Testa a criação e validação de medições de temperatura corporal.
- **MedidaTest.java**
  - Testa funcionalidades da classe Medida.
- **ManipulacaoDadosTest.java**
  - Testa métodos utilitários de manipulação de dados e estatísticas.
- **MedidasSumarioTest.java**
  - Testa o cálculo de estatísticas dos sinais vitais.
- **GraficoMedicoesTest.java**
  - Testa a geração de gráficos simplificados dos sinais vitais.
- **PessoaTest.java**
  - Testa métodos da classe abstrata Pessoa.

---

Este changelog serve como guia rápido para perceber a função de cada ficheiro principal do projeto.
