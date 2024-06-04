package threading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Product {
	private final String name;
	private final int code;
	
	private final List<String> ingredients;
	
	public Product(String name, int code, List<String> ingredients) {
		this.name = name;
		this.code = code;
		//We will create new object of ingredients and store it because
		//otherwise the caller will have the reference of ingredients
		//and will be able to update it anytime which is wrong
		this.ingredients = new ArrayList<String>(ingredients);
		//Why can't u do this? - Because it provides a read only version of the og list
		//If og list is changed (carIngredients), then this also gets changed because reference is the same
		//this.ingredients = Collections.unmodifiableList(ingredients);
	}
	
	public String getName() {
		return name;
	}
	
//	public void setName(String name) {
//		this.name = name;
//	}
	
	public int getCode() {
		return code;
	}
	
//	public void setCode(int code) {
//		this.code = code;
//	}
	
	//Do not return reference, return new ArrayList
	public List<String> getIngredients() {
		//Return unmodifiable list. In this way if the caller tries to update the list, it will throw an error.
		return Collections.unmodifiableList(ingredients);
	}
	
//	public void setIngredients(List<String> ingredients) {
//		this.ingredients = ingredients;
//	}
}
