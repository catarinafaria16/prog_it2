# Manual de Utilização da Aplicação

Este manual explica, de forma simples, como funciona a aplicação de gestão hospitalar baseada na estrutura e funcionalidades descritas no `CHANGELOG.md`.

## 1. Objetivo da Aplicação
A aplicação permite gerir um hospital, incluindo o registo de pacientes e profissionais de saúde, a introdução e consulta de medições clínicas (frequência cardíaca, saturação de oxigénio, temperatura), bem como a análise estatística e visualização dos dados.

## 2. Estrutura Principal

### Interface do Utilizador
- **Main.java**: Ponto de entrada da aplicação. Inicializa o hospital e arranca o menu principal.
- **MenuUI.java**: Apresenta o menu interativo ao utilizador, permitindo escolher operações como registar pacientes/profissionais, listar dados, introduzir medições, etc.
- **RegistarPaciente.java**: Permite registar novos pacientes e introduzir medições para cada um.
- **RegistarProfissional.java**: Permite registar novos profissionais de saúde.
- **Ficheiro.java**: Permite importar/exportar dados de pacientes e medições através de ficheiros.

### Modelo de Dados
- **Hospital.java**: Gere as listas de pacientes e profissionais, e centraliza o registo/manipulação de medições.
- **Paciente.java**: Representa um paciente, com dados pessoais e histórico de medições.
- **ProfissionalSaude.java**: Representa um profissional de saúde, com especialidade e histórico de medições realizadas.
- **Pessoa.java**: Classe base para pessoas (paciente ou profissional), com atributos comuns.
- **ManipulacaoDados.java**: Fornece métodos utilitários para ordenar, calcular estatísticas e gravar dados.
- **Medida.java**: Representa uma medição clínica (associada a paciente e profissional).
- **FrequenciaCardiaca.java, Saturacao.java, Temperatura.java**: Representam medições específicas, cada uma com validação dos seus valores.
- **MedidasSumario.java**: Calcula estatísticas (mínimos, máximos, médias, desvios padrão) dos sinais vitais dos pacientes.
- **GraficoMedicoes.java**: Imprime gráficos simplificados (barras) dos últimos valores de sinais vitais dos pacientes.

### Interfaces e Utilitários
- **IHospital.java, IMedida.java, IPessoa.java**: Interfaces que padronizam as operações básicas de hospital, medição e pessoa.
- **MedidaInvalidaException.java**: Exceção personalizada para sinalizar erros em medições inválidas.
- **Data.java**: Classe para manipulação e comparação de datas.
- **Utils.java**: Métodos utilitários para leitura e validação de dados inseridos via consola.

## 3. Funcionalidades Principais
- Registo de pacientes e profissionais de saúde.
- Introdução de medições clínicas para cada paciente.
- Consulta e listagem de pacientes, profissionais e medições.
- Cálculo de estatísticas clínicas (mínimos, máximos, médias, desvios padrão).
- Visualização gráfica (barras) dos sinais vitais mais recentes.
- Importação/exportação de dados via ficheiros.

## 4. Como Utilizar
1. **Arranque a aplicação** executando a classe `Main.java`.
2. **Utilize o menu** para navegar pelas opções disponíveis:
   - Registar paciente/profissional
   - Introduzir medições
   - Listar dados
   - Consultar estatísticas
   - Exportar/importar dados
   - Visualizar gráficos
3. **Siga as instruções** apresentadas na consola para inserir os dados pedidos.
4. **Confirme as operações** sempre que solicitado.

## 5. Notas
- Todos os dados são validados antes de serem registados.
- Em caso de erro nas medições, é lançada uma exceção específica (`MedidaInvalidaException`).
- As operações de leitura/escrita em ficheiro permitem guardar e recuperar o estado do hospital.

## 6. Notas sobre Testes e Manutenção

- O projeto utiliza **JUnit 5 (Jupiter)** para todos os testes unitários.
- Todos os testes estão localizados em `src/test/java/org/example/model/`.
- O ficheiro `pom.xml` foi limpo e atualizado para garantir compatibilidade total com Maven e JUnit 5.
- Se adicionares novos testes, garante que lançam as exceções corretas (`MedidaInvalidaException` para medições inválidas).
- Para correr os testes, basta executar:

```sh
mvn clean test
```

- Se algum teste falhar, verifica se o comportamento do código e dos testes está alinhado (exceções, mensagens, etc).

## 7. Detalhes e Explicações das Alterações Recentes

### Correção de Exceções e Testes
- O construtor de `FrequenciaCardiaca` lança agora sempre `MedidaInvalidaException` para valores inválidos, garantindo uniformidade no tratamento de erros clínicos.
- Os testes unitários foram ajustados para esperar as exceções corretas, validando o comportamento esperado do sistema.

### Limpeza e Organização do Projeto
- O ficheiro `pom.xml` foi limpo de dependências antigas e duplicadas, ficando apenas com JUnit Jupiter (JUnit 5) e o plugin surefire atualizado.
- Todos os testes unitários estão organizados em `src/test/java/org/example/model/`, seguindo as melhores práticas de projetos Maven/Java.

### Recomendações para Desenvolvimento Futuro
- Sempre que adicionares novas funcionalidades, cria testes unitários na estrutura correta e garante que lançam exceções do domínio quando apropriado.
- Mantém o `pom.xml` atualizado e sem dependências desnecessárias para evitar conflitos e facilitar a manutenção.

---

Este manual serve como guia rápido para qualquer utilizador compreender e operar a aplicação hospitalar.
