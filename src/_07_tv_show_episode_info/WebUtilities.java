package _07_tv_show_episode_info;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class WebUtilities {
	public static String[] parseJSONArray(String json) {
		ArrayList<String> obs = new ArrayList<String>();
		
		for(int i = 0; i < json.length(); i++) {
			char c = json.charAt(i);
			if(c == '{') {
				String v = "" + c;
				int ctr = 0;
				while(true) {
					i++;
					c = json.charAt(i);
					v += c;
					if(c == '}' && ctr == 0) {
						break;
					}else if(c == '}') {
						ctr--;
					}else if(c == '{') {
						ctr++;
					}
				}
				obs.add(v);
			}
		}
		
		return obs.toArray(new String[obs.size()]);
	}
	
	public static String getStringFromInputStream(InputStream in) {
		String res = "";
		int c;
		try {
			c = in.read();
			while(c != -1) {
				res += (char)c;
				c = in.read();
			}
			in.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
		return res;
	}
	
	public static int getIntFromJSONObject(String json, String key) {
		String num = "";
		
		for(int i = 1; i < json.length() - key.length() - 1; i++) {
			if(json.substring(i - 1, i + key.length() + 1).equals("\"" + key + "\"")) {
				int j = i + key.length() + 1;
				char d = json.charAt(j);
				while(d != ',') {
					if(Character.isDigit(d)) {
						num += d;
					}
					j++;
					d = json.charAt(j);
				}
				break;
			}
		}	
		
		return Integer.parseInt(num);
	}
	
	public static int getShowId(String show){
		try {
			URL url = new URL("https://api.tvmaze.com/singlesearch/shows?q=" + show);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			InputStream responseStream = connection.getInputStream();
			String in = getStringFromInputStream(responseStream);
			int id = getIntFromJSONObject(in, "id");
			responseStream.close();
			return id;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}
