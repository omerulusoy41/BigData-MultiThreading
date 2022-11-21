import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Factory {
	private List<String> allRows;
	
	public Factory() {
		try {
			readAllRows();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String getSelectedIDRow(int ID) {
		return  allRows.stream()
				.filter(line -> ID == Integer.parseInt(line.split(",")[5]))
				.findAny()
				.orElse(null);
	}
	private void readAllRows() throws Exception{
		allRows = new ArrayList();
		BufferedReader reader = new BufferedReader(new FileReader("clean.csv"));
		String row;
		while ((row = reader.readLine()) != null) 
			if (!row.isEmpty())
				allRows.add(row);	
		reader.close();
	}
	public List<String> getAllRows(){
		return allRows;
	}
	public static float controlRows(String row1 , String row2,int coloumn) {
		String[] wordOfRow1 = row1.split(",")[coloumn].toLowerCase(Locale.ENGLISH).split(" ");
		String[] wordOfRow2 = row2.split(",")[coloumn].toLowerCase(Locale.ENGLISH).split(" ");
		int same = 0 ;
		if(wordOfRow1.length >= wordOfRow2.length) {
			for(int x =0;x<wordOfRow1.length;x++)
				for (int y=0;y<wordOfRow2.length;y++) 
					if(wordOfRow1[x].equals(wordOfRow2[y])) {
						same++;
						break;
					}
		}
		else {
			for(int x =0;x<wordOfRow1.length;x++)
				for (int y=0;y<wordOfRow2.length;y++) 
					if(wordOfRow1[x].equals(wordOfRow2[y])) {
						same++;
						break;
					}
		}
		return (wordOfRow1.length > wordOfRow2.length) ? ((float)same / wordOfRow1.length)*100 : ((float)same / wordOfRow2.length)*100;
	}
}
