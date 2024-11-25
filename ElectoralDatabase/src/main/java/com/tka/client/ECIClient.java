package com.tka.client;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.tka.controller.ECIController;
import com.tka.entity.Candidate;

public class ECIClient {

	public static void main(String[] args) {

		ECIController controller = new ECIController();
		Scanner scanner = new Scanner(System.in);
		int choice = 0;

		do {

			System.out.println();
			System.out.println("** Maharashtra Assembly Election 2024 Information Hub **");
			System.out.println();
			System.out.println();
			System.out.println("Enter 1: To view All Candidates contesting in Satara District");
			System.out.println("Enter 2: To view Candidates contesting in Satara District by PartyName");
			System.out.println("Enter 3: To view Candidate by Name ");
			System.out.println("Enter 4: To view Candidate by Gender ");
			System.out.println("Enter 5: To view Candidate by Assembly ");
			System.out.println("Enter 6: To view Candidate by Age ");
			System.out.println("Enter 7: To Insert Candidate into DataBase  ");
			System.out.println("Enter 8: To update Candidate's Data  ");
			System.out.println("Enter 9: To Delete Candidate's Data  ");
			System.out.println("Enter 10: To Exit");
			System.out.println();
			System.out.println();

			System.out.println("Enter your choice");
			try {
				choice = scanner.nextInt();
				scanner.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input! Please enter a valid number.");
				scanner.nextLine();
				continue;
			}

			switch (choice) {
			case 1:
				System.out.println("List of Candidates Contesting From Satara District are: ");
				System.out.println();
				List<Candidate> allCandidates = controller.getAllCandidates();
				for (Candidate candidate : allCandidates) {
					System.out.println(candidate);
				}
				break;

			case 2:
				System.out.println();
				try {
					System.out.println("Enter PartyName of Candidate: ");
					String pn = scanner.nextLine();
					scanner.nextLine();
					System.out.println("Candidates contesting in Satara District by PartyName are: ");
					controller.getcandidatebyPartyController(pn);
				} catch (Exception e) {
					System.out.println("Error processing input: " + e.getMessage());
				}
				break;

			case 3:
				try {
					System.out.println("Enter name of Candidate: ");
					String name = scanner.nextLine();
					scanner.nextLine();
					controller.getcandidatebyNameController(name);
				} catch (Exception e) {
					System.out.println("Error processing input: " + e.getMessage());
				}
				break;

			case 4:
				try {
					System.out.println("Enter Gender of Candidate: ");
					String gender = scanner.nextLine();
					scanner.nextLine();
					controller.getcandidatebyGenderController(gender);
				} catch (Exception e) {
					System.out.println("Error processing input: " + e.getMessage());
				}
				break;

			case 5:
				try {
					System.out.println("Enter Assembly of Candidate: ");
					String assembly = scanner.nextLine();
					scanner.nextLine();
					controller.getcandidatebyAssemblyController(assembly);
				} catch (Exception e) {
					System.out.println("Error processing input: " + e.getMessage());
				}
				break;

			case 6:
				try {
					System.out.println("Enter Age of Candidate: ");
					int age = scanner.nextInt();
					scanner.nextLine();
					controller.getcandidatebyAgeController(age);
				} catch (InputMismatchException e) {
					System.out.println("Invalid age! Please enter a valid number.");
					scanner.nextLine();
				}
				break;

			case 7:
				try {
					System.out.println("Enter Data of Candidate: ");
					System.out.println("Enter id : ");
					int id = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter Candidate Name: ");
					String name = scanner.nextLine();
					scanner.nextLine();
					System.out.println("Enter Party Name: ");
					String partyname = scanner.next();
					scanner.nextLine();
					System.out.println("Enter Assembly Name: ");
					String assembly = scanner.next();
					scanner.nextLine();
					System.out.println("Enter Gender: ");
					String gender = scanner.next();
					scanner.nextLine();
					System.out.println("Enter Age: ");
					int age = scanner.nextInt();
					scanner.nextLine();
					controller.insertcandidatebyController(id, name, partyname, assembly, gender, age);
				} catch (InputMismatchException e) {
					e.printStackTrace();
				}
				break;

			case 8:
				try {
					System.out.println("Enter Data of Candidate: ");
					System.out.println("Enter id : ");
					int id = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter Candidate Name: ");
					String name = scanner.nextLine();
					scanner.nextLine();
					System.out.println("Enter Party Name: ");
					String partyname = scanner.next();
					scanner.nextLine();
					System.out.println("Enter Assembly Name: ");
					String assembly = scanner.next();
					scanner.nextLine();
					System.out.println("Enter Gender: ");
					String gender = scanner.next();
					scanner.nextLine();
					System.out.println("Enter Age: ");
					int age = scanner.nextInt();
					scanner.nextLine();
					controller.updatecandidatebyController(id, name, partyname, assembly, gender, age);
				} catch (InputMismatchException e) {
					e.printStackTrace();
				}
				break;
			case 9:
				try {
					System.out.println("Enter Data of Candidate to be Deleted: ");
					System.out.println("Enter id : ");
					int id = scanner.nextInt();
					scanner.nextLine();
					controller.deletecandidatebyController(id);
				} catch (InputMismatchException e) {
					e.printStackTrace();
				}
				break;

			case 10:
				System.out.println("Thank you for using our Portal");
				break;

			default:
				System.out.println("Invalid Choice! Please enter again.");
				System.out.println();
				break;
			}

		} while (choice != 10);
		scanner.close();
	}
}
