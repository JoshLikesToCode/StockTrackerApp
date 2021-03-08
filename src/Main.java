import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {
    private static final StockList stock_list = new StockList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many companies would you like to enter?");
        int loop = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < loop; i++)
        {
            stock_list.add();
        }

        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();

        for(int i = 0; i < stock_list.getStock_list().size(); i++)
        {
            pieData.add(new PieChart.Data(stock_list.getStock_list().get(i).getCompany_name(), stock_list.getStock_list().get(i).getPrice()));
        }

        PieChart pChart = new PieChart(pieData);
        pChart.setData(pieData);
        Group root = new Group(pChart);
        Scene scene = new Scene(root);
        primaryStage.setTitle("Portfolio sorted by company");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}



