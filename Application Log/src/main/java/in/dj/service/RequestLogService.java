package in.dj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.dj.entity.RequestLog;
import in.dj.repo.RequestLogRepo;


@Service
public class RequestLogService {

	@Autowired
	public RequestLogRepo logRepo;
	
	public void saveUserLog(RequestLog log) {
		logRepo.save(log);
	}
	
}
