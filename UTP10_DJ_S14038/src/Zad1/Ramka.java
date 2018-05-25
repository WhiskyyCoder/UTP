package Zad1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ramka extends JFrame implements ActionListener {
	ExecutorService ex;
	Map<String,Call> callbles =new HashMap<>();
	  JTextArea ta = new JTextArea(30,30);

	  Ramka() {
		  
		 ex=Executors.newFixedThreadPool(4);
	   
		  add(new JScrollPane(ta),BorderLayout.CENTER);
	    JPanel p = new JPanel();
	    JButton b = new JButton("Thread 1");
	    b.setActionCommand("Start 1");
	    b.addActionListener(this);
	 
	    p.add(b);
	    b = new JButton("Thread 2");
	    b.setActionCommand("Start 2");
	    b.addActionListener(this);
	    p.add(b);
	    b = new JButton("Thread 3");
	    b.setActionCommand("Start 3");
	    b.addActionListener(this);
	    p.add(b);
	    b = new JButton("Thread 4");
	    b.setActionCommand("Start 4");
	    b.addActionListener(this);
	    p.add(b);
	    add(p, BorderLayout.PAGE_END);
	    b = new JButton("Stop");
	    b.setActionCommand("Stop");
	    b.addActionListener(this);
	    add(b,BorderLayout.PAGE_START);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    pack();
	    setVisible(true);
	  }
	
	@Override
	public void actionPerformed(ActionEvent e) {

		String cmd = e.getActionCommand();
		
		if(cmd.startsWith("Start"))
		{
			String id=cmd.replace("Start", "");
			((JButton)e.getSource()).setText("Suspend");
			((JButton)e.getSource()).setActionCommand("Suspend "+id);
			Call c=new Call(Integer.parseInt(id.trim())*100,id,ta);
			ex.execute(new FutTask<Integer>(c,ta,id,(JButton)e.getSource()));
            callbles.put(id.trim(), c);
		}
		if(cmd.startsWith("Stop"))
		{
			ex.shutdownNow();
			ta.append("STOP ALL !\n");
			
		
		}
		if(cmd.startsWith("Suspend"))
		{
			
			String id=cmd.replace("Suspend", "");
            callbles.get(id.trim()).setSuspend(true);
			((JButton)e.getSource()).setText("Continue");
			((JButton)e.getSource()).setActionCommand("Continue "+id);
			
		}
		if(cmd.startsWith("Continue"))
		{
			String id=cmd.replace("Continue", "");
			callbles.get(id.trim()).setSuspend(false);
			  synchronized (callbles.get(id.trim())) {
				  callbles.get(id.trim()).notify();
			  }
			((JButton)e.getSource()).setText("Suspend");
			((JButton)e.getSource()).setActionCommand("Suspend "+id);
		}	
		
		
	}

}
