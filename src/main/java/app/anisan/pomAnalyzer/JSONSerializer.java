package app.anisan.pomAnalyzer;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public final class JSONSerializer {

	public static void main(String[] args) throws Throwable {
		List<POMDependencyObject> dependencies = ParseMavenDependencyOutput.getPOMDependencies("D:\\eclipse-workspace\\pomAnalyzer\\dependency.txt");
		JSONArray jsonArray = new JSONArray(dependencies);
		System.out.println(jsonArray);
	}
	
	private static List<POMDependencyObject> getDummyDependencies(){
		List<POMDependencyObject> dummyDepencies = new ArrayList<POMDependencyObject>();
		
		return dummyDepencies;
	}
}