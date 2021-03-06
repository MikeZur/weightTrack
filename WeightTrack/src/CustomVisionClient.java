import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CustomVisionClient {

    public static String get() throws Exception {
        String imageUrl = "https://www.aldi.us/fileadmin/_processed_/e/f/csm_Apples_D_01_4fc17d030f.jpg";
        String projectId = "SET_ME";
        String modelId = "SET_ME";
		String predictionKey = "";

        String postJsonResponse = classifyImage(imageUrl, projectId, modelId, predictionKey);

        return postJsonResponse;
    }

    private static String classifyImage(String imageUrl, String projectId, String modelId, String predictionKey) throws IOException {
        String predictionUrl = "https://southcentralus.api.cognitive.microsoft.com/customvision/v1.0/Prediction/c34c8a8b-2053-47b1-8a94-0c02f72236e4/image?iterationId=ee835b28-7f5d-4722-8856-721d87f0e2d2";
        HttpURLConnection connection = (HttpURLConnection) new URL(predictionUrl).openConnection();
        File pic = new File("Banana.jpg");
        
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/octet-stream");
        connection.setRequestProperty("Prediction-Key", predictionKey);
        connection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
        dataOutputStream.writeBytes("Banana.jpg");
        dataOutputStream.flush();
        dataOutputStream.close();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String output;
        StringBuffer response = new StringBuffer();
        while ((output = reader.readLine()) != null) {
            response.append(output);
        }
        reader.close();

        return response.toString();
    }
}
