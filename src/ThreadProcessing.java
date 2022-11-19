import java.util.ArrayList;
import java.util.List;

public class ThreadProcessing{
	private List<String> result;
	private List<Double> timesResult;
	private List<String> allLines;
	public ThreadProcessing(List<String> allLines) {
		this.allLines = allLines;
		result = new ArrayList<>();
		timesResult = new ArrayList<>();
	}
	public void scenario1And4(int numberOfThread,int coloumn,int ratio) {
		result.clear();
		timesResult.clear();
		List<ThreadScenario> allThread = new ArrayList<>();
		for(int indis = 0 ; indis < numberOfThread;indis++) 
			allThread.add(new ThreadScenario(allLines,indis,numberOfThread,coloumn,0,0,ratio,1,""));
		for(ThreadScenario thread : allThread)
			thread.start();
		while(true) {
			int cont = 0;
			for(ThreadScenario thread : allThread)
				if(thread.isAlive())
					cont = 1;
			if(cont == 0)
				break;
		}
		for(ThreadScenario thread : allThread) {
			timesResult.add(thread.duration);
			for(String row : thread.result)
				if(!result.contains(row))
					result.add(row);
		}
	}
	public void scenario2(int numberOfThread,int coloumn1,int coloumn2,int coloumn3,int ratio) {
		result.clear();
		timesResult.clear();
		List<ThreadScenario> allThread = new ArrayList<>();
		for(int indis = 0 ; indis < numberOfThread;indis++) 
			allThread.add(new ThreadScenario(allLines,indis,numberOfThread,coloumn1,coloumn2,coloumn3,ratio,2,""));
		for(ThreadScenario thread : allThread)
			thread.start();
		while(true) {
			int cont = 0;
			for(ThreadScenario thread : allThread)
				if(thread.isAlive())
					cont = 1;
			if(cont == 0)
				break;
		}
		for(ThreadScenario thread : allThread) {
			timesResult.add(thread.duration);
			for(String row : thread.result)
				if(!result.contains(row))
					result.add(row);
		}
	}
	public void scenario3(int numberOfThread,int coloumn,int ratio,String selectedRow) {
		result.clear();
		timesResult.clear();
		List<ThreadScenario> allThread = new ArrayList<>();
		for(int indis = 0 ; indis < numberOfThread;indis++) 
			allThread.add(new ThreadScenario(allLines,indis,numberOfThread,coloumn,0,0,ratio,3,selectedRow));
		for(ThreadScenario thread : allThread)
			thread.start();
		while(true) {
			int cont = 0;
			for(ThreadScenario thread : allThread)
				if(thread.isAlive())
					cont = 1;
			if(cont == 0)
				break;
		}
		for(ThreadScenario thread : allThread) {
			timesResult.add(thread.duration);
			for(String row : thread.result)
				if(!result.contains(row))
					result.add(row);
		}
	}
	public List<String> getResult(){
		return result;
	}
	public List<Double> getTimesResult(){
		return timesResult;
	}
}
