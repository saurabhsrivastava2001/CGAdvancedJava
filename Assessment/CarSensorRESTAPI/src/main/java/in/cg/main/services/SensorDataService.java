package in.cg.main.services;

import java.util.List;

import in.cg.main.entities.SensorData;

public interface SensorDataService {
	
	public  SensorData addDetails( SensorData sd);
	public List<SensorData> viewRecords();
	public SensorData latestRecord();
}
