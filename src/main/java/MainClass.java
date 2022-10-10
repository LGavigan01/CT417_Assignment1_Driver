import CT417.*;
import java.time.LocalDate;
import java.util.ArrayList;

import CT417.Module;
import org.joda.time.DateTime;

public class MainClass {

        public static void main(String[] args) {
            //Creating several student objects
            Student liam = new Student("Liam", LocalDate.parse("2001-08-03"), 1234);
            Student dylan = new Student("Dylan", LocalDate.parse("2001-05-08"), 9075);
            Student oisin = new Student("Oisín", LocalDate.parse("2000-12-21"), 4152);
            Student ryan = new Student("Ryan", LocalDate.parse("2002-01-05"), 7298);
            //Adding the students to a list - makes for easy printing at the end of the class
            ArrayList<Student> listOfStudents = new ArrayList<Student>();
            listOfStudents.add(liam);
            listOfStudents.add(dylan);
            listOfStudents.add(oisin);
            listOfStudents.add(ryan);

            //Creating some lecturer objects
            Lecturer lecturer1 = new Lecturer("Mike", LocalDate.parse("1980-06-12"), 1243);
            Lecturer lecturer2 = new Lecturer("Colm", LocalDate.parse("1977-03-05"), 9041);
            Lecturer lecturer3 = new Lecturer("John", LocalDate.parse("1969-09-21"), 7682);

            //Creating some module objects
            Module softwareEng = new Module("Software Engineering", "CT417", lecturer1);
            Module infoRetrieval= new Module("Information Retrieval", "CT4100", lecturer2);
            Module accounting = new Module("Accounting", "BS132", lecturer3);
            Module statistics = new Module("Statistics", "S1892", lecturer3);
            //Adding the modules to a list - makes for easy printing at the end of the class
            ArrayList<Module> listOfModules = new ArrayList<>();
            listOfModules.add(softwareEng);
            listOfModules.add(infoRetrieval);
            listOfModules.add(accounting);
            listOfModules.add(statistics);

            //Creating some course objects
            CourseProgramme csitCourse = new CourseProgramme("Computer Science & Information Technology", DateTime.parse("2022-09-01"), DateTime.parse("2023-05-01"));
            CourseProgramme bisCourse = new CourseProgramme("Business Information Systems", DateTime.parse("2022-09-01"), DateTime.parse("2023-05-01"));
            CourseProgramme commerceCourse = new CourseProgramme("Commerce", DateTime.parse("2022-09-01"), DateTime.parse("2023-05-01"));
            //Adding the courses to a list - again, makes for easy printing at the end of the class
            ArrayList<CourseProgramme> listOfCourseProgrammes = new ArrayList<>();
            listOfCourseProgrammes.add(csitCourse);
            listOfCourseProgrammes.add(bisCourse);
            listOfCourseProgrammes.add(commerceCourse);

            //Assigning courses and modules to each student
            liam.addCourse(csitCourse);
            liam.addModule(softwareEng);
            liam.addModule(infoRetrieval);

            dylan.addCourse(commerceCourse);
            dylan.addModule(accounting);
            dylan.addModule(statistics);

            oisin.addCourse(bisCourse);
            oisin.addModule(infoRetrieval);

            ryan.addCourse(bisCourse);
            ryan.addModule(infoRetrieval);

            //Handy method for adding students to their respective module/course objects after they add modules/courses to via their own addModule/addCourse methods
            for (Student s: listOfStudents) {
                for (Module m : listOfModules) {
                    if (s.getModulesRegisteredFor().contains(m)) {
                        m.addStudent(s);
                    }
                }

                for (CourseProgramme c : listOfCourseProgrammes) {
                    if (s.getCourse().contains(c)) {
                        c.addStudent(s);
                    }
                }
            }

            //Adding modules to the various courses
            csitCourse.addModule(softwareEng);
            csitCourse.addModule(infoRetrieval);
            commerceCourse.addModule(accounting);
            commerceCourse.addModule(statistics);
            bisCourse.addModule(infoRetrieval);

            //As per assignment instructions - "the program should print out a list of all the courses......."
            //System.out.println("\n-----------------------------------------------------\nCourses:\n-----------------------------------------------------");
            System.out.println("\n=====================================================\n\t\t\t\t\tCOURSES\n=====================================================");
            for (CourseProgramme course : listOfCourseProgrammes) { //Iterates through each course object within listOfCourseProgrammes and prints using toString() within the CourseProgramme class
                System.out.println(course);
            }

            //Printing out each module object to the console
            System.out.println("\n\n\n=====================================================\n\t\t\t\t\tMODULES\n=====================================================");
            for (Module module : listOfModules) { //Iterates through each module object within listOfModules and prints using toString() within the CourseProgramme class
                System.out.println(module);
            }

            //Printing out each student object to the console
            System.out.println("\n\n\n=====================================================\n\t\t\t\t\tSTUDENTS\n=====================================================");
            for (Student student : listOfStudents) { //Iterates through each student object with listOfStudents and prints using toString() within the Student class
                System.out.println(student);
            }

        }
    }