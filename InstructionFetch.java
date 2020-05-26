
public class InstructionFetch {
  public static String ProgramCount="0000000000000000";
 // public static String PC;

	public static String [] InstFetch(String PC,Memory M) {//returns instruction and program count
		System.out.println();
		String [] result=new String [2];
		int programcount=Integer.parseInt(PC,2);
		String instruction=M.fetchInst(programcount);
		
		
		System.out.println(instruction+ " in instruction Fetch Stage");
		System.out.println();
//		System.out.println("------------------------------Inputs------------------------------");
//		System.out.println("PC: "+PC);
//		System.out.println("------------------------------------------------------------------");
//		
		String incPC= ProgCount(PC);
		ProgramCount=incPC;
		
		result[0]=instruction;
		result[1]=incPC;
		//System.out.println("----------------------------Outputs---------------------------------");
		System.out.println("Next PC: "+ProgramCount);
		System.out.println("Instruction: "+instruction);
		//System.out.println("----------------------------------------------------------------------");
		return result;
	}
	
	public static String ProgCount(String PC) {//returns pc
		int programcount=Integer.parseInt(PC,2);
		programcount+=4;
		String incPC= Execute.toBinary(programcount, 16);//converts any int to 32 bit string
		return incPC;
	}
	public static String ProgCount1() {//returns pc
		   return ProgramCount;
			
		}
	
	

}
