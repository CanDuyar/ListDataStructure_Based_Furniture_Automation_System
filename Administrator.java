/**
 * @author Can Duyar 171044075
 * Administrator class which is extends from Company class and implements the User interface
 */
import java.util.ListIterator;
/**
* Administrator class which is derived from company class and implements Users class
*/
public class Administrator extends Company implements Users{
	/**
	 * It's for name of administrator.
	 */
	private String name;


	/**
	 * It's for surname of administrator.
	 */
	private String surname;

	/**
	 * Constructor with two-parameters for administrator
	 * @param name string of the administrator's name.
	 * @param surname string of the administrator's surname.
	 */
	public Administrator(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
		System.out.println();
		System.out.println(name +" "+surname + " is added as administrator!!!");
	}

	/**
	 * This method gets the administrator's name.
	 * @return administrator's name.
	 */
	@Override
	public String getName() {
		return name;
	}


	/**
	 * This method sets the administrator's name.
	 * @param name string of the administrator's name..
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * This method gets the administrator's surname.
	 * @return administrator's surname.
	 */
	@Override
	public String getSurname() {
		return surname;
	}


	/**
	 * This method sets the administrator's surname.
	 * @param surname string of the administrator's surname.
	 */
	@Override
	public void setSurname(String surname) {
		this.surname = surname;
	}


	/**
	 * At the beginning of the program, administator adds products.get(w)th this method because
	 * there is no branch-employee to add products.get() 
	 * @param fur Furniture to add. 
	 * @param number_add the number of furniture to be added.
	 */
	public void addProduct(Furniture fur, int number_add){
		
		if(number_add > 0 && furnitureNum > 0){
			int control = -1;
			for(int t=0; t<furnitureNum; t++){
				if(products.get(0).get(t).getProduct() == fur.getProduct() && products.get(0).get(t).getModel() == fur.getModel()){
					control = t;
					break;
				}
			}
			if(control != -1){
				products.get(0).get(control).setStock(products.get(0).get(control).getStock() + number_add);
				furnitureNum += 1;
			}
			else{
				products.get(0).add(fur);
				products.get(0).get(furnitureNum).setStock(products.get(0).get(furnitureNum).getStock() + number_add);
				furnitureNum += 1;
			}
		}
		else if(number_add > 0 && furnitureNum == 0){
			products.get(0).add(fur);
			products.get(0).get(furnitureNum).setStock(products.get(0).get(furnitureNum).getStock() + number_add);
			furnitureNum += 1;
		}		
	}	


	/**
	 * this method to see there are any products.get(t) need to be supplied. 
	 */	
	public void productQuery(){

		boolean querycontrol = false;

		for(int t = 0; t < furnitureNum; t++){
			if(products.get(0).get(t).getStock() == 0){
					System.out.println("Product: " + products.get(0).get(t).getProduct());
					System.out.println("Color: " + products.get(0).get(t).getColor());
					System.out.println("Model: " + products.get(0).get(t).getModel());
					System.out.println("Number of stock: " + products.get(0).get(t).getStock());
					System.out.println("\n");
					querycontrol = true;
			}
		} 

		if(querycontrol == false){
			System.out.println("There is no furniture that need to be supplied....");
		}
	}

	
	/** 
	 * This method is used for adding branch.
	 * @param newBranch Branch to add.
	 * @param branch_number the order of branch to be added.
	 * @return 1 or 0  
	 */
	public int addBranch(Branch newBranch,int branch_number){
		int control = 0;
		ListIterator<Branch> it2 = branches.listIterator();
		
		if(branch_number > 0){
			for(int i=0; i < branches.size(); i++){
				if(branches.get(i).getBranchName() != null && branches.get(i).getBranchName().equals(newBranch.getBranchName()))
					control = 1;
			}
		}

		if(control == 1){
			System.out.println("branch is not added because it already exists!!!\n");
			return 1;
		}
		else{
			branches.add(branch_number,newBranch);
			System.out.println(newBranch.getBranchName() + " branch is added.\n");
		}
		

		ListIterator<Branch> it = branches.listIterator();

		for(int t = 0;it.hasNext(); t++){
			System.out.println((t+1) + " " + it.next().getBranchName());	
						
	}
		return 0;
}


