package labajonice.it.pkg2d.payment;


import static java.lang.System.out;
import java.util.Scanner;




public class LABAJONICEIT2DPAYMENT {
    
  
   
  



    
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String response;
       
        
        
        
        do{
        System.out.println("1.ADD");
        System.out.println("2. VIEW");
        System.out.println("3. UPDATE");
        System.out.println("4. DELETE");
        System.out.println("5. EXIT");
        
        
        System.out.println("Enter Action:");
        int action = sc.nextInt();
        
            LABAJONICEIT2DPAYMENT payment= new LABAJONICEIT2DPAYMENT(); 
        switch (action){
            case 1:
              payment.addPayment();
              
                
             break;
            case 2:
            payment.viewPayment();
            
            break;
            case 3:
                
            payment.viewPayment();
            payment.updatePayment();
            payment.viewPayment();
            break;
            
            case 4:
                payment.viewPayment();
            payment.deletePayment();
            payment.viewPayment();
            break;
            
        }
            System.out.print("Do you want to continue? (yes/no):");
            response = sc.next();
        }while(response.equalsIgnoreCase("yes"));
        System.out.println("Thankyou,See you soonest");
        
        
            
        }
         public void addPayment(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print(" Payment Id: ");
        String pid = sc.next();
        System.out.print("Amount: ");
        String amount = sc.next();
             System.out.println("Payment Date:");
        String pdate = sc.next();
        System.out.print("Payment Method: ");
        String pmethod = sc.next();
        System.out.print("Status: ");
        String status = sc.next();
      

        String sql = "INSERT INTO tbl_payment (payment_id, amount, payment_date, payment_method, status) VALUES (?, ?, ?, ?)";


        conf.addRecord(sql, pid,amount, pdate, pmethod, status);


    }private void viewPayment() {
        
        config conf = new config();
        String votersQuery = "SELECT * FROM tbl_payment";
        String[] votersHeaders = {"Payment Id", "Amount", "Payment Date", "Payment Method", "Status"};
        String[] votersColumns = {"pid", "pdate", "pmethod", "status" };

        conf.viewRecords(votersQuery, votersHeaders, votersColumns);
    }
    
    private void updatePayment(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        System.out.println("Enter the id to update:");
        int id = sc.nextInt();
        
        
        System.out.print("New Payment Id");
        String pid = sc.next();
        System.out.print("New Amount:");
        String amount = sc.next();
        System.out.print("New Payment Date:");
        String pdate = sc.next();
        System.out.println("New Payment Method");
        String pmethod = sc.next ();
        System.out.print("New Status:");
        String status = sc.next();
        
        String sql = "UPDATE tbl_payment SET pid = ?, amount =?, p_date = ?, p_method =?, Status= ?";
        
      
        conf.updateRecord(sql, pid, amount, pdate, pmethod, status);
        
        
        
        
        
    }
    private void deletePayment(){
        Scanner sc = new Scanner(System.in);
         System.out.println("Enter the Id to delete:");
         
        int id= sc.nextInt();
        
        
        String qry = "DELETE FROM tbl_payment WHERE p_id = ?";
        
        
        config conf = new config();
        conf.deleteRecord(qry,id);
        
        
        
        

 
  
       
    }


}

    


