package Service;


import java.io.IOException;


import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;


import com.google.gson.Gson;




public class CNPJ_Service {
   
    public testAPI getStatusCNPJ(String cnpj) throws ClientProtocolException, IOException {
       
        testAPI testapi = null;
       
        HttpGet request = new HttpGet("https://api-publica.speedio.com.br/buscarcnpj?cnpj="+cnpj);
       
        try(CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
               
                CloseableHttpResponse response = httpClient.execute(request)) {
           
            HttpEntity entity = response.getEntity();
           
            if(entity != null) {
               
                String result = EntityUtils.toString(entity);
               
                Gson gson = new Gson();
               
                testapi = gson.fromJson(result, testAPI.class);
            }
        }
       
        return testapi;
    }
}
