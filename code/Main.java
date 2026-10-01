import java.io.*;
import java.lang.reflect.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("============================================================");
        System.out.println(" DCST, GOA BUSINESS SCHOOL - NIRF OOP INFORMATION SYSTEM");
        System.out.println(" Assignment 4: More Features of OOP");
        System.out.println("============================================================\n");

        demonstrateReferencingAndConstructors();
        demonstrateStaticAndEnums();
        demonstrateMultipleInheritance();
        demonstrateAccessModifiers();
        demonstrateAbstractAndInterface();
        demonstrateMessagePassing();
        demonstratePolymorphism();
        demonstrateGenericsAndCollections();
        demonstrateExceptionHandling();
        demonstrateReflectionPersistenceIOCloning();
        displayInstitutionalLists();

        System.out.println("\n==================== ASSIGNMENT COMPLETE ====================");
    }

    static void demonstrateReferencingAndConstructors() {
        section("1. OBJECT REFERENCING & CONSTRUCTORS");
        Student s1 = new Student(2623, "Ketan Naik", "MCA", 2026);
        Student s2 = s1; // two references point to the same object
        System.out.println("Before side effect: " + s1.getName());
        s2.setName("Ketan Naik (Updated through s2)");
        System.out.println("s1 sees the change: " + s1.getName());
        System.out.println("s1 == s2 ? " + (s1 == s2));
    }

    static void demonstrateStaticAndEnums() {
        section("2. STATIC ATTRIBUTES, METHODS & ENUMS");
        new Staff(1, "Dr. Asha", StaffType.TEACHING);
        new Staff(2, "Mr. Ravi", StaffType.NON_TEACHING);
        new Staff(3, "Ms. Priya", StaffType.TEACHING);
        Staff.displayCount();
        System.out.println("Staff type enum example: " + StaffType.TEACHING);
    }

    static void demonstrateMultipleInheritance() {
        section("3. MULTIPLE INHERITANCE USING INTERFACES");
        DCSTCoordinator coordinator = new DCSTCoordinator("NIRF Coordinator");
        coordinator.teach();
        coordinator.manage();
        coordinator.conductResearch();
        System.out.println("Java does not support multiple class inheritance, but a class can implement multiple interfaces.");
        System.out.println("Interface inheritance: AcademicUnit extends TeachingRole and ResearchRole.");
    }

    static void demonstrateAccessModifiers() {
        section("4. ACCESS MODIFIERS");
        AccessDemo inside = new AccessDemo();
        inside.showInsideAccess();
        System.out.println("Outside class -> public: " + inside.publicValue);
        System.out.println("Outside class -> protected: accessible here through inheritance only; see AccessChild.");
        AccessChild child = new AccessChild();
        child.showProtectedFromChild();
        System.out.println("privateValue is not directly accessible outside AccessDemo; getter returns: " + inside.getPrivateValue());
    }

    static void demonstrateAbstractAndInterface() {
        section("5. ABSTRACT CLASSES & INTERFACES");
        Report academic = new AcademicReport("Academic Report");
        Report nonAcademic = new NonAcademicReport("Non-Academic Report");
        academic.generate();
        nonAcademic.generate();
        System.out.println("Interface method: " + new PrintableReport().print());
    }

    static void demonstrateMessagePassing() {
        section("6. CLASS AS A TYPE & MESSAGE PASSING");
        sendMessage(new PrintableReport());
        sendMessage(new AcademicReport("MCA Activity Report"));
    }

    static void sendMessage(Printable item) {
        System.out.println("Message passing -> " + item.print());
    }

    static void demonstratePolymorphism() {
        section("7. POLYMORPHISM - OVERRIDING & OVERLOADING");
        Report report = new AcademicReport("Placement Report");
        report.generate(); // overriding: runtime polymorphism
        NIRFCalculator calc = new NIRFCalculator();
        System.out.println("Overloading (int): " + calc.total(10, 20));
        System.out.println("Overloading (double): " + calc.total(10.5, 20.5));
    }

    static void demonstrateGenericsAndCollections() {
        section("8. GENERICS & COLLECTION FRAMEWORK");
        Box<String> box = new Box<>("MCA");
        System.out.println("Generic class Box<String>: " + box.getValue());
        System.out.println("Generic method max: " + GenericUtils.max(10, 25));

        List<String> courses = new ArrayList<>(List.of("MCA", "Ph.D. Computer Science", "M.Sc. Data Science"));
        Queue<String> queue = new LinkedList<>(List.of("ISA", "Midpoint", "SEA"));
        Set<String> activities = new LinkedHashSet<>(List.of("InfoFest", "Plateaunica", "InfoFest", "Youthesia"));
        Map<Integer, String> students = new LinkedHashMap<>();
        students.put(2623, "Ketan Naik");
        students.put(2624, "Student A");
        System.out.println("List  : " + courses);
        System.out.println("Queue : " + queue);
        System.out.println("Set   : " + activities);
        System.out.println("Map   : " + students);
    }

    static void demonstrateExceptionHandling() {
        section("9. EXCEPTION HANDLING");
        try {
            validateStudentId(0);
        } catch (InvalidStudentException e) {
            System.out.println("Custom exception caught: " + e.getMessage());
        } finally {
            System.out.println("finally block executed.");
        }
        try {
            int value = 10 / 0;
            System.out.println(value);
        } catch (ArithmeticException e) {
            System.out.println("Runtime error handled: " + e.getMessage());
        }
    }

    static void validateStudentId(int id) throws InvalidStudentException {
        if (id <= 0) throw new InvalidStudentException("Student ID must be greater than zero.");
    }

    static void demonstrateReflectionPersistenceIOCloning() {
        section("10. REFLECTION, PERSISTENCE, I/O & CLONING");
        try {
            Student original = new Student(2623, "Ketan Naik", "MCA", 2026);
            original.getActivities().add("InfoFest");
            original.getActivities().add("Study Tour");

            // Shallow clone: same mutable List reference
            Student shallow = original.shallowClone();
            shallow.getActivities().add("Shallow-Added Activity");
            System.out.println("Shallow clone shares activities list: " + original.getActivities());

            // Deep clone: independent mutable List
            Student deep = original.deepClone();
            deep.getActivities().add("Deep-Added Activity");
            System.out.println("Deep clone has independent activities list: " + deep.getActivities());
            System.out.println("Original after deep clone: " + original.getActivities());

            // File I/O / persistence
            Path file = Paths.get("student_record.txt");
            Files.writeString(file, original.toRecord());
            System.out.println("File I/O: saved student record to " + file.toAbsolutePath());
            System.out.println("File I/O: read -> " + Files.readString(file));

            // Reflection / RTTI
            Class<?> clazz = original.getClass();
            System.out.println("Reflection class name: " + clazz.getName());
            System.out.println("Declared fields: " + Arrays.toString(clazz.getDeclaredFields()));
            System.out.println("Declared methods count: " + clazz.getDeclaredMethods().length);
        } catch (IOException | CloneNotSupportedException e) {
            System.out.println("I/O or cloning error: " + e.getMessage());
        }
    }

    static void displayInstitutionalLists() {
        section("DCST / GBS PROGRAMS, ACADEMIC & NON-ACADEMIC ACTIVITIES");
        System.out.println("Programs/Courses (DCST / GBS dataset for this assignment):");
        String[] programs = {
            "M.C.A. - Master of Computer Applications (DCST)",
            "Ph.D. Computer Science (DCST)",
            "M.Com. (Goa Business School)",
            "M.B.A. (Goa Business School)",
            "M.B.A. (Financial Services) (Goa Business School)",
            "M.B.A. (Executive) (Goa Business School)",
            "Integrated M.B.A. (Goa Business School)",
            "M.Sc. Data Science (Goa Business School)",
            "M.Sc. Artificial Intelligence (Goa Business School)"
        };
        for (String p : programs) System.out.println("  - " + p);

        System.out.println("\nAcademic activities:");
        String[] academic = {"ISA / Internal assessment", "Midpoint examinations", "SEA / Semester-end assessment", "Study tours / educational visits", "Placements and career activities", "Internships", "Project work / dissertation", "Seminars and guest lectures", "Technical workshops", "Alumni interactions", "Research activities", "Coding / technical competitions"};
        for (String a : academic) System.out.println("  - " + a);

        System.out.println("\nNon-academic / student activities:");
        String[] nonAcademic = {"InfoFest", "Plateaunica", "Youthesia", "Play-on (as specified in assignment brief)", "Sports and inter-university activities", "Cultural activities", "Student clubs and competitions", "Student welfare activities", "Alumni and social events"};
        for (String a : nonAcademic) System.out.println("  - " + a);

    }

    static void section(String title) {
        System.out.println("\n--- " + title + " ---");
    }
}

