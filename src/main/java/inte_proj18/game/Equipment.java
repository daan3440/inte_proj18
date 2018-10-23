package inte_proj18.game;

public class Equipment {
	public static final double DEFAULT_ATTRIBUTE_MODIFIER = 1;
	public static final double TWOHANDED_ATTACK_MODIFIER = 0.15;
	public static final double NO_HELMET_PERCEPTION_MODIFIER = 0.1;
	
	private OneHandedWeapon oneHandedWeapon;
	private Shield shield;
	private TwoHandedWeapon twoHandedWeapon;
	private Helmet helmet;
	private BodyArmor bodyArmor;
	private FootWear footWear;

	public void setOneHandedWeapon(OneHandedWeapon oneHandedWeapon) {
		this.oneHandedWeapon = oneHandedWeapon;
	}

	public OneHandedWeapon getOneHandedWeapon() {
		return oneHandedWeapon;
	}

	public void setShield(Shield shield) {
		this.shield = shield;
	}

	public Shield getShield() {
		return shield;
	}

	public void setHelmet(Helmet helmet) {
		this.helmet = helmet;
	}

	public Helmet getHelmet() {
		return helmet;
	}

	public void setBodyArmor(BodyArmor bodyArmor) {
		this.bodyArmor = bodyArmor;
	}

	public BodyArmor getBodyArmor() {
		return bodyArmor;
	}

	public void setFootWear(FootWear footWear) {
		this.footWear = footWear;
	}

	public FootWear getFootWear() {
		return footWear;
	}

	public void setTwoHandedWeapon(TwoHandedWeapon twoHandedWeapon) {
		this.twoHandedWeapon = twoHandedWeapon;
	}

	public TwoHandedWeapon getTwoHandedWeapon() {
		return twoHandedWeapon;
	}
	
	public double getAttackModifier() {
		return isTwoHandedEquiped() ? DEFAULT_ATTRIBUTE_MODIFIER+TWOHANDED_ATTACK_MODIFIER:DEFAULT_ATTRIBUTE_MODIFIER;
	}
	
	private boolean isTwoHandedEquiped() {
		return twoHandedWeapon != null;
	}
	
	public double getPerceptionModifier() {
		return !isHelmetEquiped() ? DEFAULT_ATTRIBUTE_MODIFIER+NO_HELMET_PERCEPTION_MODIFIER:DEFAULT_ATTRIBUTE_MODIFIER;
	}
	
	private boolean isHelmetEquiped() {
		return helmet != null;
	}

}
