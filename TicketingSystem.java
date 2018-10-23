/**
 * @author 90053232 Yara Gagen-Torn
 **/

package ticketingsystem;

import java.util.LinkedList; 
import java.util.Queue; 
import java.util.Timer;
import java.util.TimerTask;


public class TicketingSystem {

    public static Queue<Integer> theLine = new LinkedList<>(); //create the line
    static int ticketNumber = 1;//create ticket counter
    
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new SalesAssisstantTask(), 0, 5000); //run code in the SalesAssistantTask run() method every 5 seconds
        timer.schedule(new CustomerInLine(), 0, 3000);//run code in the CustomerInLine run() method every 3 seconds
    }
    
     public static class CustomerInLine extends TimerTask { //inner class
        @Override
        public void run() {
            System.out.println("Customer with ticket " + ticketNumber + " is added to the queue."); 
            theLine.add(ticketNumber);//add customer to the end of line
            ticketNumber++;// increase ticket number counter
         }
    }
    
    public static class SalesAssisstantTask extends TimerTask { //inner class
        @Override
        public void run() {
            System.out.println("\nSales Assistant is ready to see the next customer."); 
            if (theLine.isEmpty()) { //if the line is empty
                System.out.println("There are no customers to see.");}
            else{
                int clientNow = theLine.poll();//take customer from the head of the line
                System.out.println("The customer with ticket number " + clientNow + " will be seen");
                System.out.println("The customers with the following tickets are in the queue:" + theLine);
            }
        }
    }
}
    
