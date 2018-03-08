package com.knoldus;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MyAppTest {
  private static Operations object;

  @BeforeClass

  public static void initCalculator() {

    object = new Operations();

  }

  @Before
  final public void beforeEachTest() {

    System.out.println(" before each Test");
  }

  @After

  final
  public void afterEachTest() {

    System.out.println("after each Test");
  }

  @Test

  final public void testSum() {
    List<List<String>> actual = object.returnStudentsWithRoomAndNoSubject();
    ArrayList<ArrayList<String>> listOLists = new ArrayList<>();
    ArrayList<String> singleList = new ArrayList<>();
    singleList.add("jyoti");
    singleList.add("jyo");
    listOLists.add(singleList);
    ArrayList<String> singleList1 = new ArrayList<>();
    singleList1.add("jyoti");
    singleList1.add("jyo");
    listOLists.add(singleList1);
    assertEquals(actual, listOLists);

  }


  @Test

  final public void test1() {
    List<String> actual = object.returnStudentsAssociatedWithRoom();
    ArrayList<String> listOLists = new ArrayList<>();
    listOLists.add("xyzhello student");
    listOLists.add("xyzhello student");

    assertEquals(actual, listOLists);
  }

  @Test

  final public void testRoom() {
    List<List<String>> actual = object.returnSubjectOfRoomxyz();
    ArrayList<ArrayList<String>> listOLists = new ArrayList<ArrayList<String>>();
    ArrayList<String> singleList = new ArrayList<String>();
    singleList.add("english");
    singleList.add("maths");
    listOLists.add(singleList);
    ArrayList<String> singleList1 = new ArrayList<String>();
    singleList1.add("english");
    singleList1.add("maths");
    listOLists.add(singleList1);
    assertEquals(actual, listOLists);

  }

}
