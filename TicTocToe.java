//////////////////////////////////////////////////////////////////////
// ///  Programme  	:  TicTacToe game
// ///  Author    	:  Dhanappa Jawalkote
// ///  Date      	:  13 june 2019
// ///  display    	:  1 | 2 | 3 |
// /// 	           	:  4 | 5 | 6 |
// ///                 	:  7 | 2 | 3 |
// ///  UserInput      	: enter any any number between 1-9 randomly
// ///  computerinput  	: call random function to get random value between 1-9
// ///  output		:  x | 0 | x |
// /// 	           	:  0 | x | 0 |
// ///                 	:  0 | x | x |
// ///  output		:  user win the tictactoe game
// ////////////////////////////////////////////////////////////////////////


import java.util.*;
import java.util.Random;
//import java.lang.*;

class TicTocToe{
    static char board[][]= new char[][]{{'1','2','3'},{'4','5','6'},{'7','8','9'}};   //two diamensional array of baord
    static int position;    //position of the user
    //0 is for computer and x is for user
    //count01 is for first row condition 00 to 02 ,count02 is for first colonm condition 00 to 20,count03 is for second row condition 10 to 12
    // count04 is for third row condition 30 to 30 ,count05 is for second col condition 01 to 21,count06 is for third col condition 02 to 22
   //count07 is for digonal condition  from  00 to 22, count08 is for digonal condition  from  22 to 02
    static int count01=0,count02=0,count03=0,count04=0,count05=0,count06=0,count07=0,count=0,count08=0;  //counter variables of computers
    static int countx1=0,countx2=0,countx3=0,countx4=0,countx5=0,countx6=0,countx7=0,countx8=0;          //counter variables of users
    static boolean win[]=new boolean[]{true,false}; 					                //aray to winning value of the player
    static Scanner scanner=new Scanner(System.in);  							//boject of input 

    public static void main(String arg[]){
        System.out.println("The Tic Toc Toe Game:");
        //display method of board
      try{
      displayBoard();    
      do{
            if(count==9){
                break;
            }
            getValueFromUser();
             count++;
            displayBoard();
            getValueFromComputer();
            count++;
            displayBoard();
          
            if(count01==3 || count02==3 || count03==3 || count04==3 || count05==3 || count06==3 || count07==3 || count08==3){
                win[1]=true;
                break;
            }
            else if(countx1==3 || countx2==3 || countx3==3 || countx4==3 || countx5==3 || countx6==3 || countx7==3 || countx8==3){
                win[0]=true;
                break;
            }
            
        }while(win[0] !=true || win[1] !=true);
        if(win[0]==true){
            System.out.println("The user win the match");
        } 
        else if(win[1]==true){
            System.out.println("The computer win the match");
        }
        else{
            System.out.println("The match draw");
        }
    }
    catch(Exception e){
        System.out.println("Error Occured"+e.getMessage());
    }
    }


    // Display method of TicTacToe board
    public static void displayBoard(){
    
        System.out.println();
        for(int row=0; row<3 ;row++){
            for(int col=0; col<3; col++){
                System.out.print("|"+board[row][col]);      
            }
            System.out.println("|");
         }
        System.out.println();
         
   }

