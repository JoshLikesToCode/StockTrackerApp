import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.*;

public class StockList {

    /* StockList's Array List */
    private final ArrayList<Stock> stock_list = new ArrayList<Stock>();

    /**
     * Getter for StockList's Array List
     * @return StockList's Array List
     */
    public ArrayList<Stock> getStock_list() {
        return stock_list;
    }

    /**
     * Method to add stock
     * @param stock is the stock you want to be added to array list
     */
    public void add(Stock stock)
    {
        stock_list.add(stock);
    }

    /**
     * Method to create a Stock object AND THEN add it to Array List
     */
    public void add()
    {
        Stock stock = new Stock();
        this.add(stock);
    }

    /**
     * Have the user give a company name, find the matching name from the StockList Array List
     * and then delete it, if it's there. Otherwise, return a friendly message telling the user
     * that the stock was not found.
     */
    public void delete()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the company name of the stock you wish to remove.");
        String company_name = scanner.nextLine();
        Iterator<Stock> iter = this.stock_list.iterator();
        while(iter.hasNext())
        {
            if(iter.next().getCompany_name().equals(company_name))
            {
                System.out.println(company_name + " was successfully removed.");
                iter.remove();
                return;
            }
        }
        System.out.println(company_name + " was not found in your list of current stocks.");
    }

    /**
     * Simple print method for the StockList Array List
     */
    public void print()
    {
        if(stock_list.isEmpty())
        {
            System.out.println("Your list is empty.");
            return;
        }
        System.out.println("=========================================");
        for (Stock value : stock_list) {
            System.out.println("Company: " + value.getCompany_name());
            System.out.println("Ticker: " + value.getTicker());
            System.out.println("Category: " + value.getCategory());
            System.out.println("Price: $" + value.getPrice());
        }
        System.out.println("=========================================");
    }


    public void sum_up_list() {
        double total_investment_price = 0.0;
        String most_invested_cat = "NULL";
        int cat_count = 0;

        Map<String, Integer> category_and_count = new HashMap<String, Integer>();
        /* Get the categories and their percentages */
        for (Stock value : stock_list) {
            category_and_count.merge(value.getCategory(), 1, Integer::sum);
            total_investment_price += value.getPrice();
        }

        for (Map.Entry<String, Integer> val : category_and_count.entrySet())
        {
            if(val.getValue() >= cat_count)
            {
                most_invested_cat = val.getKey();
                cat_count = val.getValue();
            }
        }

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String myCurrency = currency.format(total_investment_price);

        System.out.println("Total investments $" + myCurrency);
        System.out.println("The category I'm most invested in is " + most_invested_cat +
                " with " + cat_count + " stocks in this category.");

    }

    public int size() {
        return this.stock_list.size();
    }
}


