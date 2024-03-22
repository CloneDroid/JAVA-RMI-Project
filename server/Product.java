import java.rmi.RemoteException;

public class Product implements ProductInterface{
	// Attributes of product
	private String name;
	private String description;
	private int productcode;
	private double retailprice;
	private double storeprice;
	private int quantity;

	Product(String newName, String newDescription, int newProductcode, double newRetailprice, double newStoreprice, int newQuantity) throws RemoteException{
		this.name = newName;
		this.description = newDescription;
		this.productcode = newProductcode;
		this.retailprice = newRetailprice;
		this.storeprice = newStoreprice;
		this.quantity = newQuantity;
	}
	public String getName() throws RemoteException{
		return this.name;
	}
	public String getDescription() throws RemoteException{
		return this.description;
	}
	public int getProductcode() throws RemoteException{
		return this.productcode;
	}
	public double getRetailprice() throws RemoteException{
		return this.retailprice;
	}
	public double getStoreprice() throws RemoteException{
		return this.storeprice;
	}
	public int getQuantity() throws RemoteException{
		return this.quantity;
	}
	public void changeProductName(String newName) throws RemoteException{
		this.name = newName;
	}
	public void viewProducts(){
		System.out.println("Name:" + this.name);
		System.out.println("Description:" + this.description);
		System.out.println("Product Code:" + this.productcode);
		System.out.println("Retail Price:" + this.retailprice);
		System.out.println("Store Price:" + this.storeprice);
		System.out.println("Quantity:" + this.quantity);
	}
}