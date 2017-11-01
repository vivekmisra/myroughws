package org.vivek.algos.queueexamples;

import java.util.ArrayList;
import java.util.List;

public class QueueAsArrayList {

	
		 
	    private List qlist;
	     
	    public QueueAsArrayList(){
	        qlist = new ArrayList();
	    }
	     
	    public void enqueue(Node o){
	        if (qlist.isEmpty())
	            qlist.add(0, o);
	        else
	            qlist.add(qlist.size(), o);
	    }
	     
	    public Node poll(){
	        if (qlist.isEmpty())
	            return null;
	        else
	            return (Node)qlist.remove(0);
	    }
	     
	    public Node peek(){
	        if (qlist.isEmpty())
	            return null;
	        else
	        return (Node)qlist.get(0);
	    }
	}
