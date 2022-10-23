// Paul Brackney
// paul.brackney@okstate.edu
// 10-22-22
// Determine whether an HTML file meets the HTML tag rules by using a stack that is implemented with 2 queues


import java.util.Deque;
import java.util.Scanner;
import java.io.*;
import java.lang.String;

public class Assignment03_Brackney_Paul_MainDriver {

    public static void main(String[] args) throws FileNotFoundException {

    // instantiate 2 new queues that will be used to implement stack (a main source queue as well as a helper queue)
    Assignment03_Brackney_Paul_Queue Q1 = new Assignment03_Brackney_Paul_Queue();
    Assignment03_Brackney_Paul_Queue Q2 = new Assignment03_Brackney_Paul_Queue();

    // read the file that is written in the command line like java Assignment03_Brackney_Paul_MainDriver text1.txt
    String fileName = args[0];
    File file = new File(fileName);
    Scanner input = new Scanner(file);
    String data = "";
    while(input.hasNext()){
        
        data = data + input.next() + " ";
        
        }
     
        for (int i = 0; i < data.length(); i++){

        // determine whether you have found an HTML tag
        if (data.charAt(i) == '<'){

            char backslash = '/';
            // determine if the tag is an opening tag or a closing tag
            if (data.charAt(i+1) != backslash){

            // if it is an opening tag, add it to the stack
            int j = i + 1;
            String tagName = "";
            do{
                tagName = tagName + data.charAt(j);
                j++;
            } while (data.charAt(j) != '>' && data.charAt(j) != ' ');

            // do not add to stack if it is <br>, <hr>, or <!DOCTYPE HTML> tag
            if (tagName.equals("br") || tagName.equals("hr") || tagName.equals("!DOCTYPE")){
            
            } else {
                // using enqueue and dequeue to implement the stack's push operation
                if(Q1.isEmpty()){
                    Q1.enqueue(tagName);
                } else {
                    do{
                        Q2.enqueue(Q1.dequeue());
                    } while (Q1.isEmpty() == false);
                    Q1.enqueue(tagName);
                    do {
                        Q1.enqueue(Q2.dequeue());
                    } while (Q2.isEmpty() == false);
                }
            }
            


        }

        // if Scanner comes across a closing tag, then check if it matches the top of the stack
        else {
            int j = i + 2;
            String tagName = "";
            do{
                tagName = tagName + data.charAt(j);
                j++;
            } while (data.charAt(j) != '>' && data.charAt(j) != ' ');

            if (Q1.first().equals(tagName)){
                // if it matches the top of the stack, then use dequeue to implement stack's pop operation
                Q1.dequeue();
            } else {
                // read file to find line number of the tag in question
                Scanner scnr2 = new Scanner(file);
                scnr2.useDelimiter(";|\r?\n|\r");
                int lineNumber = 0;
                String readLine = "";
                
                boolean flag;
                boolean flag2;

                do{
                    lineNumber++;
                    readLine = scnr2.nextLine();
                    flag = scnr2.hasNext();
                    flag2 = readLine.contains("/" + tagName);
                } while (flag && !(flag2));

                // if closing tag does not match the top of the stack, print message to the console
                System.out.println("Oops.. There is a problem...");
                System.out.println("The <" + tagName + "> tag at line #" + lineNumber + " does not meet the tag rules...");
                System.exit(0);
            }

        }

        }

        }
        
        // if at the end of the program the stack is empty, then the file meets all tag rules
        if(Q1.isEmpty()){
            System.out.println("Congratulations...");
            System.out.println("The given HTML file meets all the tag rules...");
        }

        }

    }

    