	/** 
	 * This method is used for removing branch.
	 * @param branch_number the order of branch that you want to remove.
	 * @return -1 or 0 to control a flag during the interactive menu
	 */
	public int removeBranch(int branch_number){

    	System.out.println();

		ListIterator<Branch> it = branches.listIterator();

		for(int t = 0;it.hasNext(); t++){
			System.out.println((t+1) + " " + it.next().getBranchName());	
		}				

		ListIterator<Branch> it2 = branches.listIterator();

  		if(branches.size() != 0 && branch_number < branches.size() &&
  		    branches.get(branch_number).getBranchName() != null ){
    		for(int t = 0; it2.hasNext();t++){
    			if(t == branch_number){
    			  it2.next();	
    			  it2.remove();
    			}
    			if(it2.hasNext())
    				it2.next();
    		}

        	System.out.println((branch_number+1) + ". branch is removed.\n");
        	showBranchMenu();
        	return -1;
      		}


      		else{
      			System.out.println("Branch with branchnumber- " + (branch_number+1) + " is not removed because this branch is not found!\n");
      			return 0;
      		}

	}


	/** 
	 * to show branches during interactive menu.
	 */
	public void showBranchMenu(){
		for(int t = 0; t < branches.size(); t++)
			if(branches.get(t).getBranchName() != null)   
				System.out.println((t+1) + " " + branches.get(t).getBranchName());	
	}

	
	/** 
	 * This method is used for adding branch-employee.
	 * @param newEmployee branch-employee to add.
	 * @param branchId the number of the branch where the branch-employee will be added.
	 * @param employeeNum the number of the branch-employee that will be added.
	 */
	public void addBranchEmployee(BranchEmployee newEmployee, int branchId,int employeeNum) {

		int t;

		for(t = 0; t < branches.get(branchId).employees.size(); t++){
			;
		}

		for(int u = 0; u < employeeNum; u++){
			if((branches.get(branchId)).employees.get(u) == newEmployee){
				System.out.println("Error:Branch-employee already assigned to a branch.You can not add same branch-employee to different branches.Please enter again!!!");
				System.exit(-1);
		    }		
		}

			(branches.get(branchId)).employees.add(newEmployee);
			(branches.get(branchId)).employees.get(t).setID(branchId);   
			System.out.println(newEmployee.getName() + " branchemployee is added.\n");
		
		
		for(t = 0; t < branches.get(branchId).employees.size(); t++){
			System.out.println(branches.get((branches.get(branchId)).employees.get(t).getID()).getBranchName() + " - " + (branches.get(branchId)).employees.get(t).getName() +" " +(branches.get(branchId)).employees.get(t).getSurname());
		}

	}


	/** 
	 * This method is used for removing branch-employee.
	 * @param employeeNum the number of the branch-employee that will be removed.
	 */
	public void removeBranchEmployee(int employeeNum) {
		for(int t = 0; t < employees.size(); t++){
		if(branches.get(0).employees.get(t).getName() != null)
			System.out.println((branches.get(branches.get(0).employees.get(t).getID()).getBranchName() + "(" + (branches.get(0).employees.get(t).getID()+1) + ")" + " - " + branches.get(0).employees.get(t).getName() +" " +branches.get(0).employees.get(t).getSurname()));
		}
	}

	/** 
	 * This method is used for removing branch-employee.
	 * @param removeEmployee branch-employee that will be removed.
	 * @param branchId the number of the branch-employee that will be removed.
	 */
	public void removeBranchEmployee(BranchEmployee removeEmployee,int branchId) {
		for(int u = 0; u < branches.get(branchId).employees.size(); u++){
			if(branches.get(branchId).employees.get(u) == removeEmployee){
				System.out.println(removeEmployee.getName() + " branchemployee is removed.\n");
					branches.get(branchId).employees.remove(u);
		    }		
		}

	}

}