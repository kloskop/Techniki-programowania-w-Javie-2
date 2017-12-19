package pl.edu.agh.mwo.java2;

public enum KolumnaEnum {

		A(0), B(1), C(2), D(3), E(4), F(5), G(6), H(7), J(8);
		public final int value;

		private KolumnaEnum(int value) {
			this.value = value;
		}
		
		public static String getNameByCode(int code){
			  for(KolumnaEnum e : KolumnaEnum.values()){
			    if(code == e.value) return e.name();
			  }
			  return null;
			}
		
}
