import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ProjectManagementSystem {

	public static void main(String[] args) throws ParseException {

		// Objects created for two classes project and people
		Project projectInfo = new Project();
		People peopleInfo = new People(null, null, null, null, null, null, null, null);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		// Initialise menu out of do-while loop, menu determines whether user still wants to do more actions or exit. 
		String menu = null;
		
		// Array store details about project, contractor
		// Array better if multiple new projects are created to avoid losing and overriding old project information
	    String[][] project = new String[10][8];
		String[][] contractor = new String[10][4];
		String[][] customer = new String[10][4];


		JOptionPane.showMessageDialog(null, "Welcome to the Poised Project Management System!");
		do {
			String[] choices = {"(a) Create new project", "(b) Change due date", "(c) Change total due", 
					"(d) Update contractor details", "(e) Finalise project" , "(e) Check project Status"};
			String header = (String) JOptionPane.showInputDialog(null, "Choose action from list below",
					"Poised Project Management System", JOptionPane.QUESTION_MESSAGE, null,
					choices, choices[1]);

			// Scanner takes in input for each instance of a project.
			if (header == choices[0]) {
				Scanner scan  = new Scanner(System.in);

				System.out.println("\nEnter project number: ");
				projectInfo.projectNum = Integer.parseInt(scan.nextLine());
				
				// determine Index to store into project array
				int projNum = projectInfo.projectNum;
				int projNumFinal = projNum - 1 ;
				
				System.out.println("Enter project name: ");
				projectInfo.projectName =  scan.nextLine();
				
				System.out.println("Enter building type : ");
				projectInfo.buildingType =  scan.nextLine();				
				
				System.out.println("Enter project address : ");
				projectInfo.projectAddress =  scan.nextLine();	
				
				System.out.println("Enter erf number: ");
				projectInfo.erfNum = Integer.parseInt(scan.nextLine());				

				System.out.println("Enter total amount due: ");
				projectInfo.totalDue = Double.parseDouble(scan.nextLine());				

				System.out.println("Enter deadline (format: dd/mm/yyyy) : ");
				projectInfo.deadline =  scan.nextLine();
				

				// setting up values of array
				String strProjNum = String.valueOf(projectInfo.projectNum); // convert to string
				project[projNumFinal][0] = strProjNum; //storing in row (projNum -1), and column indicated
				project[projNumFinal][1] = projectInfo.projectName;
				project[projNumFinal][2] = projectInfo.buildingType;
				project[projNumFinal][3] = projectInfo.projectAddress;
				String strErfNum = String.valueOf(projectInfo.erfNum);
				project[projNumFinal][4] = strErfNum;
				String strTotalDue = String.valueOf(projectInfo.totalDue);
				project[projNumFinal][5] = "R"+strTotalDue;
				project[projNumFinal][6] = projectInfo.deadline;
				// Automatically save completion status as No, when new project is created
				project[projNumFinal][7] = "No";
				
				// input contractor details
				System.out.println("Provide Details of contractor below!");
				
				System.out.println("\nEnter name of contractor: ");
				peopleInfo.contrName = scan.nextLine();
				
				System.out.println("Enter contact number of contractor: ");
				peopleInfo.contrTelNum = scan.nextLine();
				
				System.out.println("Enter email address of contractor: ");
				peopleInfo.contrEmailAddress = scan.nextLine();
				
				System.out.println("Enter physical address of contractor: ");
				peopleInfo.contrPhysicalAddress = scan.nextLine();
				
				// Save contractor details to mixed array contractor
				int checkProjNum = projectInfo.projectNum;
				int rowIndex = checkProjNum - 1;
				contractor[rowIndex][0] = peopleInfo.contrName;
				contractor[rowIndex][1] = peopleInfo.contrTelNum;
				contractor[rowIndex][2] = peopleInfo.contrEmailAddress;
				contractor[rowIndex][3] = peopleInfo.contrPhysicalAddress;
							
				// input customer details
				System.out.println("\nProvide Details of customer below!");
				
				System.out.println("Enter name of customer: ");
				peopleInfo.custName = scan.nextLine();
				
				System.out.println("Enter contact number of customer: ");
				peopleInfo.custTelNum = scan.nextLine();
				
				System.out.println("Enter email address of customer: ");
				peopleInfo.custEmailAddress = scan.nextLine();
				
				System.out.println("Enter physical address of customer: ");
				peopleInfo.custPhysicalAddress = scan.nextLine();
				
				//Save to customer array
				customer[rowIndex][0] = peopleInfo.custName;
				customer[rowIndex][1] = peopleInfo.custTelNum;
				customer[rowIndex][2] = peopleInfo.custEmailAddress;
				customer[rowIndex][3] = peopleInfo.custPhysicalAddress;
				
				// confirmation of new project
				JOptionPane.showMessageDialog(null, "New project successfully created!");
				
				// display new project details
				System.out.println("\n" + projectInfo);
				System.out.println("Complete        : "+project[projNumFinal][7]);
				System.out.println(peopleInfo);
				
				// Input that determines whether to close scanner or keep it open should user choose to create new project
				System.out.println("\nWould you like to go back to menu? (yes or no)");
				menu = scan.next();
				scan.nextLine();
				if(menu=="no" ) {
					System.out.println("\nYou are now exiting the program, GOODBYE!");
					scan.close(); // will scanner close if yes and not choose A?
					
				}
				
				


			}			

			if (header == choices[1]) {
				Scanner scan = new Scanner(System.in);
				
				// retrieve Project Number from user
				System.out.println("\nEnter project number of project you'd like to edit: ");			
				int projNum = Integer.parseInt(scan.nextLine());
				
				// Assume project numbers start from 1, therefore minus 1 for accurate indexes dates are stored in
				int projNumFinal = projNum - 1 ;
				
				//Show current details to user
				System.out.println("\nCurrent Project Details");
				System.out.println("Project Number	: "+project[projNumFinal][0]);
				System.out.println("Project Name	: "+project[projNumFinal][1]);
				System.out.println("Building Type	: "+project[projNumFinal][2]);
				System.out.println("Physical Address: "+project[projNumFinal][3]);
				System.out.println("ERF number		: "+project[projNumFinal][4]);
				System.out.println("Amount Due		: "+project[projNumFinal][5]);
				System.out.println("Deadline		: "+project[projNumFinal][6]);
				System.out.println("Complete        	: "+project[projNumFinal][7]);
				
				// get new date
				System.out.println("\nEnter new due date (format dd/mm/yyy): ");
				
				// update date element in array project that stores project details
				project[projNumFinal][6] = scan.next();
				
				//Display update
				System.out.println("\nUpdated Project Details");
				System.out.println("Project Number	: "+project[projNumFinal][0]);
				System.out.println("Project Name	: "+project[projNumFinal][1]);
				System.out.println("Building Type	: "+project[projNumFinal][2]);
				System.out.println("Physical Address: "+project[projNumFinal][3]);
				System.out.println("ERF number		: "+project[projNumFinal][4]);
				System.out.println("Amount Due		: "+project[projNumFinal][5]);
				System.out.println("Deadline		: "+project[projNumFinal][6]);
				System.out.println("Complete        : "+project[projNumFinal][7]);
				
				
				// Input that determines whether to close scanner or keep it open should user choose to create new project
				System.out.println("\nWould you like to go back to menu? (yes or no)");
				menu = scan.next();
				if(menu == "no") {
					System.out.println("\nYou are now exiting the program, GOODBYE!");
					scan.close();
				}

			}
			if (header == choices[2]) {
				//declare scanner object
				Scanner scan = new Scanner(System.in);
				
				// retrieve Project Number from user, 
				System.out.println("Enter project number of project you'd like to edit: ");			
				int projNum = Integer.parseInt(scan.nextLine());
				int projNumFinal = projNum - 1 ;
				
				//Display current project details
				System.out.println("\nCurrent Project Details");
				System.out.println("Project Number	: "+project[projNumFinal][0]);
				System.out.println("Project Name	: "+project[projNumFinal][1]);
				System.out.println("Building Type	: "+project[projNumFinal][2]);
				System.out.println("Physical Address: "+project[projNumFinal][3]);
				System.out.println("ERF number		: "+project[projNumFinal][4]);
				System.out.println("Amount Due		: "+project[projNumFinal][5]);
				System.out.println("Deadline		: "+project[projNumFinal][6]);
				System.out.println("Complete        : "+project[projNumFinal][7]);
				
				
				//get amount due to date input from user
				System.out.println("\nEnter amount due to date: ");
				project[projNumFinal][5] = "R" +scan.nextLine();
				
				//Display updated details
				System.out.println("\nUpdated Project Details");
				System.out.println("Project Number	: "+project[projNumFinal][0]);
				System.out.println("Project Name	: "+project[projNumFinal][1]);
				System.out.println("Building Type	: "+project[projNumFinal][2]);
				System.out.println("Physical Address: "+project[projNumFinal][3]);
				System.out.println("ERF number		: "+project[projNumFinal][4]);
				System.out.println("Amount Due		: "+project[projNumFinal][5]);
				System.out.println("Deadline		: "+project[projNumFinal][6]);
				System.out.println("Complete        : "+project[projNumFinal][7]);
				
				
				System.out.println("\nWould you like to go back to menu? (yes or no)");
				menu = scan.next();
				if(menu == "no") {
					System.out.println("\nYou are now exiting the program, GOODBYE!");
					scan.close();
				}

			}
			if (header == choices[3]) {
				
				// declare scanner object
				Scanner scan = new Scanner(System.in);
				
				// take in project number to manipulate into row of particular contractor details
				System.out.println("\nEnter project number of project you'd like to edit: ");
				int projNum = Integer.parseInt(scan.nextLine());
				int projNumFinal = projNum - 1 ;
				
				// display contractor details stored in array
				System.out.println("	Current Contractors Details");
				System.out.println("Name			: "+contractor[projNumFinal][0] );
				System.out.println("Contact Number	: "+contractor[projNumFinal][1] );
				System.out.println("Email Address	: "+contractor[projNumFinal][2]);
				System.out.println("Physical Address: "+contractor[projNumFinal][3]);
				
				// checking which element of contractor details that user would like to edit
				// update the string element within array contractor
				System.out.println("\nWould you like to edit the name? (yes or no)");
				String nameEdit = scan.nextLine();
				if (nameEdit.equalsIgnoreCase("yes")) {
					System.out.println("Enter updated name: ");
					contractor[projNumFinal][0] = scan.nextLine();
					// find way to break out of code if user doesn't require editing of any other elements
					
				}  
				System.out.println("Would you like to edit the contact number? (yes or no)");
				String telEdit = scan.nextLine();
				if (telEdit.equalsIgnoreCase("yes")) {
					System.out.println("Enter updated contact number: ");
					contractor[projNumFinal][1] = scan.nextLine();
				}
				System.out.println("Would you like to edit the email address?? (yes or no)");
				String emailEdit = scan.nextLine();
				if (emailEdit.equalsIgnoreCase("yes")) {
					System.out.println("Enter updated email address: ");
					contractor[projNumFinal][2] = scan.nextLine();
				}
				System.out.println("Would you like to edit the physical Address? (yes or no)");
				String addressEdit = scan.nextLine();
				if (addressEdit.equalsIgnoreCase("yes")) {
					System.out.println("Enter updated physical Address: ");
					contractor[projNumFinal][3] = scan.nextLine();
				}
				
				//updated contractors details
				System.out.println("\n	Updated Contractors Details ");
				System.out.println("Name			: "+contractor[projNumFinal][0] );
				System.out.println("Contact Number	: "+contractor[projNumFinal][1] );
				System.out.println("Email Address	: "+contractor[projNumFinal][2]);
				System.out.println("Physical Address: "+contractor[projNumFinal][3]);
				System.out.println("\nWould you like to go back to menu? (yes or no)");
				menu = scan.next();
				if(menu == "no") {
					System.out.println("\nYou are now exiting the program, GOODBYE!");
					scan.close();
				}
			}
			if (header == choices[4]) {
				
				// declare scanner object
				Scanner scan = new Scanner(System.in);
				
				// take in project number to manipulate into row of particular contractor details
				System.out.println("\nEnter project number of project you'd like Finalise: ");
				int projNum = Integer.parseInt(scan.nextLine());
				int projNumFinal = projNum - 1 ;
				
				System.out.println("\nIs the project completed? :");
				String answer = scan.next();
				if (answer.equalsIgnoreCase("yes")) {
					project[projNumFinal][7] = "Yes";
				}
				System.out.println("\nWould you like to generate the invoice?");
				String invoice = scan.next();
				// All details of project displayed for invoice
				if (invoice.equalsIgnoreCase("yes")) {
					System.out.println("\n	Customer details");
					System.out.println("Name			: "+customer[projNumFinal][0]);
					System.out.println("Contact Number	: "+customer[projNumFinal][1]);
					System.out.println("Contact Number	: "+customer[projNumFinal][2]);
					System.out.println("Physical Address: "+customer[projNumFinal][3]);
					System.out.println("\n	Contractors Details ");
					System.out.println("Name			: "+contractor[projNumFinal][0] );
					System.out.println("Contact Number	: "+contractor[projNumFinal][1] );
					System.out.println("Email Address	: "+contractor[projNumFinal][2]);
					System.out.println("Physical Address: "+contractor[projNumFinal][3]);
					System.out.println("\n Project Details");
					System.out.println("Project Number	: "+project[projNumFinal][0]);
					System.out.println("Project Name	: "+project[projNumFinal][1]);
					System.out.println("Building Type	: "+project[projNumFinal][2]);
					System.out.println("Physical Address: "+project[projNumFinal][3]);
					System.out.println("ERF number		: "+project[projNumFinal][4]);
					System.out.println("Amount Due		: "+project[projNumFinal][5]);
					System.out.println("Deadline		: "+project[projNumFinal][6]);
					System.out.println("Complete        : "+project[projNumFinal][7]);
					System.out.println("	---- End of Invoice -----");
				}
				System.out.println("\nWould you like to go back to menu? (yes or no)");
				menu = scan.next();
				if(menu == "no") {
					System.out.println("\nYou are now exiting the program, GOODBYE!");
					scan.close();
				}
			}
				if (header == choices[5]) {
					
					// declare scanner object
					Scanner scan = new Scanner(System.in);
					
					System.out.println("\nWould you like to check projects that still need to be completed? (yes or no): ");
					String checkComplete = scan.next();
					if (checkComplete.equalsIgnoreCase("yes")) {
						for (int i = 0; i < project.length ; i++) {
							if (project[i][7] == "No") {
								System.out.println("\n	Incomplete Projects");
								System.out.println("Project Number	: "+project[i][0]);
								System.out.println("Project Name	: "+project[i][1]);
								System.out.println("Building Type	: "+project[i][2]);
								System.out.println("Physical Address: "+project[i][3]);
								System.out.println("ERF number		: "+project[i][4]);
								System.out.println("Amount Due		: "+project[i][5]);
								System.out.println("Deadline		: "+project[i][6]);
								System.out.println("Complete        : "+project[i][7]);
							}
						}
					}
					System.out.println("\nWould you like to check for projects past the due date? (yes or no): ");
					String pastDue = scan.next();
					
					// convert current date to String
					String currentDate = sdf.format(new Date());
								
					if (pastDue.equalsIgnoreCase("yes")) {
						System.out.println("\n ---Overdue Projects---");
						for (int i = 0; i < project.length ; i++) {
							if (project[i][6] != null) {
								Date current = sdf.parse(currentDate);
								Date due = sdf.parse(project[i][6]);
								if(current.compareTo(due)>0) {
								System.out.println("\nCurrent Date	: "+currentDate);
								//*
								System.out.println("Deadline		: "+project[i][6]);
								}
							}			
						}
					}
					
					System.out.println("\nWould you like to go back to menu? (yes or no)");
					menu = scan.next();
					if(menu == "no") {
						System.out.println("\nYou are now exiting the program, GOODBYE!");
						scan.close();
					}
									
				}
			}while (menu.equalsIgnoreCase("yes"));

		}
	}




