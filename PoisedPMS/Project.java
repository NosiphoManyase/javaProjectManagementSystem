
public class Project {
	int projectNum;
	String projectName;
	String buildingType;
	String projectAddress;
	int erfNum;
	double totalDue;
	String deadline;
	
			
		
	public void setProjectNum(int projectNum) {
		this.projectNum = projectNum;
	}



	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}



	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}



	public void setProjectAddress(String projectAddress) {
		this.projectAddress = projectAddress;
	}



	public void setErfNum(int erfNum) {
		this.erfNum = erfNum;
	}



	public void setTotalFee(double totalFee) {
		this.totalDue = totalFee;
	}



	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}



		public String toString() {
			String projectDetails = "	\nProject Details	";
			projectDetails +="\nProject no.		: " + projectNum;
			projectDetails += "\nProject Name		: " + projectName;
			projectDetails += "\nBuilding Type		: " + buildingType;
			projectDetails += "\nProject Address		: " + projectAddress;
			projectDetails += "\nERF no.			: " + erfNum;
			projectDetails += "\nTotal Due		: R" + totalDue;
			projectDetails += "\nDeadline		: " + deadline;
			
			return projectDetails;					
		}

}
