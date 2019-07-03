package src.com.Dj.OOP;
import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PhoneBook {

static Scanner scan=new Scanner(System.in);
static BufferedReader Br=new BufferedReader(new InputStreamReader(System.in));

public static void main(String[] args) throws Exception{
int choice=0;
do {
System.out.println("1.Show Contact");
System.out.println("2.Save Contact");
System.out.println("3.Edit Contact");
System.out.println("4.Delete Contact");
System.out.println("5.Search Contact");
choice=scan.nextInt();
switch(choice) {
case 1:
ShowContact();
break;
case 2:
SaveContact();
break;
case 3:
EditContact();
break;
case 4:
DeleteContact();
break;
case 5:
SearchContact();
break;
default :
System.out.println("Ener proper choice");
}
}while(true);
}

private static void SearchContact() throws IOException, ParseException {
// TODO Auto-generated method stub
boolean delete=true;
JSONArray ContactList=getData();
System.out.println("Enter Name Search");
String Name=Br.readLine();
for(int i=0;i<ContactList.size();i++) {
JSONObject EachContact=(JSONObject)ContactList.get(i);
if(Name.equals((String)EachContact.get("FirstName"))){
System.out.println("Data Found");
System.out.println("FirstName\t:"+EachContact.get("FirstName"));
System.out.println("LastName\t:"+EachContact.get("LastName"));
System.out.println("Contact\t\t:"+EachContact.get("Contact"));
System.out.println("City\t\t:"+EachContact.get("City"));
System.out.println("Zip\t\t:"+EachContact.get("Zip"));
delete=false;
}
}
if(delete) {
System.out.println("No data Found");
}
}

@SuppressWarnings("unchecked")
private static void DeleteContact() throws IOException, ParseException {
boolean delete=true;
// TODO Auto-generated method stub
JSONArray ContactList=getData();
JSONObject NewList=new JSONObject();
System.out.println("Enter Name to delete");
String Name=Br.readLine();
for(int i=0;i<ContactList.size();i++) {
JSONObject eachContact=(JSONObject)ContactList.get(i);
if(Name.equals((String)eachContact.get("FirstName"))){
ContactList.remove(i);
System.out.println("Data Deleted");
NewList.put("Data",ContactList);
writeData(NewList);
delete=false;
}
}
System.out.println(ContactList);
if(delete) {
System.out.println("No Data Found");
}
}

public static void writeData(JSONObject ContactList) throws IOException {
FileWriter file = new FileWriter("/home/user/Desktop/Contact.json");
file.write(ContactList.toJSONString());
        file.flush();
        file.close();	
}

private static void EditContact() {
// TODO Auto-generated method stub


}

@SuppressWarnings("unchecked")
private static void SaveContact() throws ParseException {
// TODO Auto-generated method stub
JSONObject NewContact=new JSONObject();

try {
System.out.println("Enter First Name");
NewContact.put("FirstName",Br.readLine());
System.out.println("Enter Last Name");
NewContact.put("LastName",Br.readLine());
System.out.println("Enter Contact Number");
NewContact.put("Contact",Br.readLine());
System.out.println("Enter City");
NewContact.put("City",Br.readLine());
System.out.println("Enter Zip");
NewContact.put("Zip",Br.readLine());
System.out.println("Enter Y/n to Save");
char save=scan.next().charAt(0);
if(save=='Y' || save=='y') {
JSONArray ContactList=getData();
ContactList.add((JSONObject)NewContact);
JSONObject NewList = new JSONObject();
NewList.put("Data",ContactList);
writeData(NewList);
System.out.println("Data Saved");
}
else {
System.out.println("Data Not Saved");
}
        }catch(IOException e) {
            e.printStackTrace();
        }
}

private static void ShowContact() throws IOException, ParseException {
JSONArray ContactList=getData();
for(int i=0;i<ContactList.size();i++) {
JSONObject eachContact=(JSONObject)ContactList.get(i);
System.out.print(eachContact.get("FirstName")+"\t\t"+eachContact.get("LastName")+"\t\t"+eachContact.get("Contact")+"\t"+eachContact.get("City")+"\t"+eachContact.get("Zip"));
System.out.println();
}
}
public static JSONArray getData() throws IOException, ParseException {
JSONArray ContactList=null;
JSONParser Parser=new JSONParser();
try {
FileReader ReadFile=new FileReader("/home/user/Desktop/Contact.json");
JSONObject Contact=(JSONObject)Parser.parse(ReadFile);
ContactList =(JSONArray)Contact.get("Data");

}
catch(NullPointerException e) {
System.out.println("No Data Found");
}
return ContactList;
}
}
