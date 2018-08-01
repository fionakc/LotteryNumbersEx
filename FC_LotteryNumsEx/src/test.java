import ecs100.UI;

//The user should be able to get a random selection, 
//to replace a number, 
//to remove a number (shifting the ones afterwards downwards), 
//to insert a number (shifting the ones afterwards upwards to make space), 
//and to print out their current numbers.
//Create a text interface using a Scanner and System.in to allow the user to manipulate the numbers.
public class test {

	private Lottery lot;
	public static void main(String[] args) {
		new test();		
	}
	
	public test() {	
		UI.initialise();
		
		UI.addButton("New random numbers", this::newNumbers);
		UI.addButton("Add random number", this::addNumber);
		UI.addButton("Replace number", this::replaceNumber);
		UI.addButton("Remove number", this::removeNumber);
		//Lottery lot1=new Lottery(4);
		//Lottery lot2=new Lottery(8);
		
		//lot1.printNums();
		//lot2.printNums();
		//newNumbers();
		//addNumber();
		UI.addButton("Quit", UI::quit);
	}
	
	public void newNumbers() {
		int temp=UI.askInt("How many numbers? ");
		while(temp<4 || temp>8) {
			UI.println("You should have between 4 and 8 numbers.");
			temp=UI.askInt("How many numbers? ");
		}
		lot=new Lottery(temp);
		lot.printNums();
	}
	
	public void addNumber() { ////need to impose limits to keep between 4 and 8
		lot.addRandNum();
		lot.printNums();
	}
	
	public void replaceNumber() {
		int out=UI.askInt("Which number do you want removed? ");
		int in=UI.askInt("What number do you want to go in?");
		while(!lot.checkNum(in)) {
			UI.println("Sorry, you can't enter that number");
			in=UI.askInt("What number do you want to go in?");
		}
		lot.replaceNum(out,in);
		lot.printNums();
	}
	
	public void removeNumber() { //need to impose limits to keep between 4 and 8
		int out=UI.askInt("Which number do you want removed? ");
		while(lot.checkNum(out)) {
			UI.println("Sorry, you can't remove that number");
			out=UI.askInt("What number do you want removed?");
		}
		lot.removeNum(out);
		lot.printNums();
	}
	
}
