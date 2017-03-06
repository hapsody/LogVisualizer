package test1;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.*;
import java.io.*;

@SuppressWarnings("serial")
class LogVisualizer extends JFrame  {
	int Ptx, Pty;
	
	public void init(){
		Container con = this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
	}
	
	public LogVisualizer(String title){
		super(title);

		super.setSize(300,200);
		/*
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int)(screen.getWidth()/2 - this.getWidth()/2);
		int ypos = (int)(screen.getHeight()/2 - this.getHeight()/2);
		super.setLocation(xpos, ypos);
		*/
		super.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//super.setResizable(false);
		makeUI();
		//this.init();
		
		super.setVisible(true);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e)
			{
				Ptx = e.getX();
				Pty = e.getY();
				repaint();
			}
		});
	}
	
	private void makeUI(){
		JPanel mainPanel = new JPanel();
		JButton loadButton = new JButton();
		JFileChooser fileChooser = new JFileChooser();
		
		this.add(mainPanel, BorderLayout.CENTER);
		mainPanel.add(loadButton);
		mainPanel.setLayout(null);
		loadButton.setBounds(20, 20, 100, 10);;
		
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//loadButton이 눌리면 일어나는 event
				FileNameExtensionFilter textFilter = new FileNameExtensionFilter("LOG","log");
				// .log.1 .log.01 ... 형식은 추가할것
				fileChooser.setFileFilter(textFilter);
				
				int returnVal = fileChooser.showOpenDialog(getParent());
				
				if(returnVal == JFileChooser.APPROVE_OPTION){
					File choosedFile = fileChooser.getSelectedFile();					
					LogParser logParser = new LogParser(choosedFile);
				}
			}	
		});
	}

	public static void main(String[] args){
		LogVisualizer logViaulizer = new LogVisualizer("LogVisualizer");
	}
	
	public void update(Graphics g){	paint(g); }
	public void paint(Graphics g){ 
		g.fillOval(Ptx, Pty, 4, 4); 
	}

	
}


