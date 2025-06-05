package ch31;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UploadDownload {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
		String fileName="/Users/ohbom/Downloads/download.xlsx";
		String AnswerText="Updated Excel Data Successfully.";
		String fruitName="Apple";
		String updatedValue="598";
		
		// download
		driver.findElement(By.cssSelector("#downloadButton")).click();
		
		// upload
		WebElement upload=driver.findElement(By.cssSelector("input[type='file']"));
		upload.sendKeys(fileName);
		
		// edit excel - get column number of price , get row number of apple
		int row=getRowNumber(fileName,fruitName);
		int col=getColumnNumber(fileName,"price");
		Assert.assertTrue(updateCell(fileName,row,col,updatedValue));
		
		
		// wait for success message to show up and wait for disappear
		By toastLocator=By.cssSelector(".Toastify__toast-body div:nth-child(2)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));
		String toastText=driver.findElement(toastLocator).getText();
		
		Assert.assertEquals(toastText,"Updated Excel Data Successfully.");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(toastLocator));
		
		// verify updated excel data showing in the web table
		String priceColumn=driver.findElement(By.xpath("//div[text()='Price']")).getDomAttribute("data-column-id");
		String actualPrice=driver.findElement(By.xpath("//div[text()='"+fruitName+"']/parent::div/parent::div/div[@id='cell-"+priceColumn+"-undefined']")).getText();
		Assert.assertEquals("345", actualPrice);
	}
	
	private static boolean updateCell(String fileName, int row, int col, String updatedValue) throws IOException {
		ArrayList<String> a= new ArrayList<String>();
		FileInputStream fis=new FileInputStream(fileName);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		Row rowField=sheet.getRow(row-1);
		Cell cellField=rowField.getCell(col-1);
		
		cellField.setCellValue(updatedValue);
		
		FileOutputStream fos=new FileOutputStream(fileName);
		workbook.write(fos);
		workbook.close();
		fis.close();
		
		return true;
	}
	
	private static int getRowNumber(String fileName,String rowName) throws IOException {
		ArrayList<String> a= new ArrayList<String>();
		FileInputStream fis=new FileInputStream(fileName);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		Iterator<Row> rows=sheet.iterator();
		int k=1;
		int rowIndex=-1;
		
		while(rows.hasNext()) {
			Row row=rows.next();
			
			Iterator<Cell> cells=row.cellIterator();
			while(cells.hasNext()) {
				Cell cell=cells.next();
				
				if(cell.getCellType()==CellType.STRING && cell.getStringCellValue().equalsIgnoreCase(rowName)) {
					rowIndex=k;
				}
			}
			k++;
			
		}
		return rowIndex;
		

	}
	
	private static int getColumnNumber(String fileName,String colName) throws IOException {
		ArrayList<String> a= new ArrayList<String>();
		FileInputStream fis=new FileInputStream(fileName);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		Iterator<Row> rows=sheet.iterator();
		Row firstRow=rows.next();
		Iterator <Cell> ce=firstRow.cellIterator();
		
		int k=1;
		int column=0;
		
		while(ce.hasNext()) {
			Cell value=ce.next();
			
			if(value.getStringCellValue().equalsIgnoreCase(colName)) {
				column=k;
			}
			k++;
		}
	
		return column;
		
	}
}