   //Getting value or input from user
    public static void getValueFromUser(){
        do{
            System.out.println("Enter your position:");
            position = scanner.nextInt();
            System.out.println(position);
            switch(position){
                case 1:
                    if(board[0][0]=='x' || board[0][0]=='0'){
                        getValueFromUser(); 
                    }else{
                    board[0][0]='x';
                    countx1++;
                    countx2++;
                    countx7++;
                    }
                    break;
                case 2:
                    if(board[0][1]=='x' || board[0][1]=='0'){
                       getValueFromUser(); 
                    }else{
                        board[0][1]='x';
                    countx1++;
                    countx5++;}
                    break;
                case 3:
                   if(board[0][2]=='x' || board[0][2]=='0'){
                        getValueFromUser(); 
                     }else{
                        board[0][2]='x';
                    countx1++;
                    countx6++;
                    countx8++;}
                    break;
                case 4:
                   if(board[1][0]=='x' || board[1][0]=='0'){
                        getValueFromUser(); 
                    }else{
                        board[1][0]='x';
                    countx2++;
                    countx3++;}
                    break;
                case 5:
                    if(board[1][1]=='x' || board[1][1]=='0'){
                        getValueFromUser(); 
                    }else{
                        board[1][1]='x';
                    countx3++;
                    countx5++;
                    countx7++;
                    countx8++;}
                    break;  
                case 6:
                    if(board[1][2]=='x' || board[1][2]=='0'){
                        getValueFromUser(); 
                    }else{
                        board[1][2]='x';
                    countx3++;
                    countx6++;}
                    break;  
                case 7:
                    if(board[2][0]=='x' || board[2][0]=='0'){
                        getValueFromUser(); 
                    }else{
                        board[2][0]='x';
                    countx2++;
                    countx4++;
                    countx8++;
                    }
                    break;
                case 8:
                    if(board[2][1]=='x' || board[2][1]=='0'){
                        getValueFromUser(); 
                    }else{
                        board[2][1]='x';
                    countx4++;
                    countx5++;}
                    break;
                case 9:
                    if(board[2][2]=='x' || board[2][2]=='0'){
                        getValueFromUser(); 
                    }else{
                        board[2][2]='x';
                    countx4++;
                    countx6++;
                    countx7++;}
                    break;
                default:
                    System.out.println("Please Enter position in between 0-9:");

            }
        }while(position < 1 || position > 9);
    }



//get input from computer
    public static void getValueFromComputer(){
        do{
            System.out.println("Computer Turns:");
            //Scanner sc = new Scanner(System.in);
            Random random=new Random();
            position = random.nextInt(10);
            System.out.println(position);
            switch(position){
                case 1:
                    if(board[0][0]=='x' || board[0][0]=='0' ){
                        getValueFromComputer(); 
                    }else{
                    board[0][0]='0';
                    count01++;
                    count02++;
                    count07++;}
                    break;
                case 2:
                    if(board[0][1]=='x' || board[0][1]=='0'){
                        getValueFromComputer(); 
                    }else{
                        board[0][1]='0';
                    count01++;
                    count05++;}
                    break;
                case 3:
                    if(board[0][2]=='x' || board[0][2]=='0'){
                        getValueFromComputer(); 
                     }else{
                    board[0][2]='0';
                    count01++;
                    count06++;
                    count08++;}
                    break;
                case 4:
                    if(board[1][0]=='x' || board[1][0]=='0'){
                        getValueFromComputer(); 
                    }else{
                    board[1][0]='0';
                    count02++;
                    count03++;}
                    break;
                case 5:
                    if(board[1][1]=='x' || board[1][1]=='0'){
                        getValueFromComputer(); 
                    }else{
                        board[1][1]='0';
                    count03++;
                    count05++;
                    count07++;
                    count08++;}
                    break;  
                case 6:
                    if(board[1][2]=='x' || board[1][2]=='0'){
                        getValueFromComputer(); 
                    }else{
                        board[1][2]='0';
                    count03++;
                    count06++;}
                    break;  
                case 7:
                    if(board[2][0]=='x' || board[2][0]=='0'){
                        getValueFromComputer(); 
                    }else{
                    board[2][0]='0';
                    count02++;
                    count04++;
                    count08++;}
                    break;
                case 8:
                    if(board[2][1]=='x' || board[2][1]=='0'){
                        getValueFromComputer(); 
                    }else{
                    board[2][1]='0';
                    count04++;
                    count05++;}
                    break;
                case 9:
                    if(board[2][2]=='x' || board[2][2]=='0'){
                        getValueFromComputer(); 
                    }else{
                    board[2][2]='0';
                    count04++;
                    count06++;
                    count07++;}
                    break;
                default:
                    System.out.println("Please Enter position ");

            }
        }while(position < 1 || position > 9);
       
        //display();
    }
}
