package in.cg.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.cg.main.entities.SensorData;
import in.cg.main.services.SensorDataService;

@RestController
public class MyController {
	
	@Autowired
	SensorDataService sds;
	
	@PostMapping("/record")
	public SensorData addRecord(@RequestBody SensorData sd) {
		return sds.addDetails(sd);
	}
	@GetMapping("/view")
	public List<SensorData> viewRecords(){
		return sds.viewRecords();
	}
	@GetMapping("/latest")
	public SensorData latestRecord() {
		return sds.latestRecord();
	}
	
}
