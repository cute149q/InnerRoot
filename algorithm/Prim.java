package algorithm;


import java.util.*;

import main.Node;
import main.Path;


public class Prim  {
	
    public static LinkedList<Integer> prim(ArrayList<Node> nodeList, ArrayList<Path> pathList) {
    	LinkedList<Integer> value = new LinkedList<Integer>();
    	Set<Node> points = new HashSet<Node>();
    	points.add(nodeList.get(0));
    	int ans = 0;
    	for(int i = 1; i < nodeList.size(); i++) {
    		int min = 0xfffff;
    		int n_b = 1 ;
    		for(int j = 0; j < pathList.size(); j++) {
    			if(points.contains(nodeList.get(pathList.get(j).getA())) && !points.contains(nodeList.get(pathList.get(j).getB()))) {
    				min = min < pathList.get(j).getLength()?min:pathList.get(j).getLength();
    				n_b = pathList.get(j).getB();
    			}
    			
    			if(points.contains(nodeList.get(pathList.get(j).getB())) && !points.contains(nodeList.get(pathList.get(j).getA()))) {
    				min = min < pathList.get(j).getLength()?min:pathList.get(j).getLength();
    				n_b = pathList.get(j).getA();
    			}
    		}
    		ans += min;
    		points.add(nodeList.get(n_b));
    		value.add(nodeList.get(n_b).getMark());
    	}
    	value.add(ans);
    	return value;
    }
}
