//package com.example.demo.controller.GiangVienHuongDan;
//
//import java.util.List;
//
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import com.example.demo.entity.PhieuRenLuyen;
//
//public class ExportExcelGVHD {
//	    private XSSFWorkbook workbook;
//	    private XSSFSheet sheet;
//	    private List<User> listUsers;
//	     
//	    public UserExcelExporter(List<User> listUsers) {
//	        this.listUsers = listUsers;
//	        workbook = new XSSFWorkbook();
//	    }
//	 
//	 
//	    private void writeHeaderLine() {
//	        sheet = workbook.createSheet("Users");
//	         
//	        Row row = sheet.createRow(0);
//	         
//	        CellStyle style = workbook.createCellStyle();
//	        XSSFFont font = workbook.createFont();
//	        font.setBold(true);
//	        font.setFontHeight(16);
//	        style.setFont(font);
//	         
//	        createCell(row, 0, "User ID", style);      
//	        createCell(row, 1, "E-mail", style);       
//	        createCell(row, 2, "Full Name", style);    
//	        createCell(row, 3, "Roles", style);
//	        createCell(row, 4, "Enabled", style);
//	         
//	    }
//	     
//	    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
//	        sheet.autoSizeColumn(columnCount);
//	        Cell cell = row.createCell(columnCount);
//	        if (value instanceof Integer) {
//	            cell.setCellValue((Integer) value);
//	        } else if (value instanceof Boolean) {
//	            cell.setCellValue((Boolean) value);
//	        }else {
//	            cell.setCellValue((String) value);
//	        }
//	        cell.setCellStyle(style);
//	    }
//	     
//	    private void writeDataLines() {
//	        int rowCount = 1;
//	 
//	        CellStyle style = workbook.createCellStyle();
//	        XSSFFont font = workbook.createFont();
//	        font.setFontHeight(14);
//	        style.setFont(font);
//	                 
//	        for (User user : listUsers) {
//	            Row row = sheet.createRow(rowCount++);
//	            int columnCount = 0;
//	             
//	            createCell(row, columnCount++, user.getId(), style);
//	            createCell(row, columnCount++, user.getEmail(), style);
//	            createCell(row, columnCount++, user.getFullName(), style);
//	            createCell(row, columnCount++, user.getRoles().toString(), style);
//	            createCell(row, columnCount++, user.isEnabled(), style);
//	             
//	        }
//	    }
//	     
//	    public void export(HttpServletResponse response) throws IOException {
//	        writeHeaderLine();
//	        writeDataLines();
//	         
//	        ServletOutputStream outputStream = response.getOutputStream();
//	        workbook.write(outputStream);
//	        workbook.close();
//	         
//	        outputStream.close();
//	         
//	    }
//	    public void á à()
//	    {
//	    	
//	    	List<PhieuRenLuyen> listPhieuRenLuyen = listTaiKhoan.get(0).getPhieuRenLuyens();
//			for (int i = 1; i < listTaiKhoan.size(); i++) {
//				listPhieuRenLuyen.addAll(listTaiKhoan.get(i).getPhieuRenLuyens());
//			}
//			//lọc lại phiếu rèn luyện đã đánh giá lần 3(phiếu đánh giá lần 3 sẽ không hiển thị lại ở đây)
//			for(int i=0;i<listPhieuRenLuyen.size();i++)
//			{
//				if(listPhieuRenLuyen.get(i).getDaDuyetLan3())
//					{listPhieuRenLuyen.remove(i); i--;}
//				
//			}
//	    }
//}
