import java.util.LinkedList;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class UnOrderedList{
    public static UnOrderedList Ul = new UnOrderedList();
    Node head;
    static class Node{
        String data;
        Node next;
        Node(String d){
            data=d;
            next=null;
        }
    }
    
    public static void search(String searchElement){
        Node newNode=new Node(searchElement);
        Node currentNode=Ul.head,prevNode=null;
        newNode.next=null;
        if(Ul.head==null){
            Ul.head=newNode;
            System.out.println("Data added to empty list");
            return;
        }
        if(currentNode.data.equals(searchElement)){
            Ul.head=currentNode.next;
            System.out.println("Found and Remove");
            return;
        }
        while((currentNode.next!=null) && (currentNode.data!=searchElement)){
            prevNode=currentNode;
            currentNode=currentNode.next;
        }
        if(searchElement.equals(currentNode.data)){        
            prevNode.next=currentNode.next;
            System.out.println("Found and Remove");
            return;
        }
        if((currentNode.next==null) && (currentNode.data != searchElement)){
            currentNode.next=newNode;
            System.out.println("Not Found and added");
            return;
        }
    }

    public static void printUlist(){
        Node curNode =Ul.head;
        if(curNode.next==null){
            System.out.println("Data is empty");
        }
        while(curNode.next!=null){
            System.out.println("Data is "+curNode.data);
            curNode=curNode.next;
        }
        System.out.println("Data is "+curNode.data);
    }
    
    public static void main(String[] args) throws Exception {

        try{
        
            BufferedReader FileObj=new BufferedReader(new FileReader("/home/user/Desktop/Dj.txt")); 
	    InputStreamReader iobj=new  InputStreamReader(System.in);           
            BufferedReader InputObj=new BufferedReader(iobj);                
            Scanner scan=new Scanner(System.in);
            String Line;
            char choice;
int i=0;
            String Searchelement;
            String[] word=new String[50];
            while(Line=FileObj.readLine())!=null){
		for(i=0;i<word.length();i++)
		{
		
		word=Line.split(" ");
                word[i]=word[i].trim();
                search(word[i]);
                }
            }
            do{
            System.out.println("Enter Searching String");
            Searchelement=InputObj.readLine();
            Searchelement=Searchelement.trim();
            search(Searchelement);
            printUlist();
            System.out.println("Enter Y for continue :");
            choice=scan.nextLine().charAt(0);
            }while(choice=='Y');
            FileObj.close();
            InputObj.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}

