import Models.AccountEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class IntegrationTesting {
    @Test
    public void addUserToDatabase() throws IOException {
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("http://localhost:8080/Login/");

// Request parameters and other properties.
        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setName("Test");
        accountEntity.setEmail("IntegrationTesting@gmail.com");
        ObjectMapper objectMapper=new ObjectMapper();
        String val =objectMapper.writeValueAsString(accountEntity);
        params.add(new BasicNameValuePair("p", val));

        httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
//Execute and get the response.
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            try (InputStream instream = entity.getContent()) {
                // do something useful
            }
        }
    }
}
