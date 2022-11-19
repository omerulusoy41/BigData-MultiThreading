import java.util.ArrayList;
import java.util.List;

public class ThreadScenario extends Thread{
	private int threadID;
	private int threadCount;
	private int coloumn;
	private int coloumn2;
	private int coloumn3;
	private int iterOfThreadLine;
	private List<String> allRows;
	private int scenario;
	private String row;
	private int ratio;
	public List<String> result = new ArrayList<>();
	public double duration;
	public ThreadScenario(List<String> allRows,int threadID, int threadCount, int coloumn,
			int coloumn2,int coloumn3,int ratio,int scenario,String row) {
		this.allRows = allRows;
		this.threadID = threadID;
		this.threadCount = threadCount;
		this.iterOfThreadLine = allRows.size() / threadCount;
		this.coloumn = coloumn;
		this.coloumn2 = coloumn2;
		this.coloumn3 = coloumn3;
		this.ratio = ratio;
		this.scenario = scenario;
		this.row = row;
	}

	@Override
	public void run() {
		double first = System.currentTimeMillis();
		iter();
		duration = (System.currentTimeMillis() - first)/1000.0;
	}

	private void iter() {
		int start = threadID * iterOfThreadLine;
		int finish = start + iterOfThreadLine;
		if (threadID + 1 == threadCount)
			finish = allRows.size();
		float value;
		if(scenario == 1) {
			for(int j = start ;j < finish ;j++) 
				for(int x = j + 1 ;x < allRows.size(); x++)
					if(ratio < (value = Factory.controlRows(allRows.get(j),allRows.get(x),coloumn))) {
						String add = allRows.get(j).split(",")[coloumn]
								+ " - " + allRows.get(x).split(",")[coloumn] +
								" - Ratio = "+value;
						if(!result.contains(add))
							result.add(add);
					}
		}
		else if(scenario == 2) {
			for(int j = start ;j < finish ;j++) 
				for(int x = j + 1 ;x < allRows.size(); x++)
					if(Factory.controlRows(allRows.get(j),allRows.get(x),coloumn) == 100)
					if(ratio < (value = Factory.controlRows(allRows.get(j),allRows.get(x),coloumn2))) {
						String add = allRows.get(j).split(",")[coloumn] + " - "+
								allRows.get(x).split(",")[coloumn] + " - "
								+allRows.get(j).split(",")[coloumn2] + " - "+
								allRows.get(x).split(",")[coloumn2] + " - "+
								allRows.get(j).split(",")[coloumn3] + " - " 
								+ allRows.get(x).split(",")[coloumn3] +" - Ratio = "
								+value;
						if(!result.contains(add))
							result.add(add);
					}
		}
		else {
			for(int j = start ;j < finish ;j++) 
				if(ratio < (value = Factory.controlRows(row,allRows.get(j),coloumn))) {
					String add = row.split(",")[coloumn] + " - "+ allRows.get(j).split(",")[coloumn] + " - Ratio = "+value;
					if(!result.contains(add))
						result.add(add);
				}
		}
	}
}
