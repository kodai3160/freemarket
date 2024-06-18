package bean;

public class AdministratorInfo {

	private int administratorId;

	private int userId;

	private String surname;

	private String kanaSurname;

	private String name;

	private String kanaName;

	private String registrationDate;

	private String updateDate;

	public AdministratorInfo() {

		this.administratorId = 0;

		this.userId = 0;

		this.surname = null;

		this.kanaSurname = null;

		this.name = null;

		this.kanaName = null;

		this.registrationDate = null;

		this.updateDate = null;

	}

	public int getAdministratorId() {
		return administratorId;
	}

	public void setAdministratorId(int administratorId) {
		this.administratorId = administratorId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getKanaSurname() {
		return kanaSurname;
	}

	public void setKanaSurname(String kanaSurname) {
		this.kanaSurname = kanaSurname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKanaName() {
		return kanaName;
	}

	public void setKanaName(String kanaName) {
		this.kanaName = kanaName;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
}
