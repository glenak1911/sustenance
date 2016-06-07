package sustenanceSrc;

import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.*;
import java.util.List;
import java.util.Map;
import org.json.*;

public class Main {

	public static void main(String[] args) {
		try {
			HttpResponse<JsonNode> response = Unirest.get("https://spoonacular-recipe-food-nutrition-v1.p.mashape.com/recipes/findByIngredients?fillIngredients=false&ingredients=apples%2Cflour%2Csugar&limitLicense=false&number=5&ranking=1")
					.header("X-Mashape-Key", "yyss38ddAYmshKSQkToaZnu7Qd9Yp1OGXDfjsnpDe333h6xtq5")
					.header("Accept", "application/json")
					.asJson();
			
			JSONObject json = new JSONObject(response.getBody());
			System.out.print(json.toString(4));
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
