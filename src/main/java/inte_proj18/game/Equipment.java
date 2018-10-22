package inte_proj18.game;

public class Equipment {
	private OneHandedWeapon oneHandedWeapon;
	private Shield shield;
	private Helmet helmet;
	private BodyArmor bodyArmor;
	private FootWear footWear;
	
	
	public void setOneHandedWeapon(OneHandedWeapon oneHandedWeapon) {
		this.oneHandedWeapon=oneHandedWeapon;
	}
	public OneHandedWeapon getOneHandedWeapon() {
		return oneHandedWeapon;
	}
	public void setShield(Shield shield) {
		this.shield=shield;
	}
	public Shield getShield() {
		return shield;
	}
	public void setHelmet(Helmet helmet) {
		this.helmet=helmet;
	}
	public Helmet getHelmet() {
		return helmet;
	}
	public void setBodyArmor(BodyArmor bodyArmor) {
		this.bodyArmor=bodyArmor;
	}
	public BodyArmor getBodyArmor() {
		return bodyArmor;
	}
	public void setFootWear(FootWear footWear) {
		this.footWear=footWear;
	}
	public FootWear getFootWear() {
		return footWear;
	}
}
