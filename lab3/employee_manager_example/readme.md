# a) Identify a couple of examples that use AssertJ expressive methods chaining.

file A_EmployeeRepositoryTest.java

assertThat(found).isEqualTo(alex);
assertThat(allEmployees).hasSize(3).extracting(Employee::getName).containsOnly(alex.getName(), ron.getName(), bob.getName());

# b) Identify an example in which you mock the behavior of the repository (and avoid involving a database).

file B_EmployeeService_UnitTest.java

@Mock( lenient = true)
private EmployeeRepository employeeRepository;

# c) What is the difference between standard @Mock and @MockBean?

@Mock e usado quando queremos fazer mock de uma class o @mockBean e quando queremos fazer mock de um dos beans do spring boot

# d) What is the role of the file “application-integrationtest.properties”? In which conditions will it be used?

o ficheiro e usado quando se faz um integration test

# e)the sample project demonstrates three test strategies to assess an API (C, D and E) developed with SpringBoot. Which are the main/key differences?

o metodo C foca nos componentes mvc do springBoot
D faz um mock do webenvironment
E faz faz os testes num ambiente http real
