import java.util.ArrayList;
import java.util.Iterator;


/**
 * A simple model of an auction.
 * The auction maintains a list of lots of arbitrary length.
 *
 * @author David J. Barnes and Michael KÃ¶lling.
 * @version 2011.07.31
 */
public class Auction
{
    // The list of Lots in this auction.
    private ArrayList<Lot> lots;
    // The number that will be given to the next lot entered
    // into this auction.
    private int nextLotNumber;

    /**
     * Create a new auction.
     */
    public Auction()
    {
        lots = new ArrayList<Lot>();
        nextLotNumber = 1;
    }

    /**
     * Enter a new lot into the auction.
     * @param description A description of the lot.
     */
    public void enterLot(String description)
    {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }

    /**
     * Show the full list of lots in this auction.
     */
    public void showLots()
    {
        for(Lot lot : lots) {
            System.out.println(lot.toString());
        }
    }

    /**
     * Make a bid for a lot.
     * A message is printed indicating whether the bid is
     * successful or not.
     * 
     * @param lotNumber The lot being bid for.
     * @param bidder The person bidding for the lot.
     * @param value  The value of the bid.
     */
    public void makeABid(int lotNumber, Person bidder, long value)
    {
        Lot selectedLot = getLot(lotNumber);
        if(selectedLot != null) {
            boolean successful = selectedLot.bidFor(new Bid(bidder, value));
            if(successful) {
                System.out.println("The bid for lot number " +
                    lotNumber + " was successful.");
            }
            else {
                // Report which bid is higher.
                System.out.println("Lot number: " + 
                    lotNumber +
                    " already has a bid of: " +
                    selectedLot.getHighestBid().getValue());
            }
        }
    }

   

    /**
     * mostra los detalles de todos los items que se estén subastando
     */

    public void close()
    {

        for (Lot lot : lots)
        {

            System.out.println(lot.toString());
            if(lot.getHighestBid() != null)
            {
                System.out.println("Bidder: " + lot.getHighestBid().getBidder().getName());
            }
        }
    }

    /**
     * devuelva una colección de todos los items 
     * por los que no habido ninguna puja en este momento y no imprima nada por pantalla.
     */
    public ArrayList getUnsold()
    {
        ArrayList<Lot> noBidLot = new ArrayList<>();
        for (Lot lot : lots)
        {
            if(lot.getHighestBid() == null) 
            {
                noBidLot.add(lot);
            }
        }
        return noBidLot;
    }

    public void removeLot(int idNumber)
    {

    }

}
