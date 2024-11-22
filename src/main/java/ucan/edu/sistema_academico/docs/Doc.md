Modelagem de um sistema acadêmico, que inclui o gerenciamento de matrículas,
disciplinas, avaliações e requisitos de
precedência.

### Documentação Simplificada do Sistema

#### Entidades

##### Curso

Representa um curso oferecido pela instituição.

- **pkCurso**: Identificador único do curso.
- **nome**: Nome do curso.
- **planoCursos**: Lista de planos de curso associados ao curso.

##### Disciplina

Representa uma disciplina que faz parte de um curso.

- **pkDisciplina**: Identificador único da disciplina.
- **nome**: Nome da disciplina.

##### Estudante

Representa um estudante matriculado na instituição.

- **pkEstudante**: Identificador único do estudante.
- **numeroEstudante**: Número de matrícula do estudante.
- **pessoa**: Referência à entidade `Pessoa` associada ao estudante.

##### LOCALIDADE

Representa um estudante matriculado na instituição.

- **pkLocalidade**:
- **designacao**:
- **fkLocalidade**:

##### Pessoa

Representa uma pessoa, que pode ser um estudante, professor, etc.

- **pkPessoa**: Identificador único da pessoa.
- **nome**: Nome da pessoa.
- **numeroBi**: Número do documento de identidade.
- **dataNascimento**: Data de nascimento da pessoa.

##### PlanoCurso

Representa o plano de curso, que inclui as disciplinas e o semestre em que são oferecidas.

- **pkPlanoCurso**: Identificador único do plano de curso.
- **semestre**: Semestre em que a disciplina é oferecida.
- **disciplina**: Referência à entidade `Disciplina`.
- **curso**: Referência à entidade `Curso`.

##### Precedencia

Representa a precedência entre disciplinas, indicando quais disciplinas são pré-requisitos para outras.

- **pkPrecedencia**: Identificador único da precedência.
- **fkDisciplina**: Referência à disciplina que possui um pré-requisito.
- **fkDisciplinaPrecedente**: Referência à disciplina que é o pré-requisito.

#### CONSULTAS

- Listar disciplinas por curso (pkCurso)
- Listar Plano de Curso agrupado por semeste(Id curso)
- Listar cursos que possuem precedencia
- Listar a precedencia de uma determinada disciplina