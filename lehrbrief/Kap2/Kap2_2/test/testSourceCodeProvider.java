package Kap2.Kap2_2.test;

import Kap2.Kap2_2.sourcecodeprovider.*;

public class testSourceCodeProvider {
  public static void main(String[] args) {
    SourceCodeProvider provider;
    if (args.length==1)
		provider = new StringProvider(args[0]);
    else
		if (args.length==2 && args[0].equals("-f"))
			provider = new FileProvider(args[1]);
		else{
			System.out.println("Falsche Parameter: Rufe das Programm mit einem String auf oder übgebe eine Textdate mit der Option -f");
			return;
		}

    char c;
    int mP = 1;
    while ((c=provider.getNextChar())!=0) {
       System.out.println( c +" - " + provider.getCurrentPosition() + " - "
                           + provider.getNextPosition());
       if (c == '.' && mP>0) {
           System.out.println("marked position");
           mP = -1;
           provider.setMarker();    
       }
       else if (c == '.' && mP < 0) {
           System.out.println("reset marker");
           mP = 1;
           provider.resetToMarker();
           if(provider.getNextChar()==0) break;;
       }
    }  
  }

}
