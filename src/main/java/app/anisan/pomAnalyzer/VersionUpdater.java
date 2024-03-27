package app.anisan.pomAnalyzer;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public final class VersionUpdater {
	public static void updateLatestVersion(POMDependencyObject a_POMDependencyObject) throws Throwable {
		CloseableHttpClient		httpClient	= HttpClients.custom().setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
				.build();

		HttpGet					request		= new HttpGet("https://search.maven.org/solrsearch/select" + "?q=g:"
				+ a_POMDependencyObject.getGroupID() + "%20AND%20a:" + a_POMDependencyObject.getArtiefectID()+"&wt=json");
		CloseableHttpResponse	response	= httpClient.execute(request);
//		System.out.println(response.getProtocolVersion()); // HTTP/1.1
//		System.out.println(response.getStatusLine().getStatusCode()); // 200
//		System.out.println(response.getStatusLine().getReasonPhrase()); // OK
//		System.out.println(response.getStatusLine().toString());

		if (response.getStatusLine().getStatusCode() == 200) {
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				// return it as a String
				String result = EntityUtils.toString(entity);
				JSONObject obj = new JSONObject(result);
				//System.out.println(result);
				String latestVersion = obj.getJSONObject("response").getJSONArray("docs").getJSONObject(0).getString("latestVersion");
				a_POMDependencyObject.setLatestVersion(latestVersion);
				System.out.println(a_POMDependencyObject);
			}
		}else {
			System.out.println(response.getStatusLine().getStatusCode()); // 200
			System.out.println(response.getStatusLine().getReasonPhrase()); // OK
			System.out.println(response.getStatusLine().toString());
		}
	}
}