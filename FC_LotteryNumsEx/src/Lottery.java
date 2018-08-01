import ecs100.*;
import java.util.ArrayList;

//A lottery ticket has four to eight numbers on it in the range 1-99. 
//The order of the numbers matters. 
//The user should be able to get a random selection, 
//to replace a number, 
//to remove a number (shifting the ones afterwards downwards), 
//to insert a number (shifting the ones afterwards upwards to make space), 
//and to print out their current numbers.
//Use an array to store the currently-selected numbers. <<or arraylist?? - using arraylist
//Create a text interface using a Scanner and System.in to allow the user to manipulate the numbers.

public class Lottery {


	private ArrayList<Integer> numbers=new ArrayList<>();
	
	public Lottery(int num) {
		for(int i=0;i<num;i++) {
			int temp=randNum();
			while(!checkNum(temp)) {
				temp=randNum();
			}
			numbers.add(temp);
		}
	}
	
	public int randNum() {
		int rand=(int)(Math.random()*99)+1;
		return rand;
	}
	
	public void printNums() {
		UI.println("Lottery Numbers:");
		for(int i=0;i<this.numbers.size();i++) {
			//System.out.println(this.numbers.get(i));
			UI.println(this.numbers.get(i));
		}
	}
	
	public boolean checkNum(int num) {
		for(int i=0;i<numbers.size();i++) {
			if(numbers.get(i)==num) {
				return false;
			}
		}
		return true;
	}
	
	public void replaceNum(int out, int in) {
		for(int i=0;i<numbers.size();i++) {
			if(numbers.get(i)==out) {
				numbers.set(i, in);
				break;
			}
		}
		
	}
	
	public void removeNum(int out) {
		//if(i>0 && i<numbers.size()) {
		//	for(int j=0;j<numbers.size();j++) {
		//		if(numbers.get(j)==i) {
		//			numbers.remove(j);
		//			break;
		//		}
		//	}
		//}
		
		for(int i=0;i<numbers.size();i++) {
			if(numbers.get(i)==out) {
				numbers.remove(i);
				break;
			}
		}
	}
	
	public void insertNum(int num, int i) {
		if(i>0 && i<numbers.size()) {
			numbers.add(i,num);
		}
	}
	
	public void addRandNum() {
		int temp=randNum();
		while(!checkNum(temp)) {
			temp=randNum();
		}
		numbers.add(temp);
	}
}
