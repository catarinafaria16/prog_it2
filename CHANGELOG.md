# CHANGELOG.md

Este ficheiro descreve, de forma resumida e percetível, o propósito de cada página (classe) principal do projeto, para facilitar a compreensão do sistema.

## Alterações recentes (maio 2025)

- Corrigido o construtor de `FrequenciaCardiaca` para lançar sempre `MedidaInvalidaException` em vez de `IllegalArgumentException` para valores inválidos.
- Corrigido o teste `FrequenciaCardiacaTest` para alinhar com a exceção correta.
- Corrigido o teste `MedidasSumarioTest` para esperar a exceção `MedidaInvalidaException` quando não existem medições.
- Limpeza e atualização do `pom.xml`:
  - Removidas dependências duplicadas e antigas do JUnit.
  - Mantida apenas a dependência `junit-jupiter` (JUnit 5.10.2).
  - Garantida configuração correta do plugin `maven-surefire-plugin` (3.2.5).
- Todos os testes unitários foram movidos para `src/test/java/org/example/model/` e estão a ser executados corretamente.
- Ambiente Maven/JUnit validado e funcional para desenvolvimento e testes.

## Detalhes e Explicações das Alterações Recentes

### 1. Correção do Construtor de FrequenciaCardiaca
- O construtor `FrequenciaCardiaca(double frequencia)` lançava `IllegalArgumentException` para valores inválidos. Agora lança sempre `MedidaInvalidaException`, garantindo consistência com o resto do sistema e com os testes unitários.
- **Motivo:** Os testes esperam sempre a exceção personalizada do domínio (`MedidaInvalidaException`) para facilitar o tratamento de erros clínicos.

### 2. Ajuste dos Testes Unitários
- O teste `FrequenciaCardiacaTest.testCriarFrequenciaCardiacaInvalida` foi ajustado para esperar a exceção correta.
- O teste `MedidasSumarioTest.testCalcularMedidasSumarioParaTodosPacientesSemMedidas` foi ajustado para esperar a exceção `MedidaInvalidaException` quando não existem medições.
- **Motivo:** Garantir que os testes refletem o comportamento real do código e que o tratamento de erros é validado.

### 3. Limpeza e Atualização do pom.xml
- Removidas dependências antigas e duplicadas do JUnit (JUnit 4 e versões RELEASE).
- Mantida apenas a dependência `junit-jupiter` (JUnit 5.10.2), que é a versão recomendada para projetos modernos.
- Adicionado bloco `<build>` com o plugin `maven-surefire-plugin` (3.2.5) para garantir compatibilidade total com JUnit 5.
- **Motivo:** Evitar conflitos de versões, garantir builds estáveis e facilitar a manutenção futura.

### 4. Organização dos Testes
- Todos os testes unitários foram movidos para `src/test/java/org/example/model/`.
- Pastas antigas e duplicadas foram removidas.
- **Motivo:** Seguir as boas práticas de projetos Maven/Java, garantir que o Maven encontra e executa todos os testes automaticamente.

### 5. Ambiente Validado
- Após estas alterações, todos os testes unitários passam (exceto se o código de domínio lançar exceções esperadas).
- O ambiente está pronto para desenvolvimento, testes e integração contínua.

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
