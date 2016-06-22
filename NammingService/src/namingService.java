/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.openorb.util.MapNamingContext;
public class namingService {

    public static void main(String args[]) {
       String []t= new String[2];
         t[0]="-ORBPort=2001";
         t[1]="-print";
         MapNamingContext.main(t);
    }
}
