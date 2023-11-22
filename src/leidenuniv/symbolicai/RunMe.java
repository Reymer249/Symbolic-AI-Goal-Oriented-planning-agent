package leidenuniv.symbolicai;

import java.io.File;
import java.util.Scanner;
import java.util.HashMap;

import leidenuniv.symbolicai.environment.Maze;
import leidenuniv.symbolicai.logic.Predicate;
import leidenuniv.symbolicai.logic.Term;

public class RunMe {
	//This is our main program class
	// It loads a world, makes an agent and then keeps the agent alive by allowing it to complete it's sense think act cycle 
	public static void main(String[] args) {
		//Load a world
		Maze w=new Maze(new File("data/prison.txt"));
		//Create an agent
		Agent a=new MyAgent();
		a.HUMAN_DECISION=false;
		a.VERBOSE=true;
		//Load the rules and static knowledge for the different steps in the agent cycle
		a.loadKnowledgeBase("percepts", new File("data/percepts.txt"));
		a.loadKnowledgeBase("program", new File("data/program.txt"));
		a.loadKnowledgeBase("actions", new File("data/actions.txt"));
		
		
		//If you need to test on a simpler file, you may use this one and comment out all the other KBs:
//		a.loadKnowledgeBase("program", new File("data/family1.txt"));
		
		
		Scanner io= new Scanner(System.in);
		
		// To test unify method
//		Predicate p = a.programRules.rules().get(0).conclusions.get(0);
//		Predicate f =  a.programRules.rules().get(1).conclusions.get(0);
//		System.out.println(p.toString() + " " + f.toString());
//		
//		HashMap <String, String> unification = a.unifiesWith(a.programRules.rules().get(0).conclusions.get(0), a.programRules.rules().get(1).conclusions.get(0));
//		System.out.println(unification);
		
		while (true) {
			//have the agent run the sense-think-act loop.
			a.cycle(w);
			
			//wait for an enter 
			System.out.println("Press <enter> in the java console to continue next cycle");
			String input = io.nextLine();
			
		}
	}

}
