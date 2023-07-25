package lab6;

import java.util.Scanner;
import java.util.ArrayList;

class Student {
    private int ID;
    private String name;
    private double CGPA;

    private ArrayList<Course> CourseList = new ArrayList<Course>();
    private int count = 0;

    public Student() {
    }

    public Student(int id, String s, double cg) {
        this.ID = id;
        this.name = s;
        this.CGPA = cg;
    }

    public String display() {
        return "Student Information:\nName: " + name + "\nID: " + ID + "\n CGPA: " + CGPA;
    }

    public void setID(int id) {
        this.ID = id;
    }

    public int getID() {
        return this.ID;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getName() {
        return this.name;
    }

    public void setCGPA(double cg) {
        this.CGPA = cg;
    }

    public double getCGPA() {
        return this.CGPA;
    }

    public void addCourse(Course c) {
        CourseList.add(count, c);
        count++;
    }

    public void dropCourse(String id) {
        int i = 0;
        boolean can = false;
        for (int j = 0; j < CourseList.size(); j++) {
            if (CourseList.get(j).getID() == id) {
                i = j;
                break;
            }
        }
        if (can) {
            CourseList.remove(i);
        }
    }

    public void updateCourse(String id, Course c) {
        int i = 0;
        boolean can = false;
        for (int j = 0; j < CourseList.size(); j++) {
            if (CourseList.get(j).getID() == id) {
                i = j;
                break;
            }
        }
        if (can) {
            CourseList.set(i, c);
        }
    }

    public void printCourses() {
        System.out.println("Courses taken by " + this.name + " : ");
        for (int i = 0; i < CourseList.size(); i++) {
            System.out.println(CourseList.get(i).display());
        }
    }
}

class Course {
    private String ID, title;
    private double credit;
    private ArrayList<Student> StudentList = new ArrayList<Student>();
    private int nStudent = 0;
    private Faculty faculty;

    public Course() {
    }

    public Course(String id, String t, double c) {
        ID = id;
        title = t;
        credit = c;
    }

    public String display() {
        return "Course Information:\nCourse Title: " + title + "\nCourse Code: " + ID + "\n Course Credit: " + credit;
    }

    public void addStudent(Student s) {
        StudentList.add(nStudent, s);
        nStudent++;
    }

    public void dropStudent(int id) {
        int i = 0;
        boolean can = false;
        for (int j = 0; j < StudentList.size(); j++) {
            if (StudentList.get(j).getID() == id) {
                i = j;
                can = true;
                break;
            }
        }
        if (can) {
            StudentList.remove(i);
        }
    }

    public void addFaculty(Faculty f) {
        this.faculty = f;
        nStudent++;
    }

    public void dropFaculty() {
        this.faculty = new Faculty();
    }

    public void printStudentList() {
        for (int i = 0; i < StudentList.size(); i++) {
            System.out.println(StudentList.get(i).display());
        }
    }

    public void setID(String id) {
        this.ID = id;
    }

    public void setTitle(String t) {
        this.title = t;
    }

    public void setCredit(double c) {
        this.credit = c;
    }

    public String getID() {
        return this.ID;
    }

    public String getTitle() {
        return this.title;
    }

    public double getCredit() {
        return this.credit;
    }

    public String getFaculty() {
        return faculty.display();
    }

}

class Faculty {
    private int ID;
    private String name, position;
    private ArrayList<Course> CourseList = new ArrayList<Course>();
    private int count = 0;

    public Faculty() {
    }

    public Faculty(int i, String n, String p) {
        this.ID = i;
        this.name = n;
        this.position = p;
    }

    public String display() {
        return "Faculty Information:\nName: " + name + "\nPosition: " + position + "\nID: " + ID;
    }

    public void setID(int id) {
        this.ID = id;
    }

    public void setName(String s) {
        this.name = s;
    }

    public void setPosition(String s) {
        this.position = s;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return this.name;
    }

    public String getPosition() {
        return this.position;
    }

    public void addCourse(Course c) {
        CourseList.add(count, c);
        count++;
    }

    public void dropCourse(String id) {
        int i = 0;
        boolean can = false;
        for (int j = 0; j < CourseList.size(); j++) {
            if (CourseList.get(j).getID() == id) {
                i = j;
                break;
            }
        }
        if (can) {
            CourseList.remove(i);
        }
    }

