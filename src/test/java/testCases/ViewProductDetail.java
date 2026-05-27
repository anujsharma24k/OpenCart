package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObject.ProductDetailPage;
import testBase.BaseClassTests;

public class ViewProductDetail extends BaseClassTests {
	
	
	@Test(priority = 5, groups = {"sanity"})
	public void viewProductDetails() {
		
		ProductDetailPage productDetail = new ProductDetailPage(driver);
		try {
		
		Assert.assertEquals(productDetail.getProductTitle(), "Blue Top", "Title did not match");
		
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Test failed due to exception" + e.getMessage());
		}
		
	}

}
