package e.hospital.bean;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="OCS_TBL_Slots")
public class SlotBean {
	@Id
	@Column(name="SLOTNUMBER")
private int slotnumber;
	@Column(name="DURATION")
private String slotduration;
	
	
	
	
	public SlotBean() {
		super();
	}

	
	public int getSlotnumber() {
		return slotnumber;
	}


	public void setSlotnumber(int slotnumber) {
		this.slotnumber = slotnumber;
	}


	public String getSlotduration() {
		return slotduration;
	}
	public void setSlotduration(String slotduration) {
		this.slotduration = slotduration;
	}


	@Override
	public String toString() {
		return "SlotBean [slotnumber=" + slotnumber + ", slotduration="
				+ slotduration + "]";
	}

	
	
	
}
