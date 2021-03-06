package behavior.observer;


import java.util.ArrayList;
import java.util.Iterator;


interface Subject
{
	public void registerObserver(Observer o);
	public void unregisterObserver(Observer o);
	public void notifyObservers();
}

class CricketData1 implements Subject
{
	int runs;
	int wickets;
	float overs;
	ArrayList<Observer> observerList;

	public CricketData1() {
		observerList = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(Observer o) {
		observerList.add(o);
	}

	@Override
	public void unregisterObserver(Observer o) {
		observerList.remove(observerList.indexOf(o));
	}

	@Override
	public void notifyObservers()
	{
		for (Iterator<Observer> it =
			observerList.iterator(); it.hasNext();)
		{
			Observer o = it.next();
			o.update(runs,wickets,overs);
		}
	}

	// get latest runs from stadium
	private int getLatestRuns()
	{
		// return 90 for simplicity
		return 90;
	}

	// get latest wickets from stadium
	private int getLatestWickets()
	{
		// return 2 for simplicity
		return 2;
	}

	// get latest overs from stadium
	private float getLatestOvers()
	{
		// return 90 for simplicity
		return (float)10.2;
	}

	// This method is used update displays
	// when data changes
	public void dataChanged()
	{
		//get latest data
		runs = getLatestRuns();
		wickets = getLatestWickets();
		overs = getLatestOvers();

		notifyObservers();
	}
}


interface Observer
{
	public void update(int runs, int wickets,
					float overs);
}

class AverageScoreDisplay implements Observer
{
	private float runRate;
	private int predictedScore;

	public void update(int runs, int wickets,
					float overs)
	{
		this.runRate =(float)runs/overs;
		this.predictedScore = (int)(this.runRate * 50);
		display();
	}

	public void display()
	{
		System.out.println("\nAverage Score Display: \n"
						+ "Run Rate: " + runRate +
						"\nPredictedScore: " +
						predictedScore);
	}
}

class CurrentScoreDisplay implements Observer
{
	private int runs, wickets;
	private float overs;

	public void update(int runs, int wickets,
					float overs)
	{
		this.runs = runs;
		this.wickets = wickets;
		this.overs = overs;
		display();
	}

	public void display()
	{
		System.out.println("\nCurrent Score Display:\n"
						+ "Runs: " + runs +
						"\nWickets:" + wickets +
						"\nOvers: " + overs );
	}
}

//Driver Class
class Main
{
	public static void main(String args[])
	{

		AverageScoreDisplay averageScoreDisplay =
						new AverageScoreDisplay();
		CurrentScoreDisplay currentScoreDisplay =
						new CurrentScoreDisplay();

		// pass the displays to Cricket data
		CricketData1 cricketData = new CricketData1();

		// register display elements
		cricketData.registerObserver(averageScoreDisplay);
		cricketData.registerObserver(currentScoreDisplay);

		// in real app you would have some logic to
		// call this function when data changes
		cricketData.dataChanged();

		//remove an observer
		cricketData.unregisterObserver(averageScoreDisplay);

		// now only currentScoreDisplay gets the
		// notification
		cricketData.dataChanged();
	}
}
