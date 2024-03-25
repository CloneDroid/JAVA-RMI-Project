import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Cart extends UnicastRemoteObject implements ProductInterface{
	private ArrayList<Product> addedProducts;
	
	public Cart() throws RemoteException{
		this.addedProducts = new ArrayList<>();
	}
	
	public void addProduct(Product product) {
		try{
		addedProducts.add(product);
		System.out.println("Product added to cart: " + product.getName());
		} catch (RemoteException e) {
			System.out.println("Error adding Product.");
		}
	}
	
	public void displayAddedProducts() {
		System.out.println("Products in cart:");
		for (Product product : addedProducts) {
			try{
			System.out.println("Name: " + product.getName());
			System.out.println("Description: " + product.getDescription());
			System.out.println("Price: " + product.getStoreprice());
			} catch (RemoteException e) {
				System.out.println("Error displaying products in Cart.");
			}
		}
	}

	public void viewSummary(){
		System.out.println("Summary if products in Cart");
		for (Product product : addedProducts) {
			try{
			System.out.println("Name: " + product.getName());
			System.out.println("Description: " + product.getDescription());
			System.out.println("Price: " + product.getStoreprice());
		} catch (RemoteException e){
			System.out.println("Error displaying Summary.");
			}
		}
	}

	@Override
	public String getName() throws RemoteException{
		return null;
	}

	@Override
	public String getDescription() throws RemoteException{
		return null;
	}

	@Override
	public double getStoreprice() throws RemoteException{
		return 0;
	}
	
	@Override
	public double getRetailprice() throws RemoteException{
		return 0;
	}

	@Override
	public int getQuantity() throws RemoteException{
		return 0;
	}

	@Override
	public int getProductcode() throws RemoteException{
		return 0;
	}

	//@Override
	//public void changeProductName() throws RemoteException{
		//return Name;
	//}

}
