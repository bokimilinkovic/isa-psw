package team47pack.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import team47pack.models.ClinicAdmin;
import team47pack.models.Doctor;
import team47pack.models.ExaminationType;
import team47pack.models.NextProcedure;
import team47pack.models.Patient;
import team47pack.models.Room;
import team47pack.repository.ClinicAdminRepo;
import team47pack.repository.DoctorRepo;
import team47pack.repository.ExaminationTypeRepo;
import team47pack.repository.NextProcedureRepo;
import team47pack.repository.RoomRepo;

@Service
public class FastExaminationService {

	@Autowired
	private ClinicAdminRepo caRepo;
	
	@Autowired
	private ExaminationTypeRepo examTypeRepo;
	
	@Autowired
	private RoomRepo roomRepo;
	
	@Autowired
	private DoctorRepo doctorRepo;
	
	@Autowired
	private NextProcedureRepo nextProcedureRepo;

	public boolean addExamination(JSONObject obj, String email) throws JSONException, ParseException {
		ClinicAdmin ca = caRepo.findByEmail(email);
		if (ca == null)
			return false;

		if (obj.get("date") == null || obj.get("time") == null || obj.get("examTypeId") == null
				|| obj.get("roomId") == null || obj.get("doctorId") == null)
			return false;
		
		if (obj.get("date").equals("") || obj.get("time").equals("") || obj.get("examTypeId").equals("")
				|| obj.get("roomId").equals("") || obj.get("doctorId").equals(""))
			return false;
		
		Long examTypeId = obj.getLong("examTypeId");
		Long roomId = obj.getLong("roomId");
		Long doctorId = obj.getLong("doctorId");
		
		Optional<ExaminationType> examType = examTypeRepo.findById(examTypeId);
		if(!examType.isPresent())
			return false;
		
		Optional<Room> room = roomRepo.findById(roomId);
		if(!room.isPresent())
			return false;
		
		Optional<Doctor> doctor = doctorRepo.findById(doctorId);
		if(!doctor.isPresent())
			return false;
		//sredi date
		String[] s = obj.get("date").toString().split("-");
		String ds = s[2]+"/"+s[1]+"/"+s[0];
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(ds);
		int time = obj.getInt("time");
		
		NextProcedure np = new NextProcedure("Examination", date, null, doctor.get(), examType.get(), time);		
		nextProcedureRepo.save(np);
		
		return true;
	}

	public List<NextProcedure> getFastExaminations(String email) {
		Pageable pageable = PageRequest.of(0, 30);
		Page<NextProcedure> page = nextProcedureRepo.findByPatientAndArranged(null,false,pageable);		
		return page.getContent();

	}

	public List<Doctor> getDoctors(String email) {
		ClinicAdmin ca = caRepo.findByEmail(email);
		if (ca == null)
			return new ArrayList<>();
		Long clinicId = Long.parseLong(""+ca.getClinic());
		List<Doctor> doctors = doctorRepo.findByClinicId(clinicId);
		
		return doctors;
	}

	public List<Room> getRooms(String email) {
		ClinicAdmin ca = caRepo.findByEmail(email);
		if (ca == null)
			return new ArrayList<>();
		List<Room> rooms = roomRepo.findByTypeAndClinicId("Examination",ca.getClinic());
		
		return rooms;
	}

	public List<ExaminationType> getExaminationTypes(String specialization, String email) {
		ClinicAdmin ca = caRepo.findByEmail(email);
		if (ca == null)
			return new ArrayList<>();
		List<ExaminationType> examTypes = examTypeRepo.findByClinicAndSpecialization(Long.parseLong(""+ca.getClinic()), specialization);
	
		return examTypes;
	}

}
