Modelagem de um sistema acadêmico, que inclui o gerenciamento de matrículas, 
disciplinas, avaliações e requisitos de
precedência. 

### Entidades e seus Relacionamentos

#### **Estudante**

- **pkEstudante** (Primary Key)
- **nome** (Nome do estudante)

#### **Curso**

- **pkCurso** (Primary Key)
- **nome** (Nome do curso)

#### **Disciplina**

- **pkDisciplina** (Primary Key)
- **nome** (Nome da disciplina)

#### **Matricula**

- **pkMatricula** (Primary Key)
- **fkEstudante** (Foreign Key para **Estudante**)
- **fkCurso** (Foreign Key para **Curso**)
- **anoLectivo** (Ano em que o estudante foi matriculado)
- **semestre** (Semestre da matrícula)

#### **PlanoCurso**

- **pkPlanoCurso** (Primary Key)
- **fkCurso** (Foreign Key para