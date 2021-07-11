/**
 * @author Can Duyar 171044075
 * BranchEmployee class which is extends from Branch class and implements the User interface
 */


public class BranchEmployee extends Branch implements Users{

	/**
	 * It's for name of branch-employee.
	 */
	private String name;

	/**
	 * It's for surname of branch-employee.
	 */

	private String surname;
	/**
	 * It's for id of branch-employee.
	 */
	private int ID;


	/**
	 * Branch employee constructor with three-parameters
	 * @param branchName name of the branch
	 * @param name name of the branch-employee
	 * @param surname surname of the branch-employee
	 */

	public BranchEmployee(String branchName, String name, String surname) {
		super(branchName);
		this.name = name;
		this.surname = surname;	
	}

	/**
	 * This method gets the branch employee's name.
	 * @return branch employee's name.
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * This method sets the branch employee's name.
	 * @param name branch employee's name.
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method gets the branch employee's surname.
	 * @return branch employee's surname.
	 */
	@Override
	public String getSurname() {
		return surname;
	}


	/**
	 * This method sets the branch employee's surname.
	 * @param surname branch employee's surname.
	 */
	@Override
	public void setSurname(String surname) {
		this.surname = surname;
	}


	/**
	 * This method gets the branch employee's ID.
	 * @return branch employee's ID.
	*/
	public int getID() {
		return ID;
	}

	/**
	 * This method sets the branch employee's ID.
	 * @param ID int value of the branch employee's ID.
	*/
	public void setID(int ID) {
		this.ID = ID;
	}


	/**
	 * This method shows the list of products if their stock number is not equal to 0.
	 */
	public void seeFurnitures(){
			//see the list of products
				for(int i=0; i < (products.get(0).size()); i++){
					if(products.get(0).get(i).getStock() > 0){
						System.out.println((i+1)+"." + "Product: " + products.get(0).get(i).getProduct());
						System.out.println("Color: " + products.get(0).get(i).getColor());
						System.out.println("Model: " + products.get(0).get(i).getModel());
						System.out.println("Number of stock: " + products.get(0).get(i).getStock());
						System.out.println("\n");
					}
					else{
						System.out.println("Stock is empty now.\n");
					}
				}
			}
	

	/**
	 * This method for making sale.
	 * @param cust object of sales customer
	 * @param furn object of sold Furniture
	 * @param number number of sold furnitures
	 */
	public void makeSale(Customer cust, Furniture furn,int number){

		if(cust.buy(furn,number))
			System.out.println("Sale is done for this customer :).\n");
		
	}

	/**
	 * This method adds product.
	 * @param fur Furniture to add. 
	 * @param number_add the number of the products that will be added.
	 */

	public void addProduct(Furniture fur, int number_add){
	
		if(number_add > 0 && furnitureNum > 0){
			int control = -1;
			for(int t=0; t<furnitureNum; t++){
				if(products.get(0).get(t).getProduct() == fur.getProduct() && products.get(0).get(t).getModel() == fur.getModel()){
					control = t;
					furnitureNum += 1;
					break;
				}
			}
			if(control != -1){
				products.get(0).get(control).setStock(products.get(0).get(control).getStock() + number_add);
			}
			else if(control == -1){
				System.out.println("There is no product that you want to add in stock.\n");
			}
		}
	}

	/**
	 * This method removes the product.
	 * @param fur Furniture to remove. 
	 * @param number_remove the number of the products that will be removed.
	 */
	public void removeProduct(Furniture fur, int number_remove){
	
		if(number_remove > 0 && furnitureNum > 0){
			int control = -1;
			for(int t=0; t<furnitureNum; t++){
				if(products.get(0).get(t).getProduct().equals(fur.getProduct()) && products.get(0).get(t).getModel().equals(fur.getModel())){
					control = t;
					break;
				}
			}
			if(control != -1){
				products.get(0).get(control).setStock(products.get(0).get(control).getStock() - number_remove);
			}
			else if(control == -1){
				System.out.println("There is no product that you want to remove from the stock.\n");
			}
		}
		
	}

	/**
	 * method to access product informations of a customer.
	 * @param customId id of specific customer.
	 */
	public void accessProductInformation(int customId){
		for(int t = 0; t < customers.size(); t++){
			if(customers.get(t).getNumber() == customId){
				customers.get(t).seePreviousOrders();

			}
		  }
	    }

	/**
	 * method to show products that have 0 stock number.Branch employee informs manager for these products.
	 * @return if this object is member of branches then it returns true otherwise returns false.
	 */

	public void informManager(){
		boolean querycontrol = false;
		System.out.println("Administrator was informed by branch-employee for following products.");
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
			System.out.println("No need to inform administrator because there is no furniture that need to be supplied!!!");
		}
	}

	/**
	 * method for controling an object is member of branches or not.
	 * if this object is member of branches then it returns true otherwise returns false.
	 * @param object Branch object to control.
	 * @return true or false
	 */
	@Override
	public boolean isInThere(Branch object) {
		BranchEmployee employee = (BranchEmployee) object;
		for(int t = 0; t < branches.size(); t++){
			if(employee.getBranchName() == branches.get(t).getBranchName()) {
				for(int i = 0; i < employees.size(); i++){
					if(employees.get(i) == employee)
						return true;
				}
		}
	}

		return false;
	}



}