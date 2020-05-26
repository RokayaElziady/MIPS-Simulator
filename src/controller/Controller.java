//our instruction consists of opcode 4 bits then rd 4 bits then  rs  4 bits then rt 4 bits or immediate 4 bits
public class Controller
 {
	//static Instruction_Memory IM;
	static Register_File RF;
	//static Data_Memory DM;
	static ALU ALU;
	static InstructionFetch IFStage;
	static InstructionDecode IDStage;
	static Execute ExcuteStage;
	static MemoryAccess MAStage;
	static WriteBack WBStage;
	static Memory M;
	static int insructionCycles=0;
	public Test() {
	   // IM=new Instruction_Memory();
	    RF=new Register_File();	
	    M=new Memory();
	//	DM=new Data_Memory();
		ALU=new ALU();
		IFStage=new InstructionFetch();
		IDStage=new InstructionDecode();
	    ExcuteStage=new Execute();
	    MAStage=new MemoryAccess();
	    WBStage=new WriteBack();
	    
	}
	public static void main(String []  args) {
		//our instruction consists of opcode 4 bits then rd 4 bits then  rs  4 bits then rt 4 bits or immediate 4 bits
		Test t=new Test();

	 String [] instructions=new String [6];
	 //MY INSTRUCTIONS ARE ALL IN BINAARYY NOT HEXADECIMAL
	 //if you will test a branch insruction take care to let the bracnch adress is within size of instruction array array
	 
//	 instructions[0]="0001000100100011";//add
//	 instructions[1]="0000001100010001?";//sub

		instructions[0]="1000000100100001";//addi
	
		instructions[1]=	"0111110101000010";//sw
		
		instructions[2]="0001011001000101";//add
		
		instructions[3]="0010110010101011";//or
		
		instructions[4]="0110001100100001";//lw
				
		instructions[5]="0100011001000011";//beq
	// instructions[1]="0111100011000010";
	 //instructions[4]="00000000001000110001100000100000";
	 //instructions[5]="00000000001001100001100000100000";
	
	 insructionCycles=5+instructions.length-1;
//	 System.out.println("cycles"+insructionCycles);
	// System.out.println("cache data:         "+Memory.dataMem.cache[0][0]);
	 M.loadInstructions(instructions);
	 //System.out.println("cache data:     "+Memory.dataMem.cache[0][0]);


	 
	
	
	
	 String []IDPipelineRegister=new String[11];
	 String [] ExcutePiplineRegiter=new String[17];
	 String[] MemoryAccessPipelineRegister= {"0","0","0","0","0"};
	 String [] IF=new String[2];
	
	 int MemWrite;
	 int rt;int rd;
	 for(int i=0;i<insructionCycles;i++) {
		 System.out.println("-----------------------------------------------");
		 System.out.println("cycle: "+(i+1));
		 if(i>3 &&i<instructions.length+4) {
			 //System.out.println("in "+i);
			// if(dec16.equals("1")) {
			 String WriteBack=WBStage.WriteBack(MemoryAccessPipelineRegister[0], MemoryAccessPipelineRegister[1],MemoryAccessPipelineRegister[3],MemoryAccessPipelineRegister[4],RF,MemoryAccessPipelineRegister[2]);
			 //System.out.println(M.memory[3]);
			// System.out.println(IFStage.ProgramCount);
			 //}
		
			 }
		 if((i>2&& i<insructionCycles-1 &&i<instructions.length+3)) {
			      MemoryAccessPipelineRegister=MAStage.MemAccess(ExcutePiplineRegiter[0], ExcutePiplineRegiter[3], ExcutePiplineRegiter[12], ExcutePiplineRegiter[1], ExcutePiplineRegiter[2], ExcutePiplineRegiter[15], ExcutePiplineRegiter[14], ExcutePiplineRegiter[13], M,ExcutePiplineRegiter[5],ExcutePiplineRegiter[6],ExcutePiplineRegiter[7],ExcutePiplineRegiter[8],ExcutePiplineRegiter[9],ExcutePiplineRegiter[10],ExcutePiplineRegiter[16]);
			 }
		 if(i>1&& i<insructionCycles-2&&i<instructions.length+2) {
			 ExcutePiplineRegiter=ExcuteStage.Execute(IDPipelineRegister[8],IDPipelineRegister[9],IDPipelineRegister[1],IDPipelineRegister[2],IDPipelineRegister[10],IDPipelineRegister[3],IDPipelineRegister[4],IDPipelineRegister[0].charAt(0),IDPipelineRegister[0].charAt(1),IDPipelineRegister[0].charAt(2),IDPipelineRegister[0].charAt(3),IDPipelineRegister[0].charAt(5),IDPipelineRegister[0].charAt(6),IDPipelineRegister[5],IDPipelineRegister[6],IDPipelineRegister[7]);
		
			 }
		 if(i>0&& i<insructionCycles-3 &&i<instructions.length+1) {
			 IDPipelineRegister=IDStage.InstDecode(IF[0], IF[1],RF);
	
			  }
		 if(i<insructionCycles-4 &&i<instructions.length) {
		  IF=IFStage.InstFetch(IFStage.ProgramCount, M);}

	 }

	}}
