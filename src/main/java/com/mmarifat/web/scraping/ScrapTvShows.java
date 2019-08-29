package com.mmarifat.web.scraping;

import java.io.IOException;
import java.util.HashMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author mmarifat
 */
public class ScrapTvShows {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        //un-comment this to connect and saved into database
        //Connector connector = new Connector();

        try {
            //page handle
            for (int i = 1; i <= 100; i++) {
                final Document d = Jsoup.connect("https://psarips.eu/category/tv-show/page/" + i).get();
                System.out.println("Page no: " + i);
                Elements ele = d.select("div#grid-wrapper");
                int j = 1;
                for (Element element : ele.select("div.post-inner")) {
                    System.out.println("Element no: " + j++);
                    Elements Name = element.select("h2.post-title a[title]");
                    Elements Category = element.select("p.post-category");
                    Elements Description = element.select("div.entry");
                    Elements Author = element.select("p.post-byline a[rel]");
                    Elements UploadDate = element.select("p.post-byline");
                    Elements Link = element.select("h2.post-title a[href]");
                    Elements Img = element.select("img.attachment-thumb-medium");

                    System.out.println("Tv Show Name: " + Name.text() + "\nCategory: " + Category.text() + "\nDescription: " + Description.text() + "\nAuthor: " + Author.text() + "\nUpload Date: " + UploadDate.text().split("\\·")[2] + "\nLink: " + Link.attr("href") + "\nImage: https://psarips.net" + Img.attr("src"));

//un-comment this to connect and saved into database
                    
//                    HashMap<String, Object> whereScrap = new HashMap<>();
//                    whereScrap.put("link", Link.attr("href"));
//                    if (connector.countRow("scrapedData", whereScrap) == 0) {
//                        HashMap<String, Object> whereCustomer = new HashMap<>();
//                        whereCustomer.put("name", Name.text());
//                        whereCustomer.put("category", Category.text());
//                        whereCustomer.put("description", Description.text());
//                        whereCustomer.put("author", Author.text());
//                        whereCustomer.put("uploadDate", UploadDate.text().split("\\·")[2]);
//                        whereCustomer.put("link", Link.attr("href"));
//                        whereCustomer.put("image", "https://psarips.eu" + Img.attr("src"));
//                        connector.insert("scrapedData", whereCustomer);
//                        System.out.println(connector.countRow("scrapedData", whereScrap));
//                        System.out.println("Data added successfully");
//                    } else {
//                        System.out.println("Duplicate found.");
//                    }
                    System.out.println();
                }
            }
        } catch (IOException e) {
        }
    }
}
