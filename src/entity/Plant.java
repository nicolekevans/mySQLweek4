package entity;

public class Plant {
	private int plantId;
	private String plantName;
	
	
	public Plant(int plantId, String plantName) {
		this.setPlantId(plantId);
		this.setPlantName(plantName);
		;
		
	}

	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	
	
	
}
