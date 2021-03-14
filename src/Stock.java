import java.util.Scanner;

public class Stock {
    private String company_name;
    private String ticker;
    private String category;
    private Double price;
    private Double current_investment;

    public Stock()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter company name: ");
        this.company_name = scanner.nextLine();
        System.out.print("Please enter stock TICKER: ");
        this.ticker = scanner.nextLine();
        System.out.print("Please enter the stock's category: ");
        this.category = scanner.nextLine();
        System.out.print("Please ennter current $ invested in this stock: ");
        this.price = scanner.nextDouble();
    }
    public Stock(String cn, String tic, String cat, Double p)
    {
        this.company_name = cn;
        this.ticker = tic;
        this.category = cat;
        this.price = p;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
