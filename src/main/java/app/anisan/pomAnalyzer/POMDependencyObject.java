package app.anisan.pomAnalyzer;

import java.util.ArrayList;
import java.util.List;

public class POMDependencyObject {

	private String				groupID			= null;
	private String				artiefectID		= null;
	private String				latestVersion	= null;
	private String				currentVersion	= null;
	private List<Vulnerability>	directVulnerabilities	= new ArrayList<Vulnerability>();
	private List<Vulnerability>	dependentVulnerabilities	= new ArrayList<Vulnerability>();

	public String getGroupID() {
		return groupID;
	}

	public void setGroupID(String a_groupID) {
		groupID = a_groupID;
	}

	public String getArtiefectID() {
		return artiefectID;
	}

	public void setArtiefectID(String a_artiefectID) {
		artiefectID = a_artiefectID;
	}

	public String getLatestVersion() {
		return latestVersion;
	}

	public void setLatestVersion(String a_latestVersion) {
		latestVersion = a_latestVersion;
	}

	public String getCurrentVersion() {
		return currentVersion;
	}

	public void setCurrentVersion(String a_currentVersion) {
		currentVersion = a_currentVersion;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{groupID : " + groupID);
		sb.append(", artiefectID : " + artiefectID);
		sb.append(", currentVersion : " + currentVersion);
		sb.append(", latestVersion : " + latestVersion);
		sb.append("}");
		return sb.toString();
	}

	public List<Vulnerability> getDirectVulnerabilities() {
		if(directVulnerabilities == null) {
			directVulnerabilities	= new ArrayList<Vulnerability>();
		}
		return directVulnerabilities;
	}

	public void setDirectVulnerabilities(List<Vulnerability> a_vulnerabilities) {
		directVulnerabilities = a_vulnerabilities;
	}
	

	public List<Vulnerability> getDependentVulnerabilities() {
		if(dependentVulnerabilities == null) {
			dependentVulnerabilities	= new ArrayList<Vulnerability>();
		}
		return dependentVulnerabilities;
	}

	public void setDependentVulnerabilities(List<Vulnerability> a_vulnerabilities) {
		dependentVulnerabilities = a_vulnerabilities;
	}
}