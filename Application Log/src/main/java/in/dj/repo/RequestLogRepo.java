package in.dj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.dj.entity.RequestLog;



public interface RequestLogRepo  extends JpaRepository<RequestLog, Long>{

}
