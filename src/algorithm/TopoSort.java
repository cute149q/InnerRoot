package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import main.Node;
import main.Path;

public class TopoSort {
	public static void topo(ArrayList<Node> nodeList, ArrayList<Path> pathList) {
		 Set<Node> points = new HashSet<Node>();
		 int[] index = new int[nodeList.size()];
		 ArrayList<Node> n = new ArrayList<Node>();
		 ArrayList<Path> p = new ArrayList<Path>();

		 for(int i=0;i<nodeList.size();++i) {
			 n.add(nodeList.get(i));
		 }
		 for(int i=0;i<pathList.size();++i) {
			 p.add(pathList.get(i));
		 }
		 for(Path path:p) {
			 index[path.getB()]++ ;
		 }
		 while(true) {
			 for(int i=0;i<nodeList.size();i++) {
				 if(index[i]==0&&!points.contains(nodeList.get(i))) {
					 points.add(n.get(i));
					 for(Path path:p) {
						 if(path.getA()==i) {
							 index[path.getB()]--;
							 //p.remove(path);
						 }
					 }
				 }
			 }
			 int flag = 0 ;
			 if(points.size()==nodeList.size()) break ;
			 for(int i=0;i<nodeList.size();i++) {
				 if(index[i]!=0) flag++;
			 }
			 if(flag==nodeList.size()-points.size()) {
				 break ;
			 }
		 }
		 for(Node node:points) {
			 System.out.print(node.getMark()+" ");
		 }
	}
}
