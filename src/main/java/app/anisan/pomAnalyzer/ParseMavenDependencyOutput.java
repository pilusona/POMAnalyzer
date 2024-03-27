package app.anisan.pomAnalyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public final class ParseMavenDependencyOutput {
	
	public static void main(String[] args) throws Throwable {
		System.out.println("ParseMavenDependencyOutput.main()\n");
		
		List<POMDependencyObject> dependencies = ParseMavenDependencyOutput.getPOMDependencies("D:\\eclipse-workspace\\pomAnalyzer\\dependency.txt");
		
		for(POMDependencyObject pomDependency : dependencies) {
			VersionUpdater.updateLatestVersion(pomDependency);
		}
		
//		for(POMDependencyObject pomDependency : dependencies) {
//			VulnerabilityUpdater.updateVulnerabilities(pomDependency);
//		}
		
		System.out.println("\n\n"+dependencies);
	}
	
	public static List<POMDependencyObject> getPOMDependencies(String a_strFilePath) throws Throwable{
		List<POMDependencyObject> returnObject = new ArrayList<POMDependencyObject>();
		BufferedReader reader = new BufferedReader(new FileReader(a_strFilePath));
		String line = reader.readLine();
		boolean isHeadFound = false;
		
		while (line != null) {
			
			if(line.toLowerCase().contains("The following files have been resolved".toLowerCase())) {
				isHeadFound = true;
				line = reader.readLine();
				continue;
			}
			
			if(isHeadFound && line.toLowerCase().trim().equalsIgnoreCase("[INFO]".toLowerCase())) {
				break;
			}
			
			if(isHeadFound) {
				line = line.substring("[INFO]    ".length());
				returnObject.add(getPOMDependencyObject(line));
				
				//System.out.println(line);
			}
			
			line = reader.readLine();
		}

		reader.close();
		return returnObject;
	}
	
	private static POMDependencyObject getPOMDependencyObject(String a_strLine) {
		POMDependencyObject pomDependency = new POMDependencyObject();
		String[] strParts = a_strLine.split(":");
		pomDependency.setGroupID(strParts[0]);
		pomDependency.setArtiefectID(strParts[1]);
		pomDependency.setCurrentVersion(strParts[3]);
		return pomDependency;
	}
}