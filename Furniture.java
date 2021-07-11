/**
 * @author Can Duyar 171044075
 * Furniture class which is extended from Company class
 */

public class Furniture extends Company{

	/**
	 *this variable is for product numbers in stock
	 */
	private int stock;
	
	/**
	 *this variable is for product name
	 */
	private String product;

	/**
	 *this variable is for model name
	 */
	private String model;

	/**
	*this variable is for color
	*/
	private String color;

	/**
	 *this variable is for branch of product
	 */
	private int productBranch;



	/**
	*Furniture constructor with three parameters to initialize some informations
	* @param product name of the product
	* @param model name of the model
	* @param productBranch name of the product's branch.
	*/

	public Furniture(String product, String model, int productBranch){
		this.stock = 0;
		this.product = product;
		this.model = model;
		this.color = "None";
		this.productBranch = productBranch;
	}


	/**
	*Furniture constructor with four parameters to initialize some informations
	* @param product name of the product
	* @param model name of the model
	* @param color name of the color 
	* @param productBranch name of the product's branch.
	*/

	public Furniture(String product, String model, String color, int productBranch){

		this.product = product;
		this.model = model;
		this.color = color;
		this.productBranch = productBranch;

	}

	/**
	 * This method gets number in stock.
	 * @return number in stock.
	 */

	public int getStock(){
		return stock;
	}

	/**
	 * This method sets number in stock of furniture.
	 * @param stock number in stock of a furniture.
	 */

	public void setStock(int stock){
		this.stock = stock;
	}

	/**
	 * This method gets the branch name of product.
	 * @return branch name of product.
	 */
	public int getProductBranch(){
		return productBranch;
	}

	/**
	 * This method sets branch of product.
	 * @param productBranch branch name of product.
	 */
	public void setProductBranch(int productBranch){
		this.productBranch = productBranch;
	}


	/**
	 * This method gets name of product.
	 * @return name of product.
	 */
	public String getProduct(){
		return product;
	}


	/**
	 * This method sets name of product.
	 * @param product name of product.
	 */
	public void setProduct(String product){
		this.product = product;
	}

	/**
	 * This method gets model of product.
	 * @return model of product.
	 */
	public String getModel(){
		return model;
	}


	/**
	 * This method sets model of product.
	 * @param model model of product.
	 */

	public void setModel(String model){
		this.model = model;
	}


	/**
	 * This method gets color of product.
	 * @return color of product.
	 */
	public String getColor(){
		return color;
	}


	/**
	 * This method sets color of product.
	 * @param color color of product.
	 */
	public void setColor(String color){
		this.color = color;
	}
	
}
