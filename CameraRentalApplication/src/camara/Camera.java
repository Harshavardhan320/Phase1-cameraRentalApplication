package camara;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class CameraDetails{
	private int id;
	private String brandName;
	private String model;
	private int prise;
	private String status;
	
	//constructer;
	public CameraDetails(int id, String brandName, String model, int prise, String status) {
		
		this.id = id;
		this.brandName = brandName;
		this.model = model;
		this.prise = prise;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrise() {
		return prise;
	}

	public void setPrise(int prise) {
		this.prise = prise;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
public class Camera {
	public Camera() {
	
		// CameraList.add(new CameraDetails(123, "sony", "dslr678", 23000, "Avaliable"));
		// CameraList.add(new CameraDetails(125, "vivo", "dslr78", 53000, "Avaliable"));
		// CameraList.add(new CameraDetails(1, "oppo", "dslr68", 23000, "Avaliable"));
		// CameraList.add(new CameraDetails(2, "mi", "dslr6", 13000, "Avaliable"));
		// CameraList.add(new CameraDetails(120, "Apple", "dslr000", 30020, "Avaliable"));
		// CameraList.add(new CameraDetails(128, "realme", "dslroo", 300440, "Avaliable"));
		// CameraList.add(new CameraDetails(121, "samsung", "dslr7834", 34000, "Avaliable"));
		// CameraList.add(new CameraDetails(12, "nokhia", "dslr10101", 30000, "Avaliable"));
		// CameraList.add(new CameraDetails(90, "color", "dslr420", 40003, "Avaliable"));
		// CameraList.add(new CameraDetails(45, "milkey", "dslr640", 70030, "Avaliable"));


		/* uncomment code while using the application it is abour testing  */

	}
	public ArrayList<CameraDetails> CameraList = new ArrayList<>();

	
	
	//Adding Camera To the list
	public void addCamera(int id, String brandName, String model, int prise, String status) {
		
		if(id > 0 && brandName != null && model != null && prise > 0 && status != null ) {
			CameraList.add(new CameraDetails(id, brandName, model, prise, status));
			System.out.println(" Camera Has Been Sucessfully Added To The List");
		}else {
			System.out.println("Error Incomplete Filds");
		}
	}
	
	//printing the camera to the list
	
	public void ViewCameraList() {
		if(CameraList.isEmpty()) {
			System.out.println("No Data Present at This Moment.");
			return;
		}
		//sorting 
		Collections.sort(CameraList, Comparator.comparingInt(CameraDetails::getId));
		System.out.println();
		System.out.println("|====================================================================|");
		System.out.println("ID          Brand          Model          Prise          Status");
		System.out.println("|====================================================================|");
		
		//Printing the list
		for(int i=0; i < CameraList.size(); i++) {
			System.out.println(CameraList.get(i).getId()+"          "+CameraList.get(i).getBrandName()+"          "+CameraList.get(i).getModel()
					+"          "+
					CameraList.get(i).getPrise()+"          "+CameraList.get(i).getStatus());
		}
		System.out.println();
		System.out.println("|=====================================================================|");
		System.out.println();
	}
	
	public void RemoveCamara(int id) {
		if(CameraList.isEmpty()) {
			System.out.println("No Data Present at This Moment.");
			return;
		}
		int index =-1;
		for(int i=0; i < CameraList.size(); i++) {
			if(id == CameraList.get(i).getId()) {
				CameraDetails delete = CameraList.get(i);
				CameraList.remove(delete);
				index = 1;
				break;
			}
		}
		if(index ==1) {
			System.out.println("Camera Successfully Removed From The List");
		}else {
			System.out.println("No Camera Found In The List With Id "+id);
		}
	}
	
	
	public int rentcamera(int id) {
		int rentamount =-1;
		int index = -1;
		for(int i=0; i < CameraList.size(); i++) {	
			if(id == CameraList.get(i).getId()) {
				if(CameraList.get(i).getStatus() == "Rented") {
					return -1;
				}
				rentamount = CameraList.get(i).getPrise();
				index =1;
				break;
			}
		}
		if(index ==1) {
			return rentamount;
		}else {
			return rentamount;
		}
		
	}
	public void setStatus(int id) {
		for(int i=0; i < CameraList.size(); i++) {
			if(id == CameraList.get(i).getId()) {
				CameraList.get(i).setStatus("Rented");
				System.out.printf("YOUR TRANSACTION FOR CAMERA -%s %s with rent INR %s HAS SUCCESSFULLY COMPLETED FOR ONE DAY",CameraList.get(id).getBrandName(),CameraList.get(id).getModel(),CameraList.get(id).getPrise()+"\n");
				break;
			}
		}
		
	}
	
}








