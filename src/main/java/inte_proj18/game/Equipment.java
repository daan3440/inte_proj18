package inte_proj18.game;

public class Equipment {
	public static final double DEFAULT_ATTRIBUTE_MODIFIER = 1;
	public static final double TWOHANDED_ATTACK_MODIFIER = 0.15;
	public static final double NO_HELMET_PERCEPTION_MODIFIER = 0.1;
	public static final double SPEED_MODIFIER = 0.1;
	public static final double FULL_ARMOR_DEFENCE_MODIFIER = 0.3;
	public static final double SHIELD_DEFENCE_MODIFIER = 0.1;

	private OneHandedWeapon oneHandedWeapon;
	private Shield shield;
	private TwoHandedWeapon twoHandedWeapon;
	private Helmet helmet;
	private BodyArmor bodyArmor;
	private FootWear footWear;

	public void setOneHandedWeapon(OneHandedWeapon oneHandedWeapon) {
		unEquipTwoHandedWeapon();
		this.oneHandedWeapon = oneHandedWeapon;
	}

	public OneHandedWeapon getOneHandedWeapon() {
		return oneHandedWeapon;
	}

	private boolean isOneHandedWeaponEquipped() {
		return oneHandedWeapon != null;
	}

	public void setShield(Shield shield) {
		unEquipTwoHandedWeapon();
		this.shield = shield;
	}

	public Shield getShield() {
		return shield;
	}

	private boolean isShieldEquipped() {
		return shield != null;
	}

	private void unEquipTwoHandedWeapon() {
		if (isTwoHandedWeaponEquipped())
			// Behöver metod för att lägga i in i inventory
			twoHandedWeapon = null;
	}

	public void setHelmet(Helmet helmet) {
		this.helmet = helmet;
	}

	public Helmet getHelmet() {
		return helmet;
	}

	private boolean isHelmetEquipped() {
		return helmet != null;
	}

	public void setBodyArmor(BodyArmor bodyArmor) {
		this.bodyArmor = bodyArmor;
	}

	public BodyArmor getBodyArmor() {
		return bodyArmor;
	}

	private boolean isBodyArmorEquipped() {
		return bodyArmor != null;
	}

	public void setFootWear(FootWear footWear) {
		this.footWear = footWear;
	}

	public FootWear getFootWear() {
		return footWear;
	}

	private boolean isFootWearEquipped() {
		return footWear != null;
	}

	public void setTwoHandedWeapon(TwoHandedWeapon twoHandedWeapon) {
		unEquipOneHandedWeaponAndShield();
		this.twoHandedWeapon = twoHandedWeapon;
	}

	private boolean isTwoHandedWeaponEquipped() {
		return twoHandedWeapon != null;
	}

	private void unEquipOneHandedWeaponAndShield() {
		if (isOneHandedWeaponEquipped())
			// Behöver metod för att lägga i in i inventory
			oneHandedWeapon = null;
		if (isShieldEquipped())
			// Behöver metod för att lägga i in i inventory
			shield = null;
	}

	public TwoHandedWeapon getTwoHandedWeapon() {
		return twoHandedWeapon;
	}

	public double getAttackModifier() {
		return isTwoHandedWeaponEquipped() ? DEFAULT_ATTRIBUTE_MODIFIER + TWOHANDED_ATTACK_MODIFIER
				: DEFAULT_ATTRIBUTE_MODIFIER;
	}

	public double getPerceptionModifier() {
		return !isHelmetEquipped() ? DEFAULT_ATTRIBUTE_MODIFIER + NO_HELMET_PERCEPTION_MODIFIER
				: DEFAULT_ATTRIBUTE_MODIFIER;
	}

	public double getSpeedModifier() {
		return (isFootWearEquipped() ? SPEED_MODIFIER + getSpeedModifierForNoArmor() + DEFAULT_ATTRIBUTE_MODIFIER
				: DEFAULT_ATTRIBUTE_MODIFIER);
	}

	private double getSpeedModifierForNoArmor() {
		return !isAnyArmorEquipped() ? SPEED_MODIFIER : 0;
	}

	private boolean isAnyArmorEquipped() {
		return isBodyArmorEquipped() || isHelmetEquipped();
	}

	public double getDefenceModifier() {
		return (isShieldEquipped() ? SHIELD_DEFENCE_MODIFIER : 0)
				+ (isFullArmorEquipped() ? FULL_ARMOR_DEFENCE_MODIFIER : 0) + DEFAULT_ATTRIBUTE_MODIFIER;
	}

	private boolean isFullArmorEquipped() {
		return isBodyArmorEquipped() && isFootWearEquipped() && isHelmetEquipped();
	}

}
