
public class People {
	String contrName;
	String contrTelNum;
	String contrEmailAddress;
	String contrPhysicalAddress;
	String custName;
	String custTelNum;
	String custEmailAddress;
	String custPhysicalAddress;
	
	
	public People (String contrName, String contrTelNum, String contrEmailAddress, String physicalAddress ,
			String custName, String custTelNum, String custEmailAddress, String custPhysicalAddress) {
	
		this.contrName = contrName;
		this.contrTelNum = contrTelNum;
		this.contrEmailAddress = contrEmailAddress;
		this.contrPhysicalAddress = physicalAddress;
		this.custName = custName;
		this.custTelNum = custTelNum;
		this.custEmailAddress = custEmailAddress;
		this.custPhysicalAddress = custPhysicalAddress;
		
	}

	public String toString() {
	String peopleDetails = "	Contractor Details";
	peopleDetails += "\nName			: " + contrName;
	peopleDetails+= "\nTelephone number	: " + contrTelNum;
	peopleDetails += "\nEmail Address		: " + contrEmailAddress;
	peopleDetails += "\nPhysical Address	: " + contrPhysicalAddress;
	peopleDetails += "\n\n	Customer Details";
	peopleDetails += "\nName			: " + custName;
	peopleDetails += "\nTelephone number	: "  + custTelNum;
	peopleDetails += "\nEmail Address		: " + custEmailAddress;
	peopleDetails += "\nPhysical Address	: "+ custPhysicalAddress;
	
	
	return peopleDetails;
	}
	

}
