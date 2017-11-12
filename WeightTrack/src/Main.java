import java.io.File;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
import org.apache.http.entity.FileEntity;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class Main

{
    // **********************************************
    // *** Update or verify the following values. ***
    // **********************************************
    // Replace the subscriptionKey string value with your valid subscription key.
    public static final String subscriptionKey = "e3c3a3b18a3a44058eca3fcd458dd0e4";

    // Replace or verify the region.
    //
    // You must use the same region in your REST API call as you used to obtain your subscription keys.
    // For example, if you obtained your subscription keys from the westus region, replace
    // "westcentralus" in the URI below with "westus".
    //
    // NOTE: Free trial subscription keys are generated in the westcentralus region, so if you are using
    // a free trial subscription key, you should not need to change this region.
    public static final String uriBase = "https://southcentralus.api.cognitive.microsoft.com/customvision/v1.0/Prediction/c34c8a8b-2053-47b1-8a94-0c02f72236e4/image?iterationId=ee835b28-7f5d-4722-8856-721d87f0e2d2";
	    
    private static String s;
	    
    public static String get(){
    	return s;
    }


    public static String getter(File f)
    {
        HttpClient httpclient = new DefaultHttpClient();

        try
        {
            URIBuilder builder = new URIBuilder(uriBase);

            // Request parameters. All of them are optional.
            builder.setParameter("visualFeatures", "Categories,Description,Color");
            builder.setParameter("language", "en");

            // Prepare the URI for the REST API call.
            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);

	        // Request headers.
            request.setHeader("Content-Type", "application/octet-stream");
            request.setHeader("Prediction-Key", subscriptionKey);
            
            // Request body.
            File img = f;
            FileEntity reqEntity = new FileEntity(img);
            request.setEntity(reqEntity);

            // Execute the REST API call and get the response entity.
            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null)
            {
                // Format and display the JSON response.
                String jsonString = EntityUtils.toString(entity);
                JSONObject json = new JSONObject(jsonString);
                s = json.toString(2);
                //System.out.println("REST Response:\n");
                System.out.println(json.toString(2));
                
            }
        }
        catch (Exception e)
        {
            // Display error message.
            System.out.println(e.getMessage());
        }
        return s;
    }
}

