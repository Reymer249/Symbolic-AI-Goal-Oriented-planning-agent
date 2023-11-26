package leidenuniv.symbolicai;

import java.io.File;
import java.util.Scanner;
import java.util.Vector;
import java.util.Collection;
import java.util.HashMap;
import java.util.ArrayList;

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
//		a.loadKnowledgeBase("percepts", new File("data/percepts.txt"));
//		a.loadKnowledgeBase("program", new File("data/program.txt"));
//		a.loadKnowledgeBase("actions", new File("data/actions.txt"));
		
		
		//If you need to test on a simpler file, you may use this one and comment out all the other KBs:
		a.loadKnowledgeBase("program", new File("data/test1.txt"));
		
		
//		Scanner io= new Scanner(System.in);
		
		// To test the .unifiesWith method
		Predicate p = a.programRules.rules().get(0).conclusions.get(0);
		Predicate f =  a.programRules.rules().get(1).conclusions.get(0);
		System.out.println(p.toString() + ' ' + f.toString());
//		
		HashMap <String, String> unification = a.unifiesWith(p, f);
		System.out.println(unification);
		System.out.println("-----");
		
		// To test .findAllSubstitutions method
		Collection<HashMap<String, String>> allSubstitutions = new ArrayList<>();
		HashMap<String, String> substitution = new HashMap<String, String>();
		Vector<Predicate> conditions = new Vector<Predicate>();
		conditions.add(f);
		conditions.add(p);
		HashMap<String, Predicate> facts = new HashMap<String, Predicate>();
		String f1 = "parent(joost,leon)";
		Predicate fp1 = new Predicate(f1);
		String f2 = "parent(joost,sacha)";
		Predicate fp2 = new Predicate(f2);
		String f3 = "parent(peter,joost)";
		Predicate fp3 = new Predicate(f3);
		String f4 = "female(sacha)";
		Predicate fp4 = new Predicate(f4);
		String f5 = "male(leon)";
		Predicate fp5 = new Predicate(f5);
		facts.put(f1, fp1);
		facts.put(f2, fp2);
		facts.put(f3, fp3);
		facts.put(f4, fp4);
		facts.put(f5, fp5);
		boolean result = a.findAllSubstitions(allSubstitutions, substitution, conditions, facts);
		System.out.println(result);
		System.out.println(allSubstitutions);
		
		
		
//		while (true) {
//			//have the agent run the sense-think-act loop.
//			a.cycle(w);
//			
//			//wait for an enter 
//			System.out.println("Press <enter> in the java console to continue next cycle");
//			String input = io.nextLine();
//			
//		}
	}

}
