package bean;

public class MemberInfo {
	
	private int member_id;
	
	private int user_id;
	
	private String surname;
	
	private String kana_surname;
	
	private String name;
	
	private String kana_name;
	
	private String age;
	
	private String tel;
	
	private String prefectures;
	
	private String kana_prefectures;
	
	private String municipality;
	
	private String kana_municipality;
	
	private String street_address;
	
	private String building_name;
	
	private String birth_date;
	
	private int withdrawal;
	
	private String update_date;
	
	private byte[] photograph;
	
	private String exhibition_area;
	
	private String nickname;

	public MemberInfo() {
		this.member_id = 0;
		this.user_id = 0;
		this.surname = null;
		this.kana_surname = null;
		this.name = null;
		this.kana_name = null;
		this.age = null;
		this.tel = null;
		this.prefectures = null;
		this.kana_prefectures = null;
		this.municipality = null;
		this.kana_municipality = null;
		this.street_address = null;
		this.building_name = null;
		this.birth_date = null;
		this.withdrawal = 0;
		this.update_date = null;
		this.photograph = null;
		this.exhibition_area = null;
		this.nickname = null;
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getKana_surname() {
		return kana_surname;
	}

	public void setKana_surname(String kana_surname) {
		this.kana_surname = kana_surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKana_name() {
		return kana_name;
	}

	public void setKana_name(String kana_name) {
		this.kana_name = kana_name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPrefectures() {
		return prefectures;
	}

	public void setPrefectures(String prefectures) {
		this.prefectures = prefectures;
	}

	public String getKana_prefectures() {
		return kana_prefectures;
	}

	public void setKana_prefectures(String kana_prefectures) {
		this.kana_prefectures = kana_prefectures;
	}

	public String getMunicipality() {
		return municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public String getKana_municipality() {
		return kana_municipality;
	}

	public void setKana_municipality(String kana_municipality) {
		this.kana_municipality = kana_municipality;
	}

	public String getStreet_address() {
		return street_address;
	}

	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}

	public String getBuilding_name() {
		return building_name;
	}

	public void setBuilding_name(String building_name) {
		this.building_name = building_name;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public int getWithdrawal() {
		return withdrawal;
	}

	public void setWithdrawal(int withdrawal) {
		this.withdrawal = withdrawal;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	public byte[] getPhotograph() {
		return photograph;
	}

	public void setPhotograph(byte[] photograph) {
		this.photograph = photograph;
	}

	public String getExhibition_area() {
		return exhibition_area;
	}

	public void setExhibition_area(String exhibition_area) {
		this.exhibition_area = exhibition_area;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
