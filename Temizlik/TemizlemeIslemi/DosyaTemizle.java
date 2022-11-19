package deneme;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DosyaTemizle{
	public void temizle(){
		try (BufferedReader br = new BufferedReader(new FileReader("rows.csv"))) {
			String line;
			File file =new File("temiz.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file)); 
			while ((line = br.readLine()) != null) {
				String[] split =tirnakiciVeNoktalamaTemizle(line).split(",");
				if(split.length == 18 && split[1] != "" && split[3] != "" && split[7] !="" && split[8] != "" && split[9] != "" && split[17] != "") {
					String toplam ="";
					toplam += stopWordTemizle(split[1].toLowerCase(Locale.ENGLISH))+",";
					toplam += stopWordTemizle(split[3].toLowerCase(Locale.ENGLISH))+",";
					toplam += stopWordTemizle(split[7].toLowerCase(Locale.ENGLISH))+",";
					toplam += stopWordTemizle(split[8].toLowerCase(Locale.ENGLISH))+",";
					toplam += stopWordTemizle(split[9].toLowerCase(Locale.ENGLISH))+",";
					toplam += stopWordTemizle(split[17].toLowerCase(Locale.ENGLISH))+"\n";
					bw.write(toplam);
				}
			}
			bw.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	private  String tirnakiciVeNoktalamaTemizle(String line) {
		char[] arr = line.toCharArray();
		int i = 0;
		int kontrol = 0;
		if (line.indexOf("\"") == line.lastIndexOf("\""))
			kontrol=1;
		String x = "";
		while (i < arr.length) {
			if (kontrol == 0 && arr[i] == '\"') {
				i++;
				while (i < arr.length && arr[i] != '\"') {
					if (arr[i] == ',') {
						arr[i] = ' ';
					}
					else if (noktalama(arr[i])) {
						i++;
						continue;
					}
					x+=arr[i];
					i++;
				}
			}
			if (i == arr.length)
				break;
			if (noktalama(arr[i])) {
				i++;
				continue;
			}
			x+=arr[i];
			i++;
		}
		return x;
	}
	private  boolean noktalama(char c) {
		return (c == '.' || c=='?' || c == ':' || c == ';'
				|| c == '\"' || c == '('|| c == ')'
				|| c == '-'|| c == '_'|| c == '!'|| c=='/');
	}
	private String stopWordTemizle(String toplam) {
		List<String> stopWords;
		try {
			stopWords = Files.readAllLines(Paths.get("stopWords.txt"));
			ArrayList<String> allWords = Stream.of(toplam.split(" "))
	            .collect(Collectors.toCollection(ArrayList<String>::new));
			allWords.removeAll(stopWords);
			return allWords.stream().collect(Collectors.joining(" "));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	
}
