package managers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IOManager {
	public static StringBuilder sb;
	public static BufferedWriter bw;
	public static BufferedReader br;

	private IOManager() {
		sb = new StringBuilder();
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	private static IOManager instance = new IOManager();

	public static IOManager getInstance() {
		return instance;
	}

	public static void printString(String msg) {
		sb.setLength(0);
		sb.append(msg);
		try {
			bw.append(sb);
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String inputString(String msg) {
		sb.setLength(0);
		sb.append(msg);
		try {
			bw.append(sb);
			bw.flush();
			String input = br.readLine();
			return input;
		} catch (IOException e) {
			return "";
		}
	}
}