package application;

import java.text.ParseException;
import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.ENGLISH);
        Scanner input = new Scanner(System.in);
        List<Product> list = new ArrayList<>();
            System.out.println("Enter the number of products: ");
            int n = input.nextInt();

            for (int i = 0; i < n; i++) {
                System.out.println("Product #" + (i + 1) + "data");
                System.out.println("Common, used or imported (c/u/i)?");
                char response = input.next().charAt(0);
                System.out.println("Name: ");
                input.nextLine();
                String name = input.nextLine();
                System.out.println("Price: ");
                double price = input.nextDouble();

                if (response == 'c')
                    list.add(new Product(name,price));
                else if (response == 'u') {
                    System.out.print("manufacture Date (DD/MM/YYYY): ");
                    input.nextLine();
                    LocalDate date = LocalDate.parse(input.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    list.add(new UsedProduct(name, price, date));
                }else {
                    System.out.println("Custom Fee:");
                    double custom = input.nextDouble();
                    list.add(new ImportedProduct(name, price, custom));
                }
            }
        System.out.println("PRICE TAGS: ");
        for (Product tags: list
             ) {
            System.out.println(tags.priceTag());
            
        }
    }
}