class Student implements Serializable, Cloneable {
    private int rollNo;
    private String name;
    private String program;
    private int admissionYear;
    private List<String> activities;

    public Student(int rollNo, String name, String program, int admissionYear) {
        this.rollNo = rollNo;
        this.name = name;
        this.program = program;
        this.admissionYear = admissionYear;
        this.activities = new ArrayList<>();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<String> getActivities() { return activities; }

    public String toRecord() {
        return rollNo + "|" + name + "|" + program + "|" + admissionYear + "|" + activities;
    }

    public Student shallowClone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }

    public Student deepClone() throws CloneNotSupportedException {
        Student copy = (Student) super.clone();
        copy.activities = new ArrayList<>(this.activities);
        return copy;
    }
}

enum StaffType { TEACHING, NON_TEACHING }

class Staff {
    private int id;
    private String name;
    private StaffType type;
    private static int count = 0;

    public Staff(int id, String name, StaffType type) {
        this.id = id; this.name = name; this.type = type; count++;
    }
    public static void displayCount() { System.out.println("Static staff counter = " + count); }
}

interface TeachingRole { void teach(); }
interface ResearchRole { void conductResearch(); }
interface ManagementRole { void manage(); }
interface AcademicUnit extends TeachingRole, ResearchRole { }

class DCSTCoordinator implements AcademicUnit, ManagementRole {
    private String role;
    public DCSTCoordinator(String role) { this.role = role; }
    public void teach() { System.out.println(role + " -> teaching activity performed."); }
    public void conductResearch() { System.out.println(role + " -> research activity performed."); }
    public void manage() { System.out.println(role + " -> NIRF/academic management activity performed."); }
}

