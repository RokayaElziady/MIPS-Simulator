import java.util.ArrayList;

public class MemoryAccess {

	
	public String [] MemAccess(String ALUresult,String ReadData2,String SignExtend,String ZeroFlag,String BranchAddressResult,String MemWrite,String MemRead,String Branch,Memory M,String instruction,String MemtoReg,String rd,String rs,String rt,String opcode,String RegWrite) {
		System.out.println();
		System.out.println(instruction+ " in Memory Access Stage");
		System.out.println();
//		System.out.println("------------------------------Inputs------------------------------");
		System.out.println("ALU result: "+ALUresult);

//		System.out.println("sign extend: "+SignExtend);
//		System.out.println("zero flag: "+ZeroFlag);
//		System.out.println("branch address result: "+BranchAddressResult);
//		System.out.println("memory write: "+MemWrite);
//		System.out.println("memread: "+MemRead);
//		System.out.println("branch: "+Branch);
//		System.out.println("------------------------------------------------------------------");
		String [] result=new String [5];
		int Result=Integer.parseInt(ALUresult,2);
		if(MemRead.equals("1")) {
			ReadData2=M.fetchData(Integer.parseInt(ALUresult,2));
		}
		if(MemWrite.equals("1")) {
			
		    M.writeBack(Integer.parseInt(ALUresult,2), ReadData2);
		}
		if(instruction.substring(0,4).equals("0110"))
			System.out.println("memory word read:  "+ReadData2);
		else
			System.out.println("memory word read: don't care");
//		if(opcode.equals("0000")||opcode.equals("0001")||opcode.equals("0011")||opcode.equals("0010"))
//			System.out.println("rt/rd fields : "+rd);
//		else
//			System.out.println("rt/rd fields : "+rt);

		System.out.println("rt/rd fields : "+rd);
		System.out.println("WB controls :  MemtoReg: "+MemtoReg);
//		System.out.println("------------------------------OUTPUT------------------------------");
//		System.out.println("Alu result: "+ALUresult);
//		System.out.println("read data 2: "+ReadData2);
//		System.out.println("------------------------------------------------------------------");
		result[0]=ALUresult;
		result[1]=ReadData2;
		result[2]=instruction;
		result[3]=MemtoReg;
		result[4]=RegWrite;
		return result;
		
	}

}
