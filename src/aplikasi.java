import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import model.respon;
import org.json.JSONArray;
import org.json.JSONObject;

public class aplikasi {
    public static void main(String[] args) {
        String urlStr = "https://dummyjson.com/products/category/smartphones";
        String consID = "harber123";
        String userKey = "_tabc4XbR";
        try {
            // Mengirim permintaan HTTP GET ke URL
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-Cons-ID",  consID );
            connection.setRequestProperty("X-userkey",  userKey);

            // Menerima respon JSON
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();

            // Menampilkan data JSON sebelum diurutkan
            System.out.println("Data JSON sebelum diurutkan:");
            String jsonData = response.toString();
            JSONArray jsonArray = new JSONArray((jsonData));
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                System.out.println(jsonObject.toString());
            }

            // Mengurutkan data JSON menggunakan Selection Sort
            for (int i = 0; i < jsonArray.length() - 1; i++) {
                int index = i;
                for (int j = i + 1; j < jsonArray.length(); j++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(j);
                    JSONObject jsonObject2 = jsonArray.getJSONObject(index);
                    if (jsonObject1.getInt("id") < jsonObject2.getInt("id")) {
                        index = j;
                    }
                }
                if (index != i) {
                    JSONObject temp = jsonArray.getJSONObject(i);
                    jsonArray.put(i, jsonArray.getJSONObject(index));
                    jsonArray.put(index, temp);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}