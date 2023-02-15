package service;


import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;


import com.google.gson.Gson;


import model.convert;


public class ViaConvert {
   
    public convert getMoeda(String value) throws ClientProtocolException, IOException {
    	  convert convert = null;
          
    	  String url = "";
    	  
    	  switch (value) {
		case "1":
			url = "https://economia.awesomeapi.com.br/json/last/USD-BRL";
			break;
		
		case "2":
			url = "https://economia.awesomeapi.com.br/json/last/EUR-BRL";  
			break;
			
		case "3":
			url = "https://economia.awesomeapi.com.br/json/last/BTC-BRL";
			break;
		
		default:
			break;
		}
    	  
    	  HttpGet request = new HttpGet(url);
         
          try(CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
                 
                  CloseableHttpResponse response = httpClient.execute(request)) {
             
              HttpEntity entity = response.getEntity();
             
              if(entity != null) {
                 
                  String result = EntityUtils.toString(entity);
                 
                  Gson gson = new Gson();
                 
                  convert = gson.fromJson(result, convert.class);
              }
          }
         
          return convert;
      }
  }
   
