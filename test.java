import java.util.ArrayList;
/**
 * Write a description of class test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class test
{
 
   public void test1()
   {
       Auction action =new Auction();
       action.enterLot("maraca");
       action.enterLot("xilofono");
       action.enterLot("metalofono");
       action.getUnsold();
       Person persona = new Person("manolo") ;
       //action.makeABid( 1, persona, 100L );
       action.close();
       
       
    }
    
     public void test2()
   {
       ArrayList<Lot> lots =  new ArrayList<>();
       
      
       Auction action =new Auction();
       action.enterLot("maraca");
       action.enterLot("xilofono");
       action.enterLot("metalofono");
       Person persona = new Person("manolo") ;
       action.makeABid( 1, persona, 100L );
       action.makeABid( 1, persona, 1000L );
       action.makeABid( 2, persona, 1020L );
       lots = action.close();
       for(Lot lot : lots)
       {
        lot.toString();
        }
        
       
       
       
    }
}
