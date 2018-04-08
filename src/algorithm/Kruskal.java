package algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import main.Node;
import main.Path;

public class Kruskal {

	 static Set<Node> points = new HashSet<Node>() ;
	 public static ArrayList<Node> n = new ArrayList<Node>();
	 public static ArrayList<Path> p = new ArrayList<Path>();
	 public static void kruskal(ArrayList<Node> nodeList, ArrayList<Path> pathList) {
		Comparator<Path> comparator = new Comparator<Path>(){
			public int compare(Path p1, Path p2) {
				     return p1.getLength()-p2.getLength();
		        }
		     
		 };
		 
		 int ans = 0;
		 for(int i=0;i<nodeList.size();++i) {
			 n.add(nodeList.get(i));
		 }
		 for(int i=0;i<pathList.size();++i) {
			 p.add(pathList.get(i));
		 }
		 p.sort(comparator);
		 while(points.size()!=nodeList.size()) {
			 if(!isCircle(p.get(0))) {
				 if(!points.contains(nodeList.get(p.get(0).getA()))) {
					 points.add(nodeList.get(p.get(0).getA()));
					 System.out.println("node add:"+nodeList.get(p.get(0).getA()).getMark());
				 }
				 if(!points.contains(nodeList.get(p.get(0).getB()))) {
					 points.add(nodeList.get(p.get(0).getB()));
					 System.out.println("node add:"+nodeList.get(p.get(0).getB()).getMark());
				 }
				 ans+=p.get(0).getLength();
				 p.remove(p.get(0));
			 }
		 }
		 System.out.println(ans);
	 }
	 private static boolean isCircle(Path p) {
		 if(points.contains(n.get(p.getA()))&&points.contains(n.get(p.getB())))
			 return true;
		 return false ;
	 }
	 
	 
	 

}
