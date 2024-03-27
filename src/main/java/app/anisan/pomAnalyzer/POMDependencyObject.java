package app.anisan.pomAnalyzer;

import java.util.ArrayList;
import java.util.List;

public class POMDependencyObject {

	private String				groupID			= null;
	private String				artiefectID		= null;
	private String				latestVersion	= null;
	private String				currentVersion	= null;
	private List<Vulnerability>	vulnerabilities	= new ArrayList<Vulnerability>();

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

	public List<Vulnerability> getVulnerabilities() {
		if(vulnerabilities == null) {
			vulnerabilities	= new ArrayList<Vulnerability>();
		}
		return vulnerabilities;
	}

	public void setVulnerabilities(List<Vulnerability> a_vulnerabilities) {
		vulnerabilities = a_vulnerabilities;
	}
}