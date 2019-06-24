import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

 class DictionaryTester{
  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new FileReader("/home/user/Desktop/Dj.txt"));
      String file;
      int lineNum = 1;
      while ((file = br.readLine()) != null) {
        System.out.print( "(" + lineNum++ + ") ");
        System.out.println(file.toLowerCase());

        String line = br.readLine();
        //String is split or removes the spaces and places into the array words
        String[] words = line.split(" ");

        //for loop to keep running on the length of the array
        for(int i =0; i< words.length; i++){
          //word is equal to a particular indexed spot of the word array and gets rid of all non-alphabet letters
          String word = words[i];
          word = word.replaceAll("[^a-z]", "");
        }
      }
    }
    catch (IOException e){
      System.out.println("Error: " + e.getMessage());
    }
  }
}
//Node of a singly linked list of strings
class Node {
   private String element;
   private Node next;

   //creates a node with the given element and next

    public Node(String s, Node n){
      element = s;
      next = n;
   }

   //Returns the elements of this
    public String getElement(){
      return element;
   }
   public Node getNext(){
      return next;
   }

   //Modifier
   //Sets the element of this
   public void setElement(String newElement){
      element = newElement;
   }

   //Sets the next node of this
   public void setNext(Node newNext){
      next = newNext;
   }
}
//Singly linked list
 class SLinkedList {
   //head node of the list
   protected Node head;

   //number of nodes in the list
   protected long size;

   //Default constructor that creates an empty list
   public SLinkedList(){
      head = null;
      size = 0;
   }
}
