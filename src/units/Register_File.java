
public class Register_File {

	static Register [] registers;
	
	
	public Register_File() {
		registers=new Register[16];
		for(int i=0;i<15;i++){
			registers[i]=new Register("R"+i%16+"", Integer.toBinaryString(i)+"");
			
		}
		registers[15]=new Register("ZERO", 0+"");
	}
	public String getVal(int idx){
		return this.registers[idx].value;
	}
	
	public static  int [] decode(int rs,int rt,int rd) {
		int [] result=new int [2];
		result[0]=Integer.parseInt(registers[rs].value,2);
		result[1]=Integer.parseInt(registers[rt].value,2);
		
		
		return result;
	}
	
}
