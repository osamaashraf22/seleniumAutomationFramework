package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductToComparePage extends PageBase{

	public AddProductToComparePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css = "table.compare-products-table")
	WebElement compareTable;
	
	@FindBy(tagName = "tr")
	public List<WebElement> allRows;
	
	@FindBy(tagName = "td")
	public List<WebElement> allCols;
	
	@FindBy(css = "a.Clear.list")
	WebElement clearListBtn;
	
	@FindBy(css = "div.no-data")
	public WebElement noDataMessage;
	
	public void clearCompareList() 
	{
		clickButton(clearListBtn);
	}
	
	public void compareProducts()
	{
		// get all rows
		System.out.println(allRows.size());
		
		// get data from each row
		for (WebElement row :allRows) 
		{
			System.out.println(row.getText() + "\t");
			for(WebElement col :allCols)
			{
				System.out.println(col.getText() + "\t");
			}
		}
	}

}
