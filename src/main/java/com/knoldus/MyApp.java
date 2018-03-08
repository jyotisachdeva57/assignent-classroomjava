package com.knoldus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static java.util.stream.Collectors.toList;

/**
 * class student having name,roll number and subjects as fields.
 */
class Student {

  private String name;
  private int rollNumber;
  private Optional<List<String>> subject;

  private Student(String name, int rollNumber, Optional<List<String>> subject) {
    this.name = name;
    this.rollNumber = rollNumber;
    this.subject = subject;
  }

  public String getName() {
    return name;
  }


  private int getRollNumber() {
    return rollNumber;
  }


  @Override
  public String toString() {
    return getName() + "," + getRollNumber() + "," + getSubject();

  }

  public Optional<List<String>> getSubject() {
    return subject;
  }


  public static List<Student> getStudent() {
    List<String> listSub = new ArrayList<>();
    listSub.add("english");
    listSub.add("maths");

    Optional<List<String>> month = Optional.of(listSub);

    List<Student> list = new ArrayList<>();
    list.add(new Student("jyoti", 1, month));
    list.add(new Student("jyo", 2, Optional.empty()));
    return list;
  }

}


final class ClassRoom {

  private String roomID;
  private Optional<List<Student>> studentList;

  public String getRoomID() {
    return roomID;
  }

  public Optional<List<Student>> getStudentList() {
    return studentList;
  }

  @Override
  public String toString() {
    return getRoomID() + getStudentList();
  }

  private ClassRoom(String roomID, Optional<List<Student>> studentList) {
    this.roomID = roomID;
    this.studentList = studentList;
  }

  public static List<ClassRoom> getClassRoomStudents() {
    List<Student> student = Student.getStudent();
    List<ClassRoom> listClassStudents;
    listClassStudents = new ArrayList<>();
    listClassStudents.add(new ClassRoom("xyz", Optional.of(student)));
    listClassStudents.add(new ClassRoom("xyz", Optional.of(student)));
//    listClassStudents.add(new ClassRoom(null,Optional.empty()));
    return listClassStudents;
  }

}

class Operations {
  private List<ClassRoom> list = ClassRoom.getClassRoomStudents();

  /**
   * returns students having room and no subjects
   * @return
   */

  List<List<String>> returnStudentsWithRoomAndNoSubject() {
    return list.stream().filter(s -> s.getRoomID() != null &&
        (s.getStudentList().isPresent()))
        .map(s -> s.getStudentList().orElse(Collections.emptyList()).stream()
            .map(Student::getName).collect(toList())).collect(toList());
  }

  /**
   * returns subjects of students having room number xyz.
   * @return
   */

  List<List<String>> returnSubjectOfRoomxyz() {
    return list.stream().filter(s -> s.getRoomID().equals("xyz")
        && s.getStudentList().isPresent()).map(s -> s.getStudentList()
        .orElseThrow(() -> new NullPointerException("no Element Found")).stream()
        .flatMap(y -> y.getSubject().orElse(Collections.emptyList()).stream()).
            collect(toList())).collect(toList());
  }

  /**
   * returns students that are associated with room.
   * @return
   */
  List<String> returnStudentsAssociatedWithRoom() {
    return list.stream().filter
        (s -> s.getRoomID() != null &&
        s.getStudentList().isPresent()).map(x -> (x.getRoomID() + "hello student"))
        .collect(toList());
  }

}


public class MyApp {

  public static void main(String args[]) {
    Operations operations = new Operations();
    System.out.println(operations.returnStudentsWithRoomAndNoSubject());
    System.out.println(operations.returnStudentsAssociatedWithRoom());
    System.out.println(operations.returnSubjectOfRoomxyz());
  }

}
