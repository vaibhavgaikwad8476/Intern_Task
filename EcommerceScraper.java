import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;

public class EcommerceScraper {
    public static void main(String[] args) {
        String url = "https://example.com/products"; // Replace with actual e-commerce URL

        try {
            Document doc = Jsoup.connect(url).get();
            Elements products = doc.select(".product-item"); // Adjust selector based on website structure
            
            FileWriter csvWriter = new FileWriter("products.csv");
            csvWriter.append("Name,Price,Rating\n");
            
            for (Element product : products) {
                String name = product.select(".product-title").text(); // Adjust selector
                String price = product.select(".product-price").text(); // Adjust selector
                String rating = product.select(".product-rating").text(); // Adjust selector
                
                csvWriter.append(String.format("%s,%s,%s\n", name, price, rating));
            }
            
            csvWriter.flush();
            csvWriter.close();
            
            System.out.println("Data scraped and saved to products.csv");
        } catch (IOException e) {
            System.out.println("Error fetching or saving data: " + e.getMessage());
        }
    }
}