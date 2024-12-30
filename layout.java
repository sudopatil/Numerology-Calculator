import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class layout implements ActionListener{	
	
	private JTextField inputField  = new JTextField(15);
	private JTextField dateField  = new JTextField(12);
	private JButton displayButton = new JButton();

		public layout()
		{
			ImageIcon pic = new ImageIcon("numerology1.png");
			
			JFrame frame = new JFrame();
			frame.setVisible(true);
			frame.setSize(637,540); //proper ratio is 1.1780
			frame.setTitle("NUMEROLOGY");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLayout(new BorderLayout());
			frame.setIconImage(pic.getImage());
			frame.setResizable(true);
			
			
			JPanel panel1 = new JPanel();
			JPanel panel2 = new JPanel();
			JPanel panel3 = new JPanel();
			JPanel panel4 = new JPanel();
			JPanel mainpanel = new JPanel();	
			

			panel1.setBackground(new Color(255, 153, 19));
			panel2.setBackground(new Color(255, 153, 19));
			panel3.setBackground(new Color(255, 153, 19)); //r g b for ff9913 
			panel4.setBackground(new Color(255, 153, 19));
			mainpanel.setBackground(new Color(255, 189, 49));

			
			panel1.setPreferredSize(new Dimension(200,200));
			panel2.setPreferredSize(new Dimension(50,75));
			panel3.setPreferredSize(new Dimension(50,50));
			panel4.setPreferredSize(new Dimension(50,50));
			mainpanel.setPreferredSize(new Dimension(200,100));
			
		
			frame.add(panel1,BorderLayout.NORTH);
			frame.add(panel2,BorderLayout.SOUTH);
			frame.add(panel3,BorderLayout.EAST);
			frame.add(panel4,BorderLayout.WEST);
			frame.add(mainpanel,BorderLayout.CENTER);
			
			JLabel label = new JLabel();
			label.setText("  Pattern & Prediction");
			label.setIcon(pic);
			label.setHorizontalTextPosition(JLabel.RIGHT);
			label.setVerticalTextPosition(JLabel.CENTER);
			label.setForeground(new Color(0,0,0));
			label.setFont(new Font(Font.SERIF, Font.BOLD, 40));
			label.setBackground(new Color(255, 153, 19));
			label.setOpaque(true);
			label.setVerticalAlignment(JLabel.CENTER);
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setBounds(0, 0, 150, 600);
			panel1.add(label);
			
			inputField.setBounds(0, 0, 20, 100);
			inputField.setHorizontalAlignment(JLabel.CENTER);
			inputField.setForeground(Color.BLACK);
			inputField.setFont(new Font("salina",Font.BOLD,20));
			
			JLabel labeln = new JLabel();
			labeln.setText("Name:-");
			labeln.setForeground(new Color(0,0,0));
			labeln.setFont(new Font(Font.SERIF, Font.BOLD, 25));
			labeln.setHorizontalTextPosition(JLabel.LEFT);
			labeln.setVerticalTextPosition(JLabel.CENTER);
			labeln.setVerticalAlignment(JLabel.TOP);
			labeln.setHorizontalAlignment(JLabel.LEFT);
			
			dateField.setBounds(0, 0, 20, 100);
			dateField.setHorizontalAlignment(JLabel.CENTER);
			dateField.setForeground(Color.BLACK);
			dateField.setFont(new Font("salina",Font.BOLD,20));
			
			JLabel labeld = new JLabel();
			labeld.setText("Date (dd/mm/yyyy):-");
			labeld.setForeground(new Color(0,0,0));
			labeld.setFont(new Font(Font.SERIF, Font.BOLD, 25));
			labeld.setVerticalAlignment(JLabel.BOTTOM);
			labeld.setHorizontalAlignment(JLabel.LEFT);
			
			displayButton.setPreferredSize(new Dimension(85,35));
			displayButton.setText("Submit");
			displayButton.setForeground(new Color(255, 153, 19)); 
			displayButton.setBackground(new Color(0,0,0));
			displayButton.setFocusable(false);
			displayButton.setFont(new Font("salina",Font.PLAIN,14));
			displayButton.addActionListener(this);
			
			mainpanel.add(labeln);
			mainpanel.add(inputField);
			mainpanel.add(labeld);
			mainpanel.add(dateField);
			panel2.add(displayButton);
			
		}
		 public static void main(String[] args) {
		        SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		               layout obj = new layout();
		            }
		        });
		    }

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        if (e.getSource() == displayButton) {
		            String birthdate = dateField.getText();
		            String name = inputField.getText();
		            try {
		                String[] results = calculateResults(birthdate, name);
		                String message = "Mulaank: " + results[1] + "\n"
		                        + "Bhagyank " + results[0] + "\n"
		                        + "Ruling Planet: " + results[2] + "\n"
		                        + "Name Ultimate Sum: " + results[3]+"\n"
		                		+ "Discription: " + results[4];
		                JOptionPane.showMessageDialog(null, message, "Results", JOptionPane.INFORMATION_MESSAGE);
		            } catch (NumberFormatException ex) {
		                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid details.", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        }
		    }

		    private String[] calculateResults(String birthdate, String name) {
		        String[] parts = birthdate.split("/");
		        int day = Integer.parseInt(parts[0]);
		        int month = Integer.parseInt(parts[1]);
		        int year = Integer.parseInt(parts[2]);

		        int total = day + month + year;
		        int ultimateSum = reduceToSingleDigit(total);
		        int daySum = reduceToSingleDigit(day);
		        int nameSum = calculateNameSum(name);

		        String planet = getResult(daySum);
		        String Discp = getDiscription(daySum);

		        return new String[]{String.valueOf(ultimateSum), String.valueOf(daySum), planet, String.valueOf(nameSum),Discp};
		    }

		    private int reduceToSingleDigit(int num) {
		        int sum = num;
		        while (sum > 9) {
		            sum = sum % 10 + sum / 10;
		        }
		        return sum;
		    }

		    private int calculateNameSum(String name) {
		        int sum = 0;
		        for (char c : name.toLowerCase().toCharArray()) {
		            switch (c) {
		                case 'a':
		                case 'i':
		                case 'j':
		                case 'q':
		                case 'y':
		                    sum += 1;
		                    break;
		                case 'b':
		                case 'k':
		                case 'r':
		                    sum += 2;
		                    break;
		                case 'c':
		                case 'g':
		                case 'l':
		                case 's':
		                    sum += 3;
		                    break;
		                case 'd':
		                case 'm':
		                case 't':
		                    sum += 4;
		                    break;
		                case 'e':
		                case 'h':
		                case 'n':
		                case 'x':
		                    sum += 5;
		                    break;
		                case 'u':
		                case 'v':
		                case 'w':
		                    sum += 6;
		                    break;
		                case 'o':
		                case 'z':
		                    sum += 7;
		                    break;
		                case 'f':
		                case 'p':
		                    sum += 8;
		                    break;
		                default:
		                    // Ignore other characters
		                    break;
		            }
		        }
		        return reduceToSingleDigit(sum);
		    }

		    private String getResult(int ultimateSum) {
		        switch (ultimateSum) {
		            case 1:
		                return "SUN";
		            case 2:
		                return "Moon";
		            case 3:
		                return "Jupiter";
		            case 4:
		                return "Rahu";
		            case 5:
		                return "Budh";
		            case 6:
		                return "Venus";
		            case 7:
		                return "Ketu";
		            case 8:
		                return "Saturn";
		            case 9:
		                return "Mars";
		            default:
		                return "Invalid input. Please enter a valid birthdate.";
		        }
		    }
		    
		    private String getDiscription(int ultimateSum) {
		        switch (ultimateSum) {
		            case 1:
		                return " Mulank 1 natives are ambitious, don’t back down from a challenge, and never give up. In such a case, owning a business, entering politics.\r\n"
		                		+ "";
		            case 2:
		                return " Mulank 2 natives have a strong desire to create art. These people labor in a systematic manner and are committed to justice.Working in the arts, earning a reputation in the entertainment business, justice, social work.";
		            case 3:
		                return " Such individuals are artistic and creative, while also having a strong interest in social work. Work in the fields of creative arts, politics, social service, high-level positions.";
		            case 4:
		                return "Mulank 4 natives are self-reliant and enjoy doing things in novel ways and with novel ideas. In such a setting, their career may shine in high-risk ventures such as gambling and acting.";
		            case 5:
		                return "Mulank 5 residents have a highly welcoming nature, a fantastic conversational style, and a strong desire to meet and talk to new people. ";
		            case 6:
		                return " Mulank 6 natives have a very healthy body and a lively personality. Such people are well-known and well-liked, and they have the capacity to deal with people.";
		            case 7:
		                return "Natives belonging to this Mulank are great advisors, travel agents, researchers, and artists. In such a setting, a job in research, travel, or consulting may be a good fit for you.\r\n"
		                		+ "";
		            case 8:
		                return "Mulank 8 natives have a strong desire for spiritual and worldly pleasures of the highest level. However, they occasionally make poor mistakes for which they may have to repent.";
		            case 9:
		                return " Mulank 9 natives are brave and fearless in the face of adversity. They easily find a job and making a reputation for yourself in sports, the army, politics, entertainment.";
		            default:
		                return "Invalid input. Please enter a valid birthdate.";
		        }
		}
}	    
		    
		    
		    