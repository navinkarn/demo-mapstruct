# demo-mapstruct
Features included in this demo:
1. Basic mapping concept
2. Mapping when the field name on destination is different that source
3. Mapping when the data type on destination is different that source
4. Mapping when an object has a child entity in it
5. Mapping when an object has a list of child entities
6. Mapping Enums
7. UnmappedPolicy 
8. BeforeMapping & AfterMapping
9. Mapper inside another mapper (Dependency Injection)
10. Use of Java expression
11. Exception handling while mapping
12. Use of imports
13. InheritInverse
14. Mapper using interfae
15. Mapper with interface
16. Mapper with abstract class

Steps:
1. Compile the project (mvn clean install -DskipTests -f pom.xml)
2. After we compile, the implementation classes get generated (check target/generated-sources folder)
3. Goto DemoApplication.java and run this class and see the log.
