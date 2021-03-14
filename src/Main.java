import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main extends Application {
    private static final StockList stock_list = new StockList();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to do?");
        System.out.println("a) Make new stock list.");
        System.out.println("b) Load up last saved stock list.");

        char choice = scanner.next().charAt(0);
        if (choice == 'a' || choice == 'A') {
            System.out.println("How many companies would you like to enter?");
            int loop = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < loop; i++) {
                stock_list.add();
            }
            System.out.println("Would you like to save this list? Enter Y/N");
            char save = scanner.next().charAt(0);
            if(save == 'Y' || save == 'y')
            {
                stock_list.save();
            }

            Application.launch(args);
        }

        if(choice == 'b' || choice == 'B')
        {
            stock_list.load();
            //stock_list.sum_up_list();
            Application.launch(args);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("What PieChart do you want to see?");
        System.out.println("a) Companies to total investment ratio.");
        System.out.println("b) Categories to total investment ratio.");
        char choice = scanner.next().charAt(0);
        if(choice == 'a' || choice == 'A') {
            for (int i = 0; i < stock_list.getStock_list().size(); i++) {
                pieData.add(new PieChart.Data(stock_list.getStock_list().get(i).getCompany_name(), (stock_list.getStock_list().get(i).getPrice() / stock_list.get_total() )));
            }

            PieChart pChart = new PieChart(pieData);
            pChart.setData(pieData);
            Group root = new Group(pChart);
            Scene scene = new Scene(root);
            primaryStage.setTitle("Portfolio sorted by company");
            primaryStage.setScene(scene);
            primaryStage.show();
            return;
        }
        if(choice == 'b' || choice == 'B') {
            for (int i = 0; i < stock_list.getStock_list().size(); i++) {
                pieData.add(new PieChart.Data(stock_list.getStock_list().get(i).getCategory(), stock_list.getStock_list().get(i).getPrice() / stock_list.get_total()));
            }

            PieChart pChart = new PieChart(pieData);
            pChart.setData(pieData);
            Group root = new Group(pChart);
            Scene scene = new Scene(root);
            primaryStage.setTitle("Portfolio sorted by category");
            primaryStage.setScene(scene);
            primaryStage.show();
            return;
        }
    }
}



