package CustomDataStruc;
import java.io.*;
import java.util.Scanner;


class HashingNumber{
    public static HashingNumber Slot = new HashingNumber(); 
    static Node head[]=new Node[11];
    static class Node{
        int data;
        Node next;
        Node(int n){
            data=n;
            next=null;    
        }
    }

    public static void search(int search){
        int Number=search%11;
        Node Search=new Node(search);
        Node currentNode=head[Number],PrevNode=null;
        if(currentNode==null){
            head[Number]=Search;
            return;
        }
        if(currentNode.data==search){
            head[Number]=currentNode.next;
            return;
        }
        if(currentNode.data>search){
            head[Number]=Search;
            Search.next=currentNode;
            return;
        }
        while(currentNode.next!=null && currentNode.data<=search){
            PrevNode=currentNode;
            currentNode=currentNode.next;
        }
        if(currentNode.data==search){
            PrevNode.next=currentNode.next;
            return;
        }
        if(currentNode.data>search){
            PrevNode.next=Search;
            Search.next=currentNode;
            return;
        }
        if(currentNode.next==null){
            currentNode.next=Search;
            return;
        }
    }
    
    public static void printList(){
        ///create node obj to point list i.e:currentNode
        int Number;
        for(Number=0;Number<10;Number++){
            Node currentNode=head[Number];
            System.out.print("NumberSlot :"+Number+" Data :-> ");
            while(currentNode!=null){
                ///Print data
                System.out.print(currentNode.data+"\t");
                ///Go to next node
                currentNode=currentNode.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try{
            BufferedReader bufferReaderObj=new BufferedReader(new InputStreamReader(System.in));
            BufferedReader FileReaderObj=new BufferedReader(new FileReader("/home/user/Desktop/Dj.txt"));
            Scanner scanner=new Scanner(System.in);
            char a;
            int line;
            while((line=Integer.parseInt(FileReaderObj.readLine())) !=0 ){
               search(line);
            }
            do{
            System.out.println("Enter data to search");
            int search=scanner.nextInt();
            search(search);
            printList();
            System.out.println("type (Y/N) to continue");
            a = scanner.next().charAt(0);
            
            }while(a == 'Y');
            bufferReaderObj.close();
            FileReaderObj.close();
            scanner.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}

