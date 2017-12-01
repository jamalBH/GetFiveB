package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.E_hotel.dao.entites.Article_categorie;
import com.google.gson.Gson;


public class Test {

    private static final String USER_AGENT = null;



	public static void main(String... args) throws Exception {
    	
		Test t = new Test() ;
    	

        // Now do the magic.
        		Allmenus data = new Gson().fromJson(t.sendGet(), Allmenus.class);

        // Show it.
        System.out.println("tttttttttttttttt"+data.getMenus().get(0).getArticle_categorie().get(0).getArticle().get(0).getNom_article()); 
    }

    
    
    private String sendGet() throws Exception {

		String url = "http://localhost:8081/GetFive8/tt";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();


		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		//System.out.println(response.toString());
		return response.toString() ;

	}
}


