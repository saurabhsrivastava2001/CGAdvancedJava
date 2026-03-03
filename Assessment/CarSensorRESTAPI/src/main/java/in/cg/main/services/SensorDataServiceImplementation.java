package in.cg.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cg.main.entities.SensorData;
import in.cg.main.repo.SensorDataRepo;

@Service
public class SensorDataServiceImplementation implements SensorDataService{
	@Autowired
	SensorDataRepo sdr;
	@Override
	public  SensorData addDetails(SensorData sd) {
		// alerts 
		if (sd.getEngineTemperature() > 120) {
            System.out.println("ALERT: Engine temperature too high!");
        }

        if (sd.getFuelLevel() < 15) {
            System.out.println("ALERT: Fuel level low!");
        }
        
        if (sd.getTirePressure() < 28) {
            System.out.println("ALERT: Tire pressure low!");
        }
        
        if (sd.getSpeed() > 140) {
            System.out.println("ALERT: Overspeed detected!");
        }
		return sdr.save(sd);
	}
	@Override
	public List<SensorData> viewRecords(){
		return sdr.findAll();
	}
	@Override
	public SensorData latestRecord() {
		return sdr.findTopByOrderByIdDesc();
	}
}
