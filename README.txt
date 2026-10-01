Assignment 4 - More Features of OOP

Student:
Roll No.: 2623
Name: Ketan Naik
Programme: MCA
Discipline: Computer Science & Technology (DCST), Goa Business School, Goa University

HOW TO COMPILE AND RUN
1. Open a terminal in this project folder.
2. Run:
   javac code/Main.java
   java -cp code Main

REQUIREMENT MAPPING
1. Object Referencing & Constructors
   - Student s2 = s1 demonstrates two references pointing to the same object.
   - Constructors initialize object attributes.

2. Static Attributes, Methods & Enums
   - Staff.count is a static counter.
   - Staff.displayCount() displays the counter.
   - StaffType is an enum.

3. Multiple Inheritance
   - Java does not support multiple inheritance of classes.
   - DCSTCoordinator implements multiple interfaces.
   - AcademicUnit extends two interfaces, demonstrating multiple interface inheritance.

4. Access Modifiers
   - AccessDemo contains public, private and protected fields.
   - Access is demonstrated inside the class, through a subclass, and outside.

5. Abstract Classes & Interfaces
   - Report is abstract.
   - AcademicReport and NonAcademicReport override generate() differently.
   - Printable is an interface.

6. Class as a Type & Message Passing
   - sendMessage(Printable item) accepts any Printable object and calls print().

7. Polymorphism
   - Overriding: generate() in report subclasses.
   - Overloading: NIRFCalculator.total(int,int) and total(double,double).

8. Generics & Collections
   - Generic Box<T> and generic GenericUtils.max().
   - List, Queue, Set and Map are demonstrated.

9. Exception Handling
   - try/catch/finally.
   - ArithmeticException.
   - Custom InvalidStudentException with throw.

10. Reflection, Persistence, I/O & Cloning
   - Reflection/RTTI using Class<?>.
   - Serializable plus file writing demonstrates persistence.
   - Console and file I/O.
   - Shallow and deep cloning.

INSTITUTIONAL DATA NOTE
The program includes DCST/GBS programme and activity information for the assignment demonstration.
The lists are intentionally described as an assignment dataset, not as an exhaustive historical
NIRF record for every activity conducted during the past three years.

OFFICIAL REFERENCES
1. Goa University - Department of Computer Science & Technology
   https://unigoa.ac.in/goa-university-dept-display.php?adepid=10
2. Goa University - Goa Business School
   https://unigoa.ac.in/dept/goa-business-school.html
3. Goa University - InfoFest 2025 material
   https://www.unigoa.ac.in/uploads/confg_docs/20250117.105021~InforFest_GBS_25.pdf
4. Goa University - Directorate of Students Welfare and Cultural Affairs
   https://unigoa.ac.in/c/directorate-of-students-welfare-and-cultural-affairs-dsw.html

SUBMISSION
- code/ -> Java source code
- output/ -> screenshots and captured output
- githubA4.txt -> GitHub repository link
- README.txt -> instructions and requirement mapping
- sources.txt -> official references


