package algorithm;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import main.Node;
import main.Path;


public class Prim  {
	
	
    public static void prim(ArrayList<Node> nodeList, ArrayList<Path> pathList) {
    	Set<Node> points = new HashSet<Node>();
    	points.add(nodeList.get(0));
    	int ans = 0;
    	for(int i=1;i<nodeList.size();i++) {
    		int min = 0xfffff;
    		int n_b = 1 ;
    		for(int j=0;j<pathList.size();j++) {
    			if(points.contains(nodeList.get(pathList.get(j).getA())) && !points.contains(nodeList.get(pathList.get(j).getB()))) {
    				min = min < pathList.get(j).getLength()?min:pathList.get(j).getLength();
    				n_b = pathList.get(j).getB();
    			}
    			
    			if(points.contains(nodeList.get(pathList.get(j).getB())) && !points.contains(nodeList.get(pathList.get(j).getA()))) {
    				min = min < pathList.get(j).getLength()?min:pathList.get(j).getLength();
    				n_b = pathList.get(j).getA();
    			}
    		}
    		ans+=min ;
    		points.add(nodeList.get(n_b));
    		System.out.println(n_b);
    	}
    	System.out.println(ans);
    }

}
