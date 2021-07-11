import java.util.Scanner;

/**
 * @author Can Duyar 171044075
 * Company class
 */

public class Company{
	/**
	* this linkedlist keeps all branches of the automation system.
	*/
	protected static KWLinkedList<Branch> branches = new KWLinkedList<>();
	/**
	* this linkedlist keeps all branch-employees of the automation system.
	*/	
	protected static KWArrayList<BranchEmployee> employees = new KWArrayList<>();

	/**
	* this arraylist keeps all customers of the automation system.
	*/
	protected static KWArrayList<Customer> customers = new KWArrayList<>();

	/**
	* this HybridList keeps all products of the automation system.
	*/ 
	protected static HybridList<Furniture> products = new HybridList<>();

	/**
	* it keeps number of furnitures of the automation system.
	*/
	protected static int furnitureNum = 0;

	/**
	* it keeps number of customers of the automation system.
	*/
	protected static int customerID;


	/**
	* this is a variable from Administrator type to reach methods of Administrator class from Company class.
	*/

	private Administrator admin;


	/**
	* No-parameter Company constructor.
	*/
	public Company(){}


	/**
	 * This method gets admin object.
	 * @return admin object.
	 */
	public Administrator getAdmin(){
		return admin;
	}


	/**
	 * This method gets number of furnitures.
	 * @return number of furnitures.
	 */
	public int getfurnitureNum(){
		return furnitureNum;
	}

	/**
	 * This method gets customers array.
	 * @return customers array.
	 */
	public KWArrayList<Customer> getCustomers(){
		return customers;
	}


	/**
	 * This method gets number of customers.
	 * @return number of customers.
	 */
	public int getcustomerID(){
		return customerID;
	}

	/**
	 * This method gets arraylist of employees.
	 * @return employees arraylist.
	 */
	public KWArrayList<BranchEmployee> getEmployeeList(){
		return employees;
	}


	/**
	 * This method sets number of customer.
	 * @param nc number of customer.
	 */
	public void setcustomerID(int nc){
		this.customerID = nc;
	}

	/**
	 * This method gets hybridlist of products.
	 * @return products hybridlist.
	 */
	public HybridList<Furniture> getProductList(){
		return products;
	}

	
	/**
	 * This method sets administrator object.
	 * @param admin Administrator object.
	 */
	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}	



	/**
	 * This method gets branch object if it's member of branches.
	 * @return branch object.
	 */
	public Branch getBranch(Branch branch) throws Exception {
		if(branches.size() > 0 && branches.get(0).isInThere(branch))
			return branch;
		else
			throw new Exception("This company has not the branch.\n");
	}


	/**
	 * This method shows customers.
	 */	
	public void showCustomers(){

		boolean control = false;
		for(int t = 0; t < customers.size(); t++){
			if(customers.get(t).getName() != null){
				System.out.println();
				System.out.println((customers.get(t).getNumber()+1) + ". Customer:");
				System.out.println("Name: " + customers.get(t).getName());
				System.out.println("Surname: " + customers.get(t).getSurname());
				System.out.println("Customer Number: " + (customers.get(t).getNumber()+1));
				control = true;
			}
		}

		if(control == false){
			System.out.println("There is no customer...");
			return;
		}
	}


	/**
	 * This method shows list of products.
	 * @param manage_menuPanel this parameter determines which informations of products will be printed in the menu.
	 */	

	public void seeFurnitures(int manage_menuPanel){
		//see the list of products
		if(manage_menuPanel == 1 || manage_menuPanel == 2){
			for(int i=0; i < furnitureNum; i++){
				if(products.get(0).get(i).getStock() > 0){
					System.out.println((i+1)+"." + "Product: " + products.get(0).get(i).getProduct());
					System.out.println("Color: " + products.get(0).get(i).getColor());
					System.out.println("Model: " + products.get(0).get(i).getModel());
					System.out.println("Number of stock: " + products.get(0).get(i).getStock());
					System.out.println("\n");
				}
				else{ 
					System.out.println("Product stock is empty now.\n");
				}
			}
		}
		//see the list of products
		if(manage_menuPanel == 3){
			for(int i=0;i < (products.getIndex()+1); i++){
				if(products.get(0).get(i).getStock() > 0){
					System.out.println((i+1)+"." + "Product: " + products.get(0).get(i).getProduct());
					System.out.println("Color: " + products.get(0).get(i).getColor());
					System.out.println("Model: " + products.get(0).get(i).getModel());
					System.out.println("Number of stock: " + products.get(0).get(i).getStock());
					System.out.println("Branch: " + products.get(0).get(i).getProductBranch());
					System.out.println("\n");
				}
				else{
					System.out.println("Product stock is empty now.\n");
				}
			}
		}
		if(manage_menuPanel == -1){
			String storeName;
			Scanner inpu = new Scanner(System.in);
			System.out.println("Please enter the name of product to see which store is in:");
			storeName = inpu.next();
			for(int i=0;i < products.get(0).size()-1; i++){
				if(products.get(0).get(i).getStock() > 0 && products.get(0).get(i).getProduct().equals(storeName)){
					System.out.println((i+1)+"." + "Product: " + products.get(0).get(i).getProduct());
					System.out.println("Color: " + products.get(0).get(i).getColor());
					System.out.println("Model: " + products.get(0).get(i).getModel());
					System.out.println("Number of stock: " + products.get(0).get(i).getStock());
					System.out.println("Branch: " + products.get(0).get(i).getProductBranch());
					System.out.println("\n");
				}
			}
		}
    }
}