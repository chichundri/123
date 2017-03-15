package com.mystore.constants;
public enum SQLConstant {
	FIND_ALL_CATEGORY_AND_PRODUCTS("SELECT P.PRODUCTID, P.PRODUCTOWNER,SC.SUBCATEGORY_NAME,PC.CATEGORYNAME FROM PRODUCTS P,PRODUCTCATEGORIES PC,PROD_SUBCATEGORY SC WHERE P.PRODUCTSUBCATEGORYID = SC.SUBCATEGORY_ID AND SC.PRODUCTCATEGORYID = PC.CATEGORYID GROUP BY P.PRODUCTOWNER"),
	GET_ALL_EMPLOYEES_NATIVE("select * from employee"),
	GET_EMPLOEE_BY_ID("SELECT e FROM Employee e WHERE e.id = :empId"),
	UPDATE_EMP_BY_ID("UPDATE Employee e SET e.firstName=:firstName,e.lastName=:lastName,e.dob=:dob,e.address=:address,e.email=:email,e.department=:department WHERE e.id=:id"),
	GET_ALL_DEPTS("SELECT d FROM Department d"),
	DELETE_EMP_BY_ID("DELETE FROM Employee e WHERE e.id=:id"),
	DELETE_EMP_BY_IDS("DELETE FROM Employee e WHERE e.id IN(:ids)"),
	
	GET_ALL_CATEGORIES("SELECT * FROM productcategories"), 
	FIND_SUBCATEGORY_BY_CATEGORY_ID("SELECT * FROM prod_subcategory WHERE productCategoryId = ?"), 
	FIND_ALL_PRODUCTS_BY_SUBCATEGORY_ID("SELECT ProductID,ProductName,ProductOwner FROM products where ProductSubCategoryId = ? group by ProductOwner");

    private final String text;

    private SQLConstant(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
