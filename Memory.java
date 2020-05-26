import java.util.ArrayList;

public class Memory {
       static String [] memory=new String [2048]; //data memory is first half and instructuon are second half
       static cache dataMem=new cache(256);
   	   static cache insMem=new cache(1024);
       
       public Memory() {
    	   for(int j=0;j<1024;j++) {
    		   memory[j]=Execute.toBinary(j, 16);
    	   }
    	   for(int i=0;i<dataMem.cache.length;i++) {
    		   dataMem.cache[i][0]="";
    		   dataMem.cache[i][1]="0";
    		   dataMem.cache[i][2]="";
    	   }
    	   
       }
       public static String fetchInst(int PC) {
    	   if(insMem.cache[(PC/4)%(insMem.cache.length)][1].equals("1")&&insMem.cache[(PC/4)%(insMem.cache.length)][2].equals(((PC/4)/insMem.cache.length)+""))
              return insMem.cache[(PC/4)%(insMem.cache.length)][0];
		 else {
			 insMem.cache[(PC/4)%(insMem.cache.length)][1]="1";
			 insMem.cache[(PC/4)%(insMem.cache.length)][2]=((PC/4)/insMem.cache.length)+"";
				return memory[1024+(PC/4)];
   	}
       }
       
       public static String fetchData(int instruction) {
    	 //  System.out.println("GHHGGHGGHGHGHGHGHGHGHGHGHGHGHGHGHGHGHGHHGHGHGHGHGHGHGHGHGHHGHGHGHGHGHGHGHHGHGHGHGHGHGHGHGHGHG");
//    	   System.out.println("datamemory"+dataMem);
//    	   System.out.println("datamemory cache"+ dataMem.cache[0][2]);
//    	   System.out.println("instruction: "+instruction);
//    	   System.out.println("first part "+dataMem.cache[1][1].equals("1"));
//    	   System.out.println("lalalal: "+instruction%(dataMem.cache.length));
    	   
    	   
    	   if(dataMem.cache[instruction%(dataMem.cache.length)][1].equals("1")&&dataMem.cache[instruction%(dataMem.cache.length)][2].equals((instruction/dataMem.cache.length)+""))
               return dataMem.cache[instruction%(dataMem.cache.length)][0];
 		 else {
 			 dataMem.cache[instruction%(dataMem.cache.length)][1]="1";
 			 dataMem.cache[instruction%(dataMem.cache.length)][2]=(instruction/dataMem.cache.length)+"";
 				return memory[instruction];
    	}
   	}
       
       public static void writeBack(int instruction,String Data) {
    	   //System.out.println("WBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWWBWBWB");
    	   if(dataMem.cache[instruction%(dataMem.cache.length)][1].equals("1")&&dataMem.cache[instruction%(dataMem.cache.length)][2].equals((instruction/dataMem.cache.length)+""))
               dataMem.cache[instruction%(dataMem.cache.length)][0]=Data;
    	   
    	   memory[instruction]=Data;
    	   
    	   
    	   
       }
       
       public static void loadInstructions(String [] inst) {
		   for(int i=0;i<inst.length;i++) {
			//System.out.println("cache data:     "+dataMem.cache[0][0]);
	         memory[i+1024]=inst[i];
	         insMem.cache[i%insMem.cache.length][0]=inst[i];
	        // System.out.println("cache data:     "+Memory.dataMem.cache[0][0]);
	    	 insMem.cache[i%insMem.cache.length][1]="1";
	    	 insMem.cache[i%insMem.cache.length][2]=i/insMem.cache.length+"";
	         
		   }
	 }

       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
}
