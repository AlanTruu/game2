/* Lead Author(s):
 * @author Alan Truong
 * @author Robin Stranton
 * <<add additional lead authors here, with a full first and last name>>
 * 
 * Other contributors:
 * <<add additional contributors (mentors, tutors, friends) here, with contact information>>
 * Kenny Truong kennytruong29@yahoo.com
 *
 * References:
 *
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * <<add more references here>>
 *  Gaddis, Tony. Starting out with Java: Control Structures through Objects. Pearson, 2021, https://www.pearson.com/en-us/subject-catalog/p/Gaddis-Revel-for-Starting-Out-With-Java-Control-Structures-through-Objects-Access-Card-8th-Edition/P200000003368/9780137451524. 
 * 
 * How to loop over two dimensional array in Java? Example. (n.d.). Javarevisited: Blog about Java 
 * Programming Tutorials, Examples, Design Patterns, Interview Questions and Answers, FIX 
 * Protocol, Tibco RV messaging, UNIX and Linux Commands, XML, SQL, MySQL, Oracle, jQuery, 
 * JavaScript,HTML, Multithreading, Collection, Error and Exception, Debugging, Best Practices 
 * and Practical tips from my experience. https://javarevisited.blogspot.com/2015/09/how-to-loop-two-dimensional-array-in-java.html
 * 
 * Return keyword in Java. (2022, August 17). GeeksforGeeks. https://www.geeksforgeeks.org/return-keyword-java/
 * Version/date: 3/20/2023
 * 
 * Responsibilities of class:
 * To provide a base class for the Player, Monster, and Empty classes to inherit from.
 * To define a getType() method that returns the string "Character".

 * 
 */
// Super class that the Player and Monster classes are sub to. Necessary for CombatGrid
public class Characters {

	public String getType() {
		return "Character";
	}
}
