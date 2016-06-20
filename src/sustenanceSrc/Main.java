package sustenanceSrc;

import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.json.*;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {	
		Scanner reader = new Scanner(System.in);
		System.out.println("What ingredients do you want to use Boss?");
		String ingredients = reader.next();
		ingredients = ingredients.replace(",", "%2C");
		findByIngredients(ingredients);

		
	}
	
	public static void findByIngredients(String ingredients){
		try {
			HttpResponse<JsonNode> response = Unirest.get("https://spoonacular-recipe-food-nutrition-v1.p.mashape.com/recipes/findByIngredients?fillIngredients=false&ingredients="+ingredients+"&limitLicense=false&number=5&ranking=1")
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


