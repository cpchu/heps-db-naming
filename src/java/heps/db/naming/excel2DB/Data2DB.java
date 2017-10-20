/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.naming.excel2DB;

import heps.db.naming.api.DeviceTypeAPI;
import heps.db.naming.api.SignalTypeAPI;
import heps.db.naming.api.SubsystemAPI;
import heps.db.naming.api.SystemAPI;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author huihui
 */
public class Data2DB {

    ArrayList dataList;
    File file;

    public Data2DB(ArrayList dataList, File file) {
        this.dataList = dataList;
        this.file = file;
    }

    public Data2DB(File file) {
        this.dataList = null;
        this.file = file;
    }

    public Data2DB() {
        this.dataList = null;
        this.file = new File("");
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public ArrayList getDataList() {
        return dataList;
    }

    public void setDataList(ArrayList dataList) {
        this.dataList = dataList;
    }

    public void systemData2DB() {
        Workbook wb = ExcelTool.getWorkbook(file);
        ReadExcel readExcel = new ReadExcel(wb);
        this.dataList = readExcel.getSheetByName("system");
        SystemAPI systemAPI = new SystemAPI();
        if (!dataList.equals(null) && (!dataList.equals(""))) {
            Iterator it = dataList.iterator();
            it.next();
            while (it.hasNext()) {
                ArrayList oneRow = (ArrayList) it.next();
                //  System.out.println(oneRow);
                systemAPI.setSystemAPI(oneRow.get(0).toString(), oneRow.get(1).toString());
            }
        }
    }

    public void subsystemData2DB() {
        Workbook wb = ExcelTool.getWorkbook(file);
        ReadExcel readExcel = new ReadExcel(wb);
        this.dataList = readExcel.getSheetByName("subsystem");
        SubsystemAPI subsystemAPI = new SubsystemAPI();
        if (!dataList.equals(null) && (!dataList.equals(""))) {
            Iterator it = dataList.iterator();
            it.next();
            while (it.hasNext()) {
                ArrayList oneRow = (ArrayList) it.next();
                // System.out.println(oneRow);
                subsystemAPI.setSubsystemAPI(oneRow.get(0).toString(), oneRow.get(1).toString());
            }
        }
    }

    public void deviceTypeData2DB() {
        Workbook wb = ExcelTool.getWorkbook(file);
        ReadExcel readExcel = new ReadExcel(wb);
        this.dataList = readExcel.getSheetByName("device_type");
        DeviceTypeAPI deviceTypeAPI = new DeviceTypeAPI();
        if (!dataList.equals(null) && (!dataList.equals(""))) {
            Iterator it = dataList.iterator();
            it.next();
            while (it.hasNext()) {
                ArrayList oneRow = (ArrayList) it.next();
                // System.out.println(oneRow);
                deviceTypeAPI.setDeviceTypeAPI(oneRow.get(0).toString(), oneRow.get(1).toString());
            }
        }
    }

    public void singalTypeData2DB() {
        Workbook wb = ExcelTool.getWorkbook(file);
        ReadExcel readExcel = new ReadExcel(wb);
        this.dataList = readExcel.getSheetByName("signal_type");
        SignalTypeAPI signalTypeAPI = new SignalTypeAPI();
        if (!dataList.equals(null) && (!dataList.equals(""))) {
            Iterator it = dataList.iterator();
            it.next();
            while (it.hasNext()) {
                ArrayList oneRow = (ArrayList) it.next();
                // System.out.println(oneRow);
                signalTypeAPI.setSignalTypeAPI(oneRow.get(0).toString(), oneRow.get(1).toString());
            }
        }
    }

    public void allData2DB() {
        file=new File((this.file.getAbsolutePath()+"\\"+"naming_template.xlsx"));
        if (this.file == null) {
            System.out.println("The Excel file you provide does not exist!");
        } else {
            this.systemData2DB();
            this.subsystemData2DB();
            this.deviceTypeData2DB();
            this.singalTypeData2DB();
        }
    }
}
