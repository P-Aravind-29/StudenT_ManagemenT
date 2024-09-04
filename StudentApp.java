import java.awt.*;
import java.awt.event.*;
import java.sql.*;

	public class StudentApp extends Frame implements ActionListener {
	    TextField tfId, tfName, tfAge, tfDept;
	    Button btnAdd, btnUpdate, btnDelete, btnView;
	    TextArea taOutput;
	    StudentDAO studentDAO;
	    Label lid ,lname, lage, ldept;

	    public StudentApp() {
	        studentDAO = new StudentDAO();


	        setTitle("Student Management");
	        setSize(700, 500);
	        setLayout(null);


	        tfId = new TextField(20);
	        tfId.setBounds(180, 100, 100, 30);
	        tfName = new TextField(20);
	        tfName.setBounds(180, 150, 100, 30);
	        tfAge = new TextField(20);
	        tfAge.setBounds(180, 200, 100, 30);
	        tfDept = new TextField(20);
	        tfDept.setBounds(180, 250, 100, 30);
	        
	        btnAdd = new Button("Add");
	        btnAdd.setBounds(50, 300, 60, 30);
	        btnUpdate = new Button("Update");
	        btnUpdate.setBounds(140, 300, 60, 30);
	        btnDelete = new Button("Delete");
	        btnDelete.setBounds(230, 300, 60, 30);
	        btnView = new Button("View All");
	        btnView.setBounds(320, 300, 60, 30);
	        
	        taOutput = new TextArea(10, 30);
	        taOutput.setBounds(300, 100, 300, 180);

	        lid = new Label("ID:");
	        lid.setBounds(50, 100, 100, 30);
	        lid.setBackground(Color.lightGray);
	        lname = new Label("NAME:");
	        lname.setBounds(50, 150, 100, 30);
	        lname.setBackground(Color.LIGHT_GRAY);
	        lage = new Label("AGE:");
	        lage.setBounds(50, 200, 100, 30);
	        lage.setBackground(Color.LIGHT_GRAY);
	        ldept = new Label("DEPARTMENT:");
	        ldept.setBounds(50, 250, 100, 30);
	        ldept.setBackground(Color.LIGHT_GRAY);
	        
	        
	        
	        add(lid);
	        add(lname);
	        add(lage);
	        add(ldept);
	        add(tfId);
	        add(tfName);
	        add(tfAge);
	        add(tfDept);
	        add(btnAdd);
	        add(btnUpdate);
	        add(btnDelete);
	        add(btnView);
	        add(taOutput);


	        btnAdd.addActionListener(this);
	        btnUpdate.addActionListener(this);
	        btnDelete.addActionListener(this);
	        btnView.addActionListener(this);


	        addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent we) {
	                System.exit(0);
	            }
	        });
	        
	        setBackground(Color.pink);
	        setVisible(true);
	    }

	    public void actionPerformed(ActionEvent e) {
	    	
	    	try {
	    	
	        if (e.getSource() == btnAdd) {
	            studentDAO.addStudent(Integer.parseInt(tfId.getText()),tfName.getText(), Integer.parseInt(tfAge.getText()), tfDept.getText());
	            taOutput.append("Student added.\n");
	        } else if (e.getSource() == btnUpdate) {
	            studentDAO.updateStudent(Integer.parseInt(tfId.getText()), tfName.getText(), Integer.parseInt(tfAge.getText()), tfDept.getText());
	            taOutput.append("Student updated.\n");
	        } else if (e.getSource() == btnDelete) {
	            studentDAO.deleteStudent(Integer.parseInt(tfId.getText()));
	            taOutput.append("Student deleted.\n");
	        } else if (e.getSource() == btnView) {
	            taOutput.setText("");
	            ResultSet rs = studentDAO.getAllStudents();
	            try {
	                while (rs.next()) {
	                    taOutput.append("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Age: " + rs.getInt("age") + ", Department: " + rs.getString("dept") + "\n");
	                }
	            } 
	            catch (Exception ex) {
	                
	            }
	        }
	    }
	    catch(Exception e1) {
	    		
	    }
	        
	    }

	    public static void main(String[] args) {
	        new StudentApp();
	    }
	    
	    
	}



