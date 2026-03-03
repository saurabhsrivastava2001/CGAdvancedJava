package in.cg.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.cg.main.entities.SensorData;

@Repository
public interface SensorDataRepo extends JpaRepository<SensorData,Integer>{
	public SensorData findTopByOrderByIdDesc();

}