    public void printCourses() {
        System.out.println("Courses taught by " + this.name + " : ");
        for (int i = 0; i < CourseList.size(); i++) {
            System.out.println(CourseList.get(i).display());
        }
    }
}

public class Relations {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        ArrayList<Student> StudentList = new ArrayList<Student>();
        ArrayList<Course> CourseList = new ArrayList<Course>();
        ArrayList<Faculty> FacultyList = new ArrayList<Faculty>();

        int si = 0;
        int ci = 0;
        int fi = 0;

        int iShifter = 30;
        String InitialMenu = "1. Add\n2. Delete\n3. Update\n4. Print\n5. Search\n0. Exit";
        while (iShifter != 0) {
            switch (iShifter) {
                case 30:
                    System.out.println("Welcome to XYZ Application:\nChoose an option below to perform some task.\n"
                            + InitialMenu + "\nEnter the option(Numerical): ");
                    int shifter = 0;
                    iShifter = inp.nextInt();
                    break;
                case 1:
                    System.out.println(
                            "Choose an option below to perform some task.\n1. Add a Student\n2. Add a Course\n3. Add a Faculty\nEnter the option(Numerical): ");
                    shifter = inp.nextInt();
                    switch (shifter) {
                        case 1:
                            System.out.println("Add student information:\nEnter name: ");
                            inp.nextLine();
                            String name = inp.nextLine();
                            System.out.println("Enter student ID: ");
                            int id = inp.nextInt();
                            System.out.println("Enter student CGPA: ");
                            double cg = inp.nextDouble();
                            StudentList.add(si, new Student(id, name, cg));
                            si++;
                            System.out.println("Student added successfully......\nGetting back to main menu\n\n\n\n");
                            break;
                        case 2:
                            System.out.println("Add course information:\nEnter course name: ");
                            inp.nextLine();
                            name = inp.nextLine();
                            System.out.println("Enter course ID: ");
                            String cid = inp.nextLine();
                            System.out.println("Enter course credit: ");
                            double cr = inp.nextDouble();
                            CourseList.add(ci, new Course(cid, name, cr));
                            ci++;
                            System.out.println("Course added successfully......\nGetting back to main menu\n\n\n\n");
                            break;
                        case 3:
                            System.out.println("Add faculty information:\nEnter faculty name: ");
                            inp.nextLine();
                            name = inp.nextLine();
                            System.out.println("Enter student ID: ");
                            id = inp.nextInt();
                            System.out.println("Enter student CGPA: ");
                            inp.nextLine();
                            String pos = inp.nextLine();
                            FacultyList.add(fi, new Faculty(id, name, pos));
                            fi++;
                            System.out.println("Faculty added successfully......\nGetting back to main menu\n\n\n\n");
                            break;
                    }
                    iShifter = 30;
                    break;
                case 2:
                    System.out.println(
                            "Choose an option below to perform some task.\n1. Delete a Student\n2. Delete a Course\n3. Delete a Faculty\nEnter the option(Numerical): ");
                    shifter = inp.nextInt();
                    switch (shifter) {
                        case 1:
                            System.out.println("Enter the student id you want to remove: ");
                            int id = inp.nextInt();
                            boolean can = false;
                            int i = 0;
                            for (int j = 0; j < StudentList.size(); j++) {
                                if (StudentList.get(j).getID() == id) {
                                    i = j;
                                    can = true;
                                    break;
                                }
                            }
                            if (can) {
                                StudentList.remove(i);
                                System.out.println(
                                        "Student removed from the list successfully......\nGetting back to main menu\n\n\n\n");
                            }
                            break;
                        case 2:
                            System.out.println("Enter the course id you want to remove: ");
                            inp.nextLine();
                            String cid = inp.nextLine();
                            can = false;
                            i = 0;
                            for (int j = 0; j < CourseList.size(); j++) {
                                if (CourseList.get(j).getID() == cid) {
                                    i = j;
                                    can = true;
                                    break;
                                }
                            }
                            if (can) {
                                CourseList.remove(i);
                                System.out.println(
                                        "Course removed from the list successfully......\nGetting back to main menu\n\n\n\n");
                            }
                        case 3:
                            System.out.println("Enter the faculty id you want to remove: ");
                            id = inp.nextInt();
                            can = false;
                            i = 0;
                            for (int j = 0; j < FacultyList.size(); j++) {
                                if (FacultyList.get(j).getID() == id) {
                                    i = j;
                                    can = true;
                                    break;
                                }
                            }
                            if (can) {
                                FacultyList.remove(i);
                                System.out.println(
                                        "Student removed from the list successfully......\nGetting back to main menu\n\n\n\n");
                            }
                            break;
                    }
                    iShifter = 30;
                    break;
                case 3:
                    System.out.println(
                            "Choose an option below to perform some task.\n1. Update a Student\n2. Update a Course\n3. Update a Faculty\nEnter the option(Numerical): ");
                    shifter = inp.nextInt();
                    int upShifter = 0;
                    switch (shifter) {
                        case 1:
                            System.out.println(
                                    "Update Student information:\n1. Update Student name\n2. Update Student ID\n3. Update Student CGPA\n4. Add a course\n5. Drop a course\n6. Update a course\nEnter the option(Numerical): ");
                            upShifter = inp.nextInt();
                            switch (upShifter) {
                                case 1:
                                    System.out.print("Enter Student ID to update:");
                                    int id = inp.nextInt();
                                    for (int i = 0; i < StudentList.size(); i++) {
                                        if (StudentList.get(i).getID() == id) {
                                            System.out.print("Enter Student's new name:");
                                            inp.nextLine();
                                            String name = inp.nextLine();
                                            StudentList.get(i).setName(name);
                                            System.out.println("Name successfully updated for: " + id);
                                            break;
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.print("Enter Student ID to update:");
                                    id = inp.nextInt();
                                    for (int i = 0; i < StudentList.size(); i++) {
                                        if (StudentList.get(i).getID() == id) {
                                            System.out.print("Enter Student's new ID:");
                                            int sid = inp.nextInt();
                                            StudentList.get(i).setID(sid);
                                            System.out.println("ID successfully updated for: " + id);
                                        }
                                    }
                                    break;
                                case 3:
                                    System.out.print("Enter Student ID to update:");
                                    id = inp.nextInt();
                                    for (int i = 0; i < StudentList.size(); i++) {
                                        if (StudentList.get(i).getID() == id) {
                                            System.out.print("Enter Student's new CGPA:");
                                            double cg = inp.nextDouble();
                                            StudentList.get(i).setCGPA(cg);
                                            System.out.println("CGPA successfully updated for: " + id);
                                        }
                                    }
                                    break;
                                case 4:
                                    System.out.print("Enter Student ID to update:");
                                    id = inp.nextInt();
                                    for (int i = 0; i < StudentList.size(); i++) {
                                        if (StudentList.get(i).getID() == id) {
                                            System.out.print("Enter Student's new courseID to add:");
                                            inp.nextLine();
                                            String caID = inp.nextLine();
                                            for (int j = 0; j < CourseList.size(); j++) {
                                                if (CourseList.get(i).getID() == caID) {
                                                    StudentList.get(i).addCourse(CourseList.get(j));
                                                    System.out.println("Course successfully added for: " + id);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    break;
                                case 5:
                                    System.out.print("Enter Student ID to update:");
                                    id = inp.nextInt();
                                    for (int i = 0; i < StudentList.size(); i++) {
                                        if (StudentList.get(i).getID() == id) {
                                            System.out.print("Enter Student's new courseID to drop course:");
                                            inp.nextLine();
                                            String caID = inp.nextLine();
                                            for (int j = 0; j < CourseList.size(); j++) {
                                                if (CourseList.get(i).getID() == caID) {
                                                    StudentList.get(i).dropCourse(CourseList.get(j).getID());
                                                    System.out.println("Course successfully dropped for: " + id);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    break;
                                case 6:
                                    System.out.print("Enter Student ID to update:");
                                    id = inp.nextInt();
                                    for (int i = 0; i < StudentList.size(); i++) {
                                        if (StudentList.get(i).getID() == id) {
                                            System.out.print("Enter Student's courseID to be updated:");
                                            inp.nextLine();
                                            String caID = inp.nextLine();
                                            for (int j = 0; j < CourseList.size(); j++) {
                                                if (CourseList.get(i).getID() == caID) {
                                                    System.out.print("Enter Student's new courseID to update with "
                                                            + caID + " : ");
                                                    inp.nextLine();
                                                    String cuID = inp.nextLine();
                                                    for (int k = 0; k < CourseList.size(); k++) {
                                                        if (CourseList.get(k).getID() == cuID) {
                                                            StudentList.get(i).updateCourse(cuID, CourseList.get(k));
                                                            System.out
                                                                    .println("Course successfully updated for: " + id);
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println(
                                    "Update Course information:\n1. Update Course name\n2. Update Course credit\n3. Update Course ID\n4. Add a Student\n5. Drop a Student\n6. Add Faculty\n7. Drop Faculty\nEnter the option(Numerical): ");
                            upShifter = inp.nextInt();
                            switch (upShifter) {
                                case 1:
                                    System.out.print("Enter Course ID to update:");
                                    inp.nextLine();
                                    String id = inp.nextLine();
                                    for (int i = 0; i < CourseList.size(); i++) {
                                        if (CourseList.get(i).getID() == id) {
                                            System.out.print("Enter Course's new Title:");
                                            inp.nextLine();
                                            String name = inp.nextLine();
                                            CourseList.get(i).setTitle(name);
                                            System.out.println("Name successfully updated for: " + id);
                                            break;
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.print("Enter Course ID to update:");
                                    inp.nextLine();
                                    id = inp.nextLine();
                                    for (int i = 0; i < CourseList.size(); i++) {
                                        if (CourseList.get(i).getID() == id) {
                                            System.out.print("Enter Course's new Credit: ");
                                            double cr = inp.nextDouble();
                                            CourseList.get(i).setCredit(cr);
                                            System.out.println("Credit successfully updated for: " + id);
                                            break;
                                        }
                                    }
                                    break;
                                case 3:
                                    System.out.print("Enter Course ID to update:");
                                    inp.nextLine();
                                    id = inp.nextLine();
                                    for (int i = 0; i < CourseList.size(); i++) {
                                        if (CourseList.get(i).getID() == id) {
                                            System.out.print("Enter Course's new ID:");
                                            inp.nextLine();
                                            String cid = inp.nextLine();
                                            CourseList.get(i).setID(cid);
                                            System.out.println("ID successfully updated for: " + id);
                                            break;
                                        }
                                    }
                                    break;
                                case 4:
                                    System.out.print("Enter Course ID to update:");
                                    inp.nextLine();
                                    id = inp.nextLine();
                                    for (int i = 0; i < CourseList.size(); i++) {
                                        if (CourseList.get(i).getID() == id) {
                                            System.out.print("Enter Student's ID to add to the course:");
                                            int sid = inp.nextInt();
                                            for (int j = 0; j < StudentList.size(); j++) {
                                                if (StudentList.get(j).getID() == sid) {
                                                    CourseList.get(i).addStudent(StudentList.get(j));
                                                    System.out.println("Student successfully added for: " + id);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    break;
                                case 5:
                                    System.out.print("Enter Course ID to update:");
                                    inp.nextLine();
                                    id = inp.nextLine();
                                    for (int i = 0; i < CourseList.size(); i++) {
                                        if (CourseList.get(i).getID() == id) {
                                            System.out.print("Enter Student's ID to drop from the course:");
                                            int sid = inp.nextInt();
                                            for (int j = 0; j < StudentList.size(); j++) {
                                                if (StudentList.get(j).getID() == sid) {
                                                    CourseList.get(i).dropStudent(sid);
                                                    System.out.println("Student successfully dropped from: " + id);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    break;
                                case 6:
                                    System.out.print("Enter Course ID to update:");
                                    inp.nextLine();
                                    id = inp.nextLine();
                                    for (int i = 0; i < CourseList.size(); i++) {
                                        if (CourseList.get(i).getID() == id) {
                                            System.out.print("Enter Faculty's ID to add to the course:");
                                            int sid = inp.nextInt();
                                            for (int j = 0; j < FacultyList.size(); j++) {
                                                if (FacultyList.get(j).getID() == sid) {
                                                    CourseList.get(i).addFaculty(FacultyList.get(j));
                                                    System.out
                                                            .println("Faculty successfully added to the course: " + id);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    break;
                                case 7:
                                    System.out.print("Enter Course ID to update:");
                                    inp.nextLine();
                                    id = inp.nextLine();
                                    for (int i = 0; i < CourseList.size(); i++) {
                                        if (CourseList.get(i).getID() == id) {
                                            System.out.print("Enter Faculty's ID to drop from the course:");
                                            int sid = inp.nextInt();
                                            for (int j = 0; j < FacultyList.size(); j++) {
                                                if (FacultyList.get(j).getID() == sid) {
                                                    CourseList.get(i).dropFaculty();
                                                    System.out.println(
                                                            "Faculty successfully dropped from the course: " + id);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    break;
                            }
                            break;
                        case 3:
                            System.out.println(
                                    "Update Faculty information:\n1. Update Faculty name\n2. Update Faculty ID\n3. Update Faculty Position\n4. Add a course\n5. Drop a course\nEnter the option(Numerical): ");
                            upShifter = inp.nextInt();
                            switch (upShifter) {
                                case 1:
                                    System.out.print("Enter Faculty ID to update:");
                                    int id = inp.nextInt();
                                    for (int i = 0; i < FacultyList.size(); i++) {
                                        if (FacultyList.get(i).getID() == id) {
                                            System.out.print("Enter Faculty's new name:");
                                            inp.nextLine();
                                            String name = inp.nextLine();
                                            FacultyList.get(i).setName(name);
                                            System.out.println("Name successfully updated for: " + id);
                                            break;
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.print("Enter Faculty ID to update:");
                                    id = inp.nextInt();
                                    for (int i = 0; i < FacultyList.size(); i++) {
                                        if (FacultyList.get(i).getID() == id) {
                                            System.out.print("Enter Faculty's new ID:");
                                            int fid = inp.nextInt();
                                            FacultyList.get(i).setID(fid);
                                            System.out.println("ID successfully updated for: " + id);
                                            break;
                                        }
                                    }
                                    break;
                                case 3:
                                    System.out.print("Enter Faculty ID to update:");
                                    id = inp.nextInt();
                                    for (int i = 0; i < FacultyList.size(); i++) {
                                        if (FacultyList.get(i).getID() == id) {
                                            System.out.print("Enter Faculty's new position:");
                                            inp.nextLine();
                                            String name = inp.nextLine();
                                            FacultyList.get(i).setPosition(name);
                                            System.out.println("Position successfully updated for: " + id);
                                            break;
                                        }
                                    }
                                    break;
                                case 4:
                                    System.out.print("Enter Faculty ID to update:");
                                    id = inp.nextInt();
                                    for (int i = 0; i < FacultyList.size(); i++) {
                                        if (FacultyList.get(i).getID() == id) {
                                            System.out.print("Enter Faculty's new courseID to add:");
                                            inp.nextLine();
                                            String caID = inp.nextLine();
                                            for (int j = 0; j < CourseList.size(); j++) {
                                                if (CourseList.get(i).getID() == caID) {
                                                    FacultyList.get(i).addCourse(CourseList.get(j));
                                                    System.out.println(
                                                            "Course successfully added to the faculty with ID of: "
                                                                    + id);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    break;
                                case 5:
                                    System.out.print("Enter Faculty ID to update:");
                                    id = inp.nextInt();
                                    for (int i = 0; i < FacultyList.size(); i++) {
                                        if (FacultyList.get(i).getID() == id) {
                                            System.out.print("Enter Faculty's new courseID to drop course:");
                                            inp.nextLine();
                                            String caID = inp.nextLine();
                                            for (int j = 0; j < CourseList.size(); j++) {
                                                if (CourseList.get(i).getID() == caID) {
                                                    FacultyList.get(i).dropCourse(CourseList.get(j).getID());
                                                    System.out.println(
                                                            "Course successfully dropped for the faculty with ID of: "
                                                                    + id);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    break;
                            }
                            break;
                    }
                    iShifter = 30;
                    break;
                case 4:
                    System.out.println(
                            "Choose an option below to perform some task.\n1. Print all students\n2. Print all course\n3. Print all faculties\n4. Print information of a student\n5. Print information of a course\n6. Print information of a faculty\n7. Print student list and faculty information of a course\n8. Print courses taken by a student\nEnter the option(Numerical): ");
                    shifter = inp.nextInt();
                    switch (shifter) {
                        case 1:
                            for (int i = 0; i < StudentList.size(); i++) {
                                System.out.println(StudentList.get(i).display());
                            }
                            break;
                        case 2:
                            for (int i = 0; i < CourseList.size(); i++) {
                                System.out.println(CourseList.get(i).display());
                            }
                            break;
                        case 3:
                            for (int i = 0; i < FacultyList.size(); i++) {
                                System.out.println(FacultyList.get(i).display());
                            }
                            break;
                        case 4:
                            System.out.print("Enter the student id to print: ");
                            int id = inp.nextInt();
                            for (int i = 0; i < StudentList.size(); i++) {
                                if (StudentList.get(i).getID() == id) {
                                    System.out.println(StudentList.get(i).display());
                                } else {
                                    System.out.println("No Student with the id of " + id + " found");
                                }
                            }
                            break;
                        case 5:
                            System.out.print("Enter the Course id to print: ");
                            inp.nextLine();
                            String cid = inp.nextLine();
                            for (int i = 0; i < CourseList.size(); i++) {
                                if (CourseList.get(i).getID() == cid) {
                                    System.out.println(CourseList.get(i).display());
                                } else {
                                    System.out.println("No Course with the id of " + cid + " found");
                                }
                            }
                            break;
                        case 6:
                            System.out.print("Enter the Faculty id to print: ");
                            id = inp.nextInt();
                            for (int i = 0; i < FacultyList.size(); i++) {
                                if (FacultyList.get(i).getID() == id) {
                                    System.out.println(FacultyList.get(i).display());
                                } else {
                                    System.out.println("No Faculty with the id of " + id + " found");
                                }
                            }
                            break;
                        case 7:
                            System.out.print("Enter the Course id to print: ");
                            inp.nextLine();
                            cid = inp.nextLine();
                            for (int i = 0; i < CourseList.size(); i++) {
                                if (CourseList.get(i).getID() == cid) {
                                    CourseList.get(i).printStudentList();
                                    System.out.println(CourseList.get(i).getFaculty());
                                } else {
                                    System.out.println("No Course with the id of " + cid + " found");
                                }
                            }
                            break;
                        case 8:
                            System.out.print("Enter the student id to print: ");
                            id = inp.nextInt();
                            for (int i = 0; i < StudentList.size(); i++) {
                                if (StudentList.get(i).getID() == id) {
                                    StudentList.get(i).printCourses();
                                } else {
                                    System.out.println("No Student with the id of " + id + " found");
                                }
                            }
                            break;
                    }
                    iShifter = 30;
                    break;
                case 5:
                    System.out.println(
                            "Choose an option below to perform some task.\n1. Search a Student\n2. Search a Course\n3. Search a Faculty\n4. Search whether a student takes a course\n5. Search whether a faculty teaches a course\n6. Search courses taken by a student\n7. Search courses taught by a faculty\nEnter the option(Numerical): ");
                    shifter = inp.nextInt();
                    switch (shifter) {
                        case 1:
                            System.out.print("Enter the student id to Search: ");
                            int id = inp.nextInt();
                            boolean sFound = false;
                            for (int i = 0; i < StudentList.size(); i++) {
                                if (StudentList.get(i).getID() == id) {
                                    System.out.println(StudentList.get(i).display());
                                    StudentList.get(i).printCourses();
                                    sFound = true;
                                    break;
                                }
                            }
                            if (sFound) {
                                System.out.println("No Student with the id of " + id + " found");
                            }
                            break;
                        case 2:
                            System.out.print("Enter the course id to Search: ");
                            inp.nextLine();
                            String cid = inp.nextLine();
                            boolean cFound = false;
                            for (int i = 0; i < CourseList.size(); i++) {
                                if (CourseList.get(i).getID() == cid) {
                                    System.out.println(CourseList.get(i).display());
                                    CourseList.get(i).printStudentList();
                                    CourseList.get(i).getFaculty();
                                    cFound = true;
                                    break;
                                }
                            }
                            if (cFound) {
                                System.out.println("No Course with the id of " + cid + " found");
                            }
                            break;
                        case 3:
                            System.out.print("Enter the Faculty id to Search: ");
                            id = inp.nextInt();
                            boolean fFound = false;
                            for (int i = 0; i < FacultyList.size(); i++) {
                                if (FacultyList.get(i).getID() == id) {
                                    System.out.println(FacultyList.get(i).display());
                                    FacultyList.get(i).printCourses();
                                    fFound = true;
                                    break;
                                }
                            }
                            if (fFound) {
                                System.out.println("No Faculty with the id of " + id + " found");
                            }
                            break;
                        case 4:

                            break;
                        case 5:

                            break;
                        case 6:

                            break;
                        case 7:

                            break;

                        default:
                            break;
                    }
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    iShifter = 0;
                    break;
            }
        }
        inp.close();
    }
}