class AccessDemo {
    public String publicValue = "PUBLIC";
    private String privateValue = "PRIVATE";
    protected String protectedValue = "PROTECTED";
    public void showInsideAccess() {
        System.out.println("Inside class -> " + publicValue + ", " + privateValue + ", " + protectedValue);
    }
    public String getPrivateValue() { return privateValue; }
}
class AccessChild extends AccessDemo {
    public void showProtectedFromChild() { System.out.println("Subclass -> protected: " + protectedValue); }
}

abstract class Report {
    protected String title;
    public Report(String title) { this.title = title; }
    public abstract void generate();
}
class AcademicReport extends Report implements Printable {
    public AcademicReport(String title) { super(title); }
    public void generate() { System.out.println("AcademicReport.generate() -> " + title); }
    public String print() { return "Printable Academic Report: " + title; }
}
class NonAcademicReport extends Report {
    public NonAcademicReport(String title) { super(title); }
    public void generate() { System.out.println("NonAcademicReport.generate() -> " + title); }
}
interface Printable { String print(); }
class PrintableReport implements Printable {
    public String print() { return "PrintableReport.print() called."; }
}

class NIRFCalculator {
    public int total(int a, int b) { return a + b; }
    public double total(double a, double b) { return a + b; }
}
class Box<T> {
    private T value;
    public Box(T value) { this.value = value; }
    public T getValue() { return value; }
}
class GenericUtils {
    public static <T extends Comparable<T>> T max(T a, T b) { return a.compareTo(b) >= 0 ? a : b; }
}
class InvalidStudentException extends Exception {
    public InvalidStudentException(String message) { super(message); }
}
