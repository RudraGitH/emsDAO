package com.caprusit.ems.service;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caprusit.ems.dao.ISecurityDAO;
import com.caprusit.ems.domain.Admin;
import com.caprusit.ems.domain.Employee;

@Service
public class SecurityServiceImpl implements ISecurityService {

	@Autowired
	private ISecurityDAO securityDAO;

	private Logger logger = Logger.getLogger(SecurityServiceImpl.class);

	public int login(Admin admin) {

		String adminPass = securityDAO.login(admin);

		int status = (adminPass.equals("notValid")) ? -1 : 0;
		status = (adminPass.equals(admin.getPassword())) ? 1 : status;

		logger.info("login status for admin: " + status);

		return status;

	}

	public String forgotPassword(Admin admin, Employee employee) {

		return null;
	}

	public String changePassword(Admin admin) {


		return null;
	}

	public String uploadEmployeeDetailsExcelFile(InputStream excelInputStream,String fileName) {
		logger.info("in upload file(service)");
		int firstCellNum,lastCellNum,count,exceptionRowNumber=-1,exceptionColNumber=-1;
		Workbook workbook=null;
		Sheet sheet=null ;
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		String [] extensionArray=fileName.split("[.]");
		logger.info("arrays isze: "+extensionArray.length);
		try {
			
		    if(extensionArray[1].equals("xls")){
		    	workbook=new HSSFWorkbook(excelInputStream);
		    	logger.info("2003 file");
		    }
		     else{
		    	logger.info("2007 file");
			    workbook=new XSSFWorkbook(excelInputStream);
			    
			 }
	        int NoOfSheets=workbook.getNumberOfSheets();
			logger.info("number of sheets: "+NoOfSheets);			
			for(int i=0;i< NoOfSheets;i++){
			    sheet = workbook.getSheetAt(i);
			    Iterator<Row> rowIterator = sheet.rowIterator();
			    while (rowIterator.hasNext()) {
				    Row row =  rowIterator.next();
				    int rowNumber = row.getRowNum();
				    if (rowNumber != 0) {
					     firstCellNum = row.getFirstCellNum();
					     lastCellNum = row.getLastCellNum();
					     count=0;
					     Employee employee = new Employee();
					
					    for (; firstCellNum <= lastCellNum; firstCellNum++) {
						
						    Cell cell = row.getCell(firstCellNum);
                        
						    if (cell != null && (Cell.CELL_TYPE_BLANK != cell.getCellType())) {
							    count++;
                               System.err.println("cell value: "+cell);
						    	switch (firstCellNum) {
							    case 0:
								    employee.setEmployeeId((int) cell.getNumericCellValue());
								    break;
							    case 1:
								    employee.setFirstName(cell.getStringCellValue());
								    break;
							    case 2:
								    employee.setLastName(cell.getStringCellValue());
								    break;
							    case 3:
								    System.err.println("date of birth(cell): "+cell);
								
									    try{
										    String strDate=cell.getStringCellValue();
										    logger.info("Date of birth as String: "+strDate);
										    employee.setDob(dateFormat.parse(strDate));
									    }
									    catch(Exception exception){
										    logger.info("exception during getting dob as String type");
										    exceptionRowNumber=row.getRowNum();
										    exceptionColNumber=cell.getColumnIndex();
										    logger.info("exceprion row number: "+exceptionRowNumber+" exceptionn column number: "+exceptionColNumber);
										    //exception.printStackTrace();									
								        }									
								    break;
							    case 4:							
								    employee.setMobileNo(String.valueOf((long)cell.getNumericCellValue()));
								    break;
							    case 5:
								    employee.setEmailId(cell.getStringCellValue());
								    break;
							    case 6:
								    employee.setDesignation(cell.getStringCellValue());
								    break;
							    case 7:
								    employee.setRollId((int) cell.getNumericCellValue());
								    break;
							    case 8:
								    employee.setStatus(String.valueOf((int)cell.getNumericCellValue()));
								    break;
							    case 9:
								    employee.setDeptId((int) cell.getNumericCellValue());
								    break;
							    default:
								    System.out.println("switch default: " + firstCellNum);
								    break;
							    }
		

						    }
						    else
							    logger.info("null or blank cell");

					    }
					    System.out.println("employee object: " + employee);
					    if(count > 0)securityDAO.saveEmployee(employee);
					    System.out.println("");
				    }
				    /*workbook.close();*/
				
			    }
			
			}
			
		} catch (Exception e) {

			e.printStackTrace();
			return ValidationServiceImpl.convertToJson((exceptionRowNumber+1)+""+(exceptionColNumber+1));
		}

		return ValidationServiceImpl.convertToJson((exceptionRowNumber+1)+""+(exceptionColNumber+1));

	}



}
