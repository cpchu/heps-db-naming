/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.naming.excel2DB;

import heps.db.naming.api.SubsystemAPI;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author huihui
 */
public class Test {

    public static void main(String[] args) {
     /*   DeviceTypeAPI dtAPI=new DeviceTypeAPI();
        dtAPI.setDeviceTypeAPI("a", "b");
    */
     /*  SignalTypeAPI dtAPI=new SignalTypeAPI();
       dtAPI.setSignalTypeAPI("a", "b");
*/
     /*SubsystemAPI s=new SubsystemAPI();
     s.setSubsystemAPI("a", "b");*/
 /*  File f=new File("");
   System.out.println(f.getAbsolutePath());
   f=new File(f.getAbsolutePath()+"\\"+"naming_template.xls");
    System.out.println(f.getAbsolutePath());*/
   //Data2DB db=new Data2DB(filePath);
    //db.allData2DB();
    
   //  File f=new File(System.getProperty("user.dir")+"naming_template.xlsx");
     new Data2DB().allData2DB();
    }
    
}
