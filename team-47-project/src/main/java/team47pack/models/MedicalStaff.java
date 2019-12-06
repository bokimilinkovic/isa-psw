package team47pack.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class MedicalStaff extends User {
	
	@Column(name="onVacation", unique=false, nullable=false)
	protected Boolean onVacation;
	
	@Column(name="clinic_id", unique=false, nullable=false)
	protected Long clinicId;

	public Boolean getOnVacation() {
		return onVacation;
	}

	public void setOnVacation(Boolean onVacation) {
		this.onVacation = onVacation;
	}

	public Long getClinicId() {
		return clinicId;
	}

	public void setClinicId(Long clinicId) {
		this.clinicId = clinicId;
	}
	
	
	
	
}
