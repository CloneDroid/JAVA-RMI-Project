import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProductInterface extends Remote{
	// Lets us define API
	public String getName() throws RemoteException;
	public String getDescription() throws RemoteException;
	public int getProductcode() throws RemoteException;
	public double getRetailprice() throws RemoteException;
	public double getStoreprice() throws RemoteException;
	public int getQuantity() throws RemoteException;
	//public void changeProductName(String newName) throws RemoteException;
	
}