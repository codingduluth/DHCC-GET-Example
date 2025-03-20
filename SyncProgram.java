import java.io.BufferedReader;  // Import BufferedReader for reading input streams.
import java.io.InputStreamReader;  // Import InputStreamReader to convert byte stream into character stream.
import java.net.HttpURLConnection;  // Import HttpURLConnection to make an HTTP connection.
import java.net.URL;  // Import URL to represent the URL of the API.

public class MyProgram {
    public static void main(String[] args) {
        // Define the API URL to fetch weather data for a specific latitude and longitude.
        String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=34.0029&longitude=-84.1446&current_weather=true&temperature_unit=fahrenheit";
        
        try {
            // Create a URL object using the specified API URL string.
            URL url = new URL(apiUrl);
            
            // Open a connection to the URL and cast it to HttpURLConnection.
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            // Set the HTTP request method to GET (to fetch data).
            conn.setRequestMethod("GET");

            // Create a BufferedReader to read the response from the input stream.
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            // Variable to hold each line of the response.
            String inputLine;
            
            // StringBuilder to accumulate the entire response.
            StringBuilder response = new StringBuilder();

            // Read each line from the BufferedReader and append it to the response.
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();  // Close the BufferedReader after reading the response.

            // Print the full JSON response received from the API.
            System.out.println("Response: " + response.toString());
        } catch (Exception e) {
            // If an exception occurs, print the stack trace for debugging.
            e.printStackTrace();
        }
    }
}
